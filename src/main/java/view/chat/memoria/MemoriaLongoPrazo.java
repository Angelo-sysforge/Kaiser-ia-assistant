package view.chat.memoria;

import java.util.HashMap;
import java.util.Map;

public class MemoriaLongoPrazo {
    
    private Map<String,String> dados = new HashMap<>();
    
    public void guardar(String chave, String valor){
        dados.put(chave, valor);
    }
    
    public String obter (String chave){
        return dados.getOrDefault(chave, "");
    }
    
    public boolean existe(String chave){
        return dados.containsKey(chave);
    }
    
    public Map<String,String> todos(){
        return dados;
    }
}
