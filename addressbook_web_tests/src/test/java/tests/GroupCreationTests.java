package tests;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import common.commonfunctions;
import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class GroupCreationTests extends TestBase {


    public static List<GroupData> groupProvides() throws IOException {
        var result = new ArrayList<GroupData>();
        /*for (var name : List.of("", "group name")) {
            for (var header : List.of("", "group header")) {
                for (var footer : List.of("", "group footer")) {
                    result.add(new GroupData().withName(name).withHeader(header).withFooter(footer));
                }
            }
        }*/
        var json = " ";
        try (var reader= new FileReader("groups.json");
            var breader = new BufferedReader(reader))
        {
          var line = breader.readLine();
            while (line!=null) {
            json=json + line;
            line = breader.readLine();
            }
        }
        //var json = Files.readString(Paths.get("groups.json"));
        ObjectMapper mapper = new ObjectMapper();
        var value = mapper.readValue(json, new TypeReference<List<GroupData>>() {
        });
        result.addAll(value);
        return result;
    }

    public static List<GroupData> negativegroupProvides() {
        var result = new ArrayList<GroupData>(List.of(new GroupData("", "group name'", "", "")));
        return result;
    }
    public static Stream<GroupData> randomGroups(){
        Supplier<GroupData> randomGroup = () -> new GroupData()
        .withName(commonfunctions.randomString(10)).
                withHeader(commonfunctions.randomString(20)).
                withFooter(commonfunctions.randomString(30));
        return Stream.generate(randomGroup).limit(1);

    }


    @ParameterizedTest
    @MethodSource("randomGroups")
    public void CanCreateGroup(GroupData group) {
        var oldGroups= app.hbm().getGroupList();
        app.groups().CreateGroup(group);
        var newGroups = app.hbm().getGroupList();
        String lastGroupId = newGroups.get(newGroups.size() - 1).id();
        var extraGroups = newGroups.stream().filter(g->! oldGroups.contains(g)).toList();
        var newId = extraGroups.get(0).id();
        var expectedList = new ArrayList<>(oldGroups);
        expectedList.add(group.withId((newId)));
        Assertions.assertEquals(Set.copyOf(newGroups) ,Set.copyOf(expectedList));
    }

    @ParameterizedTest
    @MethodSource("negativegroupProvides")
    public void CantCreateGroups(GroupData group) {
        var oldGroups= app.hbm().getGroupCount();
        app.groups().CreateGroup(group);
        long newGroupCount = app.hbm().getGroupCount();
        Assertions.assertEquals(oldGroups, newGroupCount);
    }
}
