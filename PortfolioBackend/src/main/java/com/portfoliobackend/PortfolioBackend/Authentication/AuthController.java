package com.portfoliobackend.PortfolioBackend.Authentication;


import com.portfoliobackend.PortfolioBackend.Authentication.AuthRequest;
import com.portfoliobackend.PortfolioBackend.Authentication.AuthResponse;
import com.portfoliobackend.PortfolioBackend.Services.UserService;
import com.portfoliobackend.PortfolioBackend.Utilities.JwtTokenUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;
    private final JwtTokenUtil jwtTokenUtil;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest authRequest) {
        return userService.authenticate(authRequest)
                .map(user -> {
                    String token = jwtTokenUtil.generateToken(user);
                    return ResponseEntity.ok(new AuthResponse(token));
                })
                .orElseGet(() -> ResponseEntity.status(401).build());
    }
}
