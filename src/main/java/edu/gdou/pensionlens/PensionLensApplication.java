package edu.gdou.pensionlens;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class PensionLensApplication {
    public static void main(String[] args) {
        SpringApplication.run(PensionLensApplication.class, args);
    }
}