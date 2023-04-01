package pucrs.myflight.modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class GerenciadorVoos {

    private ArrayList<Voo> voos;

    private GerenciadorVoos(){
        voos = new ArrayList<>();
    }

    private static GerenciadorVoos instance;
    
    public static GerenciadorVoos getInstance(){
        if(instance == null)
            instance = new GerenciadorVoos();
        return null;
    }

    public void adicionar(Voo voei){
        voos.add(voei);
    }

    public ArrayList<Voo> listarTodosVoos(){
        return voos;
    }

    //no exercicio tu pediu pra usar LocalDate mas em Voo tu usa LocalDateTime
    public ArrayList<Voo> buscarData(LocalDateTime data){
        for(Voo voar: voos)
            if(voar.getDatahora() == data)
                return voos;
        return null;
    }

    @Override
        public String toString(){
            StringBuilder aux = new StringBuilder("\n Gerenciador de Voo\n- - - - - - - - - - -\n");
            for(Voo voar: voos){
                aux.append(voar.toString() + "\n");
            }
            return aux.toString();
        }
}
