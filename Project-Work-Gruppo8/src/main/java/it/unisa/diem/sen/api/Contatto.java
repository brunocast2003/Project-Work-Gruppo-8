/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.sen.api;

import java.util.List;

/**
 *
 * @author gruppo8
 */
public class Contatto implements Comparable<Contatto>, Validatore{
    
    private String nome;
    private String cognome;
    private List<String> email;
    private List<String> numTelefono;
    
    public Contatto(String nome, String cognome){
        
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        
    }

    public List<String> getEmail() {
        return null;
    }

    public void setEmail(String email) {
        
    }

    public List<String> getNumTelefono() {
        return null;
    }

    public void setNumTelefono(String numTelefono) {
        
    }
    
    public void aggiungiNumeroTelefono(String numero) {
        
    }
    
    public void aggiungiEmail(String email) {
        
    }
    
    @Override
    public int compareTo(Contatto o) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean validaEmail(String email) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public boolean validaNumTelefono(String numTelefono) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public boolean validaContatto(Contatto contatto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
