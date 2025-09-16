package stqa.mantis.manager;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Properties;

public class ApplicationManager {
    protected WebDriver driver;
    private Properties properties;
    private String string;
    private SessionHelper sessionHelper;

    public void init(String browser, Properties properties) {
        this.string = browser;
        this.properties = properties;
    }

    public WebDriver driver() {
        if (driver==null) {
            if (driver == null) {
                if ("firefox".equals(string)) {
                    driver = new FirefoxDriver();
                    driver.get(properties.getProperty("web.BaseUrl"));
                }
                else if ("chrome".equals(string)) {
                    driver = new ChromeDriver();
                    driver.get(properties.getProperty("web.BaseUrl"));//chrome ругается на серты

                }
                else {
                    throw new IllegalArgumentException(String.format("unknown browser", string));
                }
                Runtime.getRuntime().addShutdownHook(new Thread(driver::quit));
                driver.manage().window().setSize(new Dimension(1303, 702));
            }
        }
        return driver;
    }

    public SessionHelper session() {
        if (sessionHelper==null){
            sessionHelper = new SessionHelper(this);
        }
        return sessionHelper;
    }
}
