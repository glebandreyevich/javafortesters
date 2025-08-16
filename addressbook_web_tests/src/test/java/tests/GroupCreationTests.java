package tests;

import model.GroupData;
import org.junit.jupiter.api.Test;

public class GroupCreationTests extends TestBase{


    @Test
    public void CanCreateGroup() {
        app.groups().CreateGroup(new GroupData("name", "header", "footer"));
    }

    @Test
    public void CantCreateGroupWithEmptyName() {
        app.groups().CreateGroup(new GroupData());
    }
    @Test void canCreateGroupWithNameOnly(){
        app.groups().CreateGroup(new GroupData().withName("some name"));
    }
}
