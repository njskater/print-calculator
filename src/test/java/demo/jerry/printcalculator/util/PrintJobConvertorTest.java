package demo.jerry.printcalculator.util;

import java.util.List;

import org.junit.Test;

import demo.jerry.printcalculator.model.PaperSize;
import demo.jerry.printcalculator.model.PrintCategory;
import demo.jerry.printcalculator.model.PrintJob;
import static org.junit.Assert.assertEquals;

/**
 * PrintJobConvertor unit test.
 * @author jzhang
 */
public class PrintJobConvertorTest {

    @Test
    public void testValidDoubleSidedConvert() {
        final List<PrintJob> printJobs = PrintJobConvertor.getPrintJob(PaperSize.A4, "100", "10", "true");
        assertEquals("Expect 2 jobs returned", 2, printJobs.size());

        final PrintJob printJob1 = printJobs.get(0);
        assertEquals(PrintCategory.a4BlackWhiteDoubleSided(), printJob1.getPrintCategory());
        assertEquals(90, printJob1.getPageNumber());

        final PrintJob printJob2 = printJobs.get(1);
        assertEquals(PrintCategory.a4ColourDoubleSided(), printJob2.getPrintCategory());
        assertEquals(10, printJob2.getPageNumber());
    }

    @Test
    public void testValidSingleSidedConvert() {
        final List<PrintJob> printJobs = PrintJobConvertor.getPrintJob(PaperSize.A4, "100", "10", "false");
        assertEquals("Expect 2 jobs returned", 2, printJobs.size());

        final PrintJob printJob1 = printJobs.get(0);
        assertEquals(PrintCategory.a4BlackWhiteSingleSided(), printJob1.getPrintCategory());
        assertEquals(90, printJob1.getPageNumber());

        final PrintJob printJob2 = printJobs.get(1);
        assertEquals(PrintCategory.a4ColourSingleSided(), printJob2.getPrintCategory());
        assertEquals(10, printJob2.getPageNumber());
    }

    @Test
    public void testColouredMoreThanTotal() {
        final List<PrintJob> printJobs = PrintJobConvertor.getPrintJob(PaperSize.A4, "100", "110", "true");
        assertEquals("Expect 1 jobs returned", 1, printJobs.size());

        final PrintJob printJob1 = printJobs.get(0);
        assertEquals(PrintCategory.a4ColourDoubleSided(), printJob1.getPrintCategory());
        assertEquals(110, printJob1.getPageNumber());

    }

    @Test
    public void testSkip0PageNumber() {
        final List<PrintJob> printJobs = PrintJobConvertor.getPrintJob(PaperSize.A4, "100", "0", "true");
        assertEquals("Expect 1 jobs returned", 1, printJobs.size());

        final PrintJob printJob1 = printJobs.get(0);
        assertEquals(PrintCategory.a4BlackWhiteDoubleSided(), printJob1.getPrintCategory());
        assertEquals(100, printJob1.getPageNumber());

    }

    @Test(expected = NumberFormatException.class)
    public void testInvalidNumber() {
        PrintJobConvertor.getPrintJob(PaperSize.A4, "saf", "see", "sdf");
    }

}
