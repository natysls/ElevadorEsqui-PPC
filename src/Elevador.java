import java.util.ArrayList;
import java.util.Map;

public class Elevador {

    static boolean isLTturn = true;
    static boolean isLSturn = true;

    static boolean parar = false;

    static double roundSizeCount = 0.0;
    static double passagensDoElevador = 0.0;
    static double taxaDeAproveitamento = 0.0;

    static String tempoEmFila = "";
    static long tempoTotal;

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
            tempo("LT");

            elevador.add(Map.of("LT", Filas.LT.remove(0)));
            tempo("LT");

            elevador.add(Map.of("LT", Filas.LT.remove(0)));
            tempo("LT");

        } else { // vez da direita
            isLTturn = true;
            elevador.add(Map.of("RT", Filas.RT.remove(0)));
            tempo("RT");

            elevador.add(Map.of("RT", Filas.RT.remove(0)));
            tempo("RT");

            elevador.add(Map.of("RT", Filas.RT.remove(0)));
            tempo("RT");
        }

        if (isLSturn && LShasPerson) {
            isLSturn = false;
            elevador.add(Map.of("LS", Filas.LS.remove(0)));
            tempo("LS");

        } else if (RShasPerson) {
            elevador.add(Map.of("RS", Filas.RS.remove(0)));
            isLSturn = true;
            tempo("RS");

        }

    } else if (LThasPerson) {
        isLTturn = false;
        elevador.add(Map.of("LT", Filas.LT.remove(0)));
        tempo("LT");

        elevador.add(Map.of("LT", Filas.LT.remove(0)));
        tempo("LT");

        elevador.add(Map.of("LT", Filas.LT.remove(0)));
        tempo("LT");

        if (isLSturn && LShasPerson) {
            isLSturn = false;
            elevador.add(Map.of("LS", Filas.LS.remove(0)));
            tempo("LS");

        } else if (RShasPerson) {
            elevador.add(Map.of("RS", Filas.RS.remove(0)));
            isLSturn = true;
            tempo("RS");

        }

    } else if (RThasPerson) {
        isLTturn = true;
        elevador.add(Map.of("RT", Filas.RT.remove(0)));
        tempo("RT");

        elevador.add(Map.of("RT", Filas.RT.remove(0)));
        tempo("RT");

        elevador.add(Map.of("RT", Filas.RT.remove(0)));
        tempo("RT");

        if (isLSturn && LShasPerson) {
            isLSturn = false;
            elevador.add(Map.of("LS", Filas.LS.remove(0)));
            tempo("LS");

        } else if (RShasPerson) {
            elevador.add(Map.of("RS", Filas.RS.remove(0)));
            isLSturn = true;
            tempo("RS");

        }

    } else if (Filas.LS.size() + Filas.RS.size() >= 3) { // quando não há mais RT ou LT, as RS e LS entram
        int precisaRemover = 3;

        for (int i = 0; i < Filas.LS.size() && Filas.LS.size() > 0; i++) {
            elevador.add(Map.of("LS", Filas.LS.remove(0)));
            precisaRemover--;
            tempo("LS");

            if (precisaRemover == 0) break;

        }

        for (int i = 0; i <= precisaRemover && Filas.RS.size() > 0; i++) {
            elevador.add(Map.of("RS", Filas.RS.remove(0)));
            precisaRemover--;
            tempo("RS");

            if (precisaRemover == 0) break;

        }
    }

      if (elevador.size() > 0) {
          String elevadorResult = String.join(" / ", elevador.stream()
                  .map(e -> e.keySet().toArray()[0] + " - " + e.get(e.keySet().toArray()[0]).getNome())
                  .toList());
          roundSizeCount = roundSizeCount + elevador.size();
          passagensDoElevador++;
          taxaDeAproveitamento = ((roundSizeCount/(4 * passagensDoElevador)) * 100);

          String roundSizeCountRounded = String.format("%.0f", roundSizeCount);
          System.out.println("Entraram "+ roundSizeCountRounded +" esquiadores no elevador");

          String passagensDoElevadorRounded = String.format("%.0f", passagensDoElevador);
          System.out.println("Elevador " + passagensDoElevadorRounded + " passou: (" + elevadorResult + ")");

          System.out.println("Tempos em fila dos esquiadores:" + tempoEmFila + "\n");
          tempoEmFila = "";

      } else {
          setParar(true);
          System.out.println("Elevador parou: ( Não tinha gente suficiente )");
      }

  }
    public static void tempo(String fila){
        long tempo = Esquiador.tempoEmFila();
        tempoEmFila = tempoEmFila
                + "\nTempo em fila de esquiador em "+ fila + ": "
                + tempo + " ms.";
        tempoTotal += tempo;

    }

    public static void taxaDeAproveitamento(){
        String roundSizeCountRounded = String.format("%.0f", roundSizeCount);
        String passagensDoElevadorRounded = String.format("%.0f", passagensDoElevador);
        String taxaDeAproveitamentoRounded = String.format("%.2f", taxaDeAproveitamento);

        System.out.println("A taxa de aproveitamento foi de: (" + roundSizeCountRounded
                + "/(4 * " + passagensDoElevadorRounded + ") * 100) = "+ taxaDeAproveitamentoRounded + "%.");

        long tempoMedio = (long) (tempoTotal / passagensDoElevador);
        System.out.println("Tempo médio: " + tempoMedio);
    }

    public static boolean isParar() {
        return parar;
    }

    public static void setParar(boolean parar) {
        Elevador.parar = parar;
    }
}