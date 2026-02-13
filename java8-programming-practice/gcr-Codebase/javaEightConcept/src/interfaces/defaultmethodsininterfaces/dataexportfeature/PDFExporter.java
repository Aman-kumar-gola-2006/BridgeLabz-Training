package interfaces.defaultmethodsininterfaces.dataexportfeature;

public class PDFExporter implements ReportExporter {

    @Override
    public void export() {
        System.out.println("Exporting report to PDF");
    }
}