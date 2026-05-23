
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
        //Crearlo en el atributo porque el constructor con parámetros no tiene fecha y si no se pone en atributo la fecha será null
        this.texto = Mensaje.encripta("POR DEFECTO");
    }//Fin Constructor
    
    public Mensaje(String usuario, String ip, String texto){
        //falta la ip y si no se pone la fecha en el atributo se debería de poner aquí (creo que se debería de poner en el atributo porque la fecha siempre vale lo mismo en los dos constructores)
        this.usuario = usuario;
        this.texto = Mensaje.encripta(texto.toUpperCase());
        //cuando metamos la ip deberíamos de poner trim aquí y quitarlo de esValida
        //utilizar el mátodo esValida aquí:
        /**
         * if(Mensaje.esValida(ip.trim())){
         *      this.ip=ip.trim();
         * }else{
         *      this.ip=Mensaje.APIPA;
         * }//Fin Si
         */
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
        boolean esValido;
        
        //Algoritmo:
        esValido = ip.trim().matches("^(?:\\d|[1-9]\\d|1\\d\\d|2[0-4]\\d|25[0-5])(?:\\.(?:\\d|[1-9]\\d|1\\d\\d|2[0-4]\\d|25[0-5])){3}$");
        /**
         * en el enunciado pone que cada octeto debe tener un valor entre 1 y 254, en ese caso la expresión sería: 
         * "^(?:[1-9]|[1-9]\\d|1\\d\\d|2[0-4]\\d|25[0-4])(?:\\.(?:[1-9]|[1-9]\\d|1\\d\\d|2[0-4]\\d|25[0-4])){3}$"
         */
        return esValido;
    }//Fin Método
    
    public static String encripta(String msg){
        //Entorno:
        String msgEnc;
        int n;
        char caracterActual;
        //Algoritmo:
        msgEnc="";
        msg = Mensaje.reverse(msg);
        for (n = 0; n < msg.length(); n++){
            caracterActual = msg.charAt(n);
            if (caracterActual >= 'A' && caracterActual <= 'Z'){
                caracterActual = (char)((caracterActual - 'A'+3)%26 +'A');
            }//Fin Si
            msgEnc += caracterActual;
        }//Fin Para
        return msgEnc;
    }//Fin Método
    
    private static String reverse(String cad){
        //Entorno:
        char[] caracteres;
        String reves;
        int i;
        
        //Algoritmo:
        reves = "";
        caracteres = cad.toCharArray();
        for (i = caracteres.length -1; i >= 0; i--){
            reves = reves + caracteres[i];
        }//Fin Para
        return reves;
    }//Fin Método
}
