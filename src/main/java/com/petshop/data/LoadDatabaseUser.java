package com.petshop.data;

import com.petshop.models.Role;
import com.petshop.models.User;
import com.petshop.service.UserService;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.logging.Logger;

@Configuration
public class LoadDatabaseUser {

//    private static final Logger log = LoggerFactory.getLogger(LoadDatabaseUser.class);

    @Bean
    CommandLineRunner run(UserService userService) {
        return args -> {
            userService.saveRole(new Role(null, "ROLE_USER"));
            userService.saveRole(new Role(null, "ROLE_MANAGER"));
            userService.saveRole(new Role(null, "ROLE_ADMIN"));
            userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));


            userService.saveUser(
                    new User(null,
                            "Tu Hung",
                            "hung",
                            "123456",
                            new ArrayList<>()
                    ));
            userService.saveUser(
                    new User(null,
                            "Tu Hai",
                            "hai",
                            "123456",
                            new ArrayList<>()
                    ));
            userService.saveUser(
                    new User(null,
                            "Tu Lam",
                            "lam",
                            "123456",
                            new ArrayList<>()
                    ));
            userService.saveUser(
                    new User(null,
                            "Tu Duy",
                            "duy",
                            "123456",
                            new ArrayList<>()
                    ));

            userService.addRoleToUser("hung","ROLE_SUPER_ADMIN");
            userService.addRoleToUser("hung","ROLE_ADMIN");
            userService.addRoleToUser("hung","ROLE_USER");

            userService.addRoleToUser("hai","ROLE_ADMIN");
            userService.addRoleToUser("hai","ROLE_USER");

            userService.addRoleToUser("lam","ROLE_MANAGER");
            userService.addRoleToUser("lam","ROLE_USER");

            userService.addRoleToUser("duy","ROLE_USER");

        };
    }

}
