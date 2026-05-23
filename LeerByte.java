/**
 *
 * @author Carmen Monge Montes
 */
public class LeerByte {
    public static byte LeerByte(){
    //Entorno:
        short num;
    //Algoritmo:
        num=Leer.datoShort();
        while (num>127 || num<-128){
            System.out.println("El dato no válido, introduzca otro: ");
            num=Leer.datoShort();
        }//Fin Mientras
        return (byte)num;
    }//Fin Función
}
