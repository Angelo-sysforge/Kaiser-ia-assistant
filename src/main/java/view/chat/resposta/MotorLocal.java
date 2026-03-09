package view.chat.resposta;

import view.chat.resposta.MotorResposta;
import view.chat.linguagem.ContextoConversacional;
import view.chat.linguagem.IntentoKaiser;
import view.chat.memoria.MemoriaKaiser;
import java.util.List;
import java.util.Random;


public class MotorLocal implements MotorResposta{
    
    private final Random random = new Random();
    private String ultimaResposta = "";
    
    @Override
    public String gerar (
    
             String mensagem,
            IntentoKaiser intento,
            ContextoConversacional contexto,
            MemoriaKaiser memoria,
            List<String> historico,
            String modo
    ){


    String nome =
            memoria.obterFatos ("nome_usuario");
    String prefixo = (nome != null && !nome.isEmpty()) ? nome + ", " : "";
    
    String[] respostas;
    
    switch (intento){
    
      case SAUDACAO:
                                respostas = new String[]{
                                        "Olá, " + prefixo + "como posso ajudar?",
                                        "Oi " + prefixo + "! Tudo certo por ai?",
                                        "E aí " + prefixo + "! Como você tá?"
                                
                        };
                                break;
                                
                            case AJUDA:
                                respostas = new String []{
                                    prefixo + "vamos analisar isso juntos. O que aconteceu exatamente?",
                                    prefixo + "Conte-me mais detalhes sobre o problema.",
                                    prefixo + "Não se preocupe, vamos resolver isso passo a passo."
                                        };
                                break;
                                
                            case DESABAFO:
                               respostas = new String []{
                                       prefixo + "estou ouvindo. Pode me contar mais?",
                                       prefixo + "Entendo, continue falando.",
                                       prefixo + "Pode desabafar comigo, estou aqui."
                                       };
                               break;
                               
                            case CONVERSA:
                            case INFORMAR_NOME:
                                respostas = new String []{
                                       prefixo + "Interessante, continue.",
                                       prefixo + "Me conte mais sobre isso.",
                                       prefixo + "Hum... continue, quero entender melhor."
                                };
                                break;
                                
                            default:
                              respostas = new String []{
                                       prefixo + "Continue.",
                                       prefixo + ". Prossiga, estou ouvindo."
                        };
                    }
                        return escolherResposta(respostas);
}
    private String escolherResposta(String[] respostas){
                    
                        if(respostas.length == 1){
                            ultimaResposta = respostas [0];
                            return respostas [0];
                        }
                    String resposta;
                    int tentativas = 0;
                    
            do {
                resposta = respostas[random.nextInt(respostas.length)];
                           tentativas++;
            }
                while (resposta.equals(ultimaResposta) && 
                    tentativas < 10);
                
                ultimaResposta = resposta;
                return resposta;
            }
}
