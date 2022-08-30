/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author megan
 */
public class Persona implements Comparable<Persona>{
    long dpi;
    String name;
    String datebirth;
    String address;
    int ascii;
    
    /**
     * Constructor de mi clase.
     * @param dpi
     * @param name
     * @param datebirth
     * @param address
     */

    public Persona(long dpi, String name, String datebirth, String address) {
        this.dpi = dpi;
        this.name = name;
        this.datebirth= datebirth;
        this.address = address;
        this.ascii= this.calcularAscii(this.name);
        
    }

    @Override
    public String toString() {
        return "{"+ "\"name\" : "+ "\"" + name + "\"" + ", \"dpi\" : " + "\"" + dpi + "\"" + ", \"datebirth\" : " +"\"" + datebirth + "\"" +", \"address\" : " + "\"" +address + "\"" +'}';
    }
    
    @Override
    public int compareTo(Persona personaAComparar) {
        
        if(this.ascii < personaAComparar.getAscii()){
            return -1;
        }else if(this.ascii > personaAComparar.getAscii()){
            return 1;
        }else{
            return 0;
        }
    }
    
    public int calcularAscii(String name){
        int ascii_Value=0;
        
        List<Integer> listOfIntegers = name.chars().boxed().collect(Collectors.toList());
       
        for(int i:listOfIntegers){
            ascii_Value+= i;
        }
        System.out.println("valor: "+ascii_Value);
        return ascii_Value;
    }
    
    public long getdpi() {
        return dpi;
    }

    public void setdpi(long dpi) {
        this.dpi = dpi;
    }

    public String getNombre() {
        return name;
    }

    public void setNombre(String name) {
        this.name = name;
    }
    
    public String getFecha() {
        return datebirth;
    }

    public void setFecha(String datebirth) {
        this.datebirth = datebirth;
    }
    
    public String getDireccion() {
        return address;
    }

    public void setDireccion(String address) {
        this.address = address;
    }
    
    public int getAscii() {
        return ascii;
    }

    public void setAscii(int ascii) {
        this.ascii = ascii;
    }
    
}
