/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author megan
 */
public class Persona implements Comparable<Persona>{
    long DPI;
    String nombre;
    String fecha;
    String direccion;
    
    /**
     * Constructor de mi clase.
     * @param DPI
     * @param nombre
     * @param fecha
     * @param direccion
     */

    public Persona(long DPI, String nombre, String fecha, String direccion) {
        this.DPI = DPI;
        this.nombre = nombre;
        this.fecha= fecha;
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Persona(" + DPI+')';
    }
    
    @Override
    public int compareTo(Persona personaAComparar) {
        if(this.DPI < personaAComparar.getDPI()){
            return -1;
        }else if(this.DPI > personaAComparar.getDPI()){
            return 1;
        }else{
            return 0;
        }
    }
    
    public long getDPI() {
        return DPI;
    }

    public void setDPI(long DPI) {
        this.DPI = DPI;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
}
