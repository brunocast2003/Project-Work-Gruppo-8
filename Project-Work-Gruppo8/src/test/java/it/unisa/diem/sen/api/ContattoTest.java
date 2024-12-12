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
    private Contatto contatto4;
    
    
    @BeforeEach
    public void setUp() {
        contatto1 = new Contatto("Giuseppe", "Russo");      
        contatto2 = new Contatto("Andrea", null);
        contatto3 = new Contatto(null, "Bianchi");
        
        
    }
    
    @Test
    public void  testContatto(){
        assertEquals("Giuseppe", contatto1.getNome());
        assertEquals("Russo", contatto1.getCognome());
        
        assertEquals("Andrea", contatto2.getNome());
        assertEquals(null, contatto2.getCognome());
        
        assertEquals(null, contatto3.getNome());
        assertEquals("Bianchi", contatto3.getCognome());
        
        
        assertTrue(contatto1.getEmail().isEmpty());
        assertTrue(contatto1.getNumTelefono().isEmpty());
        
    }
    
    @Test
    public void testGetNome(){
        assertEquals("Giuseppe", contatto1.getNome());
        assertEquals("Andrea", contatto2.getNome());
    }
    
    @Test
    public void testGetCognome(){
        assertEquals("Russo", contatto1.getCognome());
        assertEquals("Bianchi", contatto3.getCognome());
    }
    
    @Test
    public void testValidaEmail(){
    assertTrue(contatto1.validaEmail("example@email.com")); 
    assertFalse(contatto1.validaEmail("example.it")); 
    assertFalse(contatto1.validaEmail("example@com")); 
    assertFalse(contatto1.validaEmail(" ")); 
    }
    
    
    @Test
    public void testAggiungiEmail(){
        
    contatto1.aggiungiEmail("example@email.com");
    contatto1.aggiungiEmail("example2@email.com");
    contatto1.aggiungiEmail("example3@email.com");
    
    assertEquals(3, contatto1.getEmail().size());
    
    assertEquals("example@email.com", contatto1.getEmail().get(0));
    assertEquals("example2@email.com", contatto1.getEmail().get(1));
    assertEquals("example3@email.com", contatto1.getEmail().get(2));
       
    }
}
