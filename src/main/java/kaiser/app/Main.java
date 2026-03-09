package kaiser.app;

import javafx.application.Application;
import javafx.stage.Stage;
import kaiser.view.MainView;

public class Main extends Application {
    
    @Override
    public void start(Stage stage) {
        
        MainView view = new MainView();
        
        stage.setTitle("Kaiser");
        stage.setScene(view.createScene());
        stage.show();
    }
    
    public static void main(String[] args){
        launch(args);
    }
    
}
    

