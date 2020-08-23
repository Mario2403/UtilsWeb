package com.dailyWorkNotes.dailyWorkNotesApp.controllers;

import com.dailyWorkNotes.dailyWorkNotesApp.beans.request.UserRequest;
import com.dailyWorkNotes.dailyWorkNotesApp.beans.response.UserResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;





@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @CrossOrigin
    @PostMapping("/login")
    public ResponseEntity<UserResponse> login(@RequestBody UserRequest userRequest){
        System.out.println("login");
        UserResponse userResponse = new UserResponse("Mario", "FAKE_TOKEN");
        return new ResponseEntity<UserResponse>(userResponse, HttpStatus.OK);
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
