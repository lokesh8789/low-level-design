package com.lld;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class FileAppender extends LogAppender {
    private final Path path;
    public FileAppender(LogFormatter logFormatter, Path path) {
        super(logFormatter);
        this.path = path;
    }

    @Override
    protected void write(String message) {
        try {
            Files.writeString(path, message + System.lineSeparator(), StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
