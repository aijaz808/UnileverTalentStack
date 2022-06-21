package com.unilever.authservice.service;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.unilever.commonservice.profile.model.Profile;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtTokenProvider {

    private static final Logger LOGGER = LoggerFactory.getLogger(JwtTokenProvider.class);

    //    @Value("${app.auth.jwt.tokenSecret}")
    private String tokenSecret = "H3CRGM$P0RT@L.C0M";

    //    @Value("${app.auth.jwt.tokenExpirationMilli}")
    private Long tokenExpirationMilli = 1800000L;;


    public ObjectNode createToken(Profile profile, String refreshToken) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + tokenExpirationMilli);
        return JsonNodeFactory.instance.objectNode()
                .put("tokenType","Bearer")
                .put("expiration", tokenExpirationMilli)
                .put("refreshToken", refreshToken)
                .put("role", profile.getRoleType().toString())
                .put("accessToken", Jwts.builder()
                        .setSubject(profile.getUserName() + "")
                        .setIssuedAt(now)
                        .setExpiration(expiryDate)
                        .signWith(SignatureAlgorithm.HS512, tokenSecret)
                        .compact());
    }

    public String getUserIdFromToken(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(tokenSecret)
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();
    }

    public boolean validateToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(tokenSecret).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException ex) {
            LOGGER.error("Invalid JWT signature");
        } catch (MalformedJwtException ex) {
            LOGGER.error("Invalid JWT token");
        } catch (ExpiredJwtException ex) {
            LOGGER.error("Expired JWT token");
        } catch (UnsupportedJwtException ex) {
            LOGGER.error("Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
            LOGGER.error("JWT claims string is empty.");
        }
        return false;
    }
}