package demo.jerry.printcalculator.input;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import demo.jerry.printcalculator.model.PrintJob;
import demo.jerry.printcalculator.util.PrintJobConvertor;
import static demo.jerry.printcalculator.model.PaperSize.A4;

/**
 * CSV Reader for print list.
 * @author jzhang
 *
 */
public class PrintListCSVReader implements PrintJobReader {
    private static final Log LOGGER = LogFactory.getLog(PrintListCSVReader.class);

    @Override
    public List<PrintJob> read(Reader in) throws IOException {
        final List<PrintJob> result = new ArrayList<>();

        final Iterable<CSVRecord> records = CSVFormat.DEFAULT.withIgnoreSurroundingSpaces().parse(in);
        records.forEach(record -> addJobList(result, record));

        return result;
    }

    private void addJobList(final List<PrintJob> result, final CSVRecord record) {
        try {
            result.addAll(PrintJobConvertor.getPrintJob(A4, record.get(0), record.get(1), record.get(2)));
        } catch (final NumberFormatException e) {
            LOGGER.warn("Can't read record:" + record);
        }
    }
}
