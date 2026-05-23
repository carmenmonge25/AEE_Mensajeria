
import java.util.LinkedList;

/**
 *
 * @author Antonio Muñoz Herrera / Carmen Monge Montes
 */
public class Mensajeria {
    
    public static byte LeerByte(){
    //Entorno:
        short num;
    //Algoritmo:
        num=Leer.datoShort();
        while (num> Byte.MAX_VALUE || num< Byte.MIN_VALUE){
            System.out.println("El dato no válido, introduzca otro: ");
            num=Leer.datoShort();
        }//Fin Mientras
        return (byte)num;
    }//Fin Función

    public static void main(String[] args) {
        //Entorno:
        short opcion;
        Mensaje mens;
        Cola cola;
        String usuario, ip, texto;
        
        //Algoritmo:
        cola = new Cola();
        System.out.println("1. Envío instantáneo.");
        System.out.println("2. Enviar mensaje.");
        System.out.println("3. Recibir Mensaje.");
        System.out.println("4. Salir.");
        opcion = LeerByte();
        
        switch(opcion){
            case 1:
                cola.meterEnCola(new Mensaje());
            break;
            case 2:
                System.out.println("Introduzca el usuario: ");
                usuario = Leer.dato();
                System.out.println("Introduzca su IP en formato IPv4: ");
                ip = Leer.dato();
                System.out.println("Introduzca el texto del mensaje: ");
                texto = Leer.dato();
                cola.meterEnCola(new Mensaje(usuario, ip, texto));
            break;
            case 3:
                if(!(cola.sacarDeCola() == null)){
                    mens = (Mensaje) cola.sacarDeCola();
                    System.out.println("Usuario: "+ mens.getUsuario());
                    System.out.println("Fecha: "+ mens.getFecha());
                    System.out.println("IP: "+ mens.getIp());
                    System.out.println("Texto: "+ mens.getTexto());
                }else{
                    System.out.println("No hay más mensajes.");
                }
            break;
            case 4:
        }
    }
}
