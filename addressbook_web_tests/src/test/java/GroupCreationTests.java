import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class GroupCreationTests extends TestBase{


    @Test
    public void CanCreateGroup() {
        openGroupPage();
        CreateGroup("name", "header", "footer");
    }

    @Test
    public void CantCreateGroupWithEmptyName() {
        openGroupPage();
        driver.findElement(By.linkText("groups")).click();
        CreateGroup("", "", "");
    }
}
