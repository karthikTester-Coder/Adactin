package org.global;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseClass {
	long maxWaitTime =10;
	WebDriverWait wait=null;
	public static WebDriver driver;
	public static JavascriptExecutor javascriptExecutor;
	public static TakesScreenshot takesScreenshot;
	public static Select select;
	
	public void setUp() {
		wait =new WebDriverWait(driver,maxWaitTime);
		
	}
	
	public static void getDriver(String BrowserType) {
		switch (BrowserType) {
		case "Chrome":
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			
			break;
		case"edge":
			WebDriverManager.chromedriver().setup();
			driver=new EdgeDriver();
			break;

		default:
			System.out.println("Invalid_BrowserType");
			break;
		}}
		
	public void handleAlert() {
		Alert base = driver.switchTo().alert();
		base.accept();
		
		
		
		
	}
	
		public void winMax() {
			driver.manage().window().maximize();
			
		}
		public void LaunchUrl(String BrowserUrl) {
			driver.get(BrowserUrl);

		}
		public void sendKeysByJava(WebElement element,String KeysTosend) {
			element.sendKeys(KeysTosend);
			

		}
		public void sendKeysJS(WebElement element,String KeysTosend) {
			javascriptExecutor =(JavascriptExecutor)driver;
			javascriptExecutor.executeScript("arguments[0].setAttribute('value',"+KeysTosend+")", element);
			

		}
		public void clickByJS(WebElement element) {
			javascriptExecutor =(JavascriptExecutor)driver;
			javascriptExecutor.executeScript("arguments[0].click()", element);
			
			

		}
        public void clickByJava(WebElement element) {
        	element.click();
			

		}
        public void screenCapture() throws IOException {
        	takesScreenshot =(TakesScreenshot)driver;
        	File frstsrc =takesScreenshot.getScreenshotAs(OutputType.FILE);
        	File dest =new File("C:\\Users\\SANKAR\\eclipse-workspace\\AdactinHot.\\ErrorImg\\img.png");
        	FileUtils.copyFile(frstsrc, dest);
        	
        	
			

		}
        public void selectByvalue(WebElement element,String value) {
        	select=new Select(element);
        	select.selectByValue(value);
        	
			

		}
        public void selectByText(WebElement element,String text) {
        	select =new Select(element);
        	select.selectByVisibleText(text);
			

		}
        
        
        
        public void sleep(long millis) throws InterruptedException {
        	Thread.sleep(millis);
			

		}
        public  String readExcel(int rownum,int cellnum) throws IOException {
        	File file=new File("C:\\Users\\SANKAR\\AdaData\\data.xlsx");
        	FileInputStream fileInputStream=new FileInputStream(file);
        	Workbook workbook =new XSSFWorkbook(fileInputStream);
        	Sheet sheet = workbook.getSheet("Sheet1");
        	Row row = sheet.getRow(rownum);
        	Cell cell = row.getCell(cellnum);
        	CellType cellType = cell.getCellType();
        	String value=null;
        	switch(cellType) {
        	case STRING:
        		value = cell.getStringCellValue();
        		break;
        	case NUMERIC:
        		if(DateUtil.isCellDateFormatted(cell)){
        			Date dateCellValue = cell.getDateCellValue();
        			SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd/MM/yyyy");
        			value = simpleDateFormat.format(dateCellValue);
        			
        		}
        		else {
        			double numericCellValue = cell.getNumericCellValue();
        			BigDecimal valueOf = BigDecimal.valueOf(numericCellValue);
        			value = valueOf.toString();
        		}
        		break;
        		default:
        			
			
		}
        	return value;
	}

}
