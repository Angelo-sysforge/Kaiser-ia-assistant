package view.chat.memoria;

import java.io.*;
import java.util.Map;

public class MemoriaPersistente {
    
    private static final String ARQUIVO = "memoria_kaiser.txt";
    
    public static void salvar (Map<String, String>memoria){
        try(PrintWriter writer= 
                new PrintWriter(new FileWriter(ARQUIVO))){
            for(Map.Entry<String,String>entry : memoria.entrySet()){
                
                writer.println(entry.getKey() + "=" +
                        entry.getValue());
            }
        } catch(IOException e){
            System.out.println("Erro ao salvar memória.");
        }
    }
    
    public static void 
            carregar(Map<String,String> memoria){
                File arquivo = new File(ARQUIVO);
                
                if(!arquivo.exists()) return;
                
                try(BufferedReader reader =
                        new BufferedReader(new FileReader(arquivo))){
                    
                    String linha;
                    
                    while((linha =
                            reader.readLine()) != null){
                        
                        String[] partes = linha.split("=");
                        
                        if(partes.length == 2){
                            
                            memoria.put(partes[0], partes[1]);
                        }
                    }
            } catch (IOException e){
                    System.out.println("Erro ao carregar memória.");
            }
    }
    
}
