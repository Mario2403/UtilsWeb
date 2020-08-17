package com.dailyWorkNotes.dailyWorkNotesApp.controllers;

import com.dailyWorkNotes.dailyWorkNotesApp.beans.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.*;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;



@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class UserController {

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestParam("username") String username, @RequestParam("pwd") String pwd){
        String token = getJWTToken(username);
        User user = new User(username, token);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    private String getJWTToken(String username) {
        String secretKey = "claveSecreta";
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList("ROLE_USER");

        String token = Jwts
                .builder()
                .setId("NotesAppJWT")
                .setSubject(username)
                .claim("authorities",
                        grantedAuthorities.stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 600000))
                .signWith(SignatureAlgorithm.HS512,
                        secretKey.getBytes()).compact();

        return "Bearer " + token;



    }
}
