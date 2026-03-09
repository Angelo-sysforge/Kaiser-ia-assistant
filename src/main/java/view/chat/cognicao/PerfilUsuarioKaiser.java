package view.chat.cognicao;

import java.util.HashMap;
import java.util.Map;

public class PerfilUsuarioKaiser {
    
    private Map<String,String> atributos = new HashMap<>();
    
    public void definir(String chave, String valor){
        atributos.put(chave, valor);
    }
    
    public String obter(String chave){
        return atributos.get(chave);
    }
    
}
