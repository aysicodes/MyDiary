//package com.example.diaryapp.security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.CorsConfigurationSource;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//
//import java.util.List;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfiguration {
//    private final AuthenticationProvider authenticationProvider;
//    private final JwtAuthenticationFilter jwtAuthenticationFilter;
//
//    public SecurityConfiguration(
//            JwtAuthenticationFilter jwtAuthenticationFilter,
//            AuthenticationProvider authenticationProvider //ignore Bean warning we will get to that
//    ) {
//        this.authenticationProvider = authenticationProvider;
//        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
//    }
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf(csrf -> csrf.disable())
//                .authorizeHttpRequests(authorize -> authorize
//                        .requestMatchers("/auth/**").permitAll()
//                        .anyRequest().authenticated()
//                )
//                .sessionManagement(session -> session
//                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                )
//                .authenticationProvider(authenticationProvider)
//                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
//
//        return http.build();
//    }
//
//    @Bean
//    public CorsConfigurationSource corsConfigurationSource() {
//        CorsConfiguration configuration = new CorsConfiguration();
//        configuration.setAllowedOrigins(List.of("https://app-backend.com", "http://localhost:8080")); //TODO: update backend url
//        configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE"));
//        configuration.setAllowedHeaders(List.of("Authorization", "Content-Type"));
//
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", configuration);
//        return source;
//    }
//}
//
//
//
//
////
////import com.example.diaryapp.JwtRequestFilter;
////import com.example.diaryapp.service.CustomUserDetailsService;
////import jakarta.servlet.http.HttpServletResponse;
////import org.springframework.context.annotation.Bean;
////import org.springframework.context.annotation.Configuration;
////import org.springframework.security.authentication.AuthenticationManager;
////import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
////import org.springframework.security.config.annotation.web.builders.HttpSecurity;
////import org.springframework.security.core.userdetails.UserDetailsService;
////import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
////import org.springframework.security.crypto.password.PasswordEncoder;
////import org.springframework.security.web.SecurityFilterChain;
////import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
////
////import lombok.RequiredArgsConstructor;
////import org.springframework.security.config.http.SessionCreationPolicy;
////
////@Configuration
////@RequiredArgsConstructor
////public class SecurityConfig {
////
////    private final JwtRequestFilter jwtRequestFilter;
////    private final CustomUserDetailsService userDetailsService;
////
////    @Bean
////    public PasswordEncoder passwordEncoder() {
////        return new BCryptPasswordEncoder();
////    }
////
////    // Убедитесь, что используете правильную конфигурацию для AuthenticationManager
////    @Bean
////    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
////        AuthenticationManagerBuilder authenticationManagerBuilder =
////                http.getSharedObject(AuthenticationManagerBuilder.class);
////
////        authenticationManagerBuilder
////                .userDetailsService(userDetailsService)
////                .passwordEncoder(passwordEncoder());
////
////        return authenticationManagerBuilder.build();
////    }
////
////    // Переименуйте метод, чтобы избежать конфликта с именем класса
////    @Bean
////    public SecurityFilterChain customSecurityConfig(HttpSecurity http) throws Exception {
////        return http
////                .csrf(csrf -> csrf.disable()) // Disable CSRF for stateless JWT authentication
////                .authorizeHttpRequests(auth -> auth
////                        .requestMatchers("/api/auth/**").permitAll() // Open authentication endpoints
////                        .anyRequest().authenticated() // All other endpoints require authentication
////                )
////                .exceptionHandling(exceptions -> exceptions
////                        .authenticationEntryPoint((request, response, authException) -> {
////                            // Send 401 Unauthorized for unauthenticated access
////                            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
////                        })
////                        .accessDeniedHandler((request, response, accessDeniedException) -> {
////                            // Send 403 Forbidden for access denied
////                            response.sendError(HttpServletResponse.SC_FORBIDDEN, "Forbidden");
////                        })
////                )
////                .sessionManagement(session -> session
////                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS) // Stateless authentication
////                )
////                .addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class) // Add JWT filter before UsernamePasswordAuthenticationFilter
////                .build();
////    }
////}
//
//
////import com.example.diaryapp.JwtRequestFilter;
////import jakarta.servlet.http.HttpServletResponse;
////import org.springframework.context.annotation.Bean;
////import org.springframework.context.annotation.Configuration;
////import org.springframework.security.authentication.AuthenticationManager;
////import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
////import org.springframework.security.config.annotation.web.builders.HttpSecurity;
////import org.springframework.security.core.userdetails.UserDetailsService;
////import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
////import org.springframework.security.crypto.password.PasswordEncoder;
////import org.springframework.security.web.SecurityFilterChain;
////import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
////
////import lombok.RequiredArgsConstructor;
////import org.springframework.security.config.http.SessionCreationPolicy;
//
//
////@Configuration
////@RequiredArgsConstructor
////public class SecurityConfiguration {
////
////    private final JwtRequestFilter jwtRequestFilter;
////    private final UserDetailsService userDetailsService;
////
////    @Bean
////    public PasswordEncoder passwordEncoder() {
////        return new BCryptPasswordEncoder();
////    }
////
////    @Bean
////    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
////        AuthenticationManagerBuilder authenticationManagerBuilder =
////                http.getSharedObject(AuthenticationManagerBuilder.class);
////
////        authenticationManagerBuilder
////                .userDetailsService(userDetailsService)
////                .passwordEncoder(passwordEncoder());
////
////        return authenticationManagerBuilder.build();
////    }
////
////    @Bean
////    protected SecurityFilterChain securityConfig(HttpSecurity http) throws Exception {
////        return http
////                .csrf(csrf -> csrf.disable()) // Disable CSRF for stateless JWT authentication
////                .authorizeHttpRequests(auth -> auth
////                        .requestMatchers("/api/auth/**").permitAll() // Open authentication endpoints
////                        .anyRequest().authenticated() // All other endpoints require authentication
////                )
////                .exceptionHandling(exceptions -> exceptions
////                        .authenticationEntryPoint((request, response, authException) -> {
////                            // Send 401 Unauthorized for unauthenticated access
////                            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
////                        })
////                        .accessDeniedHandler((request, response, accessDeniedException) -> {
////                            // Send 403 Forbidden for access denied
////                            response.sendError(HttpServletResponse.SC_FORBIDDEN, "Forbidden");
////                        })
////                )
////                .sessionManagement(session -> session
////                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS) // Stateless authentication
////                )
////                .addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class) // Add JWT filter before UsernamePasswordAuthenticationFilter
////                .build();
////    }
////
////}
//
//
//
//
//
////import org.springframework.context.annotation.Bean;
////import org.springframework.context.annotation.Configuration;
////import org.springframework.security.authentication.AuthenticationManager;
////import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
////import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
////import org.springframework.security.crypto.password.PasswordEncoder;
////
////@Configuration
////public class SecurityConfig {
////
////    @Bean
////    public PasswordEncoder passwordEncoder() {
////        return new BCryptPasswordEncoder();
////    }
////
////    @Bean
////    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
////        return configuration.getAuthenticationManager();
////    }
////}
