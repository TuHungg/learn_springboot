package com.petshop.customerAccount;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(AccountRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(
                    new Account("tuhung", "123456","admin, editor")));
            log.info("Preloading " + repository.save(
                    new Account("tuhai", "123456","editor")));
            log.info("Preloading " + repository.save(
                    new Account("tonyteo", "123456","user")));

        };

//        return args -> {
//            CustomerAccount hung = new CustomerAccount(
//                    "tuhung", "123456", "admin, editor");
//            CustomerAccount hai = new CustomerAccount(
//                    "tuhai", "123456", "editor");
//            CustomerAccount tonyteo = new CustomerAccount(
//                    "tonyteo", "123456", "user");
//
//            repository.saveAll(
//                    List.of(hung, hai, tonyteo)
//            );
//        };
    }
}

