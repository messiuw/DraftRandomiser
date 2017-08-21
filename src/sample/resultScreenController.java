package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class resultScreenController {
    @FXML
    private Label lb1,lb2,lb3,lb4,lb5,lb6,lb7,lb8,lb9,lb10,lb11,lb12;

    public void initialize() {
        generateRandomDistribution(inputScreenController.returnTeamsInLeague());
    }

    private void generateRandomDistribution(Map<Integer, String> inputMap) {
        List<Label> labelList = new ArrayList<>();
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

                StringBuilder strbldr = new StringBuilder("Pick No. " + (i+1) + ": " + inputMap.get(randomNumber));
                labelList.get(i).setText(strbldr.toString());
                inputMap.remove(randomNumber);
                i++;
            }
        }
    }

    public void saveToFileButton() {

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.showOpenDialog(null);

    }
}
