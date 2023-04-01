package pucrs.myflight.modelo;

import java.util.ArrayList;

public class GerenciadorCia {

    private ArrayList<CiaAerea> empresas;    

    private GerenciadorCia(){
        empresas = new ArrayList<>();
    }

    private static GerenciadorCia instance;

      
    public static GerenciadorCia getInstance(){
        if(instance == null)
            instance = new GerenciadorCia();

        return instance;    
    }
    
    public void inserir(CiaAerea cia){
        empresas.add(cia);
    }
 
    public void remover(CiaAerea emp){
        empresas.remove(emp);
    }

    public int tamanho(){
        return empresas.size();
    }

    // metodo get q tipo de referencia

    public ArrayList<CiaAerea> listarTodas(){
        return empresas;
    }
    
    public CiaAerea buscarCodigo(String cod){
        for(CiaAerea cia: empresas){
            if(cia.getCodigo() == cod)
                return cia;
        }
        return null;
    }

    public CiaAerea buscarNome(String nome){
        for(CiaAerea cia: empresas){
         if(cia.getNome() == nome)
            return cia;
        }
        return null;    
    }

    @Override
        public String toString(){
            StringBuilder aux = new StringBuilder("\nGerenciador de CiaAerea\n- - - - - - - - - - -\n");
            for(CiaAerea emp: empresas){
                aux.append(emp.toString() + "\n");
            }
            return aux.toString();
        }

    /*
      public int getValorTotalCentavos() {
        int somatorio = 0;
        for (int i = 0; i < moedas.size(); i++) {
            somatorio = somatorio + moedas.get(i).getValorCentavos();
        }
        return somatorio;
    }
     */
}
