package medvedstudio.sandbox.ci.lab4.tests;


import medvedstudio.sandbox.ci.lab4.src.FileAnalizer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class FileAnalizerTests {

    private final String smallFile;
    private final String largeFile;
    private final String imageFile;

    private FileAnalizer smallAnalizer;

    public FileAnalizerTests() {

        this.smallFile = "../small-file.txt";
        this.largeFile = "../large-file.txt";
        this.imageFile = "../image-file.png";
    }

    @Test
    public void checkContructor() {

        FileAnalizer small = new FileAnalizer(smallFile);
        Assertions.assertEquals(smallFile, small.getPath());

        FileAnalizer large = new FileAnalizer(largeFile);
        Assertions.assertEquals(largeFile, large.getPath());

        try {
            FileAnalizer image = new FileAnalizer(imageFile);
            Assertions.fail("Init FileAnalizer for image file.");
        }
        catch (IllegalArgumentException exception) {}
    }

    @BeforeEach
    public void init() {
        smallAnalizer = new FileAnalizer(smallFile);
    }

    @Test
    public void checkMethods() {

        Assertions.assertEquals(9, smallAnalizer.countLetters());
        Assertions.assertEquals(12, smallAnalizer.countWords());
        Assertions.assertEquals(11, smallAnalizer.countLines());

        HashMap<Character, Integer> statistic = new HashMap<Character, Integer>();
        statistic.put('1', 4);
        statistic.put('2', 3);
        statistic.put('3', 3);
        statistic.put('4', 2);
        statistic.put('5', 1);
        statistic.put('a', 3);
        statistic.put('b', 2);
        statistic.put('c', 1);
        statistic.put('l', 1);
        statistic.put('k', 1);
        statistic.put('m', 1);
        statistic.put('\n', 10);
        statistic.put('\r', 10);
        statistic.put(' ', 3);

        Assertions.assertEquals(statistic, smallAnalizer.countFrequencyCharacteristic());
    }

    @Test
    public void usingCache() {

        for(int i = 0; i < 100; i++){

           Assertions.assertNotEquals(-1, new FileAnalizer(largeFile).countLines());
        }
    }
}
