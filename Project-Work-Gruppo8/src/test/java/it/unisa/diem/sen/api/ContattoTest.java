/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.sen.api;

import java.util.ArrayList;
import java.util.Arrays;
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
    
    /*private String email1;
    private String email2;
    private String email3;
    
    private String numero1;
    private String numero2;
    private String numero3;*/

    @BeforeAll
    public static void setUpClass() throws Exception {
    }

    @AfterAll
    public static void tearDownClass() throws Exception {
    }
    
    
    @BeforeEach
    public void setUp() {
        contatto1 = new Contatto("Giuseppe", "Russo");      
        contatto2 = new Contatto("Andrea", null);
        contatto3 = new Contatto(null, "Bianchi");
        
        contatto2.aggiungiEmail("example@email.com");
        contatto2.aggiungiNumTelefono("3478784983");
        
        
    }

    @AfterEach
    public void tearDown() throws Exception {
    }
    
    @Test
    public void  testContatto(){
        assertEquals("Giuseppe", contatto1.getNome());
        assertEquals("Russo", contatto1.getCognome());
        
        assertEquals("Andrea", contatto2.getNome());
        assertEquals("", contatto2.getCognome());
        
        assertEquals("", contatto3.getNome());
        assertEquals("Bianchi", contatto3.getCognome());
        
        //Nome e cognome entrmabi vuoti 
        assertThrows(IllegalArgumentException.class, () -> new Contatto(null, null));
        
        assertTrue(contatto1.getEmail().isEmpty());
        assertTrue(contatto1.getNumTelefono().isEmpty());
        
    }
    
    @Test
    public void testGetNome(){
        assertEquals("Giuseppe", contatto1.getNome());
        assertEquals("", contatto2.getNome());
    }
    
    @Test
    public void testGetCognome(){
        assertEquals("Russo", contatto1.getCognome());
        assertEquals("", contatto3.getCognome());
    }
    
    
    
   

    /**
     * Test of setNome method, of class Contatto.
     */
    @Test
    public void testSetNome() {
        contatto1.setNome("Mario");
        assertEqual(contatto1.getNome(),"Mario");
    }

    /**
     * Test of setCognome method, of class Contatto.
     */
    @Test
    public void testSetCognome() {
        contatto1.setCognome("Rossi");
        assertEqual(contatto1.getCognome(),"Rossi");
    }

    /**
     * Test of getEmail method, of class Contatto.
     */
    @Test
    public void testGetEmail() {
        assertEquals(contatto2.getEmail().size(),1);
        assertTrue(contatto2.getEmail().contains("example@email.com"));
    }

    /**
     * Test of setEmail method, of class Contatto.
     */
    @Test
    public void testSetEmail() {
       List<String> test = new ArrayList<>(Arrays.asList("example1@email.com", "example2@email.com", "example3@email.com"));
       contatto1.setEmail(test);
       assertTrue(test.equals(contatto1.getEmail()));

    }

    /**
     * Test of getNumTelefono method, of class Contatto.
     */
    @Test
    public void testGetNumTelefono() {
        assertEquals(contatto2.getNumTelefono().size(),1);
        assertTrue(contatto2.getEmail().contains("3478784983"));
    }

    /**
     * Test of setNumTelefono method, of class Contatto.
     */
    @Test
    public void testSetNumTelefono() {
        List<String> test = new ArrayList<>(Arrays.asList("3478784983","118","089389"));
        contatto1.setNumTelefono(test);
        assertTrue(test.equals(contatto1.getNumTelefono()));
    }

 
    @Test
    public void testAggiungiEmail(){
    assertThrows(IllegalArgumentException.class, () -> contatto1.aggiungiEmail("bad.example@email"));

    // Aggiunta di email valide
    contatto1.aggiungiEmail("example@email.com");
    contatto1.aggiungiEmail("example2@email.com");
    contatto1.aggiungiEmail("example3@email.com");

    // Verifica che venga lanciata un'eccezione quando si tenta di aggiungere una quarta email
    assertThrows(IllegalStateException.class, () -> contatto1.aggiungiEmail("example4@email.com"));

    // Verifica che la lista delle email abbia esattamente 3 elementi
    assertEquals(3, contatto1.getEmail().size());

    // Verifica che le email aggiunte siano corrette
    assertEquals("example@email.com", contatto1.getEmail().get(0));
    assertEquals("example2@email.com", contatto1.getEmail().get(1));
    assertEquals("example3@email.com", contatto1.getEmail().get(2));
       
    }
    @Test
    public void testAggiungiNumeroTelefono() {
    assertThrows(IllegalArgumentException.class, () -> contatto1.aggiungiNumeroTelefono("Stringa"));

    //Aggiunta numeri validi
    contatto1.aggiungiNumeroTelefono("001");
    contatto1.aggiungiNumeroTelefono("010");
    contatto1.aggiungiNumeroTelefono("011");

    //Aggiunta oltre il limite non consentita
    assertThrows(IllegalStateException.class, () -> contatto1.aggiungiNumeroTelefono("100"));

    
    assertEquals(3, contatto1.getNumTelefono().size());

   
    assertEquals("example@email.com", contatto1.getNumTelefono().get(0));
    assertEquals("example2@email.com", contatto1.getNumTelefono().get(1));
    assertEquals("example3@email.com", contatto1.getNumTelefono().get(2));
    }

    /**
     * Test of compareTo method, of class Contatto.
     */
    @Test
    public void testCompareTo() {
        assertEquals(contatto1.compareTo(contatto1),0);
        assertTrue(contatto1.compareTo(contatto2)>0);
        assertTrue(contatto1.compareTo(contatto3)<0);
    }

    @Test
    public void testValidaEmail(){
    assertTrue(contatto1.validaEmail("example@email.com")); 
    assertFalse(contatto1.validaEmail("example.it")); 
    assertFalse(contatto1.validaEmail("example@com")); 
    assertFalse(contatto1.validaEmail(" ")); 
    }
    
    @Test
    public void testValidaNumTelefono() {
        assertTrue(contatto1.validaNumTelefono("0892289849")); 
        assertFalse(contatto1.validaNumTelefono("s")); 
        assertFalse(contatto1.validaNumTelefono("+8988989")); 
        assertFalse(contatto1.validaNumTelefono("  ")); 
    }

   
    @Test
    public void testValidaNome() {
        assertTrue(contatto1.validaNome("Mario"));
        assertFalse(contatto1.validaNome(""));
        assertFalse(contatto1.validaNome(null));
        assertFalse(contatto1.validaNome("   "));
    }

    /**
     * Test of validaCognome method, of class Contatto.
     */
    @Test
    public void testValidaCognome() {
         assertTrue(contatto1.validaCognome("Mario"));
        assertFalse(contatto1.validaCognome(""));
        assertFalse(contatto1.validaCognome(null));
        assertFalse(contatto1.validaCognome("   "));
    }

    
}
