/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.practica_calificada_2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author ALEX-LAPTOP
 */
public class password_validatorTest {
    
    @BeforeEach
    void setup(){
        new password_validator();
    }
    
    @Test
    void contraseniaNull_lanzaIllegal(){
        String password = null;
        
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> password_validator.isValid(password)
        );
        
        //Assert
        assertEquals("La contraseña no puede ser nula o vacía.", exception.getMessage());        
    }
    
    
    @Test
    void contraseniaVacia_lanzaIllegal(){
        String password = "";
        
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> password_validator.isValid(password)
        );
        
        //Assert
        assertEquals("La contraseña no puede ser nula o vacía.", exception.getMessage());
    }
    
    
    @Test
    void contraseniaValida_lanzaTrue(){
        String password = "Secure123!";
        
        boolean result = password_validator.isValid(password);
        
        assertAll(
                "Validación de contraseña válida",
                () -> assertTrue(result, "La contraseña debería ser válida"),
                () -> assertEquals(true, result, "El resultado debería ser true")
        );
    }
    
    
    @Test   
    void contraseniaCorta_lanzaFalse(){
        String password = "Abc1!d";
        
        boolean result = password_validator.isValid(password);
        
        assertFalse(result, "La contraseña con menos de 8 caracteres debe ser inválida");
    }
    
    
    @Test
    void contraseniaSinMayuscula_lanzaFalse(){
        String password = "nosecura";
        
        boolean result = password_validator.isValid(password);
        
        assertFalse(result, "La contraseña sin mayúsculas ni dígitos debe ser inválida");
    }
    
   
    @Test
    void contraseniaConEspacio_lanzaFalse(){
        String password = "Secure 123!";
        
        boolean result = password_validator.isValid(password);
        
        assertFalse(result, "La contraseña con espacios en blanco debe ser inválida");
    }
    
    @Test
    void contraseniaMuyLarga_lanzaFalse() {
        // Si usas Java 11+
        String password = "A".repeat(65);

        boolean result = password_validator.isValid(password);

        assertFalse(result, "La contraseña de más de 64 caracteres debe ser inválida");
    }

    @Test
    void contraseniaConCaracterNoPermitido_lanzaFalse() {
        String password = "Secure123€";   

        boolean result = password_validator.isValid(password);

        assertFalse(result, "La contraseña con caracteres no permitidos debe ser inválida");
    }

    @Test
    void contraseniaSinMinusculas_lanzaFalse() {
        String password = "SECURE123!";

        boolean result = password_validator.isValid(password);

        assertFalse(result, "La contraseña sin minúsculas debe ser inválida");
    }

    @Test
    void contraseniaSinDigito_lanzaFalse() {
        String password = "SecurePass!";

        boolean result = password_validator.isValid(password);

        assertFalse(result, "La contraseña sin dígitos debe ser inválida");
    }

    @Test
    void contraseniaSinCaracterEspecial_lanzaFalse() {
        String password = "Secure1234";

        boolean result = password_validator.isValid(password);

        assertFalse(result, "La contraseña sin caracteres especiales debe ser inválida");
    }
    
}
