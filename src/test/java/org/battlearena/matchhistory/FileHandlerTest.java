package org.battlearena.matchhistory;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileHandlerTest {
    FileHandler fileHandler;
    Path path;

    @BeforeEach
    void setUp() {
        fileHandler = new FileHandler();
        path = Path.of("matchhistory.txt");
    }

    @AfterEach
    void tearDown() {
        assertDoesNotThrow(() -> {
            Files.deleteIfExists(path);
        });
    }

    @Test
    void writeToFileShouldCreateFileIfNotExistsAndWriteContent() {
        String content = "Winner: Picard | Number of turns: 3";

        boolean actual = fileHandler.writeToFile(content);

        assertDoesNotThrow(() -> {
            assertEquals(content, Files.readAllLines(path).getFirst());
        });

        assertTrue(actual);
    }

    @Test
    void getFileContentsShouldReturnFileContents() {
        List<String> expected = new ArrayList<>();
        expected.add("Winner: Picard | Number of turns: 3");
        expected.add("Winner: Computer | Number of turns: 21");
        expected.add("Winner: Picard | Number of turns: 5");

        assertDoesNotThrow(() -> {
            if (!Files.exists(path)) {
                Files.createFile(path);
            }
            for (String line : expected) {
                Files.writeString(path, line + System.lineSeparator(), StandardOpenOption.APPEND);
            }

            List<String> actual = fileHandler.getFileContents();
            assertEquals(expected, actual);
        });
    }
}
