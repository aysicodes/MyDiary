//package com.example.diaryapp.controller;
//
//import com.example.diaryapp.dto.LoginUserDto;
//import com.example.diaryapp.dto.RegisterUserDto;
//import com.example.diaryapp.entity.User;
//import com.example.diaryapp.responses.LoginResponse;
//import com.example.diaryapp.service.AuthenticationService;
//import com.example.diaryapp.service.JWTService;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.web.bind.annotation.*;
//
//@RequestMapping("/auth")
//@RestController
//public class AuthenticationController {
//    private final JWTService jwtService;
//
//    private final AuthenticationService authenticationService;
//
//    public AuthenticationController(JWTService jwtService, AuthenticationService authenticationService) {
//        this.jwtService = jwtService;
//        this.authenticationService = authenticationService;
//    }
//
//    @PostMapping("/signup")
//    public ResponseEntity<User> register(@RequestBody RegisterUserDto registerUserDto) {
//        User registeredUser = authenticationService.signup(registerUserDto);
//        return ResponseEntity.ok(registeredUser);
//    }
//
//    @PostMapping("/login")
//    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginUserDto loginUserDto){
//        User authenticatedUser = authenticationService.authenticate(loginUserDto);
//        String jwtToken = jwtService.generateToken((UserDetails) authenticatedUser);
//        LoginResponse loginResponse = new LoginResponse(jwtToken, jwtService.getExpirationTime());
//        return ResponseEntity.ok(loginResponse);
//    }
//
//    @PostMapping("/verify")
//    public ResponseEntity<?> verifyUser(@RequestBody VerifyUserDto verifyUserDto) {
//        try {
//            authenticationService.verifyUser(verifyUserDto);
//            return ResponseEntity.ok("Account verified successfully");
//        } catch (RuntimeException e) {
//            return ResponseEntity.badRequest().body(e.getMessage());
//        }
//    }
//
//    @PostMapping("/resend")
//    public ResponseEntity<?> resendVerificationCode(@RequestParam String email) {
//        try {
//            authenticationService.resendVerificationCode(email);
//            return ResponseEntity.ok("Verification code sent");
//        } catch (RuntimeException e) {
//            return ResponseEntity.badRequest().body(e.getMessage());
//        }
//    }
//}
//
//
////import com.example.diaryapp.service.UserService;
////import com.example.diaryapp.utils.JwtUtil;
////import lombok.RequiredArgsConstructor;
////import org.springframework.http.ResponseEntity;
////import org.springframework.security.authentication.AuthenticationManager;
////import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
////import org.springframework.security.core.Authentication;
////import org.springframework.web.bind.annotation.*;
////
////import java.util.Map;
////
////@RestController
////@RequestMapping("/api/auth")
////@RequiredArgsConstructor
////public class AuthController {
////
////    private final UserService userService;
////    private final AuthenticationManager authenticationManager;
////    private final JwtUtil jwtUtil;
////
////    @PostMapping("/register")
////    public ResponseEntity<?> register(@RequestBody Map<String, String> request) {
////        String username = request.get("username");
////        String email = request.get("email");
////        String password = request.get("password");
////
////        userService.registerUser(username, email, password);
////        return ResponseEntity.ok("User registered successfully");
////    }
////
////    @PostMapping("/login")
////    public ResponseEntity<?> login(@RequestBody Map<String, String> request) {
////        String username = request.get("username");
////        String password = request.get("password");
////
////        // Аутентификация пользователя
////        Authentication authentication = authenticationManager.authenticate(
////                new UsernamePasswordAuthenticationToken(username, password)
////        );
////
////        // Генерация JWT токена с использованием getName() напрямую
////        String jwt = jwtUtil.generateToken(authentication.getName());
//
////        authenticationManager.authenticate(
////                new UsernamePasswordAuthenticationToken(username, password)
////        );
////        // Аутентификация пользователя
////        Authentication authentication = authenticationManager.authenticate(
////                new UsernamePasswordAuthenticationToken(username, password)
////        );
//
//        // Генерация JWT токена
////        String jwt = jwtUtil.generateToken(username);
//
//
//
////        return ResponseEntity.ok(Map.of("jwt", jwt));
////    }
////
////    @PostMapping("/reset-password")
////    public ResponseEntity<?> resetPassword(@RequestBody Map<String, String> request) {
////        String email = request.get("email");
////        String newPassword = request.get("newPassword"); // Добавьте это поле в запросе
////
////        return userService.findByEmail(email)
////                .map(user -> {
////                    userService.updatePassword(user, newPassword); // Здесь используется метод
////                    return ResponseEntity.ok("Password updated successfully.");
////                })
////                .orElse(ResponseEntity.status(404).body("User not found."));
////    }
////}
//
//
////
////import com.example.diaryapp.service.UserService;
////import lombok.RequiredArgsConstructor;
////import com.example.diaryapp.util.JwtUtil;
////import org.springframework.http.ResponseEntity;
////import org.springframework.security.authentication.AuthenticationManager;
////import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
////import org.springframework.security.core.Authentication;
////import org.springframework.web.bind.annotation.*;
////
////import java.util.Map;
////
////@RestController
////@RequestMapping("/api/auth")
////@RequiredArgsConstructor
////public class AuthController {
////    private final UserService userService;
////
////    @PostMapping("/register")
////    public ResponseEntity<?> register(@RequestBody Map<String, String> request) {
////        String username = request.get("username");
////        String email = request.get("email");
////        String password = request.get("password");
////
////        userService.registerUser(username, email, password);
////        return ResponseEntity.ok("User registered successfully");
////    }
////    @PostMapping("/login")
////    public ResponseEntity<?> login(@RequestBody Map<String, String> request) {
////        String username = request.get("username");
////        String password = request.get("password");
////
////        Authentication authentication = authenticationManager.authenticate(
////                new UsernamePasswordAuthenticationToken(username, password)
////        );
////
////        String jwt = jwtUtil.generateToken(username);
////
////        return ResponseEntity.ok(Map.of("jwt", jwt));
////    }
////
////
////    @PostMapping("/reset-password")
////    public ResponseEntity<?> resetPassword(@RequestBody Map<String, String> request) {
////        String email = request.get("email");
////        String newPassword = request.get("newPassword"); // Добавьте это поле в запросе
////
////        return userService.findByEmail(email)
////                .map(user -> {
////                    userService.updatePassword(user, newPassword); // Здесь используется метод
////                    return ResponseEntity.ok("Password updated successfully.");
////                })
////                .orElse(ResponseEntity.status(404).body("User not found."));
////    }
////
////}
//
