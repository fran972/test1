/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package proyectos.perfumeria;
import java.util.Scanner;
/**
 *
 * @author MSI
 */
public class Perfumeria {

    public static void main(String[] args) {
        
        Articulos articulo[]= new Articulos[1000];
        
        Scanner scanner = new Scanner(System.in);
        
        Funcionalidades funciones= new Funcionalidades();
        
        int opcion=0;
        int contadorDeArticulos=0;
        String eliminar;
        
        
        
        for(int i=0;i<1000;i++){
        articulo[i]=new Articulos();
        articulo[i].setIdentificador("0");
        }
        
        
        
        do{
        System.out.println("1.Ingresar articulos");
        System.out.println("2.mostrar articulos ingresados");
        System.out.println("3.Actualizar articulos");
        System.out.println("4.Eliminar articulos");
        System.out.println("5.salir");
        opcion=scanner.nextInt();
        
        
        
        
        switch(opcion){
            case 1:
                
                
            for (int i = 0; i < 1000; i++) {
                if (articulo[i].getIdentificador() != null && articulo[i].getIdentificador().equals("0")) {
                funciones.rellenarDatos(articulo, i);
                contadorDeArticulos++;
                break;
                }
            }
                break;
            case 2:
                if(contadorDeArticulos==0){
                    System.out.println("No hay Articulos para mostrar");
                    break;
                }
                for (int i = 0; i < 1000; i++) {
                    if (articulo[i].getIdentificador() != null && articulo[i].getIdentificador().equals("0")) {
                    continue;
                    }
                    else{
                        funciones.mostrar(articulo, i);
                    }
                }
                break;
            case 3:
                if(contadorDeArticulos==0){
                    System.out.println("No hay Articulos para Actualizar");
                    break;
                }
                funciones.actualizarArticulos(articulo);
                break;
            case 4:
                if(contadorDeArticulos==0){
                    System.out.println("No hay Articulos para Eliminar");
                    break;
                }
                    scanner.nextLine();
                    System.out.println("ingrese el id del articulo a eliminar");
                    eliminar=scanner.nextLine();
                    for (int i = 0; i < 1000; i++) {
                        if (articulo[i].getIdentificador() != null && articulo[i].getIdentificador().equals(eliminar)) {
                            articulo[i].setIdentificador("0");
                            contadorDeArticulos--;
                            break;
                        }
                    }
                
                break;
            case 5:
                System.out.println("Programa finalizado");
                break;
            default:
                System.out.println("Ingrese un valor que este dentro del menu");
                break;
        }
        }while(opcion!=5);
    }
}