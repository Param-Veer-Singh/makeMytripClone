package com.makemytrip.makemytrip.Controllers;

import com.makemytrip.makemytrip.RequestDtos.AddUserRequestDto;
import com.makemytrip.makemytrip.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public String addUser(AddUserRequestDto addUserRequestDto){

        return userService.addUser(addUserRequestDto);
    }
}
