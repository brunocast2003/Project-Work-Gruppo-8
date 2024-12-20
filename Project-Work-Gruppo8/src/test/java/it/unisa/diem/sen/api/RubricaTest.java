/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.diem.sen.api;

import java.util.List;
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
public class RubricaTest {
    private Rubrica rubrica;
    
    public RubricaTest(){
        rubrica=new  Rubrica();
    }
    
    @Test 
    public void testAggiungiContatto(){
        Contatto c=new Contatto("Bruno", "Di Carluccio");
        rubrica.aggiungiContatto(c);
        assertEquals(c, rubrica.getTuttiContatti().get(0));
        assertEquals(1, rubrica.getTuttiContatti().size());
    }
    @Test
    public void testRimuoviContatto(){
        Contatto c1=new Contatto("Pasquale", "La Mura");
        c1.aggiungiNumeroTelefono("354205020423");
        c1.aggiungiEmail("pasquale@example.com");
        rubrica.aggiungiContatto(c1);
        assertEquals(1, rubrica.getTuttiContatti().size());
        rubrica.rimuoviContatto(c1);
        assertEquals(0,rubrica.getTuttiContatti().size());
        assertFalse(rubrica.getTuttiContatti().contains(c1));
    }

    @Test 
    public void testCercaContatto(){
        Contatto c=new Contatto("Giovanni","Giachetta");
        rubrica.aggiungiContatto(c);
        assertEquals(1,rubrica.getTuttiContatti().size());
        assertEquals(c, rubrica.getTuttiContatti().get(0));
        assertTrue(rubrica.getTuttiContatti().contains(c));
    }
    
    @Test
    public void testOrdinaRubrica(){
        Contatto c1 = new Contatto("Alessandro", "Di Carluccio");
        c1.aggiungiNumeroTelefono("3421113445");
        c1.aggiungiEmail("example1@gmail.com");
        Contatto c2 = new Contatto("Armando", "Di Cesare");
        rubrica.aggiungiContatto(c1);
        rubrica.aggiungiContatto(c2);
        rubrica.ordinaRubrica();
        assertEquals(c1, rubrica.getTuttiContatti().get(0)); 
        assertEquals(c2, rubrica.getTuttiContatti().get(1));
    }
    
    @Test
    public void testGetTuttiContatti(){
        Contatto c1=new Contatto("Diego Armando","Maradona");
         Contatto c2=new Contatto("Khvicha","Kvaratskhelia");
        rubrica.aggiungiContatto(c1);
        rubrica.aggiungiContatto(c2);
        List<Contatto> list2=rubrica.getTuttiContatti();
        assertEquals(2, list2.size());
        assertEquals(c1, list2.get(0));
        assertEquals(c2, list2.get(1));
    }

}
