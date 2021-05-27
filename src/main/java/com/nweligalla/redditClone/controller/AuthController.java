package com.nweligalla.redditClone.controller;


import com.nweligalla.redditClone.dto.RegisterRequest;
import com.nweligalla.redditClone.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthController {

    private final AuthService authService;



    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@RequestBody RegisterRequest registerRequest) {
        System.out.println("here");
        try {
            authService.signUp(registerRequest);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return new ResponseEntity<>("User Registration successfull", HttpStatus.OK);
    }

    @GetMapping("/test")
    public String test() {
        return "Test";
    }

}
