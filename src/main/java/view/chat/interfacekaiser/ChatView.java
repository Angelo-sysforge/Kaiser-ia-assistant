package view.chat.interfacekaiser;

import view.chat.core.KaiserBrain;
import javafx.animation.Animation;
import javafx.animation.PauseTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.util.Duration;

public class ChatView {

    private VBox chatArea;
    private TextField campoMensagem;
    private ScrollPane scroll;
    private KaiserBrain brain = new KaiserBrain();
    private boolean aguardandoResposta = false;
    
    
    public VBox createChat(){
        
          chatArea = new VBox(10);
          chatArea.setFillWidth(true);
          chatArea.setPadding(new Insets(15));
          chatArea.setStyle(
                  "-fx-background-color: #121212;");
          
          scroll = new ScrollPane(chatArea);
          scroll.setFitToWidth(true);
          scroll.setStyle(
                  "-fx-background: transparent;" +
                          "-fx-background-color: transparent;" +
                          "-fx-border-color: transparent;");
          
          chatArea.heightProperty().addListener((obs, oldVal, newVal) -> {
              scroll.setVvalue(1.0);
          });
          
          campoMensagem = new TextField();
          
          campoMensagem.setPromptText("Digite uma mensagem...");
          campoMensagem.setPrefWidth(300);
          
          Button enviar = new Button("Enviar");
          enviar.setPrefHeight(35);
          enviar.setMinWidth(80);
          
          enviar.setFocusTraversable(false);
          
           enviar.setOnAction(e ->
                  enviarMensagem());
           
          campoMensagem.setOnAction(e ->
                  enviarMensagem());
          
          
          HBox inputArea = new HBox (10, campoMensagem, enviar);
          
          inputArea.setPadding(new Insets(10));
          inputArea.setAlignment(Pos.CENTER);
          inputArea.setStyle("-fx-background-color: #1e1e1e;");
          
          VBox root = new VBox (scroll, inputArea);
           VBox.setVgrow(scroll, Priority.ALWAYS);
           
            brain.setListener(resposta -> {
            
                        HBox pensando = criarIndicadorPensando();
            chatArea.getChildren().add(pensando);
            
                        PauseTransition pausa = new
                PauseTransition(Duration.seconds(1.2));
            
            pausa.setOnFinished(e -> {
                chatArea.getChildren().remove(pensando);
                
                adicionarMensagemKaiser(resposta);
                aguardandoResposta = false;
            });
            pausa.play();
    });
           
           root.setMaxWidth(450);
           root.setMaxHeight(350);
          
          return root;
}
    private void enviarMensagem(){
        
        if (aguardandoResposta) return;
        
        String texto =
                campoMensagem.getText().trim();
                        if(texto.isEmpty()) return;
                        
                        aguardandoResposta = true;
                        
                        adicionarMensagemUsuario(texto);
                        campoMensagem.clear();
                        
                        brain.processarMensagem(texto);
                        
                        }
    
        private void adicionarMensagemUsuario(String texto){
         
            Label mensagem = new Label(texto);
            mensagem.setWrapText(true);
            mensagem.setMaxWidth(260);
            mensagem.setStyle(
                    "-fx-background-color: #2b2b2b;" +
                            "-fx-text-fill: white;" +
                            "-fx-padding: 8 12 8 12;" +
                            "-fx-background-radius: 10;"
            );
            
            HBox caixa = new HBox(mensagem);
            
            caixa.setAlignment(Pos.CENTER_RIGHT);
            caixa.setPadding(new Insets (4, 10, 4, 10));
            
            
            chatArea.getChildren().add(caixa);
                          }
        
        private void adicionarMensagemKaiser(String texto){
         
            Label mensagem = new Label(texto);
            mensagem.setWrapText(true);
            mensagem.setMaxWidth(260);
            mensagem.setStyle(
                    "-fx-background-color: #3a0d5c;" +
                            "-fx-text-fill: #b57cff;" +
                            "-fx-padding: 8 12 8 12;" +
                            "-fx-background-radius: 10;"
            );
            
            HBox linha = new HBox(mensagem);
            
            linha.setAlignment(Pos.CENTER_LEFT);
            linha.setPadding(new Insets(4, 10, 4, 10));
            
            chatArea.getChildren().add(linha);
            
        }
        
        private HBox criarIndicadorPensando(){
            
            Label p1 = new Label (".");
            Label p2 = new Label (".");
            Label p3 = new Label (".");
            
            HBox box = new HBox(5, p1, p2, p3);
            
            animarPonto(p1, 0);
            animarPonto(p2, 200);
            animarPonto(p3, 400);
            
            return box;
        }
        
        private void animarPonto(Label ponto, int delay){
            
            TranslateTransition anim = new TranslateTransition(Duration.millis(600), ponto);
            
            anim.setFromY(0);
            anim.setToY(-6);
            anim.setAutoReverse(true);
            
            anim.setCycleCount(Animation.INDEFINITE);
            anim.setDelay(Duration.millis(delay));
            
            anim.play();
        }        
        
}
            
    
