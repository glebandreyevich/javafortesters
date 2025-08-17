package tests;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import java.io.File;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.Dimension;


public class CreateContact  {
  private WebDriver driver;


  @BeforeEach

  public void setUp() {
    if (driver == null) {
      driver = new FirefoxDriver();
      Runtime.getRuntime().addShutdownHook(new Thread(driver::quit));
      driver.get("http://localhost/addressbook/addressbook/");
      driver.manage().window().setSize(new Dimension(1303, 705));
      fillelement("user", "admin");
      fillelement("pass", "secret");
    }
  }
  @Test
  public void test() {
    fillcontact();
    clickElementByLocatorType("linktext","Logout");
  }

  private void fillcontact() {
    clickElementByLocatorType("css","input:nth-child(7)");
    clickElementByLocatorType("linktext","add new");
    fillelement("firstname", "first name");
    fillelement("middlename", "middle name");
    fillelement("lastname", "last name");
    fillelement("nickname", "nickname");
    fillelement("title", "title");
    if (isFileExists("C:\\javatest\\hr\\javafortesters\\pic.png")) {
      fillelement("photo", "C:\\javatest\\hr\\javafortesters\\pic.png");
    }
    fillelement("company", "company");
    fillelement("address", "address");
    fillelement("home", "33");
    fillelement("mobile", "33");
    fillelement("work", "33");
    fillelement("fax", "33");
    fillelement("email", "1mail");
    fillelement("email2", "2mail");
    fillelement("email3", "3mail");
    fillelement("bday", "//option[. = '10']");
    fillelement("bmonth", "//option[. = 'May']");
    fillelement("byear", "2000");
    fillelement("aday", "//option[. = '9']");
    fillelement("amonth", "//option[. = 'August']");
    fillelement("ayear", "2001");
    fillelement("new_group", "//option[. = 'modified name']");
    clickElementByLocatorType("css","#content > form:nth-child(2) > input:nth-child(75)");
  }

  private  void clickElementByLocatorType(String locatorType, String input) {
    By locator = switch (locatorType) {
        case "css" -> By.cssSelector(input);
        case "linktext" -> By.linkText(input);
        default -> throw new IllegalArgumentException("Unsupported locator type: " + locatorType);
    };

      driver.findElement(locator).click();
  }
  private void fillelement(String name, String input_name) {
      driver.findElement(By.name(name)).sendKeys(input_name);
  }

  public boolean isFileExists(String path) {
    try {
      File file = new File(path);
      return file.exists() && file.isFile();
    } catch (SecurityException e) {
      return false;
    }
  }
}
