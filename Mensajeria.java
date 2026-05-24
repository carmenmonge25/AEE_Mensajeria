
/**
 *
 * @author Antonio Muñoz Herrera / Carmen Monge Montes
 */
public class Mensajeria {

    public static byte leerByte() {
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

    public static boolean continuar() {
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
        }//Fin Si
        return continuar;
    }//Fin Función
    
    public static Mensaje pedirDatosMensaje(){
        //Entorno:
        String usuario, ip, texto;
        //Algoritmo:
        System.out.println("Introduzca el usuario: ");
        usuario = Leer.dato();
        System.out.println("Introduzca su IP en formato IPv4: ");
        ip = Leer.dato();
        System.out.println("Introduzca el texto del mensaje: ");
        texto = Leer.dato();
        return new Mensaje(usuario, ip, texto);
    }//Fin Función
    
    public static void mostrarMensaje(Mensaje mensaje){
        System.out.println("Usuario: " + mensaje.getUsuario());
        System.out.println("Fecha: " + mensaje.getFecha());
        System.out.println("IP: " + mensaje.getIp());
        System.out.println("Texto: " + mensaje.getTexto());
    }//Fin Procedimiento
    
    public static void main(String[] args) {
        //Entorno:
        short opcion;
        Mensaje mensaje;
        Cola cola;
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
            opcion = leerByte();
            
            switch (opcion) {
                case 1:
                    cola.meterEnCola(new Mensaje());
                    System.out.println("Se ha introducido un mensaje "
                            + "instantáneo.");
                    break;
                case 2:
                    cola.meterEnCola(Mensajeria.pedirDatosMensaje());
                    System.out.println("Se ha introducido el mensaje "
                            + "correctamente.");
                    break;
                case 3:
                    mensaje = (Mensaje) cola.sacarDeCola();
                    if (!(mensaje == null)) {
                        Mensajeria.mostrarMensaje(mensaje);
                    } else {
                        System.out.println("No hay más mensajes.");
                    }//Fin Si
                    break;
                case 4:
                    if (!cola.esColaVacia()) {
                        continuar = Mensajeria.continuar();
                    } else {
                        continuar = false;
                    }//Fin Si
                    break;
                default:
                    System.out.println("Esa opción no está en el menú. "
                            + "Vuelva a intentarlo: ");
            }//Fin Según Sea
            System.out.println();
        } while (continuar == true || opcion != 4);

    }//Fin Programa
}
