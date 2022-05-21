public class Elevador {

    private int numeroDeLugares = 4;
    private Esquiador[] lugares = new Esquiador[4];

    // seta na nossa variavel de numero de lugares ocupados um esquiador
    public synchronized void carregaEsquiadorNoElevador(Esquiador esquiador){
        System.out.println("Carrega esquiadores");

        // 4 lugares no elevador
        for(int i = 0; i < numeroDeLugares; i++){

            // detrminar qual fila será retirado um esquiador
            for(Esquiador filaDeEsquiadores: esquiador.getNumeroDeFilas()){
                if(filaDeEsquiadores.getFilaEsquerdaTripla().length >= 3){
                    lugares[i] = filaDeEsquiadores;
                } else if(filaDeEsquiadores.getFilaDireitaTripla().length >= 3){
                    lugares[i] = filaDeEsquiadores;
                } else if(filaDeEsquiadores.getFilaEsquerdaSozinho().length >= 1){
                    lugares[i] = filaDeEsquiadores;
                } else if(filaDeEsquiadores.getFilaDireitaSozinho().length >= 1){
                    lugares[i] = filaDeEsquiadores;
                }
            }
        }

        System.out.println("Lista de Esquiadores: " + numeroDeLugares);
    }

//    public void redistributeTriple(Esquiador esquiador){
//        for(int i = 0; i < numeroDeLugares.length - 1; i++){
//            numeroDeLugares[i] = esquiador.getNumeroDeEsquiadores();
//            try {
//                Thread.sleep(200);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    public void redistributeOnly(Esquiador esquiador){
//        for(int i = 0; i < numeroDeLugares.length - 3; i++){
//            numeroDeLugares[i] = esquiador.getNumeroDeEsquiadores();
//            try {
//                Thread.sleep(200);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }

//    public void chooseQueue(){
//        switch (this.fila) {
//            case LS:
//                this.fila = Fila.LS;
//                break;
//            case LT:
//                this.fila = Fila.LT;
//                break;
//            case RT:
//                this.fila = Fila.RT;
//                break;
//            case RS:
//                this.fila = Fila.RS;
//                break;
//            default:
//                break;
//        }
//    }

}
