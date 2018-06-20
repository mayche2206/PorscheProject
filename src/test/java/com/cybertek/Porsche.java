package com.cybertek;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Porsche {
	

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.porsche.com/usa/modelstart/");
		driver.findElement(By.className("b-teaser-link")).click();
		driver.findElement(By.xpath("//*[@id=\"m982120\"]/div[2]/div/a")).click();
		String str1 = driver.findElement(By.className("m-14-model-price")).getText();
		System.out.println(str1);
		Thread.sleep(2000);
		String winHandleBefore = driver.getWindowHandle();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		String str2 = driver.findElement(By.xpath("//*[@id=\"s_price\"]/div[1]/div[1]/div[2]")).getText();
		System.out.println("6");
		PorscheMethod.comparePrices(str1, str2);
		System.out.println("7");
		String str3 = driver.findElement(By.xpath("//*[@id=\"s_price\"]/div[1]/div[2]/div[2]")).getText();
		PorscheMethod.comparePrices(str3, "0");
		String base = driver.findElement(By.xpath("//*[@id=\"s_price\"]/div[1]/div[1]/div[2]")).getText();
		String del = driver.findElement(By.xpath("//*[@id=\"s_price\"]/div[1]/div[3]/div[2]")).getText();
		String total1 = driver.findElement(By.xpath("//*[@id=\"s_price\"]/div[1]/div[4]/div[2]")).getText();
		System.out.println("8");
		String BaseDel = PorscheMethod.add(del, base);
		PorscheMethod.comparePrices(total1, BaseDel);
		driver.findElement(By.xpath("//*[@id=\"s_exterieur_x_FJ5\"]/span")).click();
		String color = driver.findElement(By.xpath("//*[@id=\"s_price\"]/div[1]/div[2]/div[2]")).getText();
		String equip1 = driver.findElement(By.xpath("//*[@id=\"s_exterieur_x_IAF\"]/div[2]/div[1]/div/div[2]")).getText();
		System.out.println("10");
		PorscheMethod.comparePrices(color, equip1);
		String BaseDelEquip = PorscheMethod.add(BaseDel, color);
		String total2 = driver.findElement(By.xpath("//*[@id=\"s_price\"]/div[1]/div[4]/div[2]")).getText();
		System.out.println("11");
		PorscheMethod.comparePrices(total2, BaseDelEquip);
		driver.findElement(By.xpath("//*[@id=\"s_exterieur_x_MXRD\"]/span/span")).click();
		String equip2 = driver.findElement(By.xpath("//*[@id=\"s_price\"]/div[1]/div[2]/div[2]")).getText();
		String wheel = driver.findElement(By.xpath("//*[@id=\"s_exterieur_x_IRA\"]/div[2]/div[1]/div/div[2]")).getText();
		String ColorWheel = PorscheMethod.add(color, wheel);
		System.out.println("13");
		PorscheMethod.comparePrices(equip2, ColorWheel);
		System.out.println("14");
		String total3 = driver.findElement(By.xpath("//*[@id=\"s_price\"]/div[1]/div[4]/div[2]")).getText();
		String equip3 = driver.findElement(By.xpath("//*[@id=\"s_price\"]/div[1]/div[2]/div[2]")).getText();
		String BaseDelEquip3 = PorscheMethod.add(BaseDel, equip3);
		PorscheMethod.comparePrices(total3, BaseDelEquip3);

		JavascriptExecutor ex = (JavascriptExecutor) driver;
		ex.executeScript("arguments[0].click()", driver.findElement(By.id("s_interieur_x_73_x_PP06_x_shorttext")));
		String seat = driver.findElement(By.xpath("//*[@id=\"seats_73\"]/div[2]/div[1]/div[3]/div")).getText();

		String ColorSeat = PorscheMethod.add(color, seat);
		String ColorSeatWheel = PorscheMethod.add(ColorSeat, wheel);
		String equip4 = driver.findElement(By.xpath("//*[@id=\"s_price\"]/div[1]/div[2]/div[2]")).getText();
		System.out.println("16");
		PorscheMethod.comparePrices(equip4, ColorSeatWheel);
		String total4 = driver.findElement(By.xpath("//*[@id=\"s_price\"]/div[1]/div[4]/div[2]")).getText();
		String BaseDelEquip4 = PorscheMethod.add(BaseDel, equip4);
		System.out.println("17");
		PorscheMethod.comparePrices(total4, BaseDelEquip4);
		ex.executeScript("arguments[0].click()", driver.findElement(By.id("IIC_subHdl")));
		ex.executeScript("arguments[0].click()", driver.findElement(By.id("vs_table_IIC_x_PEKH_x_c01_PEKH")));
		String Fib = driver.findElement(By.xpath("//*[@id=\"vs_table_IIC_x_PEKH\"]/div[1]/div[2]/div")).getText();
		String equip5 = driver.findElement(By.xpath("//*[@id=\"s_price\"]/div[1]/div[2]/div[2]")).getText();
		String ColSeatWheelFib = PorscheMethod.add(ColorSeatWheel, Fib);
		System.out.println("20");
		PorscheMethod.comparePrices(equip5, ColSeatWheelFib);
		String total5 = driver.findElement(By.xpath("//*[@id=\"s_price\"]/div[1]/div[4]/div[2]")).getText();
		String BaseDelEquip5 = PorscheMethod.add(BaseDel, equip5);
		System.out.println("21");
		PorscheMethod.comparePrices(total5, BaseDelEquip5);
		ex.executeScript("arguments[0].click()", driver.findElement(By.id("IMG_subHdl")));
		ex.executeScript("arguments[0].click()", driver.findElement(By.id("vs_table_IMG_x_M250_x_c11_M250")));
		ex.executeScript("arguments[0].click()", driver.findElement(By.id("vs_table_IMG_x_M450_x_c91_M450")));
		String Speed = driver.findElement(By.xpath("//*[@id=\"vs_table_IMG_x_M250\"]/div[1]/div[2]/div")).getText();
		String Brakes = driver.findElement(By.xpath("//*[@id=\"vs_table_IMG_x_M450\"]/div[1]/div[2]/div")).getText();
		String SpeedBrakes = PorscheMethod.add(Speed, Brakes);
		String equip6 = driver.findElement(By.xpath("//*[@id=\"s_price\"]/div[1]/div[2]/div[2]")).getText();
		String ColSeatWheelFibSpeedBrakes = PorscheMethod.add(ColSeatWheelFib, SpeedBrakes);
		System.out.println("25");
		PorscheMethod.comparePrices(equip6, ColSeatWheelFibSpeedBrakes);
		String total6 = driver.findElement(By.xpath("//*[@id=\"s_price\"]/div[1]/div[4]/div[2]")).getText();
		System.out.println("26");
		String BaseDelEquip6 = PorscheMethod.add(BaseDel, equip6);
		PorscheMethod.comparePrices(total6, BaseDelEquip6);

	}
}
