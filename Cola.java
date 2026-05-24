

import java.util.LinkedList;


/**
 *
 * @author Antonio Muñoz Herrera / Carmen Monge Montes
 */
public class Cola {
    //Atributos:
    private LinkedList<Mensaje> tCola;
    
    //Constructores:
    public Cola(){
        this.tCola=new LinkedList<>();
    }//Fin Constructor
    
    //Métodos:
    public void meterEnCola(Object obj){
        if(obj instanceof Mensaje){
            this.tCola.offer((Mensaje)obj);
            System.out.println("Mensaje introducido");
        }else{
            System.out.println("ERROR: Mensaje no introducido");
        }//Fin Si
    }//Fin Método
    
    public Object sacarDeCola(){
        return this.tCola.poll();
    }//Fin Método
    
    public boolean esColaVacia(){
        return this.tCola.isEmpty();
    }//Fin Método
}
