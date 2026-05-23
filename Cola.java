
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
        tCola=new LinkedList<>();
    }//Fin Constructor
    
    //Métodos:
    public void meterEnCola(Object obj){
        if(obj instanceof Mensaje){
            this.tCola.offer((Mensaje)obj);
        }//Fin Si
    }//Fin Método
    
    public Object sacarDeCola(){
        return this.tCola.poll();
    }//Fin Método
    
    public boolean esColaVacia(){
        return this.tCola.isEmpty();
    }//Fin Método
}
