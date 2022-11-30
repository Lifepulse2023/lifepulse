package com.lifepulse.api.controller;

import com.lifepulse.api.model.User;
import com.lifepulse.api.model.common.ApiResponseModel;
import com.lifepulse.api.service.UserRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/lifepulse/v1")
public class UserRegistrationController {


   @Autowired
    private UserRegistrationService userRegistrationService;

    @PostMapping(value="/register", consumes= MediaType.APPLICATION_JSON_VALUE)
    public ApiResponseModel addEmployees(@Validated @Valid @RequestBody User user) throws Exception {
        return userRegistrationService.addUser(user);
    }
}
