package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Properties;


public class ApplicationManager {

    protected WebDriver driver;
    private LoginHelper session;
    private GroupHelper groups;
    private ContactHelper contact;
    private Properties properties;
    private JdbcHelper jdbc;
    private HibernateHelper hbm;

    public void init(String browser, Properties properties) {
        this.properties = properties;
        if (driver == null) {
            if ("firefox".equals(browser)) {
                driver = new FirefoxDriver();
                driver.get(properties.getProperty("web.BaseUrlFirefox"));
            }
            else if ("chrome".equals(browser)) {
                driver = new ChromeDriver();
                driver.get(properties.getProperty("web.BaseUrlChrome"));//chrome ругается на серты

            }
            else {
            throw new IllegalArgumentException(String.format("unknown browser", browser));
            }
            Runtime.getRuntime().addShutdownHook(new Thread(driver::quit));
            driver.manage().window().setSize(new Dimension(1303, 702));
            Session().login(properties.getProperty("web.UserName"), properties.getProperty("web.password"));
        }
    }

    public LoginHelper Session() {
        if (session==null) {
            session = new LoginHelper(this);
        }
        return session;
    }
    public GroupHelper groups() {
        if (groups==null) {
            groups = new GroupHelper(this);
        }
        return groups;
    }
    public HibernateHelper hbm() {
        if (hbm==null) {
            hbm = new HibernateHelper(this);
        }
        return hbm;
    }
    public JdbcHelper jdbc() {
        if (jdbc==null) {
            jdbc = new JdbcHelper(this);
        }
        return jdbc;
    }
    public ContactHelper contact() {
        if (contact==null) {
            contact = new ContactHelper(this);
        }
        return contact;
    }

    public boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException exception) {
            return false;
        }
    }

}
