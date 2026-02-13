package interfaces.defaultmethodsininterfaces.dataexportfeature;

public class CSVExporter implements ReportExporter {

	@Override
	public void export() {
		System.out.println("Exporting report to CSV");
	}
}
