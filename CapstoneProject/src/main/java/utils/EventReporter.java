package utils;

import java.lang.reflect.Method;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;

public class EventReporter implements WebDriverListener {

	public void afterAnyNavigationCall(WebDriver.Navigation navigation, Method method, Object[] args, Object result) {

		System.out.println("Navigation call: " + method.getName());
	}

	public void beforeAnyWebDriverCall(WebDriver driver, Method method, Object[] args) {
		System.out.println("Location: " + driver.getTitle());
		System.out.println("Test step: " + method.getName());
	}

	public void afterGetWindowHandles(WebDriver driver, Set<String> result) {

		System.out.println("Total number of active windows: " + result.size());
	}

	public void afterClick(WebElement element) {

		System.out.println("Clicked: " + element.getAccessibleName());
	}

	public void afterSendKeys(WebElement element, CharSequence... keysToSend) {

		System.out.println("Text: " + keysToSend.toString() + " set in element: " + element.getAccessibleName());
	}

	/*
	 * public void afterAccept(Alert alert) { System.out.println("Alert accepted.");
	 * }
	 * 
	 * public void afterDismiss(Alert alert) {
	 * 
	 * System.out.println("Alert Dismmised."); }
	 * 
	 * public void afterGetText(Alert alert, String result) {
	 * System.out.println("Alert Text: " + result);
	 * 
	 * }
	 */

	public void afterQuit(WebDriver driver) {
		System.out.println("Browser closed.");
	}

	public void afterTo(WebDriver.Navigation navigation, String url) {
		System.out.println("Navigating to: " + url);
	}

	public void afterAddCookie(WebDriver.Options options, Cookie cookie) {

		System.out.println("Cookie added: " + cookie.getName() + " Value: " + cookie.getValue());
	}

}
