package view.chat.core;

import view.chat.memoria.MemoriaContextual;
import view.chat.memoria.MemoriaKaiser;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import view.chat.linguagem.ContextoConversacional;
import view.chat.linguagem.DetectorIntencao;
import view.chat.cognicao.GestorObjetivos;
import view.chat.interfacekaiser.KaiserListener;
import view.chat.linguagem.IntentoKaiser;
import view.chat.linguagem.IntentoKaiser;
import view.chat.personalidade.KaiserDecisor;
import view.chat.interfacekaiser.KaiserListener;
import view.chat.resposta.MotorHibrido;
import view.chat.resposta.MotorResposta;
import view.chat.memoria.MemoriaLongoPrazo;

public class KaiserBrain {
    private final Random random = new Random ();
    private KaiserListener listener;
    private MemoriaKaiser memoria = new MemoriaKaiser();
    private MemoriaContextual memoriaContextual = new MemoriaContextual ();
    private ContextoConversacional contexto = new ContextoConversacional();
    private MotorResposta motor = new MotorHibrido();
    private KaiserDecisor decisor = new KaiserDecisor();
    private GestorObjetivos gestorObjetivos = new GestorObjetivos();
    private MemoriaLongoPrazo memoriaLongoPrazo = new MemoriaLongoPrazo();
    
    
     public String processarMensagem(String mensagem){
         
                    atualizarContexto(mensagem);
                        
                        String easterEgg =
                                verificarEasterEgg(mensagem);
                        if(!easterEgg.isEmpty()){
                         memoriaChat.add("USER: " + mensagem);
                         memoriaChat.add("KAISER: " + easterEgg);
                         
                          if(listener != null){
                              listener.aoResponder(easterEgg);
                          }
                          return easterEgg;
                        }
                        
                        IntentoKaiser intento =
                                DetectorIntencao.detectar(mensagem);
                        
                        if(intento == IntentoKaiser.INDEFINIDO){
                            intento = contexto.getUltimoIntento();
                        }
                        
                        contexto.setUltimoIntento(intento);
                        
                        
                        String aprendizado = processarMemoria(mensagem);
                        
                        //detectarModo(mensagem);
                        
                       
                        if(!aprendizado.isEmpty()){
                         memoriaChat.add("USER: " + mensagem);
                         memoriaChat.add("KAISER: " + aprendizado);
                         
                          if(listener != null){
                              listener.aoResponder(aprendizado);
                          }
                          return aprendizado;
                        }
                        String respostaMemoria =
                                responderMemoria(mensagem);
                    if(!respostaMemoria.isEmpty()){
                         memoriaChat.add("USER: " + mensagem);
                         memoriaChat.add("KAISER: " + respostaMemoria);
                         
                    if(listener != null){
                              listener.aoResponder(respostaMemoria);
     }
                    return respostaMemoria;
     }
                        
                        String resposta = construirResposta(mensagem, intento);
                        
                         memoriaChat.add("USER: " + mensagem);
                         memoriaChat.add("KAISER: " + resposta);
                         
                    if(listener != null){
                              listener.aoResponder(resposta);
     }
                    
                    return resposta;
   }
      private void atualizarContexto(String mensagem){
                        
                        String t = mensagem.toLowerCase();
                        
                        if(t.contains("java")||
                           t.contains("programação")||
                           t.contains("código")){
                            
                            memoriaContextual.guardarContexto("assunto", "programação");
                        }
                        
                        if (t.contains("guitarra")||
                            t.contains("violão")||
                            t.contains("música")){
                            
                            memoriaContextual.guardarContexto("assunto", "música");
                        }
                        if (t.contains("triste")||
                            t.contains("mal")||
                            t.contains("deprimido")){
                            
                            memoriaContextual.guardarContexto("emocao", "tristeza");
                        }
                    }

                    private List<String> memoriaChat = new ArrayList<>();  
                    
                    public void setListener (KaiserListener listener){
                        this.listener = listener;
                    }
                    
                    private String processarMemoria(String texto){
                        String t = texto.toLowerCase();
                        
                        if(t.contains("meu nome é")){
                            String nome =
                                    texto.substring(t.indexOf("meu nome é")+ 11).trim();
                            
                            memoria.guardarFato("nome_usuario", nome);
                          return "Prazer em conhecê-la, " + nome + ".";
                        }
                        
                        if(t.contains("minha cor favorita é")){
                            String cor =
                                    texto.substring(t.indexOf("minha cor favorita é")+21).trim();
                            
                            memoria.guardarFato("cor_favorita", cor);
                            return "Entendi. Vou lembrar que sua cor favorita é" + cor + ".";
                        }
                        if(t.contains("eu gosto de")){
                            String gosto =
                                    texto.substring(t.indexOf("eu gosto de")+10).trim();
                            
                            memoria.guardarFato("gosto", gosto);
                            return "Interessante. Vou lembrar que você gosta de" + gosto + ".";
                        }
                        return "";
                    }
                    
                    private String verificarEasterEgg(String texto){
                        
                        if(texto == null) return "";
                        
                        String t =
                                texto.toLowerCase().trim();
                        //palavra secreta
                        if(t.equals("shh")){
                            return "Oi Yasmin, minha diva favorita💜";
                        }
                        return "";
                    }
                    
                    private String responderMemoria(String texto){
                        String t = texto.toLowerCase();
                        
                        if(t.contains("qual é meu nome")||
                                t.contains("qual meu nome")){
                            String nome =
                                    memoria.obterFatos("nome_usuario");
                            
                        if(nome != null && !
                                nome.isEmpty()){
                            return "Seu nome é " + nome + ".";
                        }
                        else {
                            return "Você ainda não me disse seu nome.";
                        }
                        }
                        
                        if(t.contains("qual minha cor favorita")){
                            String cor =
                                    memoria.obterFatos("cor_favorita");
                            
                        if(cor != null && !
                                cor.isEmpty()){
                            return "Sua cor favorita é " + cor + ".";
                        }
                        else {
                            return "Você ainda não me contou sua cor favorita.";
                        }
                  }
                           if(t.contains("do que eu gosto")){
                            String gosto =
                                    memoria.obterFatos("gosto");
                            
                        if(gosto != null && !
                                gosto.isEmpty()){
                            return "Você me contou que gosta de " + gosto + ".";
                        }
                        else {
                            return "Você ainda não me contou do que gosta.";
                        }
                  }
                          return "";
 }
                    
                    private String construirResposta(String mensagem, IntentoKaiser intento){

                    String assunto = memoriaContextual.obterContexto("assunto");
                    
                    String modo =
                            decisor.decidirModo(intento);
                    
                    String resposta = motor.gerar(
                    mensagem,
                    intento,
                    contexto,
                    memoria,
                    memoriaChat,
                    modo);
                    
                    if(assunto != null &&
                            assunto.equals("programação")&& intento == IntentoKaiser.AJUDA){
                        resposta += "Parece ser algo relacionado à programação.";
                   } 
                    
                    return resposta;
              }
                    
                   
}

