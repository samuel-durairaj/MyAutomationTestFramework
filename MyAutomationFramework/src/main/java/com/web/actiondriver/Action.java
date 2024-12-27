/**
 * 
 */
package com.web.actiondriver;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.web.base.BaseClass;


/**
 * @author Samuel Durairaj added on 13th March2019
 *
 */

public class Action extends BaseClass {

	public static void scrollByVisibilityOfElement(WebDriver driver, WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollintoview();", ele);
	}
	
	public static void click(WebDriver driver, WebElement ele) {
		Actions act = new Actions(driver);
		act.moveToElement(ele).click().build().perform();
	}
	
	public static boolean findElement(WebDriver driver, WebElement ele) {
		boolean flag = false;
		try {
			ele.isDisplayed();
			flag = true;
		} catch (Exception e) {
			flag = false;
		}finally {
		if(flag) {
			System.out.println("Successfully found element at");
		}
		else {
			System.out.println("Unable to locate element at");
		  }
		}
		return flag;
	}
	
	public static boolean isDisplayed(WebDriver driver, WebElement ele) {
		boolean flag = false;
		flag = findElement(driver,ele);
		if(flag) {
			flag = ele.isDisplayed();
			if(flag) {
				System.out.println("The element is displayed");
			}else {
				System.out.println("The element is not displayed");
			}
		}else {
			System.out.println("Not displayed");
		}
		return flag;
	}
	
	public static boolean isSelected(WebDriver driver, WebElement ele) {
		boolean flag = false;
		flag = findElement(driver,ele);
		if(flag) {
			flag = ele.isSelected();
			if(flag) {
				System.out.println("The element is Selected");
			}else {
				System.out.println("The element is not Selected");
			}
		}else {
			System.out.println("Not selected");
		}
		return flag;
	}
	
	public static boolean isEnabled(WebDriver driver, WebElement ele) {
		boolean flag = false;
		flag = findElement(driver, ele);
		if(flag) {
			flag = ele.isEnabled();
			if(flag) {
				System.out.println("The element is Enabled");
			}else {
				System.out.println("The element is not Enabled");
			}
		}else {
			System.out.println("Not enabled");
		}
		return flag;
	}
	
	/**
	 * Type text at location
	 * 
	 * @param locatorName
	 * @param text
	 * @return - true/false
	 */
	
	public static boolean type(WebElement ele, String text) {
		boolean flag = false;
		try {
			flag = ele.isDisplayed();
			ele.clear();
			ele.sendKeys(text);
			flag = true;
		} catch (Exception e) {
			System.out.println("Location Not found");
			flag = false;
		}finally {
			if(flag) {
				System.out.println("Successfully entered value");
			}else {
				System.out.println("Unable to enter value");
			}
		}
		return flag;
	}
	
	public static boolean selectBySendKeys(WebElement ele, String value) {
		boolean flag = false;
		try {
			ele.sendKeys(value);
			flag = true;
			return true;
		} catch (Exception e) {
			return false;
		}finally {
			if(flag) {
				System.out.println("Select value from the Dropdown");
			}else {
				System.out.println("Not selected value from the Dropdown");
			}
		}
	}
	
	/**
	 * select value from DropDown by using selectByIndex
	 * 
	 * @param locator     : Action to be performed on element (Get it from Object
	 *                    repository)
	 * 
	 * @param index       : Index of value wish to select from dropdown list.
	 * 
	 * @param locatorName : Meaningful name to the element (Ex:Year Dropdown, items
	 *                    Listbox etc..)
	 * 
	 */
	
	public static boolean selectByIndex(WebElement ele, int index) {
		boolean flag = false;
		try {
			Select s = new Select(ele);
			s.selectByIndex(index);
			flag = true;
			return true;
		} catch (Exception e) {
			return false;
		}finally {
			if(flag) {
				System.out.println("Option selected by Index");
			}else {
				System.out.println("Option not selected by Index");
			}
		}
	}
	
	/**
	 * select value from DD by using value
	 * 
	 * @param locator     : Action to be performed on element (Get it from Object
	 *                    repository)
	 * 
	 * @param value       : Value wish to select from dropdown list.
	 * 
	 * @param locatorName : Meaningful name to the element (Ex:Year Dropdown, items
	 *                    Listbox etc..)
	 */
	
	public static boolean selectByValue(WebElement ele, String value) {
		boolean flag = false;
		try {
			Select s = new Select(ele);
			s.selectByValue(value);
			flag = true;
			return true;
		} catch (Exception e) {
			return false;
		}finally {
			if(flag) {
				System.out.println("Option selected by Value");
			}
			else {
				System.out.println("Option not selected by Value");
			}
		}
	}
	
	/**
	 * select value from DropDown by using selectByVisibleText
	 * 
	 * @param locator     : Action to be performed on element (Get it from Object
	 *                    repository)
	 * 
	 * @param visibletext : VisibleText wish to select from dropdown list.
	 * 
	 * @param locatorName : Meaningful name to the element (Ex:Year Dropdown, items
	 *                    Listbox etc..)
	 */
	
	public static boolean selectByVisibleText(WebElement ele, String visibleText) {
		boolean flag = false;
		try {
			Select s = new Select(ele);
			s.selectByVisibleText(visibleText);
			flag = true;
			return true;
		}catch(Exception e) {
			return false;
		}finally {
			if(flag) {
				System.out.println();
			}else {
			    System.out.println();	
			}
		}
	}
	
	public static boolean mouseHoverByJavaScript(WebElement ele) {
		boolean flag = false;
		try {
			WebElement mo = ele;
			String javascript = "var evObj = document.createEvent('MouseEvents');"
					+ "evObj.initMouseEvent(\"mouseover\",true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);"
					+ "arguments[0].dispatchEvent(evObj);";
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript(javascript, mo);
			flag = true;
			return true;
		} catch (Exception e) {
			return false;
		}finally {
			if(flag) {
				System.out.println("Mouse hover action is performed");
			}else {
				System.out.println("Mouse hover action is not performed");
			}
			
		}
	}
	
	public static boolean JSClick(WebElement ele, WebDriver driver) throws Exception {
		boolean flag = false;
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", ele);
			flag = true;
		} 
		finally {
			if(flag) {
				System.out.println("Click action is performed");
			}else {
				System.out.println("Click action is not performed");
			}
		}
		return flag;
	}
	
	public static boolean switchToFramByIndex(WebDriver driver, int index) {
		boolean flag = false;
		try {
			new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe")));
			flag = true;
			return true;
		} catch (Exception e) {
			return false;
		}finally {
			if(flag) {
				System.out.println("Frame with index \"" + index + "\" is selected");
			}else {
				System.out.println("Frame with index \"" + index + "\" is not selected");
			}
		}
	}
	

	/**
	 * This method switch the to frame using frame ID.
	 * 
	 * @param idValue : Frame ID wish to switch
	 * 
	 */
	
	public static boolean switchToFramByID(WebDriver driver, String idValue) {
		boolean flag = false;
		try {
		driver.switchTo().frame(idValue);
		flag = true;
		return true;
		}catch (Exception e){
			e.printStackTrace();
			return false;
		}finally {
			if(flag) {
				System.out.println("Frame with Id \"" + idValue + "\" is selected");
			}else {
				System.out.println("Frame with Id \"" + idValue + "\" is not selected");
			}
		}
	}
	
	/**
	 * This method switch the to frame using frame Name.
	 * 
	 * @param nameValue : Frame Name wish to switch
	 * 
	 */
	
	public static boolean switchToFrameByName(WebDriver driver, String nameValue) {
		boolean flag = false;
		try {
			driver.switchTo().frame(nameValue);
			flag = true;
			return true;
		} catch (Exception e) {
			return false;
		}finally {
			if (flag) {
				System.out.println("Frame with Name \"" + nameValue + "\" is selected");
			} else if (!flag) {
				System.out.println("Frame with Name \"" + nameValue + "\" is not selected");
			}
		}
	}
	
	public static boolean switchToDefaultFrame(WebDriver driver, WebElement ele) {
		boolean flag = false;
		try {
			driver.switchTo().defaultContent();
			flag = true;
			return true;
		} catch (Exception e) {
			return false;
		}finally {
			if(flag) {
				// SuccessReport("SelectFrame ","Frame with Name is selected");
			}else {
				// failureReport("SelectFrame ","The Frame is not selected");
			}
		}
	}
	
	public static void mouseOverElement(WebDriver driver, WebElement ele) {
		boolean flag = false;
		try {
			new Actions(driver).moveToElement(ele).build().perform();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(flag) {
				System.out.println(" MouserOver Action is performed on ");
			}else {
				System.out.println(" MouserOver Action is not performed on ");
			}
		}
	}
	
	public static boolean moveToElement(WebDriver driver, WebElement ele) {
		boolean flag = false;
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", ele);
			
			Actions action = new Actions(driver);
			action.moveToElement(ele).build().perform();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	public static boolean mouseover(WebDriver driver, WebElement ele) {
		boolean flag = false;
		try {
			new Actions(driver).moveToElement(ele).build().perform();
			flag = true;
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public static boolean draggable(WebDriver driver, WebElement source, int x, int y) {
		boolean flag = false;
		try {
			new Actions(driver).dragAndDropBy(source, x, y).build().perform();
			flag = true;
			return true;
		}catch (Exception e){
			return false;
		}finally {
			if (flag) {
				System.out.println("Draggable Action is performed on \""+source+"\"");			
			} else if(!flag) {
				System.out.println("Draggable action is not performed on \""+source+"\"");
			}
		}
	}
	
	public static boolean draganddrop(WebDriver driver, WebElement source, WebElement target) {
		boolean flag = false;
		try {
			new Actions(driver).dragAndDrop(source, target).build().perform();
			flag = true;
			return true;
		} catch (Exception e) {
			return false;
		}finally {
			if(flag) {
				System.out.println("Drag and Drop action is performed");
			}else {
				System.out.println("Drag and Drop action is not performed");
			}
		}
	}
	
	public static boolean slider(WebDriver driver, WebElement ele, int x, int y) {
		boolean flag = false;
		try {
			new Actions(driver).dragAndDropBy(ele, x, y).build().perform();
			Thread.sleep(5000);
			flag = true;
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally {
			if(flag) {
				System.out.println("Slider action is performed");
			}else {
				System.out.println("Slider action is not performed");
			}	
		}
	}
	
	public static boolean rightClick(WebDriver driver, WebElement ele) {
		boolean flag = false;
		try {
			Actions action = new Actions(driver);
			flag = true;
			return true;
		} catch (Exception e) {
			return false;
		}finally {
			if(flag) {
				System.out.println("Right Click action is performed");
			}else {
				System.out.println("Right Click action is not performed");
			}
		}
	}
	
	public static boolean switchWindowByTitle(WebDriver driver, String windowTitle, int count) {
		boolean flag = false;
		try {
			Set<String> windowList = driver.getWindowHandles();
			String[] array = windowList.toArray(new String[0]);
			driver.switchTo().window(array[count-1]);
			
			if(driver.getTitle().contains(windowTitle)) {
				return true;
			}else {
			    return false;	
			}
		} catch (Exception e) {
			return false;
		}finally {
			if(flag) {
				System.out.println("Navigated to the window with Title");
			}else {
				System.out.println("The Window with the title is not selected");
			}
		}
	}
	
	public static boolean switchToNewWindow(WebDriver driver) {
		boolean flag = false;
		try {
			Set<String> set = driver.getWindowHandles();
			Object[] popup = set.toArray();
			driver.switchTo().window(popup[1].toString());
			
			flag = true;
			return true;
		} catch (Exception e) {
			return false;
		}finally {
			if(flag) {
				System.out.println("Window is Navigated with title");
			}else {
				System.out.println("The Window with title: is not Selected");
			}
		}
	}
	
	public static boolean switchToOldWindow(WebDriver driver) {
		boolean flag = false;
		try {
			Set<String> set = driver.getWindowHandles();
			Object[] popup = set.toArray();
			driver.switchTo().window(popup[0].toString());
			
			flag = true;
			return true;
		} catch (Exception e) {
			return false;
		}finally {
			if(flag) {
			    System.out.println("Focus navigated to the window with title");	
			}else {
				System.out.println("The Window with title: is not Selected");
			}
		}
	}
	
	public static int getColumnCount(WebElement col) {
		List<WebElement> columns = col.findElements(By.tagName("td"));
		int colSize = columns.size();
		System.out.println(columns.size());
		
		for(WebElement column: columns) {
			System.out.print(column.getText());
			System.out.print("|");
		}
		return colSize;
	}
	
	public static int getRowCount(WebElement row) {
		List<WebElement> rows = row.findElements(By.tagName("tr"));
		int rowSize = rows.size()-1;
		return rowSize;
	}
	
	/**
	 * Verify alert present or not
	 * 
	 * @return: Boolean (True: If alert preset, False: If no alert)
	 * 
	 */
	
	public static boolean Alert(WebDriver driver) {
		boolean presentFlag = false;
		Alert alert = null;

		try {
			//Check the presence of alert
			alert = driver.switchTo().alert();
			//if present consume the alert
			alert.accept();
			presentFlag = true;
		} catch (NoAlertPresentException ex) {
			// Alert present; set the flag

			// Alert not present
			ex.printStackTrace();
		} finally {
			if (!presentFlag) {
				System.out.println("The Alert is handled successfully");		
			} else{
				System.out.println("There was no alert to handle");
			}
		}

		return presentFlag;
	}
	
	public static boolean launchUrl(WebDriver driver, String url) {
		boolean flag = false;
		try {
			driver.navigate().to(url);
			flag = true;
			return true;
		} catch (Exception e) {
			return false;
		}finally {
			if (flag) {
				System.out.println("Successfully launched \""+url+"\"");				
			} else {
				System.out.println("Failed to launch \""+url+"\"");
			}
		}
	}
	
	public static boolean isAlertPresent() {
		try {
			getDriver().switchTo().alert();
			return true;
		} catch (NoAlertPresentException Ex) {
			return false;
		}
	}
	
	public static String getTitle(WebDriver driver) {
		boolean flag = false;
		
		String text = driver.getTitle();
		if(flag) {
			System.out.println("Title of the page is: \""+text+"\"");
		}
		return text;
	}
	
	public static String getCurrentUrl(WebDriver driver) {
		boolean flag = false;
		
		String text = driver.getCurrentUrl();
		if(flag) {
			System.out.println("Current URL is: \""+text+"\"");
		}
		return text;
	}
	
	public static boolean click1(WebElement locator, String locatorName) {
		boolean flag = false;
		try {
			locator.click();
			flag = true;
			return true;
		} catch (Exception e) {
			return false;
		}finally {
			if (flag) {
				System.out.println("Able to click on \""+locatorName+"\"");
			} else {
				System.out.println("Click Unable to click on \""+locatorName+"\"");
			}
		}
	}
	
	public static void fluentWait(WebDriver driver, WebElement element, int timeOut) {
		Wait<WebDriver> wait = null;
		try {
			wait = new FluentWait<WebDriver>((WebDriver) driver)
					   .withTimeout(Duration.ofSeconds(20))
					   .pollingEvery(Duration.ofSeconds(2))
					   .ignoring(Exception.class);
			wait.until(ExpectedConditions.visibilityOf(element));
			element.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void implicitWait(WebDriver driver, int timeOut) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public static void explicitWait(WebDriver driver, WebElement element, Duration timeOut) {
		WebDriverWait wait = new WebDriverWait(driver,timeOut);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public static void pageLoadTimeOut(WebDriver driver, int timeOut) {
		driver.manage().timeouts().pageLoadTimeout(timeOut, TimeUnit.SECONDS);
	}
	
	public static String screenShot(WebDriver driver, String filename) {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot takesScreenshot = (TakesScreenshot)driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\ScreenShots\\" + filename + "_" + dateName + ".png";
		
		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}
		String newImageString = "http://localhost:8082/job/MyStoreProject/ws/MyStoreProject/ScreenShots/" + filename + "_"
				+ dateName + ".png";
		return newImageString;
	}
	
	public static String getCurrentTime() {
		String currentDate = new SimpleDateFormat("yyyy-MM-dd-hhmmss").format(new Date());
	    return currentDate;
	}
}
