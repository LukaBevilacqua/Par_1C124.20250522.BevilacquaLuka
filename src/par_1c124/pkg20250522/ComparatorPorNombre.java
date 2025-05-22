/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package par_1c124.pkg20250522;

import java.util.Comparator;

/**
 *
 * @author lukab
 */
public class ComparatorPorNombre implements Comparator<Nave>{
    
    @Override
    public int compare(Nave n1, Nave n2){
        return n1.getNombre().compareTo(n2.getNombre());
    }
}
