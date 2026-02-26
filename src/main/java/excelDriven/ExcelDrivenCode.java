package excelDriven;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDrivenCode {

	public static void main(String[] args) throws IOException {

	}

	public ArrayList<String> getData(String testcasename) throws IOException {

		FileInputStream fis = new FileInputStream("C:\\Users\\LENOVO\\Documents\\ExcelWorkBoook.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		int sheets = workbook.getNumberOfSheets();

		ArrayList<String> arr = new ArrayList<String>();

		for (int i = 0; i < sheets; i++) {
			if (workbook.getSheetName(i).equalsIgnoreCase("testData")) {
				// identify test cases column by scanning the entire 1st row

				XSSFSheet sheet = workbook.getSheetAt(i);
				Iterator<Row> rows = sheet.iterator(); // sheet is the collections of rows
				Row firstrow = rows.next();
				Iterator<Cell> cell = firstrow.cellIterator(); // row is collections of rows
				int k = 0;
				int column = 0;
				while (cell.hasNext()) {

					Cell value = cell.next();
					if (value.getStringCellValue().equalsIgnoreCase("TestCases")) {
						column = k;
					}
					k++;
				}
				System.out.println(column);

				while (rows.hasNext()) {
					Row r = rows.next();
					if (r.getCell(column).getStringCellValue().equalsIgnoreCase(testcasename)) {

						Iterator<Cell> cv = r.iterator();
						while (cv.hasNext()) {
							Cell cel = cv.next();
							if (cel.getCellType() == CellType.STRING) {
								arr.add(cel.getStringCellValue());
							} else {
								arr.add(NumberToTextConverter.toText(cel.getNumericCellValue()));
							}

						}

					}
				}
			}
		}
		return arr;
	}

}
