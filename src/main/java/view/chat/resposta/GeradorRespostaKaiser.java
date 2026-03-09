package view.chat.resposta;

import view.chat.linguagem.IntentoKaiser;
import view.chat.memoria.MemoriaKaiser;

public class GeradorRespostaKaiser {
    
    public static String gerar (
                         IntentoKaiser intento,
                         String mensagem,
                         MemoriaKaiser memoria){
        
        String nome =
                memoria.obterFatos("nome_usuario");
        
        switch (intento){
            
            case SAUDACAO:
                if(nome != null && !nome.isEmpty())
                    return "Olá, " + nome + ". Como posso ajudar?";
                return "Olá. Como posso ajudar?";
                
            case AJUDA:
                return "Vamos analisar isso juntos. O que aconteceu exatamente?";
                
            case DESABAFO:
                return "Entendo. Quer me contar um pouco mais sobre isso?";
                
            case INFORMAR_NOME:
                return ""; //memória já responde
                
            default:
                return responderContextual(mensagem);
     }
    }
    
    private static String responderContextual(String msg){
        
        if(msg.endsWith("?"))
            return "Boa pergunta. Pode explicar um pouco mais o contexto?";
        
        if(msg.length()<8)
            return "Pode desenvolver melhor a ideia?";
        
        return "Interessante... continue.";
    }
}
