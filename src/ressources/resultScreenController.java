package ressources;

import javafx.stage.FileChooser;
import javafx.stage.Stage;
import utility.teamsInLeague;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class resultScreenController {

    @FXML
    private GridPane gridPane;
    private List<Label> labelList = new ArrayList<>();

    @FXML
    public void saveToFileButton(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Path to save the File");
        File outputFile = fileChooser.showSaveDialog(new Stage());
        String content = readLabels();
        saveFile(content, outputFile);
    }

    public void initialize() {
        int i = 0;
        for (Node node : gridPane.getChildren()) {
            if (node.getId().contains("lb")) {
                labelList.add((Label) node);
                ((Label) node).setText(teamsInLeague.getInstance().returnRandomTeamsInLeauge().get(i));
                i++;
            }
        }
    }

    private String readLabels() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Label label : labelList) {
            stringBuilder.append(label.getText());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    private void saveFile(String content, File file) {
        try {
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(content);
            fileWriter.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
