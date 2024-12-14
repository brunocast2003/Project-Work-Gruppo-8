/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.diem.sen.api;

import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
/**
 *
 * @author Alessandro
 */
public class RubricaTest {
private Rubrica rubrica;
public RubricaTest(){
   rubrica=new  Rubrica();
    }
@Test 
public void testAggiungiContatto(){
  Contatto c=new Contatto("andrea", "bruno");
  rubrica.aggiungiContatto(c);
    assertEquals(c, rubrica.getTuttiContatti().get(0));
    assertEquals(1, rubrica.getTuttiContatti().size());
}
@Test
public void testRimuoviContatto(){
  Contatto c1=new Contatto("pasquale", "chiacchio");
  c1.aggiungiNumeroTelefono("354205020423");
  c1.aggiungiEmail("pasquale@example.com");
  rubrica.aggiungiContatto(c1);
    assertEquals(1, rubrica.getTuttiContatti().size());
  rubrica.rimuoviContatto(c1);
    assertEquals(0,rubrica.getTuttiContatti().size());
    assertFalse(rubrica.getTuttiContatti().contains(c1));
}

@Test 
public void testModificaContatto(){
  Contatto c=new Contatto("alessandro", "di carluccio");
  c.aggiungiEmail("alex@gmail.com");
  c.aggiungiNumeroTelefono("3245600604");
  Contatto c1= new Contatto("alessandro", "chiacchio");
  c1.aggiungiEmail("example@gmail.com");
  c1.aggiungiNumeroTelefono("3243353341");
  rubrica.aggiungiContatto(c);
    assertEquals(1, rubrica.getTuttiContatti().size());
  rubrica.modificaContatto(c1);
    assertEquals(c, rubrica.getTuttiContatti().get(0));
}
@Test 
public void testCercaContatto(){
 Contatto c=new Contatto("andrea","bruno");
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
        Contatto c2 = new Contatto("Pasquale", "Chiacchio");
        rubrica.aggiungiContatto(c1);
        rubrica.aggiungiContatto(c2);
        rubrica.ordinaRubrica();
        assertEquals(c2, rubrica.getTuttiContatti().get(0)); 
        assertEquals(c1, rubrica.getTuttiContatti().get(1));
    }
@Test
public void testGetTuttiContatti(){
    Contatto c1=new Contatto("mario","ambrosone");
     Contatto c2=new Contatto("mario","ambrosone");
  rubrica.aggiungiContatto(c1);
  rubrica.aggiungiContatto(c2);
 List<Contatto> list2=rubrica.getTuttiContatti();
    assertEquals(2, list2.size());
    assertEquals(c1, list2.get(0));
    assertEquals(c2, list2.get(1));
}

}
