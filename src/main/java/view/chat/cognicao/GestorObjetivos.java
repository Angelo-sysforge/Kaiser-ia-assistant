package view.chat.cognicao;

import java.util.ArrayList;
import java.util.List;

public class GestorObjetivos {
    
    private String objetivoAtual;
    private List<String> subtarefas = new ArrayList<>();
    
    public void denifirObjetivo(String objetivo){
        this.objetivoAtual = objetivo;
    }
    
    public String obterObjetivo(){
        return objetivoAtual;
    }
    
    public void
            adicionarSubtarefas(String tarefa){
                subtarefas.add(tarefa);
            }
            
    public List<String>
            obterSubtarefas(){
                return subtarefas;
            }
            
            public void limparSubtarefas(){
                subtarefas.clear();
            }
}
