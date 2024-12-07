/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.sen.api;

/**
 *
 * @author ggrie
 */
public interface Validatore {
    boolean validaEmail(String email);
    boolean validaNumTelefono(String numTelefono);
    boolean validaContatto(Contatto contatto);
}
