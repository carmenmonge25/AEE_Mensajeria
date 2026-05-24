
import java.util.GregorianCalendar;

/**
 *
 * @author Antonio Muñoz Herrera / Carmen Monge Montes
 */
public class Mensaje {
    //Atributos:
    private static final String APIPA = "169.254.0.1";
    private String usuario;
    private GregorianCalendar fecha=new GregorianCalendar();
    private String ip;
    private String texto;
    
    //Constructores:
    public Mensaje(){
        this.usuario = "System";
        this.ip = Mensaje.APIPA;
        this.texto = Mensaje.encripta("POR DEFECTO");
    }//Fin Constructor
    
    public Mensaje(String usuario, String ip, String texto){
        this.usuario = usuario.trim();
        if(Mensaje.esValida(ip.trim())){
            this.ip=ip.trim();
        }else{
            this.ip=Mensaje.APIPA;
        }//Fin Si
        this.texto = Mensaje.encripta(texto.toUpperCase());
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
        return Mensaje.desencriptar(this.texto);
    }//Fin Método

    public String getIp() {
        return this.ip;
    }//Fin método
    
    private static boolean esValida(String ip){
        //Entorno:
        boolean esValido;
        
        //Algoritmo:
        esValido = ip.matches("^(?:\\d|[1-9]\\d|1\\d\\d|2[0-4]\\d|25[0-5])"
                + "(?:\\.(?:\\d|[1-9]\\d|1\\d\\d|2[0-4]\\d|25[0-5])){3}$");
        return esValido;
    }//Fin Método
    
    private static String encripta(String msg){
        //Entorno:
        String msgEnc;
        int n;
        char caracter;
        //Algoritmo:
        msgEnc="";
        msg = Mensaje.reverse(msg);
        for (n = 0; n < msg.length(); n++){
            caracter = msg.charAt(n);
            if (caracter >= 'A' && caracter <= 'Z'){
                caracter = (char)((caracter - 'A'+3)%26 +'A');
            }//Fin Si
            msgEnc = msgEnc+caracter;
        }//Fin Para
        return msgEnc;
    }//Fin Método
    
    private static String desencriptar(String msg){
        //Entorno:
        String msgDesen;
        int n;
        char caracter;
        //Algoritmo:
        msgDesen="";
        msg = Mensaje.reverse(msg);
        for (n = 0; n < msg.length(); n++){
            caracter = msg.charAt(n);
            if (caracter >= 'A' && caracter <= 'Z'){
                caracter = (char)((caracter - 'A'-3)%26 +'A');
            }//Fin Si
            msgDesen = msgDesen+caracter;
        }//Fin Para
        return msgDesen;
    }
    
    private static String reverse(String cad){
        //Entorno:
        String reves;
        int i;
        
        //Algoritmo:
        reves = "";
        for (i=0;i<cad.length();i++){
            reves = reves + cad.charAt(i);
        }//Fin Para
        return reves;
    }//Fin Método
}
