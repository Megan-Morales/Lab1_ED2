/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;
import estructuras.arbolB.ArbolB;
import clases.Persona;
import java.io.IOException;
import ventana.MenuPrincipal;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;
/**
 *
 * @author megan
 */
public class Main {
    public static void main(String[] args) {   //metodo estatico main 
        
        
        ArbolB<Persona> arbolPersonas = new ArbolB();
        //Persona personaPrueba = new Persona( 1234567891, "megan", "12/01/2002", "guatemala");
        //arbolPersonas.insertarEnArbol(personaPrueba);
        MenuPrincipal menu = new MenuPrincipal(arbolPersonas);
        menu.setVisible(true);
    }

    
    
}
