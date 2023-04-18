package pucrs.myflight.modelo;

import java.util.ArrayList;
import java.util.Collections;

public class GerenciadorRotas {

    private ArrayList<Rota> rotas;

    private GerenciadorRotas(){
        rotas = new ArrayList<>();
    }

    private static GerenciadorRotas instance;

    public static GerenciadorRotas getInstance() {
        if (instance == null)
            instance = new GerenciadorRotas();

        return instance;
    }

    public void adicionar(Rota percurso){
        rotas.add(percurso);
    }

    public ArrayList<Rota> listarTodasRotas(){
        return rotas;
    }

    public ArrayList<Rota> buscarPorOrigem(Aeroporto origem){
        for(Rota percurso: rotas)
            if(percurso.getOrigem() == origem)
                return rotas;
        return null;
    }

    public void ordenaCia(){
        Collections.sort(rotas);
    }

    @Override
        public String toString(){
            StringBuilder aux = new StringBuilder("\nGerenciador de Rota\n- - - - - - - - - - -\n");
            for(Rota percurso: rotas){
                aux.append(percurso.toString() + "\n");
            }
            return aux.toString();
        }
}
