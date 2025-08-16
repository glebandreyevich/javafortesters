import model.GroupData;
import org.junit.jupiter.api.Test;

public class GroupCreationTests extends TestBase{


    @Test
    public void CanCreateGroup() {
        openGroupPage();
        CreateGroup(new GroupData("name", "header", "footer"));
    }

    @Test
    public void CantCreateGroupWithEmptyName() {
        openGroupPage();
        CreateGroup(new GroupData());
    }
    @Test void canCreateGroupWithNameOnly(){
        openGroupPage();
        var emptyGroup=new GroupData();
        var groupWithName = emptyGroup.withName("some name");
        CreateGroup(groupWithName);
    }
}
