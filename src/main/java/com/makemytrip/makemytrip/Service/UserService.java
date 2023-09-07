package com.makemytrip.makemytrip.Service;

import com.makemytrip.makemytrip.Repository.UserRepository;
import com.makemytrip.makemytrip.RequestDtos.AddUserRequestDto;
import com.makemytrip.makemytrip.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public String addUser(AddUserRequestDto addUserRequestDto){

        User user = User.builder().name(addUserRequestDto.getName())
                .age(addUserRequestDto.getAge())
                .emailId(addUserRequestDto.getEmailId()).build();

        userRepository.save(user);

        return "User has been added successfully";
    }
}
