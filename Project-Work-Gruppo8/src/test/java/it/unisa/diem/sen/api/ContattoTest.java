/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.sen.api;

import java.util.AbstractList;
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
    public void testSetNome(){
        contatto1.setNome("mario");
        assertEquals("mario", contatto1.getNome());
    }
    
    @Test
    public void testGetCognome(){
        assertEquals("Russo", contatto1.getCognome());
        assertEquals("Bianchi", contatto3.getCognome());
    }
    
    @Test
    public void testSetCognome(){
        contatto1.setCognome("rossi");
        assertEquals("rossi", contatto1.getCognome());
    }
    
    @Test
    public void testGetEmail(){
        List<String>email=new ArrayList<>();
        email.add("mario@studenti.com");
        contatto1.setEmail(email);
        assertEquals(email,contatto1.getEmail());
    }
    
    @Test
    public void testSetEmail(){
        List<String> numeri=new ArrayList<>();
        numeri.add("mariorossi@gmail.com");
        contatto1.setEmail(numeri);
        assertEquals(numeri, contatto1.getEmail());
    }
    
    @Test
    public void testGetNumTelefono(){
        List<String> numeri=new ArrayList<>();
        numeri.add("341204042");
        contatto1.setNumTelefono(numeri);
        assertEquals(numeri, contatto1.getNumTelefono());
    }
    
    @Test
    public void testSetNumTelefono(){
        List<String> numeri=new ArrayList<>();
        numeri.add("010");
        contatto1.setNumTelefono(numeri);
        assertEquals(numeri, contatto1.getNumTelefono());
    }   
    
    
    @Test
    public void testAggiungiNumTelefono(){
        contatto1.aggiungiNumeroTelefono("3276518923");
        contatto1.aggiungiNumeroTelefono("333999666000");
        contatto1.aggiungiNumeroTelefono("1926");
        
        assertEquals("3276518923", contatto1.getNumTelefono().get(0));
        assertEquals("333999666000", contatto1.getNumTelefono().get(1));
        assertEquals("1926", contatto1.getNumTelefono().get(2));
    }
    
    @Test
    public void testAggiungiEmail(){
        contatto1.aggiungiEmail("example@email.com");
        contatto1.aggiungiEmail("example2@email.com");
        contatto1.aggiungiEmail("example3@email.com");

        assertEquals("example@email.com", contatto1.getEmail().get(0));
        assertEquals("example2@email.com", contatto1.getEmail().get(1));
        assertEquals("example3@email.com", contatto1.getEmail().get(2));
    }  
}
