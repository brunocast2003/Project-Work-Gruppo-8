/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.sen.api;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Castellano Bruno
 * @author Grieco Giovanni
 * @author Giachetta Corradomaria
 * @author Di Carluccio Alesssandro
 * 
 * @date December 10, 2024
 */

public class ContattoTest {
    
    private Contatto contatto1;
    private Contatto contatto2;
    private Contatto contatto3;
    private List<String> email;
    private List<String> numTelefono;
    
    @BeforeEach
    public void setUp() {
        contatto1 = new Contatto("Giuseppe", "Russo");
        contatto2 = new Contatto(null, null);
        contatto3 = new Contatto("Giuseppe", null);
        email = new ArrayList<String>(3);
        numTelefono = new ArrayList<String>(3);
    }
    
    @Test
    public void  testContatto(){
        assertEquals("Giuseppe", contatto1.getNome());
        assertEquals("Russo", contatto1.getCognome());
        assertEquals(null, contatto2.getNome());
        assertEquals(null, contatto2.getCognome());
        assertEquals("Giuseppe", contatto3.getNome());
        assertEquals(null, contatto3.getCognome());
        
        for(String e : email){
            assertEquals(" ", e);
        }
        
        for(String n : numTelefono){
            assertEquals(" ", n);
        }
        
    }
    
    @Test
    public void testGetNome(){
        assertEquals("Giuseppe", contatto1.getNome());
        assertEquals(null, contatto2.getNome());
    }
    
    @Test
    public void testGetCognome(){
        assertEquals("Russo", contatto1.getCognome());
        assertEquals(null, contatto3.getCognome());
    }
    
    @Test
    public void testValidaEmail(){
    assertTrue(contatto1.validaEmail("example@email.com")); // Email valida
    assertFalse(contatto1.validaEmail("example.it")); // Email non valida
    assertFalse(contatto1.validaEmail("example@com")); // Email non valida
    assertFalse(contatto1.validaEmail("")); // Email vuota
    }
}
