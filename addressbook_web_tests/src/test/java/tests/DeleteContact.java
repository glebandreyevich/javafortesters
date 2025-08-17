package tests;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class DeleteContact {
  private WebDriver driver;
  @BeforeEach
  public void setUp() {
      if (driver == null) {
          driver = new FirefoxDriver();
          Runtime.getRuntime().addShutdownHook(new Thread(driver::quit));
          driver.get("http://localhost/addressbook/addressbook/");
          driver.manage().window().setSize(new Dimension(1303, 705));
          driver.findElement(By.name("user")).sendKeys("admin");
          driver.findElement(By.name("pass")).sendKeys("secret");
      }
  }
  @Test
  public void del() {
      driver.findElement(By.cssSelector("input:nth-child(7)")).click();
      if (clickIfElementPresent(By.name("selected[]"))) {
          driver.findElement(By.name("selected[]")).click();
          driver.findElement(By.cssSelector(".left:nth-child(8) > input")).click();
      }
      driver.findElement(By.linkText("Logout")).click();
    }

    public boolean clickIfElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }


  }



