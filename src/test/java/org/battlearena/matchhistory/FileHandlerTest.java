package org.battlearena.matchhistory;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;

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
}