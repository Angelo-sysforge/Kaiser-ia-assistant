package view.chat.linguagem;

import view.chat.linguagem.IntentoKaiser;

public class ContextoConversacional {
    
    private String ultimoTopico = "";
    private IntentoKaiser ultimoIntento = IntentoKaiser.DESCONHECIDO;
    private String ultimaMensagemUsuario = "";
    
   public String ultimoTopico(String ultimoTopico){
       return ultimoTopico;
   }
       
       public void setUltimoTopico(String ultimoTopico){
       this.ultimoTopico = 
               ultimoTopico;
   }
   
   public IntentoKaiser getUltimoIntento(){
       return ultimoIntento;
   }
   
   public void setUltimoIntento(IntentoKaiser ultimoIntento){
       this.ultimoIntento = 
               ultimoIntento;
   }
   
   public String getUltimaMensagemUsuario(){
       return ultimaMensagemUsuario;
   }
   
   public void setUltimaMensagemUsuario(String msg){
       this.ultimaMensagemUsuario =
             msg;
   }
    
}
