package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

public class ManejadorDeArchivos {

    public static void archivar(String fileName, String text) {
        Path filePath = Path.of(fileName + ".txt").toAbsolutePath();
        try(FileWriter fileWriter = new FileWriter(filePath.toFile(), true)) {
            fileWriter.write(text + System.lineSeparator());
        } catch (IOException e) {
            throw new RuntimeException("Error while writing to file: " + fileName, e);
        }
    }
}
