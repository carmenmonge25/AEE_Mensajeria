
import java.util.GregorianCalendar;

/**
 *
 * @author Antonio Muñoz Herrera / Carmen Monge Montes
 */
public class Mensaje {
    //Atributos:
    private static final String APIPA = "169.254.0.1";
    private String usuario;
    private GregorianCalendar fecha;
    private String ip;
    private String texto;
    
    //Constructores:
    public Mensaje(){
        this.usuario = "System";
        this.ip = Mensaje.APIPA;
        this.fecha = new GregorianCalendar();
        this.texto = "Por defecto";
    }//Fin Constructor
    
    public Mensaje(String usuario, String ip, String texto){
        this.usuario = usuario;
        this.texto = texto;
    }//Fin Constructor
    
    //Métodos:
    public static String getAPIPA() {
        return Mensaje.APIPA;
    }//Fin Método
 
    public String getUsuario() {
        return this.usuario;
    }//Fin Método

    public String getFecha() {
        return this.fecha.get(GregorianCalendar.DAY_OF_MONTH)+"/"+
              (this.fecha.get(GregorianCalendar.MONTH) + 1)+"/"+
               this.fecha.get(GregorianCalendar.YEAR);
    }//Fin Método

    public String getTexto() {
        return this.texto;
    }//Fin Método

    public String getIp() {
        return this.ip;
    }//Fin método
    
    private static boolean esValida(String ip){
        //Entorno:
        String ipv4;
        String expReg;
        //Algoritmo:
        ipv4 = "(\\d{1,2}|(0|1)\\\\d{2}|2[0-4]\\\\d|25[0-5])";
        expReg = ipv4+"\\."+ipv4+"\\."+ipv4+"\\."+ipv4;
        return ip.matches(expReg);
    }
}
