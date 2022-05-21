public class Esquiador {

    private int numeroDeEsquiadores = 120;
    private Esquiador[] arrayDeEsquiadoresEmFilas = new Esquiador[numeroDeEsquiadores]; //array auxiliar

    private Esquiador[] filaEsquerdaSozinho;
    private Esquiador[] filaEsquerdaTripla;
    private Esquiador[] filaDireitaTripla;
    private Esquiador[] filaDireitaSozinho;

    private Esquiador[] numeroDeFilas = new Esquiador[4]; //são 4 filas, array auxiliar


    private void carregaEsquiadorNasFilas(){
        for(int i = 0; i < numeroDeEsquiadores; i++){
            if(filaEsquerdaTripla.length <= 3){
                filaEsquerdaTripla[i] = arrayDeEsquiadoresEmFilas[i];
            } else if(filaDireitaTripla.length <= 3){
                filaDireitaTripla[i] = arrayDeEsquiadoresEmFilas[i];
            } else if(filaEsquerdaSozinho.length <= 1) {
                filaEsquerdaSozinho[i] = arrayDeEsquiadoresEmFilas[i];
            } else if(filaDireitaSozinho.length <= 1) {
                filaDireitaSozinho[i] = arrayDeEsquiadoresEmFilas[i];
            }
        }
    }

    public int getNumeroDeEsquiadores() {
        return numeroDeEsquiadores;
    }

    public Esquiador[] getNumeroDeFilas() {
        return numeroDeFilas;
    }

    public Esquiador[] getFilaEsquerdaSozinho() {
        return filaEsquerdaSozinho;
    }

    public Esquiador[] getFilaEsquerdaTripla() {
        return filaEsquerdaTripla;
    }

    public Esquiador[] getFilaDireitaTripla() {
        return filaDireitaTripla;
    }

    public Esquiador[] getFilaDireitaSozinho() {
        return filaDireitaSozinho;
    }
}
