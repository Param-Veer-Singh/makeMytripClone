package com.makemytrip.makemytrip.RequestDtos;

import lombok.Data;

@Data
public class AddUserRequestDto {

    private String name;

    private Integer age;

    private String emailId;
}
