package ressources;

import javafx.stage.FileChooser;
import utility.teamsInLeague;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.*;

public class startScreenController {
    @FXML
    public Button manualButton;
    public Button loadButton;
    private FXMLLoader fxmlLoader;
    private Stage stage = new Stage();

    @FXML
    public void startScreenButtonPressed(ActionEvent event) {

        boolean leagueContainsTeams = true;
        if (event.getSource().equals(manualButton)) {
            teamsInLeague.getInstance().fillTeamsInLeagueWithDefaultValues();
        } else {
            leagueContainsTeams = loadFromFile();
        }

        if (leagueContainsTeams) {
            fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/inputScreen.fxml"));
            Scene scene = null;

            try {
                scene = new Scene(fxmlLoader.load(),300,600);
                inputScreenController controller = fxmlLoader.getController();
                controller.setParsedEvent(event);
            } catch (IOException IOEx) {
                IOEx.printStackTrace();
            }
            stage.setScene(scene);
            stage.show();
        }
    }

    private boolean loadFromFile() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Load list of Teams");
        File file = fileChooser.showOpenDialog(new Stage());
        if (file != null) {
            teamsInLeague.getInstance().writeFileToMap(file);
            return true;
        }
        return false;
    }

}
