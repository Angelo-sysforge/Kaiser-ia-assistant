package view.chat.resposta;

import view.chat.resposta.MotorResposta;
import view.chat.linguagem.ContextoConversacional;
import view.chat.linguagem.IntentoKaiser;
import view.chat.memoria.MemoriaKaiser;
import java.util.List;

public class MotorHibrido implements MotorResposta{
    
    private MotorResposta motorLocal;
    
    public MotorHibrido(){
        this.motorLocal = new MotorLocal();
    }
    @Override
    public String gerar (
    
             String mensagem,
            IntentoKaiser intento,
            ContextoConversacional contexto,
            MemoriaKaiser memoria,
            List<String> historico,
            String modo
    ) {
        
        if (intento == 
                IntentoKaiser.AJUDA) {
            return
                    motorLocal.gerar(mensagem, intento, contexto, memoria, historico, modo);
        }
        
        return
                motorLocal.gerar(mensagem, intento, contexto, memoria, historico, modo);
    }
}
