
import java.util.LinkedList;

/**
 *
 * @author Antonio Muñoz Herrera / Carmen Monge Montes
 */
public class Mensajeria {

    public static byte LeerByte() {
        //Entorno:
        short num;
        //Algoritmo:
        num = Leer.datoShort();
        while (num > Byte.MAX_VALUE || num < Byte.MIN_VALUE) {
            System.out.println("El dato no válido, introduzca otro: ");
            num = Leer.datoShort();
        }//Fin Mientras
        return (byte) num;
    }//Fin Función

    public static boolean Continuar() {
        //Entorno:
        String opcion;
        boolean continuar;
        //Algoritmo:
        do {
            System.out.println("Hay mensajes pendientes de recibir. "
                    + "¿Salir de todas formas? (S/N)");
            opcion = Leer.dato();
        } while (opcion.trim().toUpperCase().matches("^[^SN]$"));
        if (opcion.trim().toUpperCase().equals("S")) {
            continuar = false;
        } else {
            continuar = true;
            System.out.println("Sí quieres continuar");
        }//Fin Si
        return continuar;
    }//Fin Función

    public static void main(String[] args) {
        //Entorno:
        short opcion;
        Mensaje mens;
        Cola cola;
        String usuario, ip, texto;
        boolean continuar;
        //Algoritmo:
        cola = new Cola();
        continuar = true;
        do {
            System.out.println("1. Envío instantáneo.");
            System.out.println("2. Enviar mensaje.");
            System.out.println("3. Recibir Mensaje.");
            System.out.println("4. Salir.");
            System.out.println("OPCION: ");
            opcion = LeerByte();
            System.out.println("Has introducido la opción: "+opcion);
            switch (opcion) {
                case 1:
                    System.out.println("Hola");
                    cola.meterEnCola(new Mensaje());
                    System.out.println("Se ha introducido un mensaje instantáneo.");
                    System.out.println(cola.esColaVacia());
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
                    mens = (Mensaje) cola.sacarDeCola();
                    System.out.println(mens);
                    if (!(mens == null)) {
                        System.out.println("Usuario: " + mens.getUsuario());
                        System.out.println("Fecha: " + mens.getFecha());
                        System.out.println("IP: " + mens.getIp());
                        System.out.println("Texto: " + mens.getTexto());
                    } else {
                        System.out.println("No hay más mensajes.");
                    }//Fin Si
                    break;
                case 4:
                    if (!cola.esColaVacia()) {
                        continuar = Mensajeria.Continuar();
                        System.out.println(continuar);
                    } else {
                        continuar = false;
                    }//Fin Si
                    break;
                default:
                    System.out.println("Esa opción no está en el menú. "
                            + "Vuelva a intentarlo: ");
            }//Fin Según Sea
        } while (continuar==true || opcion != 4);

    }//Fin Programa
}
