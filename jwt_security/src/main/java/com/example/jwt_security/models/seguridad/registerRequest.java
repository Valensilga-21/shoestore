package com.example.jwt_security.models.seguridad;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class registerRequest {
    /*
     * Contiene la estructura de la repeticion de registro
     */

     String email;
     String password;
     String confirmPassword;
}
