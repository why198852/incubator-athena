package io.inke.athena.support.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class AppmetaModel {

    private Integer id;
    private String name; // name, unique
    private String code; // generate code
    private Boolean active; // active status
    private String token; // token unique, generate by name+code+now()
    private String displayName; // displayName, unique
    private Date deadTime; // dead time
    private Date createTime; // create time
    private Date modifyTime; // last modfiy time
    private Boolean deleted; // delete status
    private Boolean locked; // lock status

    private UserModel user; // user info

}
