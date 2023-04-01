package pucrs.myflight.modelo;

import java.util.ArrayList;

public class GerenciadorAeroportos {

    private ArrayList<Aeroporto> aeroportos;

    private GerenciadorAeroportos(){
        aeroportos = new ArrayList<>();
    }

    private static GerenciadorAeroportos instance;

        public static GerenciadorAeroportos getInstance() {
            if (instance == null)
                instance = new GerenciadorAeroportos();

            return instance;
        }

    public void adicionar(Aeroporto porto){
        aeroportos.add(porto);
    }    

    public ArrayList<Aeroporto> listarTodosAeroportos(){
        return aeroportos;
    }

    public Aeroporto buscarPorCodigo(String cod){
        for(Aeroporto porto: aeroportos){
            if(porto.getCodigo() == cod)
                return porto;
        }
        return null;
    }
    
    @Override
        public String toString(){
            StringBuilder aux = new StringBuilder("\nGerenciador de Aeroporto\n- - - - - - - - - - -\n");
            for(Aeroporto porto: aeroportos){
                aux.append(porto.toString() + "\n");
            }
            return aux.toString();
        }
}
