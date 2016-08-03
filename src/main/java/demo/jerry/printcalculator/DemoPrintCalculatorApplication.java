package demo.jerry.printcalculator;

import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import demo.jerry.printcalculator.input.PrintJobReader;
import demo.jerry.printcalculator.input.PrintListCSVReader;
import demo.jerry.printcalculator.model.PrintCategory;
import demo.jerry.printcalculator.model.PrintCost;
import demo.jerry.printcalculator.model.PrintJob;
import demo.jerry.printcalculator.model.PrintPriceTable;
import demo.jerry.printcalculator.output.PrintCostOutputWriter;
import demo.jerry.printcalculator.output.PrintCostPrintStreamWriter;
import demo.jerry.printcalculator.service.BulkPrintCostCalculator;
import demo.jerry.printcalculator.service.FixedPricePrintCalculator;
import demo.jerry.printcalculator.service.PrintCalculator;
import demo.jerry.printcalculator.service.SimpleBulkPrintCostCalculator;

/**
 * A Demo print calculator application. This class is responsible for setup and configure required components. In real world, this part is handled by Dependency
 * Injection framework.
 * @author jzhang
 */
public class DemoPrintCalculatorApplication {

    private static final Log LOGGER = LogFactory.getLog(DemoPrintCalculatorApplication.class);

    private final BulkPrintCostCalculator controller;
    private final PrintJobReader reader;
    private final PrintCostOutputWriter writer;

    public static void main(String[] args) {
        if (args.length <= 0 || StringUtils.isBlank(args[0])) {
            LOGGER.error("File name need to be provided as parameter");
            return;
        }

        new DemoPrintCalculatorApplication().execute(args[0]);
    }

    /**
     * Default constructor with necessary default configuration.
     */
    public DemoPrintCalculatorApplication() {
        // Initialize required components
        final PrintPriceTable printPriceTable = configPriceTable();
        final PrintCalculator calculator = new FixedPricePrintCalculator(printPriceTable);

        controller = new SimpleBulkPrintCostCalculator(calculator);
        reader = new PrintListCSVReader();
        writer = new PrintCostPrintStreamWriter(System.out);
    }

    /**
     * This method execute main demo process that read from a CSV file and print out cost of printing.
     * @param fileName
     */
    public void execute(String fileName) {
        try {
            final List<PrintJob> input = reader.read(new FileReader(fileName));
            final List<PrintCost> calcResult = controller.calculateAllJobs(input);
            writer.outputPrintCost(calcResult);
        } catch (final IOException e) {
            LOGGER.error("File can not be read:" + fileName, e);
        }
    }

    /**
     * Configure price for all printing job type. This can be easily refactored to be more configurable. For demo purpose, we simply add required prices.
     * @return
     */
    private PrintPriceTable configPriceTable() {
        final PrintPriceTable priceTable = new PrintPriceTable();
        priceTable.addUnitPrice(PrintCategory.a4BlackWhiteSingleSided(), new BigDecimal("0.15"));
        priceTable.addUnitPrice(PrintCategory.a4BlackWhiteDoubleSided(), new BigDecimal("0.10"));
        priceTable.addUnitPrice(PrintCategory.a4ColourSingleSided(), new BigDecimal("0.25"));
        priceTable.addUnitPrice(PrintCategory.a4ColourDoubleSided(), new BigDecimal("0.20"));
        return priceTable;
    }

}
