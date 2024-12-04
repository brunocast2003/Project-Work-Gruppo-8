/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.sen.api;

/**
 *
 * @author bruno
 */
public class Contatto {
    
    private String nome;
    private String cognome;
    private String email;
    private String numTelefono;
    
    public Contatto(String nome, String cognome, String email, String numTelefono){
        
    }
    
    public Contatto modificaContatto(Contatto c){
        return c;
    }
    
}
