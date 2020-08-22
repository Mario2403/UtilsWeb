package com.dailyWorkNotes.dailyWorkNotesApp.controllers;

import com.dailyWorkNotes.dailyWorkNotesApp.beans.User;
import com.dailyWorkNotes.dailyWorkNotesApp.beans.request.UserRequestBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;





@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @CrossOrigin
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserRequestBean userRequest){
        System.out.println("login");
//        String token = getJWTToken(username);
        return new ResponseEntity<String>("OK", HttpStatus.OK);
    }
//
//    private String getJWTToken(String username) {
//        String secretKey = "claveSecreta";
//        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
//                .commaSeparatedStringToAuthorityList("ROLE_USER");
//
//        String token = Jwts
//                .builder()
//                .setId("NotesAppJWT")
//                .setSubject(username)
//                .claim("authorities",
//                        grantedAuthorities.stream()
//                                .map(GrantedAuthority::getAuthority)
//                                .collect(Collectors.toList()))
//                .setIssuedAt(new Date(System.currentTimeMillis()))
//                .setExpiration(new Date(System.currentTimeMillis() + 600000))
//                .signWith(SignatureAlgorithm.HS512,
//                        secretKey.getBytes()).compact();
//
//        return "Bearer " + token;
//
//    }
}
