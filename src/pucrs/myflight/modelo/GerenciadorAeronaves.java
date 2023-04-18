package pucrs.myflight.modelo;

import java.util.ArrayList;
import java.util.Collections;

public class GerenciadorAeronaves {

    private ArrayList<Aeronave> aeronaves;

    private GerenciadorAeronaves(){
        aeronaves = new ArrayList<>();
    }

    private static GerenciadorAeronaves instance;

        public static GerenciadorAeronaves getInstance() {
            if (instance == null)
                instance = new GerenciadorAeronaves();

            return instance;
        }

        public void inserir(Aeronave nave){
            aeronaves.add(nave);
        }

        public ArrayList<Aeronave> listarTodasAeronaves(){
            return aeronaves;
        }

        public Aeronave buscarPorCodigo(String cod){
            for(Aeronave nave: aeronaves){
                if(nave.getCodigo() == cod)
                    return nave;
            }
            return null;
        }
         
        public void ordenaDescricao(){
            Collections.sort(aeronaves);
        }
        
        @Override
        public String toString(){
            StringBuilder aux = new StringBuilder("\nGerenciador de Aeronaves\n- - - - - - - - - - -\n");
            for(Aeronave nave: aeronaves){
                aux.append(nave.toString() + "\n");
            }
            return aux.toString();
        }
}
