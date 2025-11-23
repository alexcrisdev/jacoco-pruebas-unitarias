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
public class EmailTest {
    
    private Email email;

    @BeforeEach
    void setUp() {
        email = new Email();
    }


    @Test
    void correosNulosOVaciosLanzanExcepcion() {
        assertAll(
                () -> {
                    IllegalArgumentException ex = assertThrows(
                            IllegalArgumentException.class,
                            () -> email.isValidEmail(null)
                    );
                    assertEquals("El correo no puede ser nulo o vacío", ex.getMessage());
                },
                () -> {
                    IllegalArgumentException ex = assertThrows(
                            IllegalArgumentException.class,
                            () -> email.isValidEmail("")
                    );
                    assertEquals("El correo no puede ser nulo o vacío", ex.getMessage());
                }
        );
    }


    @Test
    void correosSinArrobaODominioSinPuntoDevuelvenFalse() {
        assertAll(
                () -> assertFalse(email.isValidEmail("usuario.gmail.com")),
                () -> assertFalse(email.isValidEmail("usuario@com"))
        );
    }


    @Test
    void correosValidosConFormatoCorrecto() {
        assertAll(
                () -> assertTrue(email.isValidEmail("cliente123@tienda.com")),
                () -> assertTrue(email.isValidEmail("a@b.co")),
                () -> assertTrue(email.isValidEmail("user.name@dominio.com")),
                () -> assertTrue(email.isValidEmail("user-name@dominio.com")),
                () -> assertTrue(email.isValidEmail("user_name@dominio.com")),
                () -> assertTrue(email.isValidEmail("user@sub-dominio.com"))
        );
    }


    @Test
    void correosConLongitudInvalidaDevuelvenFalse() {
        assertAll(
                () -> assertFalse(email.isValidEmail("a@b.c")),  
                () -> {
                    String local = "a".repeat(250);            
                    String correo = local + "@b.com";
                    assertFalse(email.isValidEmail(correo));
                }
        );
    }


    @Test
    void correosConEspaciosOMultiplesArrobasDevuelvenFalse() {
        assertAll(
                () -> assertFalse(email.isValidEmail("cliente 123@tienda.com")),
                () -> assertFalse(email.isValidEmail("usu@ario@dominio.com"))
        );
    }


    @Test
    void correosConParteLocalODominioVaciosDevuelvenFalse() {
        assertAll(
                () -> assertFalse(email.isValidEmail("@tienda.com")),
                () -> assertFalse(email.isValidEmail("usuario@"))
        );
    }


    @Test
    void correosConProblemasDePuntosEnParteLocalDevuelvenFalse() {
        assertAll(
                () -> assertFalse(email.isValidEmail(".usuario@tienda.com")),
                () -> assertFalse(email.isValidEmail("usuario.@tienda.com")),
                () -> assertFalse(email.isValidEmail("us..uario@tienda.com"))
        );
    }


    @Test
    void correosConCaracteresInvalidosEnParteLocalODominioDevuelvenFalse() {
        assertAll(
                () -> assertFalse(email.isValidEmail("us$uario@tienda.com")), // local con $
                () -> assertFalse(email.isValidEmail("cliente@.com")),        // dominio sin nombre
                () -> assertFalse(email.isValidEmail("usuario@dom.c")),       // extensión de 1 char
                () -> assertFalse(email.isValidEmail("cliente@tie_nda.com")), // dominio con _
                () -> assertFalse(email.isValidEmail("cliente@tienda.c0m"))   // extensión con número
        );
    }   
}
