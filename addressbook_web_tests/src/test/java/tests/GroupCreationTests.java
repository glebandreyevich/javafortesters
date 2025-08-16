import model.GroupData;
import org.junit.jupiter.api.Test;

public class GroupCreationTests extends TestBase{


    @Test
    public void CanCreateGroup() {
        app.openGroupPage();
        app.CreateGroup(new GroupData("name", "header", "footer"));
    }

    @Test
    public void CantCreateGroupWithEmptyName() {
        app.openGroupPage();
        app.CreateGroup(new GroupData());
    }
    @Test void canCreateGroupWithNameOnly(){
        app.openGroupPage();
        var emptyGroup=new GroupData();
        var groupWithName = emptyGroup.withName("some name");
        app.CreateGroup(groupWithName);
    }
}
