/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package it.unisa.diem.sen.api;

/**
 * @brief Interfaccia per la gestione dell'I/O della rubrica.
 * 
 * @author Castellano Bruno
 * @author Grieco Giovanni
 * @author Giachetta Corradomaria
 * @author Di Carluccio Alesssandro
 * 
 * Questa interfaccia definisce i metodi per caricare e salvare una rubrica da e verso un file.
 */
public interface FileIO {

    Rubrica caricaRubrica(String nomefile);

    void salvaRubrica(String nomefile);
}
