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
    
    @Test
    void testCorreoNuloLanzaExcepcion() {
        Email emailObj = new Email();

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> emailObj.isValidEmail(null)
        );

        assertEquals("El correo no puede ser nulo o vacío", exception.getMessage());
    }

    @Test
    void testCorreoVacioLanzaExcepcion() {
        Email emailObj = new Email();

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> emailObj.isValidEmail("")
        );

        assertEquals("El correo no puede ser nulo o vacío", exception.getMessage());
    }

    @Test
    void testCorreosSinArrobaODominioInvalido() {
        Email emailObj = new Email();

        assertAll(
                () -> assertFalse(emailObj.isValidEmail("usuario.gmail.com")),
                () -> assertFalse(emailObj.isValidEmail("usuario@com"))
        );
    }

    @Test
    void testCorreoValidoFormatoCorrecto() {
        Email emailObj = new Email();

        boolean resultado = emailObj.isValidEmail("cliente123@tienda.com");

        assertTrue(resultado);
    }

    @Test
    void testCorreoLongitudMinimaValido() {
        Email emailObj = new Email();

        boolean resultado = emailObj.isValidEmail("a@b.co");

        assertTrue(resultado);
    }

    @Test
    void testProblemasParteLocal() {
        Email emailObj = new Email();

        assertAll(
                () -> assertFalse(emailObj.isValidEmail(".usuario@tienda.com")),
                () -> assertFalse(emailObj.isValidEmail("usuario.@tienda.com")),
                () -> assertFalse(emailObj.isValidEmail("us..uario@tienda.com"))
        );
    }
}
