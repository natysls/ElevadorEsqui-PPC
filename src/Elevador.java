public class Elevador {

    private Fila fila;
    private Filas filas;
    private int[] numeroDeLugares = new int[4];

    public synchronized void carregaEsquiador(Esquiador esquiador){
        System.out.println("Carrega esquiadores");

        if(filas.getEsquerdaTripla().length >= 3 || filas.getDireitaTripla().length >= 3){
            redistributeTriple(esquiador);
//            if(filas.getDireitaSozinho().length >= 1 || filas.getEsquerdaSozinho().length >= 1){
//
//            }
        }
        chooseQueue();


        System.out.println("Lista de Esquiadores: " + numeroDeLugares);
    }

    public void redistributeTriple(Esquiador esquiador){
        for(int i = 0; i < numeroDeLugares.length - 1; i++){
            numeroDeLugares[i] = esquiador.getNumeroDeEsquiadores();
//            try {
//                Thread.sleep(200);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
    }

    public void redistributeOnly(Esquiador esquiador){
        for(int i = 0; i < numeroDeLugares.length - 3; i++){
            numeroDeLugares[i] = esquiador.getNumeroDeEsquiadores();
//            try {
//                Thread.sleep(200);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
    }

    public void chooseQueue(){
        switch (this.fila) {
            case LS:
                this.fila = Fila.LS;
                break;
            case LT:
                this.fila = Fila.LT;
                break;
            case RT:
                this.fila = Fila.RT;
                break;
            case RS:
                this.fila = Fila.RS;
                break;
            default:
                break;
        }
    }

}
