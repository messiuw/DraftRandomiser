package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class resultScreenController {
    @FXML
    private Label lb1,lb2,lb3,lb4,lb5,lb6,lb7,lb8,lb9,lb10,lb11,lb12;
    private final Stage stage = new Stage();
    private List<Label> labelList;

    public void initialize() {
        generateRandomDistribution(inputScreenController.returnTeamsInLeague());
    }

    private void generateRandomDistribution(Map<Integer, String> inputMap) {
        labelList = new ArrayList<>();
        labelList.add(lb1);
        labelList.add(lb2);
        labelList.add(lb3);
        labelList.add(lb4);
        labelList.add(lb5);
        labelList.add(lb6);
        labelList.add(lb7);
        labelList.add(lb8);
        labelList.add(lb9);
        labelList.add(lb10);
        labelList.add(lb11);
        labelList.add(lb12);

        int i=0;
        while (inputMap.size() > 0) {
            int randomNumber = ThreadLocalRandom.current().nextInt(1,13);
            if (inputMap.containsKey(randomNumber)) {
                labelList.get(i).setText("Pick No. " + (i + 1) + ": " + inputMap.get(randomNumber));
                inputMap.remove(randomNumber);
                i++;
            }
        }
    }

    public void saveToFileButton() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save draftorder to file...");
        File file = fileChooser.showSaveDialog(stage);
        String content = readFields();
        saveFile(content, file);
    }

    private boolean saveFile(String content, File file) {
        try {
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(content);
            fileWriter.close();
            return true;
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    private String readFields() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Label label : labelList) {
            stringBuilder.append(label.getText());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
