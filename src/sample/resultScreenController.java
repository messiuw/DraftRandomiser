package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class resultScreenController {
    @FXML
    private Label lb1;
    @FXML
    private Label lb2;
    @FXML
    private Label lb3;
    @FXML
    private Label lb4;
    @FXML
    private Label lb5;
    @FXML
    private Label lb6;
    @FXML
    private Label lb7;
    @FXML
    private Label lb8;
    @FXML
    private Label lb9;
    @FXML
    private Label lb10;
    @FXML
    private Label lb11;
    @FXML
    private Label lb12;

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
}
