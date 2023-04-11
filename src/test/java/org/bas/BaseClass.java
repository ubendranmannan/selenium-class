package org.bas;
import java.io.File; 
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFAnchor;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	  public static  WebDriver driver;
	  
	public static void launchBrowser() {
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	}
	
	public static void windowMaximize() {
		driver.manage().window().maximize();
	}
public static void launchUrl(String url) {
	driver.get(url);
}
public static String pageTitle() {
	String title=driver.getTitle();
	System.out.println(title);
	return title;
}
public static String  pageUrl() {
	String url=driver.getCurrentUrl();
	System.out.println(url);
	return url;
}
public static void passText(String txt,WebElement ele) {
	ele.sendKeys(txt);
}
public static void closeEntireBrowser() {
	driver.quit();
}
public static void clickBtn(WebElement ele) {
	ele.click();
}
public static void screenShot(String imgName) throws IOException {
TakesScreenshot ts= (TakesScreenshot) driver;
File img=ts.getScreenshotAs(OutputType.FILE);
File f = new File("location + imgName.png");
FileUtils.copyFile(img, f);
}
public static Actions a;
public static void moveTheCursor(WebElement targetWebElement) {
	a= new Actions(driver);
    a.moveToElement(targetWebElement).perform();
}
public static void dragDrop(WebElement dragWebElement, WebElement dropWebElement) {
	a=new Actions(driver);
	a.dragAndDrop(dragWebElement, dropWebElement).perform();
}
public static JavascriptExecutor js;

public static void scrollThePage(WebElement tarWebEle) {
	js = (JavascriptExecutor)driver;
	js.executeScript("arguments[0].scrollIntroView(true)",tarWebEle );
}
public static void scroll(WebElement element){
	js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].scrollIntroView(false)", element);
}
public static void excelRead(String sheetName ,int rowNum ,int cellNum) throws IOException {
	File f = new File("excellocation.xlsx");
	FileInputStream fi = new FileInputStream(f);
	Workbook wb = new XSSFWorkbook(fi);
	Sheet mysheet =wb.getSheet("Data1");
	Row r =mysheet.getRow(rowNum);
	Cell cl=r.getCell(cellNum);
    int celltype=cl.getCellType();
	
	String value =" ";
	if (celltype == 1) {
		String value2 =cl.getStringCellValue();
		System.out.println(value2);
	}
	   
	else if (DateUtil.isCellDateFormatted(cl)) {
		java.util.Date dd = cl.getDateCellValue();
		  SimpleDateFormat sd = new SimpleDateFormat();
		  String  value1  =sd.format(dd);
		  System.out.println(value1);
	}	
	
	else {
		double d=cl.getNumericCellValue();
		long l=  (long) d;
		String valueof =String.valueOf(l);
		System.out.println(valueof);
	}
}
public static void createNewExcelFile(int rowNum,int cellNum,String writeData) throws IOException {
	File f = new File("C:\\Users\\this pc\\eclipse-workspace\\FrameWork\\Excel\\excellocation.xlsx");
	Workbook wb = new XSSFWorkbook();
	Sheet mysheet =wb.createSheet("Data1");
	Row r =mysheet.createRow(rowNum);
	Cell cl=r.createCell(cellNum);
    cl.setCellValue(writeData);
    FileOutputStream fs = new  FileOutputStream(f);
    wb.write(fs);
}
public static void createCell(int getRow, int creCell,String newData) throws IOException {
	File f = new File("C:\\Users\\this pc\\eclipse-workspace\\FrameWork\\Excel\\excellocation.xlsx");
	FileInputStream fi = new FileInputStream(f);
	Workbook wb = new XSSFWorkbook(fi);
	Sheet mysheet =wb.getSheet("Data1");
	Row r =mysheet.getRow(getRow);
	Cell cl=r.createCell(creCell);
    cl.setCellValue(newData);
   FileOutputStream fs = new  FileOutputStream(f);
   wb.write(fs);
}
	public static void createRow(int creRow,int creCell,String newData) throws IOException {
		File f = new File("C:\\Users\\this pc\\eclipse-workspace\\FrameWork\\Excel\\excellocation.xlsx");
		FileInputStream fi = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fi);
		Sheet mysheet =wb.getSheet("Data1");
		Row r =mysheet.createRow(creRow);
		Cell cl=r.createCell(creCell);
	   cl.setCellValue(newData);
	   FileOutputStream fs = new  FileOutputStream(f);
	   wb.write(fs);
}
public static void updateDataToParticulerCell(int getTheRow,int getTheCell, String exisitingData,String writeNewData) throws IOException {
	File f = new File("excellocation.xlsx");
	FileInputStream fi = new FileInputStream(f);
	Workbook wb = new XSSFWorkbook(fi);
	Sheet mysheet =wb.getSheet("Data1");
	Row r =mysheet.getRow(getTheRow);
	Cell cl=r.getCell(getTheCell);
	String st=cl.getStringCellValue();
	if (st.equals(exisitingData)) {
			cl.setCellValue(writeNewData);
	}
   FileOutputStream fs = new  FileOutputStream(f);
   wb.write(fs);
}	

}
















































