package utils;

import java.util.Set;

import org.openqa.selenium.WebDriver;

public class WindowManager {

	private WebDriver driver;
	private WebDriver.Navigation navigate;

	public WindowManager(WebDriver driver) {
		this.driver = driver;
		navigate = driver.navigate();
	}

	public void goBack() {
		navigate.back();
	}

	public void goForward() {
		navigate.forward();
	}

	public void refresh() {
		navigate.refresh();
	}

	public void goTo(String url) {
		navigate.to(url);
	}

	public void switchToTab(String tabTitle) {
		var windows = driver.getWindowHandles();
		System.out.println("Number of tabs: " + windows.size());
		System.out.println("Window Handles: ");
		windows.forEach(System.out::println);

		for (String handle : windows) {
			System.out.println("Switching to window: " + handle);
			driver.switchTo().window(handle);
			System.out.println("Title of current window: " + driver.getTitle());
			if (tabTitle.equalsIgnoreCase(driver.getTitle().trim())) {
				break;
			}
		}
	}

}
