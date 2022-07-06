import java.util.ArrayList;

public class Esquiador {
    
    private String nome;
    static private ArrayList<Esquiador> listaEsquiadores = new ArrayList<>();
    static long tempoEntrada;

    public Esquiador(String nome) {
        this.nome = nome;
    }

    public static void inserirEsquiador() {
        boolean LsTwiceLessThanLT = Filas.LS.size() < 2 * Filas.LT.size();
        boolean LsTwiceLessThanRT = Filas.LS.size() < 2 * Filas.RT.size();
        boolean LsLessThanRS = Filas.LS.size() < Filas.RS.size();

        boolean RsTwiceLessThan = Filas.RS.size() < 2 * Filas.LT.size();
        boolean RsTwiceLessThanRT = Filas.RS.size() < 2 * Filas.RT.size();
        boolean RsLessThanLS = Filas.RS.size() <= Filas.LS.size();

        int posicao = listaEsquiadores.size();
        listaEsquiadores.add(new Esquiador("Esquiador " + (posicao + 1)));
        Esquiador esquiador = listaEsquiadores.get(posicao);

        if (LsTwiceLessThanLT && LsTwiceLessThanRT && LsLessThanRS) {
            Filas.LS.add(esquiador);
            tempoEntrada = System.currentTimeMillis();
            String sizes = "(" + Filas.LS.size() + "-" + Filas.LT.size() + "-" + Filas.RT.size() + "-" + Filas.RS.size() + ")";
            System.out.println("O " + esquiador.getNome() + " entrou na fila LS " + sizes);

        } else if (RsTwiceLessThan && RsTwiceLessThanRT && RsLessThanLS) {
            Filas.RS.add(esquiador);
            tempoEntrada = System.currentTimeMillis();
            String sizes = "(" + Filas.LS.size() + "-" + Filas.LT.size() + "-" + Filas.RT.size() + "-" + Filas.RS.size() + ")";
            System.out.println("O " + esquiador.getNome() + " entrou na fila RS " + sizes);

        } else if (Filas.LT.size() <= Filas.RT.size()) {
            Filas.LT.add(esquiador);
            tempoEntrada = System.currentTimeMillis();
            String sizes = "(" + Filas.LS.size() + "-" + Filas.LT.size() + "-" + Filas.RT.size() + "-" + Filas.RS.size() + ")";
            System.out.println("O " + esquiador.getNome() + " entrou na fila LT " + sizes);

        } else {
            Filas.RT.add(esquiador);
            tempoEntrada = System.currentTimeMillis();
            String sizes = "(" + Filas.LS.size() + "-" + Filas.LT.size() + "-" + Filas.RT.size() + "-" + Filas.RS.size() + ")";
            System.out.println("O " + esquiador.getNome() + " entrou na fila RT " + sizes);

        }

    }

    public static void acabaramEsquiadores(){
        String sizes = "(" + Filas.LS.size() + "-" + Filas.LT.size() + "-" + Filas.RT.size() + "-" + Filas.RS.size() + ")";
        System.out.println("Não existem mais esquiadores para entrar nas filas " + sizes);
    }

    public static void esquiadoresQueSobraramNaFila(){
        String sizes = "(" + Filas.LS.size() + "-" + Filas.LT.size() + "-" + Filas.RT.size() + "-" + Filas.RS.size() + ")";
        System.out.println("Filas " + sizes);
    }

    public static long tempoEmFila() {
        long tempoSaida = System.currentTimeMillis();
        return tempoSaida - tempoEntrada;
    }

    public String getNome() {
        return nome;
    }

}
