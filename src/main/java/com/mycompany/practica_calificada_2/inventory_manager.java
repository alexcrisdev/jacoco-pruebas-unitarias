/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica_calificada_2;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ALEX-LAPTOP
 */
public class inventory_manager {
    
    private final Map<String, Integer> inventory = new HashMap<>();

    public void addItem(String item, int quantity) {

        if (item == null) {
            throw new IllegalArgumentException("El nombre del producto no puede estar vacío");
        }

        String trimmed = item.trim();

        if (trimmed.isEmpty()) {
            throw new IllegalArgumentException("El nombre del producto no puede estar vacío");
        }

        if (trimmed.length() < 2) {
            throw new IllegalArgumentException("El nombre del producto debe tener al menos 2 caracteres");
        }

        if (trimmed.length() > 50) {
            throw new IllegalArgumentException("El nombre del producto no puede exceder 50 caracteres");
        }

        if (quantity <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor a 0");
        }

        if (quantity > 1000) {
            throw new IllegalArgumentException("La cantidad no puede ser mayor a 1000");
        }

        int current = inventory.getOrDefault(trimmed, 0);
        int newQuantity = current + quantity;

        inventory.put(trimmed, newQuantity);
    }
    
    public int getStock(String item) {
        if (item == null) {
            return 0;
        }
        String trimmed = item.trim();
        return inventory.getOrDefault(trimmed, 0);
    }
    
    public Map<String, Integer> getInventory() {
        return new HashMap<>(inventory);
    }
    
}
