import model.GroupData;
import org.junit.jupiter.api.Test;

public class GroupRemovaTests extends TestBase {


    @Test
    public void CanRemoveGroup() {
        openGroupPage();
        if (IsGroupPresent())
       {
           CreateGroup(new GroupData("name", "header", "footer"));
       }
        removeGroup();
    }

}
