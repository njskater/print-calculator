package demo.jerry.printcalculator.model;

/**
 * Immutable POJO to represent print job.
 * @author jzhang
 *
 */
public class PrintJob {
    private final PrintCategory printCategory;
    private final int pageNumber;

    public PrintJob(PrintCategory printcategory, int pageNumber) {
        if (printcategory == null) {
            throw new IllegalArgumentException("print category must be provided");
        }

        if (pageNumber < 0) {
            throw new IllegalArgumentException("page number must be greater than 0");
        }

        this.printCategory = printcategory;
        this.pageNumber = pageNumber;
    }

    public PrintCategory getPrintCategory() {
        return printCategory;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    @Override
    public String toString() {
        return "PrintJob [printCategory=" + printCategory + ", pageNumber=" + pageNumber + "]";
    }



}
