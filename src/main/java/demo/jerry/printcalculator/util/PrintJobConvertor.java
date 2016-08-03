package demo.jerry.printcalculator.util;

import java.util.ArrayList;
import java.util.List;

import demo.jerry.printcalculator.model.PaperSize;
import demo.jerry.printcalculator.model.PrintCategory;
import demo.jerry.printcalculator.model.PrintJob;

/**
 * A utility class to convert String values to PrintJob records.
 * @author jzhang
 */
public class PrintJobConvertor {

    /**
     * Get black and white or colour print job from string parameters.
     * @param paperSize paper size of printing job
     * @param totalPageNum number of total page of printing job.
     * @param colourPageNum number of color page of print job. In case this number is more than total page number, we assume total page number is colourPageNum.
     * @param doubleSided a flag to indicate whether the job is double sided job.
     * @return print jobs constructed from parameters. If page number is 0 then job is not added.
     */
    public static List<PrintJob> getPrintJob(PaperSize paperSize, String totalPageNum, String colourPageNum, String doubleSided) {
        final int colourPageNumber = Integer.parseInt(colourPageNum);
        final int totalPageNumber = Integer.parseInt(totalPageNum);
        final int bwPageNumber = totalPageNumber >= colourPageNumber ? totalPageNumber - colourPageNumber : 0;
        final boolean doubleSidedBool = Boolean.parseBoolean(doubleSided);

        final List<PrintJob> result = new ArrayList<>();
        addPrintJob(paperSize, false, bwPageNumber, doubleSidedBool, result);
        addPrintJob(paperSize, true, colourPageNumber, doubleSidedBool, result);

        return result;
    }

    private static void addPrintJob(PaperSize paperSize, boolean colourPrint, final int pageNum,
            final boolean doubleSided, final List<PrintJob> result) {
        if (pageNum > 0) {
            result.add(new PrintJob(new PrintCategory(paperSize, colourPrint, doubleSided), pageNum));
        }
    }
}
