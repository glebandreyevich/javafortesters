import org.junit.jupiter.api.Test;

public class GroupRemovaTests extends TestBase {


    @Test
    public void CanRemoveGroup() {
        openGroupPage();
        if (IsGroupPresent())
       {
           CreateGroup("name", "header", "footer");
       }
        removeGroup();
    }

}
