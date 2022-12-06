package com.demo.playersaver.dto.request;

import lombok.Data;

@Data
public class CreatePlayerRequest {
    private String name;
    private String lastname;
    private String mail;
    private int age;
    private String teamName;
}
