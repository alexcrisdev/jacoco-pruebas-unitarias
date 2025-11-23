/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.practica_calificada_2;

import java.util.Map;
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
public class inventory_managerTest {
    
    @Test
    void agregarProductoNuevoEnInventarioVacio() {
        
        inventory_manager manager = new inventory_manager();

       
        manager.addItem("Laptop", 5);

        
        int stockLaptop = manager.getStock("Laptop");

        assertAll(
                "Validar alta de producto nuevo",
                () -> assertEquals(5, stockLaptop,
                        "El stock de 'Laptop' debe ser 5 después de agregar 5 unidades"),
                () -> assertTrue(manager.getInventory().containsKey("Laptop"),
                        "El inventario debe contener la clave 'Laptop'")
        );
    }

    
    @Test
    void agregarElMismoProductoDosVeces() {
        
        inventory_manager manager = new inventory_manager();

        
        manager.addItem("Laptop", 3);
        manager.addItem("Laptop", 2);

        
        int stockLaptop = manager.getStock("Laptop");

        assertAll(
                "Validar suma de cantidades",
                () -> assertEquals(5, stockLaptop,
                        "El stock de 'Laptop' debe ser 5 (3 + 2)"),
                () -> assertTrue(stockLaptop > 0,
                        "El stock de 'Laptop' debe ser mayor que 0")
        );
    }

    @Test
    void agregarProductoConCantidadNegativa() {
        
        inventory_manager manager = new inventory_manager();

        
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> manager.addItem("Mouse", -1)
        );

        assertEquals("La cantidad debe ser mayor a 0",
                exception.getMessage(),
                "El mensaje debe indicar que la cantidad debe ser mayor a 0");

        assertFalse(manager.getInventory().containsKey("Mouse"),
                "El inventario no debe contener 'Mouse' cuando la operación falla");
    }

    @Test
    void agregarConProductoCero() {
        
        inventory_manager manager = new inventory_manager();

        
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> manager.addItem("Teclado", 0)
        );

        // Assert
        assertEquals("La cantidad debe ser mayor a 0",
                exception.getMessage(),
                "El mensaje debe indicar que la cantidad debe ser mayor a 0");

        assertFalse(manager.getInventory().containsKey("Teclado"),
                "El inventario no debe contener 'Teclado' cuando la operación falla");
    }

    @Test
    void agregarProductoConNombreVacio() {
        
        inventory_manager manager = new inventory_manager();
        String emptyName = "";

        
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> manager.addItem(emptyName, 5)
        );

        
        assertEquals("El nombre del producto no puede estar vacío",
                exception.getMessage(),
                "El mensaje debe indicar que el nombre del producto no puede estar vacío");

        assertTrue(manager.getInventory().isEmpty(),
                "El inventario debe seguir vacío al fallar por nombre vacío");
    }

    @Test
    void dadoCantidad_mayoralpermitido() {
       
        inventory_manager manager = new inventory_manager();

        
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> manager.addItem("Monitor", 1500)
        );

       
        assertEquals("La cantidad no puede ser mayor a 1000",
                exception.getMessage(),
                "El mensaje debe indicar que la cantidad no puede ser mayor a 1000");

        assertFalse(manager.getInventory().containsKey("Monitor"),
                "El inventario no debe contener 'Monitor' cuando la operación falla");
    }   
    
    @Test
    void agregarProductoConNombreNull_lanzaIllegal() {
        inventory_manager manager = new inventory_manager();

        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> manager.addItem(null, 5)
        );

        assertEquals("El nombre del producto no puede estar vacío", ex.getMessage());
        assertTrue(manager.getInventory().isEmpty());
    }
    
    @Test
    void agregarProductoConNombreMuyCorto_lanzaIllegal() {
        
        inventory_manager manager = new inventory_manager();

        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> manager.addItem("A", 5)
        );

        assertEquals("El nombre del producto debe tener al menos 2 caracteres", ex.getMessage());
        assertTrue(manager.getInventory().isEmpty());
    }
    
    @Test
    void agregarProductoConNombreMuyLargo_lanzaIllegal() {
        inventory_manager manager = new inventory_manager();
        String nombreLargo = "A".repeat(51); 

        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> manager.addItem(nombreLargo, 5)
        );

        assertEquals("El nombre del producto no puede exceder 50 caracteres", ex.getMessage());
        assertTrue(manager.getInventory().isEmpty());
    }
    
    @Test
    void getStockConNombreNull_retornaCero() {
        inventory_manager manager = new inventory_manager();
        manager.addItem("Laptop", 5);   

        int stockNull = manager.getStock(null);

        assertEquals(0, stockNull);
    }        
    
}
