import java.util.ArrayList;

public class Esquiador{
    
    private String nome;
    private ArrayList<Esquiador> listaEsquiadores = new ArrayList<>();

    public Esquiador(String nome) {
        this.nome = nome;
    }

    private void popularListaEsquiadores(){
        for(int i = 1; i <= 120; i++){
            listaEsquiadores.add(new Esquiador("Esquiador " + i));
        }
    }

    public static void inserirEsquiador() {
        boolean LsTwiceLessThanLT = Filas.LS.size() < 2 * Filas.LT.size();
        boolean LsTwiceLessThanRT = Filas.LS.size() < 2 * Filas.RT.size();
        boolean LsLessThanRS = Filas.LS.size() < Filas.RS.size();

        boolean RsTwiceLessThan = Filas.RS.size() < 2 * Filas.LT.size();
        boolean RsTwiceLessThanRT = Filas.RS.size() < 2 * Filas.RT.size();
        boolean RsLessThanLS = Filas.RS.size() <= Filas.LS.size();

        Esquiador esquiador = new Esquiador("Esquiador ");

        if (LsTwiceLessThanLT && LsTwiceLessThanRT && LsLessThanRS) {
            Filas.LS.add(esquiador);
            String sizes = "(" + Filas.LS.size() + "-" + Filas.LT.size() + "-" + Filas.RT.size() + "-" + Filas.RS.size() + ")";
            System.out.println("O " + esquiador.getNome() + " entrou na LS " + sizes);
        
        } else if (RsTwiceLessThan && RsTwiceLessThanRT && RsLessThanLS) {
            Filas.RS.add(esquiador);
            String sizes = "(" + Filas.LS.size() + "-" + Filas.LT.size() + "-" + Filas.RT.size() + "-" + Filas.RS.size() + ")";
            System.out.println("O " + esquiador.getNome() + " entrou na RS " + sizes);
        
        } else if (Filas.LT.size() <= Filas.RT.size()) {
            Filas.LT.add(esquiador);
            String sizes = "(" + Filas.LS.size() + "-" + Filas.LT.size() + "-" + Filas.RT.size() + "-" + Filas.RS.size() + ")";
            System.out.println("O " + esquiador.getNome() + " entrou na LT " + sizes);
        
        } else {
            Filas.RT.add(esquiador);
            String sizes = "(" + Filas.LS.size() + "-" + Filas.LT.size() + "-" + Filas.RT.size() + "-" + Filas.RS.size() + ")";
            System.out.println("O " + esquiador.getNome() + " entrou na RT " + sizes);
        
        }
    }

    public String getNome() {
        return nome;
    }

}
