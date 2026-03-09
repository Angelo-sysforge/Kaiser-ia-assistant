package view.chat.resposta;

import view.chat.linguagem.ContextoConversacional;
import view.chat.linguagem.IntentoKaiser;
import view.chat.memoria.MemoriaKaiser;
import java.util.List;

public interface MotorResposta {
    
    String gerar (
    
            String mensagem,
            IntentoKaiser intento,
            ContextoConversacional contexto,
            MemoriaKaiser memoria,
            List<String> historico,
            String modo
    );
    
}
