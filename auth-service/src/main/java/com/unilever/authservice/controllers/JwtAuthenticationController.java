package com.unilever.authservice.controllers;

import com.fasterxml.jackson.databind.node.ObjectNode;

import com.unilever.authservice.dto.TokenRefreshRequest;
import com.unilever.authservice.dto.TokenRefreshResponse;
import com.unilever.authservice.exception.TokenRefreshException;
import com.unilever.authservice.model.RefreshToken;
import com.unilever.authservice.service.AuthService;
import com.unilever.authservice.service.JwtTokenProvider;
import com.unilever.authservice.service.RefreshTokenService;
import com.unilever.commonservice.profile.model.Profile;
import com.unilever.utilityservice.response.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class JwtAuthenticationController {

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private AuthService authService;

    @Autowired
    RefreshTokenService refreshTokenService;

    @PostMapping("/authenticate")
    public ResponseEntity<?> authenticate(@RequestBody Map<String, String> request) throws Exception {
        Profile profile=authService.login(request);
        RefreshToken refreshToken=refreshTokenService.createRefreshToken(profile.getId());
        return ResponseHandler.buildResponseData(jwtTokenProvider.createToken(profile, refreshToken.getToken()), HttpStatus.OK);
    }

    @PostMapping("/refreshToken")
    public ResponseEntity<?> refreshToken(@Valid @RequestBody TokenRefreshRequest request) {

        String requestRefreshToken = request.getRefreshToken();
        RefreshToken refreshToken= refreshTokenService.findByToken(requestRefreshToken);
        if(refreshToken != null) {
            RefreshToken refreshToken1 = refreshTokenService.verifyExpiration(refreshToken);
            ObjectNode token = jwtTokenProvider.createToken(refreshToken.getProfile(), requestRefreshToken);
            return ResponseHandler.buildResponseData(new TokenRefreshResponse(token), HttpStatus.OK);
        }
        else
            throw  new TokenRefreshException(requestRefreshToken,"Refresh token is not in database!");
    }
}
