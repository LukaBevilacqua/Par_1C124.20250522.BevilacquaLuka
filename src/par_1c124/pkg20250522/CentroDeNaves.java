/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package par_1c124.pkg20250522;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author lukab
 */
public class CentroDeNaves {
    private String nombre;
    private ArrayList<Nave> listaNaves;

    public CentroDeNaves(String nombre) {
        this.nombre = nombre;
        this.listaNaves = new ArrayList<>();
    }
    
    public void mostrarNaves(){
        for(Nave n : listaNaves){
            System.out.println(n.toString());
        }
    }
    
    public void agregarNave(Nave nueva){
        for(Nave n : listaNaves){
            if(n.equals(nueva)){
                System.out.println("Ya existe una nave con ese nombre y año");
                return;
            }
        }
        listaNaves.add(nueva);
        System.out.println("Agregado correctamente");
    }
    
    public void iniciarExploracion(){
        for(Nave n : listaNaves){
            if(n instanceof Exploracion){
                Exploracion e = (Exploracion) n;
                e.explorar();
            }else if(n instanceof Carguero){
                Carguero c = (Carguero) n;
                c.explorar();
            }else{
                System.out.println("Esta nave no esta habilitada para esto: " + n.toString());
            }
        }
    }
    
    
    public void menuPrincipal(){
        Scanner sc = new Scanner(System.in);
        int opcion;
        do{
           System.out.println("\n-------------------------MENU------------------------------------");
           System.out.println("1. Agregar nave (Exploración, Carguero o Crucero Estelar)");
           System.out.println("2. Mostrar todas las naves registradas.");
           System.out.println("3. Iniciar misión de exploración");
           System.out.println("4. Mostrar naves ordenadas por nombre (Comparable)");
           System.out.println("5. Mostrar naves ordenadas por año de lanzamiento descendente");
           System.out.println("6. Mostrar naves ordenadas por capacidad de tripulación descendente.");
           System.out.println("7. Salir del Sistema");
           System.out.println("Opcion: ");
           opcion = sc.nextInt();
           sc.nextLine();
           switch(opcion){
               case 1:
                   System.out.println("Que tipo de nave quiere agregar (exploracion) (carguero) (crucero estelar)");
                   String opcionAgregar = sc.nextLine().toLowerCase();
                   this.menuAgregar(opcionAgregar);
                   break;
               case 2:
                   this.mostrarNaves();
                   break;
               case 3:
                   this.iniciarExploracion();
                   break;
               case 4:
                   Collections.sort(this.listaNaves, new ComparatorPorNombre());
                   this.mostrarNaves();
                   break;
               case 5:
                   Collections.sort(this.listaNaves, new ComparatorPorAño());
                   this.mostrarNaves();
                   break;
               case 6:
                   Collections.sort(this.listaNaves, new ComparatorPorCapacidadTripulacion());
                   this.mostrarNaves();
                   break;
                case 7:
                   System.out.println("Saliendo....");
                   break;
               default:
                   System.out.println("Opcion invalida, intente nuevamente");
           }
        }while(opcion != 7);
    }
    
    public void menuAgregar(String opcionPublicar){
        Scanner sc = new Scanner(System.in);
        switch(opcionPublicar){
            case "exploracion":
                System.out.println("Nombre: ");
                String nombreExploracion = sc.nextLine();
                int añoExploracion;
                while(true){
                    System.out.println("Año: ");
                    añoExploracion = sc.nextInt();
                    if(añoExploracion > 0){
                        break;
                    }else{
                        System.out.println("Año invalido, intente nuevamente");
                    }
                }
                sc.nextLine();
                int capacidadExploracion;
                while(true){
                    System.out.println("Capacidad de pasajeros: ");
                    capacidadExploracion = sc.nextInt();
                    if(capacidadExploracion > 0){
                        break;
                    }else{
                        System.out.println("capacidad invalida, intente nuevamente");
                    }
                }
                sc.nextLine();
                String tipoMision;
                while(true){
                    System.out.println("Mision [CARTOGRAFIA] [INVESTIGACION] [CONTACTO]: ");
                    tipoMision = sc.nextLine().toUpperCase();

                    if (tipoMision.equals("CARTOGRAFIA") || tipoMision.equals("INVESTIGACION") || 
                        tipoMision.equals("CONTACTO")){
                        break;
                    }else{
                        System.out.println("Mision invalida. Intente nuevamente. ");
                    }
                }
                Exploracion e = new Exploracion(tipoMision, nombreExploracion, capacidadExploracion, añoExploracion);
                this.agregarNave(e);
                break;
            case "carguero":
                System.out.println("Nombre: ");
                String nombreCarguero = sc.nextLine();
                int añoCarguero;
                while(true){
                    System.out.println("Año: ");
                    añoCarguero = sc.nextInt();
                    if(añoCarguero > 0){
                        break;
                    }else{
                        System.out.println("Año invalido, intente nuevamente");
                    }
                }
                sc.nextLine();
                int capacidadPasajerosCarguero;
                while(true){
                    System.out.println("Capacidad de pasajeros: ");
                    capacidadPasajerosCarguero = sc.nextInt();
                    if(capacidadPasajerosCarguero > 0){
                        break;
                    }else{
                        System.out.println("capacidad invalida, intente nuevamente");
                    }
                }
                sc.nextLine();
                int capacidadCarga;
                while(true){
                    System.out.println("Ingrese la capacidad de la carga (100 - 500): ");
                    capacidadCarga = sc.nextInt();
                    if(capacidadCarga >= 100 && capacidadCarga <= 500){
                        break;
                    }else{
                        System.out.println("capacidad fuera de rango, intente nuevamente");
                    }                    
                }
                Carguero c = new Carguero(capacidadCarga, nombreCarguero, capacidadPasajerosCarguero, añoCarguero);  
                this.agregarNave(c);
                break;
            case "crucero estelar":
                System.out.println("Nombre: ");
                String nombreCruceroEstelar = sc.nextLine();
                int añoCruceroEstelar;
                while(true){
                    System.out.println("Año: ");
                    añoCruceroEstelar = sc.nextInt();
                    if(añoCruceroEstelar > 0){
                        break;
                    }else{
                        System.out.println("Año invalido, intente nuevamente");
                    }
                }
                sc.nextLine();
                int capacidadPasajerosCruceroEstelar;
                while(true){
                    System.out.println("Capacidad de pasajeros: ");
                    capacidadPasajerosCruceroEstelar = sc.nextInt();
                    if(capacidadPasajerosCruceroEstelar > 0){
                        break;
                    }else{
                        System.out.println("capacidad invalida, intente nuevamente");
                    }
                }
                sc.nextLine();
                int cantPasajeros;
                while(true){
                    System.out.println("Cantidad de pasajeros: ");
                    cantPasajeros = sc.nextInt();
                    if(cantPasajeros <= capacidadPasajerosCruceroEstelar){
                        break;
                    }else{
                        System.out.println("No se puede exceder la capacidad de pasajeros, intente nuevamente");
                    }
                }
                CruceroEstelar cE = new CruceroEstelar(cantPasajeros, nombreCruceroEstelar, añoCruceroEstelar, 
                        capacidadPasajerosCruceroEstelar);  
                this.agregarNave(cE);
                break;
            default:
                System.out.println("El tipo de nave no es valida");
        }
    }
    
}

