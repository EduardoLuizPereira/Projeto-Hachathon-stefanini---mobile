package utils;

import static utils.Utils.driver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import io.cucumber.core.api.Scenario;

public class Utils {

	public static AppiumDriver<WebElement> driver;

	public static void acessarApp() throws MalformedURLException, InterruptedException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("deviceName", "RQ8NB04EF2H");
		desiredCapabilities.setCapability("automationName", "uiautomator2");
		desiredCapabilities.setCapability("appPackage", "notizen.basic.notes.notas.note.notepad");
		desiredCapabilities.setCapability("appActivity", "notizen.basic.notes.notas.note.notepad.main.SplashActivity");
		desiredCapabilities.setCapability("autoGrantPermissions", true);
		URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AndroidDriver(remoteUrl, desiredCapabilities);
	}

	public static File gerarScreenShot(Scenario cenario) {
		final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		cenario.embed(screenshot, "image/png");
		File imagem = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {

			FileUtils.copyFile(imagem,
					(new File("./target/screenshots", cenario.getName() + "-" + cenario.getStatus() + ".png")));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return imagem;

	}

	public static void inputTextAppiumCommand(MobileElement elemento, String keyeventCommand) {

		elemento.click();

		List<String> argsCommandKeyevent = Arrays.asList("text", transformarNome(keyeventCommand));
		Map<String, Object> commandKeyevent = ImmutableMap.of("command", "input", "args", argsCommandKeyevent);

		String output = (String) driver.executeScript("mobile: shell", commandKeyevent);

		System.out.println(output);

	}

	public static String transformarNome(String texto) {
		String[] lista = texto.split(" ");

		String stringModificada = "";

		for (String palavra : lista) {
			stringModificada += palavra + "%s";

		}

		if (stringModificada.length() > 0) {
			stringModificada = stringModificada.substring(0, stringModificada.length() - 2);
		}

		return stringModificada;

	}

	public static void dragAndDropDown(MobileElement src) {

		TouchAction action = new TouchAction(driver);
		action.press(new PointOption().point(src.getLocation().getX(), src.getLocation().getY()))
				.waitAction(new WaitOptions().withDuration(Duration.ofSeconds(1)))
				.moveTo(new PointOption().point(src.getLocation().getX(), 1000)).release();

		MultiTouchAction multiAction = new MultiTouchAction(driver);
		multiAction.add(action).perform();
	}
	
	public static void dragAndDropUp(MobileElement src) {

		TouchAction action = new TouchAction(driver);
		action.press(new PointOption().point(src.getLocation().getX(), src.getLocation().getY()))
				.waitAction(new WaitOptions().withDuration(Duration.ofSeconds(1)))
				.moveTo(new PointOption().point(src.getLocation().getX(), 0)).release();

		MultiTouchAction multiAction = new MultiTouchAction(driver);
		multiAction.add(action).perform();
	}

	public static void dragAndHoldDoing(MobileElement src) {
		TouchAction action = new TouchAction(driver);
		action.longPress(new LongPressOptions().withElement(new ElementOption().withElement(src))).perform();
		action.press(new PointOption().point(src.getLocation().getX(), src.getLocation().getY()))
				.waitAction(new WaitOptions().withDuration(Duration.ofSeconds(1)))
				.moveTo(new PointOption().point(src.getLocation().getX(), 0)).release();

		MultiTouchAction multiAction = new MultiTouchAction(driver);
		multiAction.add(action).perform();
	}

}
