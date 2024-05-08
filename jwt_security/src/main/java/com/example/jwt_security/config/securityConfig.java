package com.example.jwt_security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import lombok.RequiredArgsConstructor;

@Configuration
//configurar la seguridad del proyecto
@EnableWebSecurity
//se incluye el constructor con lombok
@RequiredArgsConstructor
public class securityConfig {
    //filter chain encargado de filtrar las peticiones e indicar el acceso al end point
    @Bean
    //se utilizan para indicar que es un metodo de cofiguracion
    public SecurityFilterChain securityFilterChain(HttpSecurity http
    ) throws Exception 
    {
        return http
        .csrf(csrf->csrf.disable())
        .authorizeHttpRequests(
            authRequest->authRequest
            /*Todas la peticipones que comiencen por api/v1/public
            van a hacer permitidas sin restriccion del usuario
             */
            .requestMatchers("/api/v1/public/**")
            .permitAll()
            //para el resto de peticiones
            //es requerido que se autentique
            .anyRequest().permitAll()
        ).build();
    }
}
