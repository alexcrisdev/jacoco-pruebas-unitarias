/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica_calificada_2;

/**
 *
 * @author ALEX-LAPTOP
 */
public class text_processor {
    
    public String processText(String text) {

        if (text == null) {
            throw new IllegalArgumentException("El texto no puede ser nulo");
        }

        if (text.isEmpty()) {
            throw new IllegalArgumentException("El texto no puede estar vacío");
        }

        if (text.length() > 1000) {
            throw new IllegalArgumentException("El texto excede el límite de 1000 caracteres");
        }

        if (text.trim().isEmpty()) {
            throw new IllegalArgumentException("El texto no puede contener solo espacios");
        }

        String trimmed = text.trim();

        String reversed = new StringBuilder(trimmed).reverse().toString();

        return reversed.toUpperCase();
    }
    
}
