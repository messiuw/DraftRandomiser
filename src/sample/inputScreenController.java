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
    private TextField team1;
    @FXML
    private TextField team2;
    @FXML
    private TextField team3;
    @FXML
    private TextField team4;
    @FXML
    private TextField team5;
    @FXML
    private TextField team6;
    @FXML
    private TextField team7;
    @FXML
    private TextField team8;
    @FXML
    private TextField team9;
    @FXML
    private TextField team10;
    @FXML
    private TextField team11;
    @FXML
    private TextField team12;

    private static Map<Integer, String> teamsInLeague = new HashMap<>();

    @FXML
    public void onButtonClicked() {

        fillMapWithTeams();
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("resultScreen.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load(), 300,400);
            Stage stage = new Stage();
            stage.setTitle("Randomised Draftorder");
            stage.setScene(scene);
            stage.show();

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
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
