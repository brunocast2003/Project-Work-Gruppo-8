/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.sen.api;

import java.util.List;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author bruno
 */
public class RubricaTest {
    
    public RubricaTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of aggiungiContatto method, of class Rubrica.
     */
    @Test
    public void testAggiungiContatto() {
        System.out.println("aggiungiContatto");
        Contatto contatto = null;
        Rubrica instance = new Rubrica();
        instance.aggiungiContatto(contatto);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of rimuoviContatto method, of class Rubrica.
     */
    @Test
    public void testRimuoviContatto() {
        System.out.println("rimuoviContatto");
        Contatto contatto = null;
        Rubrica instance = new Rubrica();
        instance.rimuoviContatto(contatto);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modificaContatto method, of class Rubrica.
     */
    @Test
    public void testModificaContatto() {
        System.out.println("modificaContatto");
        Contatto contatto = null;
        Rubrica instance = new Rubrica();
        instance.modificaContatto(contatto);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cercaContatto method, of class Rubrica.
     */
    @Test
    public void testCercaContatto() {
        System.out.println("cercaContatto");
        String cerca = "";
        Rubrica instance = new Rubrica();
        ObservableList<Contatto> expResult = null;
        ObservableList<Contatto> result = instance.cercaContatto(cerca);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ordinaRubrica method, of class Rubrica.
     */
    @Test
    public void testOrdinaRubrica() {
        System.out.println("ordinaRubrica");
        Rubrica instance = new Rubrica();
        instance.ordinaRubrica();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTuttiContatti method, of class Rubrica.
     */
    @Test
    public void testGetTuttiContatti() {
        System.out.println("getTuttiContatti");
        Rubrica instance = new Rubrica();
        List<Contatto> expResult = null;
        List<Contatto> result = instance.getTuttiContatti();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of caricaRubrica method, of class Rubrica.
     */
    @Test
    public void testCaricaRubrica() throws Exception {
        System.out.println("caricaRubrica");
        String nomefile = "";
        Rubrica instance = new Rubrica();
        Rubrica expResult = null;
        Rubrica result = instance.caricaRubrica(nomefile);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of salvaRubrica method, of class Rubrica.
     */
    @Test
    public void testSalvaRubrica() throws Exception {
        System.out.println("salvaRubrica");
        String nomefile = "";
        Rubrica instance = new Rubrica();
        instance.salvaRubrica(nomefile);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
