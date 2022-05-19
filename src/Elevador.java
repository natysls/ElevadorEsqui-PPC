public class Elevador {

    private int[] numeroDeLugares = new int[4];

    public synchronized int[] carregaEsquiador(Esquiador esquiador){
        System.out.println("Carrega esquiadores");
        for(int i = 0; i < numeroDeLugares.length; i++){
            numeroDeLugares[i] = esquiador.getNumeroDeEsquiadores();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Lista de Esquiadores: " + numeroDeLugares);
        return numeroDeLugares;
    }


}
