package demo.jerry.printcalculator.input;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import demo.jerry.printcalculator.model.PrintJob;
import static org.junit.Assert.assertEquals;

/**
 * PrintListCSVReader unit test.
 * @author jzhang
 */
public class PrintListCSVReaderTest {

    private PrintListCSVReader reader;

    @Before
    public void setup() {
        reader = new PrintListCSVReader();
    }

    @Test
    public void testValidRead() throws IOException {
        final List<PrintJob> result = reader.read(new FileReader("target/test-classes/printjobs.csv"));

        assertEquals("Expect 6 jobs are parsed", 6, result.size());
    }

    @Test
    public void testInvalidRead() throws IOException {
        final List<PrintJob> result = reader.read(new FileReader("target/test-classes/invalidprintjobs.csv"));

        assertEquals("Expect 4 jobs are parsed", 4, result.size());
    }

}
