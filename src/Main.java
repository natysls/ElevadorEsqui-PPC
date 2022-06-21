import java.util.Timer;
import java.util.TimerTask;

public class Main {

    public static void main(String[] args) {
        System.out.println("inicio");

        // try{
        
        //     inserirEsquiador(i);
        //     Thread.sleep(1000);

        //     elevadorPassando();
        //     Thread.sleep(5000);
        
        // }catch(InterruptedException e){
        //     e.printStackTrace();
        // }

        Timer timerEsquiador = new Timer();
        timerEsquiador.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                try {
                    Esquiador.inserirEsquiador();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, 1000, 1000);

        Timer timerElevador = new Timer();
        timerElevador.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                try {
                    Elevador.elevadorPassando();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, 5000, 5000);
    }
    
}