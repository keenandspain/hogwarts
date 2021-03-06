package edu.tcu.cs.hogwartsartifactsonline;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HogwartsartifactsonlineApplication {

    public static void main(String[] args) {
        SpringApplication.run(HogwartsartifactsonlineApplication.class, args);
    }


    @Bean
    public IdWorker idWorker(){
        return new IdWorker(1, 1);
    }

}
