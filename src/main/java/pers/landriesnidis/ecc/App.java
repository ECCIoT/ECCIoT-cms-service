package pers.landriesnidis.ecc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by landriesnidis on 17-10-27.
 */
@ComponentScan(basePackages = {"pers.landriesnidis.ecc.controller","pers.landriesnidis.ecc.dao"})
@EnableAutoConfiguration
public class App {
    public static void main(String[] args){
        SpringApplication.run(App.class,args);
    }
}
