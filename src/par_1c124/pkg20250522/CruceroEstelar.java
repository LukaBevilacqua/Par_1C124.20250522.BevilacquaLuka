/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package par_1c124.pkg20250522;

/**
 *
 * @author lukab
 */
public class CruceroEstelar extends Nave{
    private int cantPasajeros;

    public CruceroEstelar(int cantPasajeros, String nombre, int capacidadTripulacion, int año) {
        super(nombre, capacidadTripulacion, año);
        this.cantPasajeros = cantPasajeros;
    }
    
    @Override
    public String toString() {
        return "Nombre: " + this.getNombre() + " Capacidad de tripulacion: " + this.getCapacidadTripulacion()
                + " Año: "+ this.getAño() + " Cantidad de pasajeros: " + cantPasajeros;
    }
}
