package org.battlearena.matchhistory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class FileHandler {
    private static final String PATH = "matchhistory.txt";

    private Path getPath() {
        return Path.of(PATH);
    }

    public boolean writeToFile(String content) {
        if (content.isBlank()) {
            return false;
        }

        try {
            if (!Files.exists(getPath())) {
                Files.createFile(getPath());
            }

            Files.writeString(
                    getPath(),
                    content + System.lineSeparator(),
                    StandardOpenOption.APPEND
            );
        } catch (IOException e) {
            return false;
        }

        return true;
    }
}
