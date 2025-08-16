import model.GroupData;
import org.junit.jupiter.api.Test;

public class GroupRemovaTests extends TestBase {


    @Test
    public void CanRemoveGroup() {
        app.openGroupPage();
        if (app.IsGroupPresent())
       {
           app.CreateGroup(new GroupData("name", "header", "footer"));
       }
        app.removeGroup();
    }

}
