package tests;

import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GroupRemovaTests extends TestBase {


    @Test
    public void CanRemoveGroup() {
        if (app.groups().getCount() == 0)
       {
           app.groups().CreateGroup(new GroupData("", "name", "header", "footer"));
       }
        var oldGroups= app.groups().GetList();
        var rnd = new Random();
        var index = rnd.nextInt(oldGroups.size());
        app.groups().removeGroup(oldGroups.get(index));
        var newGroups = app.groups().GetList();
        var expectedList = new ArrayList<>(oldGroups);
        expectedList.remove(index);
        Assertions.assertEquals(newGroups ,expectedList);
    }
    @Test
    public void CanRemoveAllgroupOnce(){
        if (app.groups().getCount() == 0)
        {
            app.groups().CreateGroup(new GroupData("", "name", "header", "footer"));
        }
        app.groups().removeAllGroups();
        Assertions.assertEquals(0,app.groups().getCount());
    }

}
