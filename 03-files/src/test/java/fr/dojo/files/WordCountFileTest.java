package fr.dojo.files;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.File;
import java.net.URL;

import static fr.dojo.files.OsUtils.isNotWindows;
import static fr.dojo.files.OsUtils.isWindows;
import static fr.dojo.files.WordCountOption.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assume.assumeTrue;

public class WordCountFileTest {

    private WordCountFile wordCountFile;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private File testResourceFile;

    @Before
    public void setUp() {
        wordCountFile = new WordCountFile();
        testResourceFile = getFile("loremipsum.txt");
    }

    @Test
    public void wordCountSimpleFile() throws WordCountException {
        long charsNumber = wordCountFile.count(CHARS_NUMBER, testResourceFile);
        assertEquals(charsNumber, 2047);

        long linesNumber = wordCountFile.count(LINES_NUMBER, testResourceFile);
        assertEquals(linesNumber, 4);
    }

    @Test
    public void wordCountBytesWindows() throws WordCountException {
        assumeTrue(isWindows());

        long bytesNumber = wordCountFile.count(BYTES_NUMBER, testResourceFile);
        assertEquals(2053, bytesNumber);
    }

    @Test
    public void wordCountBytesOther() throws WordCountException {
        assumeTrue(isNotWindows());

        long bytesNumber = wordCountFile.count(BYTES_NUMBER, testResourceFile);
        assertEquals(2050, bytesNumber);
    }

    @Test
    public void wordCountEmptyFile() throws WordCountException {
        File testResourceFile = getFile("empty.txt");

        long bytesNumber = wordCountFile.count(BYTES_NUMBER, testResourceFile);
        assertEquals(bytesNumber, 0);

        long charsNumber = wordCountFile.count(CHARS_NUMBER, testResourceFile);
        assertEquals(charsNumber, 0);

        long linesNumber = wordCountFile.count(LINES_NUMBER, testResourceFile);
        assertEquals(linesNumber, 0);
    }

    @Test
    public void wordCountLinesUnexistingFile() throws WordCountException {
        expectedException.expectMessage("Unable to count lines number into this file");
        expectedException.expect(WordCountException.class);

        wordCountFile.count(LINES_NUMBER, new File("unexisting.file"));
    }

    @Test
    public void wordCountCharsUnexistingFile() throws WordCountException {
        expectedException.expectMessage("Unable to count chars number into this file");
        expectedException.expect(WordCountException.class);

        wordCountFile.count(CHARS_NUMBER, new File("unexisting.pdf"));
    }

    @Test
    public void wordCountBytesUnexistingFile() throws WordCountException {

        wordCountFile.count(BYTES_NUMBER, new File("unexisting.pdf"));
    }

    private File getFile(String fileName) {
        URL testResource = getClass().getResource(fileName);
        return new File(testResource.getFile());
    }

}