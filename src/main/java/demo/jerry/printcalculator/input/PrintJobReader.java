package demo.jerry.printcalculator.input;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import demo.jerry.printcalculator.model.PrintJob;

/**
 * Defines contract for print job reading.
 * Class implements this interface should provide a way to
 * read from a input {@link Reader} and convert data to a list of {@link PrintJob}.
 * @author jzhang
 *
 */
public interface PrintJobReader {

    /**
     * Read data to a list of {@link PrintJob}.
     * @param in input reader.
     * @return parsed print job list.
     * @throws IOException when file can not be read.
     */
    List<PrintJob> read(Reader in) throws IOException;

}
