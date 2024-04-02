package comunicaciones;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class Telegram {
    public static void main(String[] args) {
        do {
            String mensaje;
            Scanner s = new Scanner(System.in);
            System.out.println("Introduzca el mensaje para telegram:");
            mensaje = s.nextLine();
            if (enviaMensajeTelegram(mensaje)) {
                System.out.println("Mensaje enviado con exito");
            } else System.out.println("Fallo al enviar el mensaje");
        } while (true);

    }

    public static boolean enviaMensajeTelegram(String mensaje) {
        String direccion;  //URL de la API de mi en mi conversación
        String fijo = "https://api.telegram.org/bot6773460254:AAHKsxk5qzdJdJsc3NRvivm7kFo-qLMh3rU/sendMessage?chat_id=1658527991&text=";
        direccion = fijo + mensaje; //Metemos el mensaje al final
        URL url;
        boolean dev;
        dev = false;
        try {
            url = new URL(direccion); //Creando un objeto URL con la direccion de la API de mi bot
            URLConnection con = url.openConnection(); //Realizando la peticion GET
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            dev = true; //Ha tenido exito
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return dev; //Devuelvo si ha tenido exito
    }
}