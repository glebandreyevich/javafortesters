package tests;

import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GroupCreationTests extends TestBase{


    @Test
    public void CanCreateGroup() {
        int groupCount = app.groups().getCount();
        app.groups().CreateGroup(new GroupData("name", "header", "footer"));
        int newGroupCount = app.groups().getCount();
        Assertions.assertEquals(groupCount +1,newGroupCount);
    }

    @Test
    public void CantCreateGroupWithEmptyName() {
        app.groups().CreateGroup(new GroupData());
    }
    @Test void canCreateGroupWithNameOnly(){
        app.groups().CreateGroup(new GroupData().withName("some name"));
    }
}
