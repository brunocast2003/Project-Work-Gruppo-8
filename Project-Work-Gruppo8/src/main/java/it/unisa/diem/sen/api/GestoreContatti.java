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
 */
public interface GestoreContatti<T extends Contatto, C extends Collection<T>> {
    
    void aggiungiContatto(T contatto);
    
    void modificaContatto(T contatto);
    
    C cercaContatti(String cerca); 
    
    void ordinaRubrica();
    
    C getTuttiContatti();  
    
}

    
    

