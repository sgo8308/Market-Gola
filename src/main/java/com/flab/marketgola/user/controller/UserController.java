package com.flab.marketgola.user.controller;

import com.flab.marketgola.user.dto.request.FindUserRequestDto;
import com.flab.marketgola.user.dto.request.JoinUserRequestDto;
import com.flab.marketgola.user.dto.response.UserResponseDto;
import com.flab.marketgola.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("users")
@RestController
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserResponseDto> joinUser(
            @Validated @RequestBody JoinUserRequestDto joinUserRequestDto) throws Exception {
        return new ResponseEntity<>(userService.join(joinUserRequestDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<UserResponseDto> findUser(
            @ModelAttribute FindUserRequestDto findUserRequestDto) {
        return new ResponseEntity<>(userService.findByCondition(findUserRequestDto), HttpStatus.OK);
    }

}