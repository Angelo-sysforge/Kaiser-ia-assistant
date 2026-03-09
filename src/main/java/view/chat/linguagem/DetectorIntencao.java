package view.chat.linguagem;

import view.chat.linguagem.IntentoKaiser;

public class DetectorIntencao {
    
    public static IntentoKaiser detectar(String texto){
        
        if(texto == null ||
                texto.isEmpty())
            return
                    IntentoKaiser.DESCONHECIDO;
        
        String t = texto.toLowerCase();
        
        if(t.contains("meu nome é")){
            return
                    IntentoKaiser.INFORMAR_NOME;}
        
        if(t.matches(".*\\b(erro|bug|não funciona|nao funciona|não compila|nao compila|ajuda)\\b*.")){
            return
                    IntentoKaiser.AJUDA;}
        
        if(t.matches(".*\\b(triste|cansado|mal|ansioso|mau)\\b*.")){
            return
                    IntentoKaiser.DESABAFO;}
                   
        if(t.matches(".*\\b(oi|olá|ola|hey|eae|hey|oioi)\\b*.")){
            return
                    IntentoKaiser.SAUDACAO;}
        
        return IntentoKaiser.INDEFINIDO;
    }
}
