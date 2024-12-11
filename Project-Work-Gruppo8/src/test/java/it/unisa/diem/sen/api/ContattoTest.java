/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.sen.api;

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
        contatto1 = new Contatto("Bruno", "Grieco");
        contatto2 = new Contatto(null, null);
        contatto3 = new Contatto("Bruno", null);
        
    }
    
    @Test
    public void  testContatto(){
        assertEquals("Bruno", contatto1.getNome());
        assertEquals("Grieco", contatto1.getCognome());
        assertEquals(null, contatto2.getNome());
        assertEquals(null, contatto2.getCognome());
        assertEquals("Bruno", contatto3.getNome());
        assertEquals(null, contatto3.getCognome());
    }
     
}
