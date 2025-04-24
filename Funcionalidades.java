package proyectos.perfumeria;
import java.util.ArrayList;
import java.util.Scanner;


public class Funcionalidades {
    
    Scanner entrada = new Scanner(System.in);
    Controladores verificador = new Controladores();
    
     
    
   private String identificador;
   private String nombre;
   private String marca;
   private double precio;
   private int stock;
   private int almacenDeIndice =0;
   private int opcion;
  
    //las variables de arriba las que tienen los mismos nombres que la clase articulos, existen para pedir datos al usuario y almacenar esos datos para luego pasarlo al objeto 
    

    public void rellenarDatos(Articulos articulo[], int i){
        
        System.out.println("Porfavor indique el indentificador del nuevo articulo\n\n");
        System.out.println("El mismo no puede superar los 10 caracteres numericos o contener letras\n\n");
        
        this.identificador=entrada.nextLine();
        
        this.identificador = verificador.verificarIdRepetidos(articulo,this.identificador); //Obtendra un return de la funcion si el id es diferente a los 
                                                                                            //que existe pero no verifica aun que no se haya cumplido la condicion de solo numeros y maximo 10 caracteres 
                                                                                            
        while (verificador.verificarCaractresId(this.identificador) != true){ //llama al metodo verificar carracteres, si el mismo larga un flase, ejecuta el while
            System.out.println("El identificador ingresado no cumple con lo pedido, porfavor vuelva a intentarlo");
            this.identificador=entrada.nextLine();
            this.identificador = verificador.verificarIdRepetidos(articulo,this.identificador); // lo pongo dentro del while para que no permita que se creen id repetidos 
        }
        
        articulo[i].setIdentificador(this.identificador);
        
        System.out.println("Ingrese el nombre del articulo");
        this.nombre=entrada.nextLine();
        
        while (verificador.verificarCaractresNombre(this.nombre) != true){
            System.out.println("El Nombre ingresado no cumple con lo pedido, porfavor vuelva a intentarlo");
            this.nombre=entrada.nextLine();
        }
        
        articulo[i].setNombre(this.nombre);
        
        System.out.println("Ingrese la marca del articulo");
        this.marca=entrada.nextLine();
        
        while (verificador.verificarCaractresMarca(this.marca) != true){
            System.out.println("La marca ingresada no cumple con lo pedido, porfavor vuelva a intentarlo");
            this.marca=entrada.nextLine();
        }
        
        articulo[i].setMarca(this.marca);
        
        System.out.println("Ingrese el precio del articulo");
        this.precio=entrada.nextDouble();
        
        while(this.precio<=0){
            System.out.println("ingrese un precio valido");
            this.precio=entrada.nextDouble();
        }
        
        articulo[i].setPrecio(this.precio);
        
        System.out.println("Ingrese el stock del producto");
        this.stock=entrada.nextInt();
        
        while(this.stock<0){
            System.out.println("Ingrese un stock valido");
            this.stock=entrada.nextInt();
        }
        
        articulo[i].setStock(this.stock);
        
        entrada.nextLine(); // limpiador de buffer
        
    }
    
    
    public void mostrar(Articulos arreglo[] , int i ){
        
        System.out.println("--------------- PRODUCTO "+ (i+1) + "----------------");
        System.out.println("Identificador: " + arreglo[i].getIdentificador());
        System.out.println("Nombre: " + arreglo[i].getNombre());
        System.out.println("Marca: " + arreglo[i].getMarca());
        System.out.println("Precio: " + arreglo[i].getPrecio());
        System.out.println("Stock: " + arreglo[i].getStock());
        System.out.println("\n");
    }
    

    public void actualizarArticulos ( Articulos articulos[]){
        
        System.out.println("Porfavor ingrese el id del articulo a modificar");
        System.out.println("0. Salir");
        
        this.identificador=entrada.nextLine();
        
        
        for (int i = 0; i < 1000; i++) {
            if (articulos[i].getIdentificador() != null && articulos[i].getIdentificador().equals(this.identificador)){
                this.almacenDeIndice = i;
                break;
            }
            else{
                
                System.out.println("El id no fue encontrado, volviendo al menu\n");
                return; 
            }
        }
        System.out.println("Que desea modificar del articulo con id "+ articulos[this.almacenDeIndice].getIdentificador());
        System.out.println("1. ID");
        System.out.println("2. Nombre");
        System.out.println("3. Marca");
        System.out.println("4. Precio");
        System.out.println("5. Stock");
        
        opcion=entrada.nextInt();
        
        
        
        switch(opcion){
            case 1:
                entrada.nextLine(); // limpiador de buffer
                
                System.out.println("Porfavor indique el indentificador del nuevo articulo\n\n");
                System.out.println("El mismo no puede superar los 10 caracteres numericos o contener letras\n\n");
        
                this.identificador=entrada.nextLine();
        
                this.identificador = verificador.verificarIdRepetidos(articulos,this.identificador); //Obtendra un return de la funcion si el id es diferente a los 
                                                                                                     //que existe pero no verifica aun que no se haya cumplido la condicion de solo numeros y maximo 10 caracteres 
                                                                                            
                while (verificador.verificarCaractresId(this.identificador) != true){ //llama al metodo verificar carracteres, si el mismo larga un flase, ejecuta el while
                System.out.println("El identificador ingresado no cumple con lo pedido, porfavor vuelva a intentarlo");
                this.identificador=entrada.nextLine();
                this.identificador = verificador.verificarIdRepetidos(articulos,this.identificador); // lo pongo dentro del while para que no permita que se creen id repetidos 
                }
        
                articulos[this.almacenDeIndice].setIdentificador(this.identificador);
                
                
                
                break;
            case 2:
                entrada.nextLine(); // limpiador de buffer
                System.out.println("Porfavor ingrese el nuevo nombre del articulo");
                this.nombre=entrada.nextLine();
                
                while (verificador.verificarCaractresNombre(this.nombre) != true){
                    System.out.println("El Nombre ingresado no cumple con lo pedido, porfavor vuelva a intentarlo");
                    this.nombre=entrada.nextLine();
                }
                
                articulos[this.almacenDeIndice].setNombre(this.nombre);
                
                
                break;
            case 3:
                entrada.nextLine(); // limpiador de buffer
                
                System.out.println("Porfavor ingrese la marca editada del articulo");
                this.marca=entrada.nextLine();
                
                while (verificador.verificarCaractresNombre(this.marca) != true){
                    System.out.println("La marca ingresada no cumple con lo pedido, porfavor vuelva a intentarlo");
                    this.marca=entrada.nextLine();
                }
                
                articulos[this.almacenDeIndice].setMarca(this.marca);
                
                break;
            case 4:
                System.out.println("Porfavor ingrese el nuevo precio del articulo");
                
                this.precio=entrada.nextDouble();
                
                while(this.precio<=0){
                    System.out.println("ingrese un precio valido");
                    this.precio=entrada.nextDouble();
                }
                articulos[this.almacenDeIndice].setPrecio(this.precio);
                entrada.nextLine(); // limpiador de buffer
                
                break;
            case 5:
                System.out.println("Porfavor ingrese el nuevo stock del articulo");
                this.stock=entrada.nextInt();
                
                    while(this.stock<0){
                    System.out.println("Ingrese un stock valido");
                    this.stock=entrada.nextInt();
                }
        
                articulos[this.almacenDeIndice].setStock(this.stock);
                entrada.nextLine(); // limpiador de buffer
                break;
                
        }
        
        
    }
    
    
    public void eliminarArticulo(Articulos articulos[], int i){
        articulos[i].setIdentificador("0");
    }
    
    
    
}
