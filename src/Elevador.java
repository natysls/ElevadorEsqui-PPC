import java.util.ArrayList;
import java.util.Map;

public class Elevador {

  public static void elevadorPassando() {
    ArrayList<Map<String, Esquiador>> elevador = new ArrayList<>();
    boolean LThasPerson = Filas.LT.size() >= 3;
    boolean RThasPerson = Filas.RT.size() >= 3;
    boolean LShasPerson = Filas.LS.size() >= 1;
    boolean RShasPerson = Filas.RS.size() >= 1;

    if (LThasPerson && RThasPerson) {
        if (Filas.isLTturn) {
            Filas.isLTturn = false;
            elevador.add(Map.of("LT", Filas.LT.remove(0)));
            elevador.add(Map.of("LT", Filas.LT.remove(0)));
            elevador.add(Map.of("LT", Filas.LT.remove(0)));

        } else {
            Filas.isLTturn = true;
            elevador.add(Map.of("RT", Filas.RT.remove(0)));
            elevador.add(Map.of("RT", Filas.RT.remove(0)));
            elevador.add(Map.of("RT", Filas.RT.remove(0)));

        }

        if (Filas.isLSturn && LShasPerson) {
            Filas.isLSturn = false;
            elevador.add(Map.of("LS", Filas.LS.remove(0)));

        } else if (RShasPerson) {
            elevador.add(Map.of("RS", Filas.RS.remove(0)));
            Filas.isLSturn = true;

        }

    } else if (LThasPerson) {
        Filas.isLTturn = false;
        elevador.add(Map.of("LT", Filas.LT.remove(0)));
        elevador.add(Map.of("LT", Filas.LT.remove(0)));
        elevador.add(Map.of("LT", Filas.LT.remove(0)));

        if (Filas.isLSturn && LShasPerson) {
            Filas.isLSturn = false;
            elevador.add(Map.of("LS", Filas.LS.remove(0)));

        } else if (RShasPerson) {
            elevador.add(Map.of("RS", Filas.RS.remove(0)));
            Filas.isLSturn = true;

        }

    } else if (RThasPerson) {
        Filas.isLTturn = true;
        elevador.add(Map.of("RT", Filas.RT.remove(0)));
        elevador.add(Map.of("RT", Filas.RT.remove(0)));
        elevador.add(Map.of("RT", Filas.RT.remove(0)));

        if (Filas.isLSturn && LShasPerson) {
            Filas.isLSturn = false;
            elevador.add(Map.of("LS", Filas.LS.remove(0)));

        } else if (RShasPerson) {
            elevador.add(Map.of("RS", Filas.RS.remove(0)));
            Filas.isLSturn = true;

        }

    } else if (Filas.LS.size() + Filas.RS.size() >= 3) {
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

        System.out.println("Elevador passou: (" + elevadorResult + ")");

    }else{
        System.out.println("Elevador passou: ( Não tinha gente suficiente )");

    }

  }

}