package io.inke.athena.core.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtTokenTemplate implements Serializable {

    private static final String CLAIM_KEY_USERNAME = "userName";
    private static final String CLAIM_KEY_USERID = "userId";

    private static final long EXPIRATION_TIME = 432000000;

    private static final String SECRET = "secret";

    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>(16);
        String[] userNameAndId = userDetails.getUsername().split(String.valueOf(Character.LINE_SEPARATOR));
        claims.put(CLAIM_KEY_USERNAME, userNameAndId[0]);
        if (userNameAndId.length > 1) {
            claims.put(CLAIM_KEY_USERID, userNameAndId[1]);
        }
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(new Date(Instant.now().toEpochMilli() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        User user = (User) userDetails;
        String username = getUsernameFromToken(token);
        return (username.equals(user.getUsername().split(String.valueOf(Character.LINE_SEPARATOR))[0]) && !isTokenExpired(token));
    }

    public Boolean isTokenExpired(String token) {
        Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    public String getUsernameFromToken(String token) {
        String username = getClaimsFromToken(token).get(CLAIM_KEY_USERNAME).toString();
        return username;
    }

    public Date getExpirationDateFromToken(String token) {
        Date expiration = getClaimsFromToken(token).getExpiration();
        return expiration;
    }

    private Claims getClaimsFromToken(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token)
                .getBody();
        return claims;
    }

    public static Integer getUserId(Authentication authentication) {
        String[] userNameAndId = authentication.getName().split(String.valueOf(Character.LINE_SEPARATOR));
        if (userNameAndId.length > 1) {
            return Integer.valueOf(userNameAndId[1]);
        }
        throw new RuntimeException(String.format("not found user id by %s ", userNameAndId[0]));
    }

}
