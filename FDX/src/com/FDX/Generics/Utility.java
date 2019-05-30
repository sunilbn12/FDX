package com.FDX.Generics;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

public class Utility {
	
	/******************************************************
	 * Returns the used rows in the sheet 
	 * @author NADSunil
	 * @exception IOException
	 * @param path
	 * @param sheet
	 * @return
	 ********************/
	public static int getRowCount(String path,String sheet)
	{
		int row=0;
		try{
			Workbook wb=WorkbookFactory.create(new FileInputStream(path));
			row=wb.getSheet(sheet).getLastRowNum();
		}
		catch(Exception e)
		{
			Reporter.log("Please check the path",true);
		}
		return row;
	}
	
	/******************************************************************************
	 * return the cell value;
	 * @author NADSunil
	 * @param path
	 * @param sheet
	 * @param row
	 * @param column
	 * @return String 
	 */
	static public String readExcelValue(String path,String sheet,int row,int column)
	{
		String value="";
		try{
			Workbook wb=WorkbookFactory.create(new FileInputStream(path));
			value=wb.getSheet(sheet).getRow(row).getCell(column).toString().trim();
		}
		catch(Exception e)
		{
			
		}
		return value;
	}

	/********************************************************************************
	 * 
	 * @return
	 *********************************************************************************/
	
	static String date()
	{
		String TimeStamp="";
		SimpleDateFormat s=new SimpleDateFormat("mm_HH_ss_MM_DD_YY");
		TimeStamp=s.format(new Date());
		
		return TimeStamp;
	}
	
	/********************************************************************************
	 * 
	 * @param driver
	 * @param path
	 *********************************************************************************/
	static public void getScreenPrint(WebDriver driver,String path)
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		try{
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dest=new File(path+""+date());
		FileUtils.copyFile(src, dest);
		}
		catch(Exception e)
		{
			
		}
	}
	
	
	/**************************************************************************************
	 * 
	 * @param path
	 **************************************************************************************/
	public static void getScreenPrint(String path)
	{
		try{
			Robot robot=new Robot();
			Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
			BufferedImage image=robot.createScreenCapture(new Rectangle(d));
			ImageIO.write(image, "png", new File(path));
		}
		catch(Exception e)
		{
			
		}
	}
	
	/***************************************************************************************
	 * 
	 */
	
	static public String readProperties(String path,String key)
	{
		String value="";
	
		
		Properties p=new Properties();
		try{
		p.load(new FileInputStream(path));
		value=p.getProperty(key);
		}
		catch(Exception e)
		{
			
		}
		
		return value;
	}

}
