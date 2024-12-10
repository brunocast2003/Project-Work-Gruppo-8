/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package it.unisa.diem.sen.api;

import java.util.Collection;

/**
 *
 * @author Castellano Bruno
 * @author Gireco Giovanni
 * @author Giachetta Corradomaria
 * @author Di Carluccio Alessandro
 * @param <T extends Contatto> parametro di tipo Contatto o un eventuale sottoclasse
 */
public interface GestoreContatti<T extends Contatto> {
    
    void aggiungiContatto(T contatto);
    
    void modificaContatto(T contatto);
    
    <C extends Collection<T>> C cercaContatti(String cerca); 
    
    void ordinaRubrica();
    
    <C extends Collection<T>> C getTuttiContatti();  
    
}

    
    

