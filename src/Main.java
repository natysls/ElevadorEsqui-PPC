import java.util.Timer;
import java.util.TimerTask;

public class Main {

    public static void main(String[] args) {
        System.out.println("inicio");

         Timer timerEsquiador = new Timer();
         timerEsquiador.scheduleAtFixedRate(new TimerTask() {
             int count = 0;
             public void run() {
                 try {
                     boolean flag = true;

                     while(flag) {
                         if (count == 120) {
                             Esquiador.acabaramEsquiadores();
                             timerEsquiador.cancel();
                             break;
                         }
                         Esquiador.inserirEsquiador();
                         count++;
                         flag = false;
                     }
                 } catch (Exception e) {
                     e.printStackTrace();
                 }
             }
         }, 1000, 1000);

         Timer timerElevador = new Timer();
         timerElevador.scheduleAtFixedRate(new TimerTask() {
             public void run() {
                 try {
                     if(Elevador.isParar()) {
                         Esquiador.esquiadoresQueSobraramNaFila();
                         timerElevador.cancel();
                     }

                     Elevador.elevadorPassando();
                 } catch (Exception e) {
                     e.printStackTrace();
                 }
             }
         }, 5000, 5000);
     }

}