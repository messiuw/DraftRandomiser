package ressources;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import utility.teamsInLeague;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.util.Map;

public class inputScreenController {

    private final Map<Integer, String> teams = teamsInLeague.getInstance().returnTeamsInLeague();
    private ActionEvent parsedEvent;
    @FXML
    private GridPane gridPane;
    private FXMLLoader fxmlLoader;
    private Scene scene;

    public void initialize() {
        int i = 1;
        for (Node node : gridPane.getChildren()) {
            if (node.getId().contains("team")) {
                ((TextField) node).setText(teams.get(i));
                i++;
            }
        }
    }

    public void generateRandomDistribution() {
        teamsInLeague.getInstance().generateRandomDistribution();
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/resultScreen.fxml"));

        try {
            scene = new Scene(fxmlLoader.load(),300,600);
        } catch (IOException IOEx) {
            IOEx.printStackTrace();
        }

        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setX(0.0);
        stage.setY(0.0);
        stage.show();

    }

    void setParsedEvent(ActionEvent event) {
        this.parsedEvent = event;
    }

}
