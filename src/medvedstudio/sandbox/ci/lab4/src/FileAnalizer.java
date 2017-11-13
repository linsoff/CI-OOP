package medvedstudio.sandbox.ci.lab4.src;

//Letters - "[^a-zA-Zа-яА-Я]"
//Words - "([^A-Za-zА-Яа-я])([\\s\\W]+)"

import java.util.HashMap;
import java.util.Map;

public class FileAnalizer {

    private String path;

    public String getPath() {
        return path;
    }

    public FileAnalizer(String path) {

        this.path = path;

    }

    public int countLetters() {

        return -1;
    }
    public int countWords() {

        return -1;
    }
    public int countLines() {

        return -1;
    }
    public Map<Character,Integer> countFrequencyCharacteristic() {

        return new HashMap<Character, Integer>();
    }
}
