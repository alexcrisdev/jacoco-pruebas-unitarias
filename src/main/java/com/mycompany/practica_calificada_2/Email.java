/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica_calificada_2;

/**
 *
 * @author ALEX-LAPTOP
 */
public class Email {
    
    public boolean isValidEmail(String email) {
        
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("El correo no puede ser nulo o vacío");
        }

        email = email.trim();

        if (email.length() < 6) {
            return false;
        }

        if (email.length() > 254) {
            return false;
        }

        if (email.contains(" ")) {
            return false;
        }

        int indiceArroba = email.indexOf('@');
        int ultimoIndiceArroba = email.lastIndexOf('@');

        if (indiceArroba == -1) {
            return false;
        }

        if (indiceArroba != ultimoIndiceArroba) {
            return false;
        }

        String parteLocal = email.substring(0, indiceArroba);
        String dominio = email.substring(indiceArroba + 1);

        if (parteLocal.length() == 0 || dominio.length() == 0) {
            return false;
        }

        if (parteLocal.charAt(0) == '.' ||
            parteLocal.charAt(parteLocal.length() - 1) == '.') {
            return false;
        }

        for (int i = 0; i < parteLocal.length() - 1; i++) {
            if (parteLocal.charAt(i) == '.' && parteLocal.charAt(i + 1) == '.') {
                return false;
            }
        }

        for (int i = 0; i < parteLocal.length(); i++) {
            char c = parteLocal.charAt(i);
            if (!Character.isLetterOrDigit(c) && c != '.' && c != '-' && c != '_') {
                return false;
            }
        }


        int indicePunto = dominio.indexOf('.');
        if (indicePunto == -1) {
            return false;
        }

        int indiceUltimoPunto = dominio.lastIndexOf('.');
        String nombreDominio = dominio.substring(0, indiceUltimoPunto);
        String extension = dominio.substring(indiceUltimoPunto + 1);

        if (nombreDominio.length() < 1) {
            return false;
        }

        if (extension.length() < 2) {
            return false;
        }

        for (int i = 0; i < dominio.length(); i++) {
            char c = dominio.charAt(i);
            if (!Character.isLetterOrDigit(c) && c != '.' && c != '-') {
                return false;
            }
        }

        for (int i = 0; i < extension.length(); i++) {
            char c = extension.charAt(i);
            if (!Character.isLetter(c)) {
                return false;
            }
        }
        
        return true;
    }
}
