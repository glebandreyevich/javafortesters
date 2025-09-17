package stqa.mantis.manager;

import org.openqa.selenium.By;

public class UIHelper extends HelperBase{
    public UIHelper(ApplicationManager manager)
    {
        super(manager);
    }

    public void addUser(String username, String email) {
        click(By.linkText("Signup for a new account"));
        type(By.id("username"),username);
        type(By.id("email-field"),email);
        click(By.xpath("//input[@value='Signup']"));
    }

    public void openLink(String username ,String link, String password) {
        manager.driver.navigate().to(link);
        type(By.id("realname"),username);
        type(By.id("password"),password);
        type(By.id("password-confirm"),password);
        click(By.xpath("//span[@class='bigger-110' and text()='Update User']"));
    }
}
