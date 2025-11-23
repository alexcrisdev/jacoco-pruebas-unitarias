/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica_calificada_2;

/**
 *
 * @author ALEX-LAPTOP
 */
public class password_validator {
    
    private static String CARACTERES_ESPECIALES = "!@#$%^&*()_-+={}[]|\\\\:;\\\"'<>,.?/";
    
    public static boolean isValid(String password){
        
        if (password == null || password.isEmpty()){
            throw new IllegalArgumentException("La contraseña no puede ser nula o vacía.");
        }
        
        int longitud = password.length();
        if (longitud < 8 || longitud > 64){
            return false;
        }
        
        
        boolean tieneMayuscula = false;
        boolean tieneMinuscula = false;
        boolean tieneDigito = false;
        boolean tieneEspecial = false;
        
        
        for (int i = 0; i < longitud; i++){
            char c = password.charAt(i);
            
            if (c == ' '){
                return false;
            }
            
            if(Character.isUpperCase(c)){
                tieneMayuscula = true;
            } else if(Character.isLowerCase(c)){
                tieneMinuscula = true;
            } else if(Character.isDigit(c)){
                tieneDigito = true;
            } else if(CARACTERES_ESPECIALES.indexOf(c) >= 0){
                tieneEspecial = true;
            } else{
                return false;
            }
        }
        
        return tieneMayuscula && tieneMinuscula && tieneDigito && tieneEspecial;        
    }    
}
