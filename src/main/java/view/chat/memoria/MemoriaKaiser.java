package view.chat.memoria;

import java.util.HashMap;
import java.util.Map;


public class MemoriaKaiser {
    
    private Map<String, String>
            fatos = new HashMap<>();
    
    public MemoriaKaiser(){
        
        MemoriaPersistente.carregar(fatos);
    }
    
    public void guardarFato(String chave, String valor){
        fatos.put(chave, valor);
        
        MemoriaPersistente.salvar(fatos);
    }
    
    public String obterFatos(String chave){
        return
                fatos.getOrDefault(chave, "");
    }
    public boolean possuiFato(String chave){
        return
                fatos.containsKey(chave);
    }
}
