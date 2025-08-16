package tests;

import model.GroupData;
import org.junit.jupiter.api.Test;

public class GroupRemovaTests extends TestBase {


    @Test
    public void CanRemoveGroup() {
        if (app.groups().IsGroupPresent(app))
       {
           app.groups().CreateGroup(new GroupData("name", "header", "footer"));
       }
        app.groups().removeGroup();
    }

}
