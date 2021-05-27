package com.nweligalla.redditClone.service;


import com.nweligalla.redditClone.dto.RegisterRequest;
import com.nweligalla.redditClone.model.EmailNotification;
import com.nweligalla.redditClone.model.User;
import com.nweligalla.redditClone.model.VerificationToken;
import com.nweligalla.redditClone.repository.UserRepository;
import com.nweligalla.redditClone.repository.VerificationTokenRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Instant;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AuthService {

    // for encode the password
    private final PasswordEncoder passwordEncoder;


    private final UserRepository userRepository;

    private final VerificationTokenRepository verificationTokenRepository;

    private final MailService mailService;

    @Transactional
    public void signUp(RegisterRequest registerRequest) {
        User user = new User();
        user.setUserName(registerRequest.getUserName());
        user.setEmail(registerRequest.getEmail());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        user.setCreated(Instant.now());
        user.setEnabled(false);

        userRepository.save(user);

        String token = generateVerificationToken(user);
        mailService.sendMail(new EmailNotification(
                "Please Activate your Account",
                user.getEmail(),
                "please click on the below url to activate your account" + "http://localhost:8080/api/auth/accountVerification/" + token
        ));
    }


    //create verificationToken for send to user as email
    private String generateVerificationToken(User user) {
        String token = UUID.randomUUID().toString();

        VerificationToken verificationToken = new VerificationToken();

        verificationToken.setToken(token);
        verificationToken.setUser(user);

        verificationTokenRepository.save(verificationToken);

        return token;
    }
}
