/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package it.unisa.diem.sen.api;

/**
 * @brief Interfaccia per la validazione di contatti e relativi campi.
 * 
 * @author Castellano Bruno
 * @author Grieco Giovanni
 * @author Giachetta Corradomaria
 * @author Di Carluccio Alesssandro
 * 
 * Questa interfaccia definisce i metodi per validare email, numeri di telefono e contatti.
 */
public interface Validatore {

    boolean validaEmail(String email);

    boolean validaNumTelefono(String numTelefono);

    boolean validaNome(String nome);
    
    boolean validaCognome(String cognome);
}
