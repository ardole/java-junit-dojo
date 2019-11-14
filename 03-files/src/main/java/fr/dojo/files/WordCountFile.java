package fr.dojo.files;

import java.io.*;

public class WordCountFile {

    public long count(WordCountOption option, File file) throws WordCountException {
        switch (option) {
            case BYTES_NUMBER:
                return countBytesNumber(file);
            case CHARS_NUMBER:
                return countCharsNumber(file);
            case LINES_NUMBER:
                return countLinesNumber(file);
            default:
                return 0;
        }
    }

    private long countBytesNumber(File file) {
        return file.length();

    }

    private long countCharsNumber(File file) throws WordCountException {
        try (FileInputStream inputStream = new FileInputStream(file)) {
            try (InputStreamReader reader = new InputStreamReader(inputStream)) {
                try (BufferedReader bi = new BufferedReader(reader)) {
                    long total = 0L;
                    String line;
                    while ((line = bi.readLine()) != null) {
                        total += line.length();
                    }
                    return total;
                }
            }
        } catch (IOException e) {
            throw new WordCountException("Unable to count chars number into this file", e);
        }
    }

    private long countLinesNumber(File file) throws WordCountException {
        try (FileInputStream inputStream = new FileInputStream(file)) {
            try (InputStreamReader reader = new InputStreamReader(inputStream)) {
                try (BufferedReader bi = new BufferedReader(reader)) {
                    long total = 0L;
                    while (bi.readLine() != null) {
                        total += 1;
                    }
                    return total;
                }
            }
        } catch (IOException e) {
            throw new WordCountException("Unable to count lines number into this file", e);
        }
    }

}
