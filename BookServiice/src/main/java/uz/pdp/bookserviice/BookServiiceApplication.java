package uz.pdp.bookserviice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = "uz.pdp.feinclient")
public class BookServiiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookServiiceApplication.class, args);
    }

}
