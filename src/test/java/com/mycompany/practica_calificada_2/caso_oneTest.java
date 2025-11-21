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
public class caso_oneTest {
    
    
    @Test
    void contraseniaNull_lanzaIllegal(){
        String password = null;
        
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> caso_one.isValid(password)
        );
        
        assertEquals("La contraseña no puede ser nula o vacía.", exception.getMessage());        
    }
    
    
    @Test
    void contraseniaVacia_lanzaIllegal(){
        String password = "";
        
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> caso_one.isValid(password)
        );
        
        assertEquals("La contraseña no puede ser nula o vacía.", exception.getMessage());
    }
    
    
    @Test
    void contraseniaValida_lanzaTrue(){
        String password = "Secure123!";
        
        boolean result = caso_one.isValid(password);
        
        assertAll(
                "Validación de contraseña válida",
                () -> assertTrue(result, "La contraseña debería ser válida"),
                () -> assertEquals(true, result, "El resultado debería ser true")
        );
    }
    
    
    @Test   
    void contraseniaCorta_lanzaFalse(){
        String password = "Abc1!d";
        
        boolean result = caso_one.isValid(password);
        
        assertFalse(result, "La contraseña con menos de 8 caracteres debe ser inválida");
    }
    
    
    @Test
    void contraseniaSinMayuscula_lanzaFalse(){
        String password = "nosecura";
        
        boolean result = caso_one.isValid(password);
        
        assertFalse(result, "La contraseña sin mayúsculas ni dígitos debe ser inválida");
    }
    
   
    @Test
    void contraseniaConEspacio_lanzaFalse(){
        String password = "Secure 123!";
        
        boolean result = caso_one.isValid(password);
        
        assertFalse(result, "La contraseña con espacios en blanco debe ser inválida");
    }
}
