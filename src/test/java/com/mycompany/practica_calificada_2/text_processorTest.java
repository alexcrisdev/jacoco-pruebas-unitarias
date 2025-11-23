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
public class text_processorTest {
    
    @Test
    void textoNull_lanzaIllegalArgumentException() {
        text_processor processor = new text_processor();

        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> processor.processText(null)
        );

        assertEquals("El texto no puede ser nulo", ex.getMessage());
    }

    @Test
    void textoVacio_lanzaIllegalArgumentException() {
        text_processor processor = new text_processor();

        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> processor.processText("")
        );

        assertEquals("El texto no puede estar vacío", ex.getMessage());
    }

    @Test
    void textoMayorAlLimite_lanzaIllegalArgumentException() {
        text_processor processor = new text_processor();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 1001; i++) {
            sb.append('a');
        }
        String textoLargo = sb.toString();

        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> processor.processText(textoLargo)
        );

        assertEquals("El texto excede el límite de 1000 caracteres", ex.getMessage());
    }

    @Test
    void textoSoloEspacios_lanzaIllegalArgumentException() {
        text_processor processor = new text_processor();

        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> processor.processText("   ")
        );

        assertEquals("El texto no puede contener solo espacios", ex.getMessage());
    }

    @Test
    void textoValidoConEspaciosInternosYExtremos_seProcesaCorrectamente() {
        text_processor processor = new text_processor();

        String resultado = processor.processText("  hola mundo  ");

        assertEquals("ODNUM ALOH", resultado);
    }
}
