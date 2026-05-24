
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/**
 *
 * @author CMM
 */
public class Prueba {
    
    public static void main(String[] args) {
     
        Cola lista;
        Mensaje pd, mj1, mj2, pd1, pd2;
        Short opcion;
        
        pd=new Mensaje();
        pd1=new Mensaje();
        pd2=new Mensaje();
        mj1=new Mensaje("Joselito", "1555.6584.5.2", "Hola que tal ");
        mj2=new Mensaje("Jorge", "255.23.1.0", "Hola que tal estamos");
        lista=new Cola();
        System.out.println(lista.esColaVacia());
        System.out.println(lista.sacarDeCola());
        Mensajeria.Continuar();
        System.out.println("Usuario: "+pd.getUsuario()+
                "\nFecha: "+pd.getFecha()+
                "\nIP: "+pd.getIp()+
                "\nTexto: "+pd.getTexto());
        System.out.println("Usuario: "+mj1.getUsuario()+
                "\nFecha: "+mj1.getFecha()+
                "\nIP: "+mj1.getIp()+
                "\nTexto: "+mj1.getTexto());
        System.out.println("Usuario: "+mj2.getUsuario()+
                "\nFecha: "+mj2.getFecha()+
                "\nIP: "+mj2.getIp()+
                "\nTexto: "+mj2.getTexto());
        
        do{
            lista.meterEnCola(new Mensaje());
            System.out.println("OPCION: ");
            opcion=Leer.datoShort();
        }while(opcion==1);
        lista.meterEnCola(new Mensaje());
        lista.meterEnCola(new Mensaje());
        System.out.println(lista.sacarDeCola());
        System.out.println(lista.sacarDeCola());
        System.out.println(lista.sacarDeCola());
        System.out.println(lista.esColaVacia());
        System.out.println(lista.sacarDeCola());
    }
}
