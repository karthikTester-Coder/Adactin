package org.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Driver;
import java.text.SimpleDateFormat;

import org.apache.commons.io.FileUtils;
import org.global.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TestScript extends BaseClass{
	public static void main(String[] args) throws IOException, InterruptedException {
		BaseClass base=new BaseClass();
		base.getDriver(base.readExcel(0, 1));
		base.LaunchUrl(base.readExcel(1, 1));
		base.winMax();
		WebElement username = driver.findElement(By.xpath("//input[@id='username']"));
		base.sendKeysByJava(username, base.readExcel(2, 1));
		WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
		base.sendKeysByJava(password, base.readExcel(3, 1));
		WebElement click = driver.findElement(By.xpath("//input[@id='login']"));
		base.clickByJS(click);
		base.screenCapture();
		WebElement searchhotel = driver.findElement(By.xpath("//td[@class='login_title']"));
		String text = searchhotel.getText();
		System.out.println("USER ENTERED LOGGED IN ");
		WebElement location = driver.findElement(By.xpath("//select[@id='location']"));
		base.selectByText(location, "New York");
		WebElement hotel = driver.findElement(By.xpath("//select[@id='hotels']"));
		base.selectByvalue(hotel,"Hotel Creek");
		WebElement RoomType = driver.findElement(By.xpath("//select[@id='room_type']"));
		base.selectByText(RoomType, "Super Deluxe");
		WebElement Noofroom = driver.findElement(By.xpath("//select[@id='room_nos']"));
		base.selectByText(Noofroom, "9 - Nine");
		WebElement Checkindate
              = driver.findElement(By.id("datepick_in"));
		base.sendKeysByJava(Checkindate,base.readExcel(4, 1));
		WebElement Checkout = driver.findElement(By.xpath("//input[@id='datepick_out']"));
		base.sendKeysByJava(Checkout, base.readExcel(5, 1));
		WebElement AdultRoom = driver.findElement(By.xpath("//select[@id='adult_room']"));
		base.selectByText(AdultRoom, "2 - Two");
		WebElement ChildRoom = driver.findElement(By.xpath("//select[@id='child_room']"));
		base.selectByText(ChildRoom, "3 - Three");
		WebElement submit = driver.findElement(By.xpath("//input[@id='Submit']"));
		base.clickByJava(submit);
		WebElement radiobutton = driver.findElement(By.id("radiobutton_0"));
		base.clickByJava(radiobutton);
		WebElement continouebutton = driver.findElement(By.id("continue"));
		base.clickByJava(continouebutton);
		base.sleep(5000);
		WebElement firstname = driver.findElement(By.id("first_name"));
		base.sendKeysByJava(firstname, base.readExcel(6, 1));
		WebElement lastName = driver.findElement(By.id("last_name"));
		base.sendKeysByJava(lastName, base.readExcel(7, 1));
		WebElement address = driver.findElement(By.id("address"));
		base.sendKeysByJava(address, base.readExcel(8, 1));
		WebElement ccNum = driver.findElement(By.id("cc_num"));
		base.sendKeysByJava(ccNum, base.readExcel(9, 1));
		WebElement ccType = driver.findElement(By.id("cc_type"));
		base.selectByText(ccType, "Master Card");
		WebElement ccExpMonth = driver.findElement(By.id("cc_exp_month"));
		base.selectByText(ccExpMonth, "July");
		WebElement ccExpYear = driver.findElement(By.id("cc_exp_year"));
		base.selectByText(ccExpYear, "2029");
		WebElement cvvNum = driver.findElement(By.id("cc_cvv"));
		base.sendKeysByJava(cvvNum, base.readExcel(13, 1));
		WebElement bookNow = driver.findElement(By.id("book_now"));
		base.clickByJava(bookNow);
		base.sleep(5000);
		System.out.println("USER BOOKED HOTEL");
		WebElement myItinerary = driver.findElement(By.id("my_itinerary"));
		base.clickByJava(myItinerary);
		//base.screenCapture();
		WebElement allselectbutton = driver.findElement(By.xpath("//input[@name='check_all']"));
		base.clickByJava(allselectbutton);
		WebElement cancelall = driver.findElement(By.xpath("//input[@name='cancelall']"));
		base.clickByJava(cancelall);
		base.handleAlert();
		System.out.println("USER CANCELLED ROOMS");
		//base.screenCapture();
		WebElement logoutButton = driver.findElement(By.xpath("//a[@href='Logout.php']"));
		base.clickByJava(logoutButton);
		System.out.println("USER SUCESSFULLY LOGOUT PAGE");
		//base.screenCapture();
		WebElement againLogin = driver.findElement(By.xpath("//a[@href='index.php']"));
		base.clickByJava(againLogin);
		System.out.println("USER AGAIN ENTERED LOGIN PAGE");
		//base.screenCapture();
		
		
		
		
		
		
	}

}
