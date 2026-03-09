package view.chat.personalidade;

import view.chat.linguagem.IntentoKaiser;

public class KaiserDecisor {
    
    public String decidirModo (IntentoKaiser intento){
        
        switch (intento){
            
            case DESABAFO:
                return "EMPATICO";
                
            case AJUDA:
                return "EXPLICATIVO";
                
            case CONVERSA:
                return "CURIOSO";
                
            default:
                return "NEUTRO";
        }
    }
    
}
