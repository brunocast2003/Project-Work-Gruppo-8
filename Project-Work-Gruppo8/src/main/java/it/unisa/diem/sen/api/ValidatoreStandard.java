/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.diem.sen.api;

/**
 *
 * @author corry
 */
public class ValidatoreStandard implements Validatore<Contatto>{

    public boolean validaEmail(String email) {
        return email.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$") || email.isEmpty();
    }

    /**
     * @brief Verifica che il numero di telefono in input contenga esclusivamente cifre decimali
     * 
     * @param[in] numTelefono Il numero di telefono da validare.
     * @return true se il numero è valido, false altrimenti.
     */
    
    public boolean validaNumTelefono(String numTelefono) {
        return numTelefono.matches("^[0-9]+$") || numTelefono.isEmpty();
    }

    /**
     * @brief Verifica che il contatto contenga un nome 
     * 
     * @param[in] nome Il nome da validare.
     * @return true se il nome è presente, false altrimenti.
     */
   
    public boolean validaNome(String nome) {
        return nome!=null && !nome.trim().isEmpty();
    }
    
     /**
     * @brief Verifica che il contatto contenga un cognome
     * 
     * @param[in] cognome Il cognome da validare.
     * @return true se il cognome è presente, false altrimenti.
     */
    
    public boolean validaCognome(String cognome) {
        return cognome!=null && !cognome.trim().isEmpty();
    }
    
}
