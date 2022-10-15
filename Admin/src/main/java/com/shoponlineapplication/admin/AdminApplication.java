package com.shoponlineapplication.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.shoponlineapplication.library.*","com.shoponlineapplication.admin.*"})
@EnableJpaRepositories(value = "com.shoponlineapplication.library.repository")
@EntityScan(value = "com.shoponlineapplication.library.model")
public class  AdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminApplication.class, args);
    }

}
