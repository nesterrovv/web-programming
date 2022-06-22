package com.nesterrovv.web4.controllers;

import com.nesterrovv.web4.DTO.UserDTO;
import com.nesterrovv.web4.config.jwt.JWTProvider;
import com.nesterrovv.web4.model.User;
import com.nesterrovv.web4.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Base64;

@RestController
@RequestMapping(path = "/api/user")
public class UserController {
    private final UserService userService;
    private final JWTProvider jwtProvider;
    private final AuthenticationManager authManager = new AuthenticationManager() {
        @Override
        public Authentication authenticate(Authentication authentication) throws AuthenticationException {
            return null;
        }
    };

    public UserController(UserService userService, JWTProvider jwtProvider) {
        this.userService = userService;
        this.jwtProvider = jwtProvider;
    }

    @CrossOrigin
    @PostMapping("/user")
    private ResponseEntity<String> login(@Valid @RequestBody UserDTO userDTO) {
        if (checkUserData(userDTO)) {
            return new ResponseEntity<>("Недопустимое имя или пароль пользователя", HttpStatus.BAD_REQUEST);
        }
        String username = userDTO.getUsername();
        String password = encodePassword(userDTO.getPassword());
        User user = userService.getUserByUsernameAndPassword(username, password);
        if (user != null) {
            authManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            String token = jwtProvider.generateToken(username);
            return ResponseEntity.ok(token);
        } else {
            return new ResponseEntity<>("Пользователь не найден или пароль введен не верно", HttpStatus.NOT_FOUND);
        }
    }

    @CrossOrigin
    @PostMapping("/new-user")
    private ResponseEntity<String> register(@Valid @RequestBody UserDTO userDTO) {
        if (checkUserData(userDTO)) {
            return new ResponseEntity<>("Недопустимое имя или пароль пользователя", HttpStatus.BAD_REQUEST);
        }
        String username = userDTO.getUsername();
        String password = encodePassword(userDTO.getPassword());
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        if (userService.saveUser(user)) {
            authManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            String token = jwtProvider.generateToken(username);
            return ResponseEntity.ok(token);
        } else {
            return new ResponseEntity<>("Пользователь с данным логином уже существует", HttpStatus.BAD_REQUEST);
        }
    }

    private boolean checkUserData(UserDTO userDTO) {
        return userDTO.getUsername() == null || userDTO.getPassword() == null || userDTO.getUsername().trim().equals("")
                || userDTO.getPassword().trim().equals("");
    }

    private String encodePassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(password.getBytes(StandardCharsets.UTF_8));
            byte[] passwordDigest = md.digest();
            return new String(Base64.getEncoder().encode(passwordDigest));
        } catch (Exception e) {
            throw new RuntimeException("Exception encoding password", e);
        }
    }
}