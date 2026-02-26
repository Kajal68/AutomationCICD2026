package excelDriven;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UploadDownloadFile {

	public static void main(String[] args) {

		// WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\LENOVO\\Documents\\Drivers\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/upload-download-test/index.html");

		driver.findElement(By.cssSelector("#downloadButton")).click();
		WebElement upload = driver.findElement(By.cssSelector("input[type='file']"));
		upload.sendKeys("C:\\Users\\LENOVO\\Downloads\\download.xlsx");

		WebDriverWait wait = (WebDriverWait) driver;
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.cssSelector(".Toastify__toast-body div:nth-child(2)")));
		wait.until(ExpectedConditions
				.invisibilityOf(driver.findElement(By.cssSelector(".Toastify__toast-body div:nth-child(2)"))));

	}

}
