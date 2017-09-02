package ressources;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    private static Stage window;

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("inputScreen.fxml"));
        Parent root = FXMLLoader.load(getClass().getResource("../fxml/startScreen.fxml"));
        primaryStage.setTitle("Draft Randomizer");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        window = primaryStage;
    }


    public static void main(String[] args) {
        launch(args);
    }
}
