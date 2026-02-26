package excelDriven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {

	@Test
	public void getDataProvider(String Greetings, String Communication, int ID) {

	}

	@DataProvider
	public Object[][] getData() throws FileNotFoundException {

		Object[][] data = { { "", "", "" }, { "", "", "" }, { "", "", "" } };
		FileInputStream fis = new FileInputStream("C:\\Users\\LENOVO\\DataPro.xlsx");
		return data;

	}

}
