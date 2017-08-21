package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class inputScreenController {

    @FXML
    private TextField team1,team2,team3,team4,team5,team6,team7,team8,team9,team10,team11,team12;
    private static Map<Integer, String> teamsInLeague = new HashMap<>();
    private Scene scene;
    private FXMLLoader fxmlLoader;
    private Stage stage;

    public void initialize() {
        fillMapWithTeams();
        stage = new Stage();
        stage.setTitle("Randomised Draftorder");
    }

    @FXML
    public void onButtonClicked() {
        try {
            fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("resultScreen.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 300, 400);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.out.println(ex);
        }

    }

    private void fillMapWithTeams() {
        teamsInLeague.put(1, team1.getText());
        teamsInLeague.put(2, team2.getText());
        teamsInLeague.put(3, team3.getText());
        teamsInLeague.put(4, team4.getText());
        teamsInLeague.put(5, team5.getText());
        teamsInLeague.put(6, team6.getText());
        teamsInLeague.put(7, team7.getText());
        teamsInLeague.put(8, team8.getText());
        teamsInLeague.put(9, team9.getText());
        teamsInLeague.put(10, team10.getText());
        teamsInLeague.put(11, team11.getText());
        teamsInLeague.put(12, team12.getText());
    }

    static public Map<Integer, String> returnTeamsInLeague() {
        return new HashMap<>(teamsInLeague);
    }

}
