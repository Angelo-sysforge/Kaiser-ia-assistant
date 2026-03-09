package kaiser.view;

import javafx.scene.image.Image;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import view.chat.interfacekaiser.ChatView;

public class MainView {

    public Scene createScene() {

        BorderPane root = new BorderPane();
        
        ChatView chat = new ChatView();
        VBox chatUI = chat.createChat();
        StackPane centro = new StackPane();
        centro.getChildren().add(chatUI);
        centro.setStyle("-fx-background-color:#1e1e1e;");
        StackPane.setAlignment(chatUI, Pos.CENTER);
        
        centro.setPadding(new Insets(0, 0, 20, 0));
        root.setCenter(centro);
        root.setStyle(
                "-fx-background-color: #2b2b2b;" +
                        "-fx-background-radius: 15;" +
                        "-fx-padding: 15;"
                );
        
            
             Button perfil = criarBotaoRedondo("/images/perfil.jpeg");
             Button projetos = criarBotaoRedondo("/images/projetos.jpeg");
             Button config = criarBotaoRedondo("/images/config.jpeg");

        HBox menu = new HBox(15);
        menu.getChildren().addAll(perfil, projetos, config);
        menu.setAlignment(Pos.CENTER);
        menu.setPadding(new Insets(10));
        menu.setStyle("-fx-background-color: transparent;");
        
        
        Scene scene = new Scene(root, 600, 400);
        scene.getStylesheets().add(
              getClass().getResource("/style.css").toExternalForm());
                
        root.setBottom(menu);
        
        return scene;
    
        }
        
           private Button criarBotaoRedondo(String caminhoImagem){
            
            double buttonSize = 42;
                    double iconSize = 35;
                    
                     Image img = new Image(getClass().getResourceAsStream(caminhoImagem));
                     ImageView icon = new ImageView (img);
                     
                     icon.setFitWidth(iconSize);
                     icon.setFitHeight(iconSize);
                     icon.setPreserveRatio(true);
                     
                     Circle clip = new Circle(iconSize/2, iconSize/2, iconSize/2);
                     icon.setClip(clip);
                     
                     Button botao = new Button();
                     botao.setGraphic(icon);
                     botao.setPrefSize(buttonSize, buttonSize);
                     
                     botao.setStyle(
                                "-fx-background-radius: 50em;" +
                                "-fx-background-color: #2b2b2b;" +
                                "-fx-padding: 0;" +
                                "-fx-border-color: transparent;"
                     );
                     
                     botao.setOnMouseEntered(e ->
                        botao.setStyle(
                        "-fx-background-radius: 50em;" +
                        "-fx-background-color: #3c3f41;")
                        );

                        botao.setOnMouseExited(e ->
                        botao.setStyle(
                        "-fx-background-radius: 50em;" +
                        "-fx-background-color: #2b2b2b;")
                        );

                     return botao;
         }
}