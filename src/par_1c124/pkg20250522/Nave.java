/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package par_1c124.pkg20250522;

/**
 *
 * @author lukab
 */
public abstract class Nave implements Comparable<Nave>{
    private String nombre;
    private int capacidadTripulacion;
    private int año;

    public Nave(String nombre, int capacidadTripulacion, int año) {
        this.nombre = nombre;
        this.capacidadTripulacion = capacidadTripulacion;
        this.año = año;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCapacidadTripulacion() {
        return capacidadTripulacion;
    }

    public int getAño() {
        return año;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Nave))return false; 
        Nave otra = (Nave) obj;
        return this.año == otra.año && this.nombre.equalsIgnoreCase(otra.nombre);
    }
    
    
    @Override
    public int compareTo(Nave otra) {
        return Integer.compare(this.año, otra.año);
    }
    
}
