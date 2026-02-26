package excelDriven;

import java.io.IOException;
import java.util.ArrayList;

public class testSample {

	public static void main(String[] args) throws IOException {

		ExcelDrivenCode excel = new ExcelDrivenCode();
		ArrayList data = excel.getData("Purchase");

		System.out.println(data.get(0));
		System.out.println(data.get(1));
		System.out.println(data.get(2));

		// driver.findElement(By.id("")).sendKeys(data.get(0)); same code for appium or
		// rest assured
	}

}
