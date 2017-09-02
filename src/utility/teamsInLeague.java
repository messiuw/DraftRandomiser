package utility;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class teamsInLeague {

    private static teamsInLeague instance = new teamsInLeague();
    private Map<Integer, String> teamsInLeague = new HashMap<>();
    private Map<Integer, String> teamsInLeagueRandom = new HashMap<>();

    // returning the only instance of this class
    public static teamsInLeague getInstance() {
        return instance;
    }

    // private constructor
    private teamsInLeague() {
    }

    public Map<Integer,String> returnTeamsInLeague() {
        return Collections.unmodifiableMap(this.teamsInLeague);
    }

    public Map<Integer,String> returnRandomTeamsInLeauge() {
        return Collections.unmodifiableMap(this.teamsInLeagueRandom);
    }

    public void fillTeamsInLeagueWithDefaultValues() {
        for (int i=1; i<=12; i++) {
            teamsInLeague.put(i,"Team No. " + i);
        }
    }

    public void generateRandomDistribution() {
        Map<Integer,String> workingMap = new HashMap<>(teamsInLeague);

        int i=0;
        while (workingMap.size() > 0) {
            int randomNumber = ThreadLocalRandom.current().nextInt(1,13);
            if (workingMap.containsKey(randomNumber)) {
                teamsInLeagueRandom.put(i,workingMap.get(randomNumber));
                workingMap.remove(randomNumber);
                i++;
            }
        }
    }

    public void writeFileToMap(File inputFile) {
        String filecontentAsString = null;
        try {
            byte[] filecontentAsBytes = Files.readAllBytes(inputFile.toPath());
            filecontentAsString = new String(filecontentAsBytes, Charset.defaultCharset());
        } catch (IOException IOEx) {
            System.out.println("Error while reading File");
            IOEx.printStackTrace();
        }

        String[] fileContentAsStringarray = filecontentAsString.split("\n");
        int i = 1;
        for (String team : fileContentAsStringarray) {
            this.teamsInLeague.put(i,team);
            i++;
        }
    }
}
