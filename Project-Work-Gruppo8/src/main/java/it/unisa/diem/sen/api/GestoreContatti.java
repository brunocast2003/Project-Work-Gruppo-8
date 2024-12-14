
package it.unisa.diem.sen.api;

import java.util.Collection;

/**
 * @brief Interfaccia utilizzata per la gestione delle operazioni su ogni contatto
 *
 * @author Castellano Bruno
 * @author Gireco Giovanni
 * @author Giachetta Corradomaria
 * @author Di Carluccio Alessandro
 * 
 * @param <T extends Contatto> parametro di tipo Contatto o un eventuale sottoclasse
 */
public interface GestoreContatti<T extends Contatto> {
    
    void aggiungiContatto(T contatto);
    
    void rimuoviContatto(T contatto);
    
    
    <C extends Collection<T>> C cercaContatto(String cerca); 
    
    void ordinaRubrica();
    
    <C extends Collection<T>> C getTuttiContatti();  
    
}

    
    

