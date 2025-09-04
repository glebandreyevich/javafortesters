package tests;

import common.commonfunctions;
import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class GroupCreationTests extends TestBase {


    public static List<GroupData> groupProvides() {
        var result = new ArrayList<GroupData>();
        for (var name : List.of("", "group name")) {
            for (var header : List.of("", "group header")) {
                for (var footer : List.of("", "group footer")) {
                    result.add(new GroupData().withName(name).withHeader(header).withFooter(footer));
                }
            }
        }
        for (int i = 1; i < 6; i++) {
            result.add(new GroupData().withName(commonfunctions.randomString(i * 10))
                    .withHeader(commonfunctions.randomString(i * 10))
                    .withFooter(commonfunctions.randomString(i * 10)));
        }
        return result;
    }

    public static List<GroupData> negativegroupProvides() {
        var result = new ArrayList<GroupData>(List.of(new GroupData("", "group name'", "", "")));
        return result;
    }


    @ParameterizedTest
    @MethodSource("groupProvides")
    public void CanCreateGroups(GroupData group) {
        var oldGroups= app.groups().GetList();
        app.groups().CreateGroup(group);
        var newGroups = app.groups().GetList();
        Comparator<GroupData> compareById = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };
        newGroups.sort(compareById);

        var expectedList = new ArrayList<>(oldGroups);
        expectedList.add(group.withId(newGroups.get(newGroups.size()-1).id()).withHeader("").withFooter(""));
        expectedList.sort(compareById);
        Assertions.assertEquals(newGroups ,expectedList);
    }

    @ParameterizedTest
    @MethodSource("negativegroupProvides")
    public void CantCreateGroups(GroupData group) {
        var oldGroups= app.groups().GetList();
        app.groups().CreateGroup(group);
        int newGroupCount = app.groups().getCount();
        Assertions.assertEquals(oldGroups, newGroupCount);
    }
}
