//package init;
//
//import org.openqa.selenium.remote.RemoteWebDriver;
//
//
//public class SeleniumSetup {
//	DriverFactory selenium;
//	private static ThreadLocal<RemoteWebDriver> remote;
//
//	public DriverFactory getSelenium() {
//		return this.selenium;
//	}
//
//	public void setSelenium(DriverFactory selenium) {
//		this.selenium = selenium;
//	}
//
//	public static synchronized void setRemote(ThreadLocal<RemoteWebDriver> webdriver) {
//		remote = webdriver;
//	}
//
//	public static synchronized ThreadLocal<RemoteWebDriver> getRemote() {
//		return remote;
//	}
//}