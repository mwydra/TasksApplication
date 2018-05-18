package com.crud.tasks.config;

import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
public class AdminConfig {

    //@Value("${admin.mail}")
    private String adminMail = "kodilla0course@gmail.com";
}
