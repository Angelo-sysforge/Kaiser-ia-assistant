package view.chat.memoria;

import java.util.HashMap;
import java.util.Map;

public class MemoriaContextual {
    
    private Map<String, String> contexto = new HashMap<>();
    
    public void guardarContexto (String chave, String valor){
        contexto.put(chave, valor);
    }
    
    public String obterContexto(String chave){
        return 
              contexto.getOrDefault(chave, "");
    }
    
    public boolean temContexto(String chave){
        return
              contexto.containsKey(chave);
    }
    
}
