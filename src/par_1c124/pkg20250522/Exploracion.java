/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package par_1c124.pkg20250522;

/**
 *
 * @author lukab
 */
public class Exploracion extends Nave implements Explorable{
    private String tipoMision;

    public Exploracion(String tipoMision, String nombre, int capacidadTripulacion, int año) {
        super(nombre, capacidadTripulacion, año);
        this.tipoMision = tipoMision;
    }
    
    @Override
    public void explorar() {
        System.out.println("Saliendo a explorar, nave: " + this.getNombre());
    }
    
    @Override
    public String toString() {
        return "Nombre: " + this.getNombre() + " Capacidad de tripulacion: " + this.getCapacidadTripulacion()
                + " Año: "+ this.getAño() + " Tipo de mision: " + tipoMision;
    }
}
