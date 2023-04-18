package pucrs.myflight.modelo;

import java.util.ArrayList;
import java.util.Collections;

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
    
    public void ordenaNome(){
        Collections.sort(aeroportos);
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
