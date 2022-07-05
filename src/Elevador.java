import java.util.ArrayList;
import java.util.Map;

public class Elevador {

    static boolean isLTturn = true;
    static boolean isLSturn = true;
    static boolean parar = false;
    static int roundSizeCount = 0;
    static int emptySpaces = 0;
    static double taxaDeAproveitamento;
    static int passagensDoElevador = 0;

  public static void elevadorPassando() {
    ArrayList<Map<String, Esquiador>> elevador = new ArrayList<>();

    boolean LThasPerson = Filas.LT.size() >= 3;
    boolean RThasPerson = Filas.RT.size() >= 3;
    boolean LShasPerson = Filas.LS.size() >= 1;
    boolean RShasPerson = Filas.RS.size() >= 1;

    if (LThasPerson && RThasPerson) {
        if (isLTturn) { // vez da esquerda
            isLTturn = false;
            elevador.add(Map.of("LT", Filas.LT.remove(0)));
            elevador.add(Map.of("LT", Filas.LT.remove(0)));
            elevador.add(Map.of("LT", Filas.LT.remove(0)));

        } else { // vez da direita
            isLTturn = true;
            elevador.add(Map.of("RT", Filas.RT.remove(0)));
            elevador.add(Map.of("RT", Filas.RT.remove(0)));
            elevador.add(Map.of("RT", Filas.RT.remove(0)));

        }

        if (isLSturn && LShasPerson) {
            isLSturn = false;
            elevador.add(Map.of("LS", Filas.LS.remove(0)));

        } else if (RShasPerson) {
            elevador.add(Map.of("RS", Filas.RS.remove(0)));
            isLSturn = true;

        }

    } else if (LThasPerson) {
        isLTturn = false;
        elevador.add(Map.of("LT", Filas.LT.remove(0)));
        elevador.add(Map.of("LT", Filas.LT.remove(0)));
        elevador.add(Map.of("LT", Filas.LT.remove(0)));

        if (isLSturn && LShasPerson) {
            isLSturn = false;
            elevador.add(Map.of("LS", Filas.LS.remove(0)));

        } else if (RShasPerson) {
            elevador.add(Map.of("RS", Filas.RS.remove(0)));
            isLSturn = true;

        }

    } else if (RThasPerson) {
        isLTturn = true;
        elevador.add(Map.of("RT", Filas.RT.remove(0)));
        elevador.add(Map.of("RT", Filas.RT.remove(0)));
        elevador.add(Map.of("RT", Filas.RT.remove(0)));

        if (isLSturn && LShasPerson) {
            isLSturn = false;
            elevador.add(Map.of("LS", Filas.LS.remove(0)));

        } else if (RShasPerson) {
            elevador.add(Map.of("RS", Filas.RS.remove(0)));
            isLSturn = true;

        }

    } else if (Filas.LS.size() + Filas.RS.size() >= 3) { // quando não há mais RT ou LT, as RS e LS entram
        int precisaRemover = 3;

        for (int i = 0; i < Filas.LS.size() && Filas.LS.size() > 0; i++) {
            elevador.add(Map.of("LS", Filas.LS.remove(0)));
            precisaRemover--;
            if (precisaRemover == 0) break;

        }

        for (int i = 0; i <= precisaRemover && Filas.RS.size() > 0; i++) {
            elevador.add(Map.of("RS", Filas.RS.remove(0)));
            precisaRemover--;
            if (precisaRemover == 0) break;

        }
    }

    if (elevador.size() > 0) {
        String elevadorResult = String.join(" / ", elevador.stream()
                .map(e -> e.keySet().toArray()[0] + " - " + e.get(e.keySet().toArray()[0]).getNome())
                .toList());
        roundSizeCount = roundSizeCount + elevador.size();
        passagensDoElevador++;
        System.out.println("Subiram: ("+ roundSizeCount +")");
        System.out.println("Elevador passou: (" + elevadorResult + ")");
        System.out.println("Passagem do elevador de nº:" + passagensDoElevador + "");
        System.out.println("A Taxa de aproveitamento foi de: "+ (roundSizeCount/(4 * passagensDoElevador)) * 100 +"%.");
    } else {
        setParar(true);
        System.out.println("Elevador parou: ( Não tinha gente suficiente )");
    }

  }

    public static boolean isParar() {
        return parar;
    }

    public static void setParar(boolean parar) {
        Elevador.parar = parar;
    }
}