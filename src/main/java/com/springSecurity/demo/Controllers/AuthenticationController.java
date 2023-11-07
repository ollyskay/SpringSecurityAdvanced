package com.springSecurity.demo.Controllers;

import com.springSecurity.demo.Config.JwtUtils;
import com.springSecurity.demo.DAO.UserDao;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {


    private final AuthenticationManager authenticationManager;
    private final UserDao userDao;
    private final JwtUtils jwtUtils;

    @PostMapping("/authenticate")

    public ResponseEntity<String> authenticate(
            @RequestBody AuthenticationRequest request){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );

        final UserDetails user = userDao.findUserByEmail(request.getEmail());
        if(user != null){
            Map<String, Object> claims = new HashMap<>();

            return ResponseEntity.ok(jwtUtils.generateToken(user, claims));
        }
        return ResponseEntity.status(400).body("Some error has occurred");




    }

}
