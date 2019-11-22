package io.inke.athena.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = {
        "io.inke.athena"
})
public class AthenaServerLaunch {

    public static void main(String[] args) {
        SpringApplication.run(AthenaServerLaunch.class, args);
    }

}
