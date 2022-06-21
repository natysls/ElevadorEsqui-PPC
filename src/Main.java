import java.util.ArrayList;
import java.util.*;
import java.util.Timer;
import java.util.TimerTask;
import java.util.stream.Collectors;

public class Main {
    static ArrayList<Esquiador> LS = new ArrayList<>(); // Fila de uma pessoa no lado esquerdo
    static ArrayList<Esquiador> LT = new ArrayList<>(); // Fila de uma tripla no lado esquerdo
    static ArrayList<Esquiador> RT = new ArrayList<>(); // Fila de uma tripla no lado direito
    static ArrayList<Esquiador> RS = new ArrayList<>(); // Fila de uma pessoa no lado direito

    static boolean isLTturn = true;
    static boolean isLSturn = true;

    public static void main(String[] args) {
        System.out.println("inicio");

        try{
            for(int i = 1; i<=120; i++){
                
                inserirEsquiador(i);
                Thread.sleep(1000);

                elevadorPassando();
                Thread.sleep(5000);
        
            }
        }catch(InterruptedException e){
            e.printStackTrace();
        }

        // Timer timerEsquiador = new Timer();
        // timerEsquiador.scheduleAtFixedRate(new TimerTask() {
        //     public void run() {
        //         try {
        //             inserirEsquiador();
        //         } catch (Exception e) {
        //             e.printStackTrace();
        //         }
        //     }
        // }, 1000, 1000);

        // Timer timerElevador = new Timer();
        // timerElevador.scheduleAtFixedRate(new TimerTask() {
        //     public void run() {
        //         try {
        //             elevadorPassando();
        //         } catch (Exception e) {
        //             e.printStackTrace();
        //         }
        //     }
        // }, 5000, 5000);
        
    }

    private static void inserirEsquiador(int atualEsquiador) {
        boolean LsTwiceLessThanLT = LS.size() < 2 * LT.size();
        boolean LsTwiceLessThanRT = LS.size() < 2 * RT.size();
        boolean LsLessThanRS = LS.size() < RS.size();

        boolean RsTwiceLessThan = RS.size() < 2 * LT.size();
        boolean RsTwiceLessThanRT = RS.size() < 2 * RT.size();
        boolean RsLessThanLS = RS.size() <= LS.size();

        Esquiador esquiador = new Esquiador("esquiador " + atualEsquiador);

        if (LsTwiceLessThanLT && LsTwiceLessThanRT && LsLessThanRS) {
            LS.add(esquiador);
            String sizes = "(" + LS.size() + "-" + LT.size() + "-" + RT.size() + "-" + RS.size() + ")";
            System.out.println("O " + esquiador.getNome() + " entrou na LS " + sizes);
        } else if (RsTwiceLessThan && RsTwiceLessThanRT && RsLessThanLS) {
            RS.add(esquiador);
            String sizes = "(" + LS.size() + "-" + LT.size() + "-" + RT.size() + "-" + RS.size() + ")";
            System.out.println("O " + esquiador.getNome() + " entrou na RS " + sizes);
        } else if (LT.size() <= RT.size()) {
            LT.add(esquiador);
            String sizes = "(" + LS.size() + "-" + LT.size() + "-" + RT.size() + "-" + RS.size() + ")";
            System.out.println("O " + esquiador.getNome() + " entrou na LT " + sizes);
        } else {
            RT.add(esquiador);
            String sizes = "(" + LS.size() + "-" + LT.size() + "-" + RT.size() + "-" + RS.size() + ")";
            System.out.println("O " + esquiador.getNome() + " entrou na RT " + sizes);
        }
    }

    private static void elevadorPassando() {
        ArrayList<Map<String, Esquiador>> elevador = new ArrayList<>();
        boolean LThasPerson = LT.size() >= 3;
        boolean RThasPerson = RT.size() >= 3;
        boolean LShasPerson = LS.size() >= 1;
        boolean RShasPerson = RS.size() >= 1;

        if (LThasPerson && RThasPerson) {
            if (isLTturn) {
                isLTturn = false;
                elevador.add(Map.of("LT", LT.remove(0)));
                elevador.add(Map.of("LT", LT.remove(0)));
                elevador.add(Map.of("LT", LT.remove(0)));
            } else {
                isLTturn = true;
                elevador.add(Map.of("RT", RT.remove(0)));
                elevador.add(Map.of("RT", RT.remove(0)));
                elevador.add(Map.of("RT", RT.remove(0)));
            }

            if (isLSturn && LShasPerson) {
                isLSturn = false;
                elevador.add(Map.of("LS", LS.remove(0)));
            } else if (RShasPerson) {
                elevador.add(Map.of("RS", RS.remove(0)));
                isLSturn = true;
            }
        } else if (LThasPerson) {
            isLTturn = false;
            elevador.add(Map.of("LT", LT.remove(0)));
            elevador.add(Map.of("LT", LT.remove(0)));
            elevador.add(Map.of("LT", LT.remove(0)));

            if (isLSturn && LShasPerson) {
                isLSturn = false;
                elevador.add(Map.of("LS", LS.remove(0)));
            } else if (RShasPerson) {
                elevador.add(Map.of("RS", RS.remove(0)));
                isLSturn = true;
            }
        } else if (RThasPerson) {
            isLTturn = true;
            elevador.add(Map.of("RT", RT.remove(0)));
            elevador.add(Map.of("RT", RT.remove(0)));
            elevador.add(Map.of("RT", RT.remove(0)));

            if (isLSturn && LShasPerson) {
                isLSturn = false;
                elevador.add(Map.of("LS", LS.remove(0)));
            } else if (RShasPerson) {
                elevador.add(Map.of("RS", RS.remove(0)));
                isLSturn = true;
            }
        } else if (LS.size() + RS.size() >= 3) {
            int precisaRemover = 3;

            for (int i = 0; i < LS.size() && LS.size() > 0; i++) {
                elevador.add(Map.of("LS", LS.remove(0)));
                precisaRemover--;
                if (precisaRemover == 0) break;
            }

            for (int i = 0; i <= precisaRemover && RS.size() > 0; i++) {
                elevador.add(Map.of("RS", RS.remove(0)));
                precisaRemover--;
                if (precisaRemover == 0) break;
            }
        }
        if (elevador.size() > 0) {
            String elevadorResult = String.join(" / ", elevador.stream()
                    .map(e -> e.keySet().toArray()[0] + " - " + e.get(e.keySet().toArray()[0]).getNome())
                    .collect(Collectors.toList()));

            System.out.println("Elevador passou: (" + elevadorResult + ")");
        }else{
            System.out.println("Elevador passou: ( Não tinha gente suficiente )");
        }
    }
}