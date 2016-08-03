package demo.jerry.printcalculator.output;

import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import demo.jerry.printcalculator.model.PrintCategory;
import demo.jerry.printcalculator.model.PrintCost;
import demo.jerry.printcalculator.model.PrintJob;
import static org.junit.Assert.assertEquals;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * PrintCostPrintStreamWriter unit test.
 * @author jzhang
 */
public class PrintCostPrintStreamWriterTest {
    private PrintCostPrintStreamWriter writer;

    @Mock
    private PrintStream printStream;

    @Captor
    private ArgumentCaptor<String> stringCaptor;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        writer = new PrintCostPrintStreamWriter(printStream);
    }

    @Test
    public void testOutput() {
        final List<PrintCost> testPrintCosts = new ArrayList<>();

        final PrintJob printJob = new PrintJob(PrintCategory.a4BlackWhiteDoubleSided(), 10);
        final PrintCost printCost1 = new PrintCost(printJob, new BigDecimal("1.5"), new BigDecimal("0.15"));
        testPrintCosts.add(printCost1);

        final PrintCost printCost2 = new PrintCost(printJob, new BigDecimal("3.0"), new BigDecimal("0.30"));
        testPrintCosts.add(printCost2);

        writer.outputPrintCost(testPrintCosts);

        verify(printStream, times(3)).println(stringCaptor.capture());

        final String expectedString = " job: [paperSize=A4, colorPrint=false, doubleSided=true] page "
                + "number:10 unit price:0.15 job cost:1.5";
        assertEquals(expectedString, stringCaptor.getAllValues().get(0));

        final String expectedString2 = " job: [paperSize=A4, colorPrint=false, doubleSided=true] page "
                + "number:10 unit price:0.30 job cost:3.0";
        assertEquals(expectedString2, stringCaptor.getAllValues().get(1));

        final String expectedSummaryString = "total amount:4.5";
        assertEquals(expectedSummaryString, stringCaptor.getAllValues().get(2));

    }

}
