/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.diem.sen.api;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
/**
 *
 * @author Alessandro
 */
public class ValidatoreStandardTest {
    private final ValidatoreStandard validatore;
    public ValidatoreStandardTest(){
      validatore=new ValidatoreStandard();
    }
 @Test
 public void testValidaEmail(){
     assertTrue(validatore.validaEmail("alessandro@gmail.com"));
     assertTrue(validatore.validaEmail("bro.ciao@hotmail.com"));
     assertTrue(validatore.validaEmail(""));
     assertFalse(validatore.validaEmail("marioorris@gmailcom")); 
     assertFalse(validatore.validaEmail("plainaddress"));
     assertFalse(validatore.validaEmail("ciao@.com"));
 }
@Test
public void testValidaNumTelefono(){
    assertTrue(validatore.validaNumTelefono(""));
    assertTrue(validatore.validaNumTelefono("123456789"));
    assertFalse(validatore.validaNumTelefono("12345c"));
}
@Test
public void testValidaNome(){
    assertTrue(validatore.validaNome(" alessandro"));
    assertFalse(validatore.validaNome(null));
    assertFalse(validatore.validaNome(" ")); 
}
@Test 
public void testValidaCognome(){
    assertFalse(validatore.validaCognome("  "));
    assertFalse(validatore.validaCognome(null));
    assertTrue(validatore.validaCognome("di carluccio"));
}
}
