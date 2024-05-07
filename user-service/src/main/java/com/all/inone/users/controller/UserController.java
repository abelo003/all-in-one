package com.all.inone.users.controller;

import com.all.inone.users.entity.User;
import com.all.inone.users.service.UserService;
import com.all.inone.users.vo.ResponseTemplateVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    //Replace by RequiredArgsConstructor annotations
    //public UserController(UserService userService) {
    //    this.userService = userService;
    //}

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public User save(@RequestBody User user) {
        log.info("Inside save of UserController.");
        return this.userService.save(user);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseTemplateVO findUser(@PathVariable Long id) {
        log.info("Inside findUser of UserController.");
        return userService.findUserByIdWhitDepartment(id);
    }

}
