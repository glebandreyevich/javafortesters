package tests;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import common.commonfunctions;
import model.ContactData;
import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class CreateContact extends TestBase {


    public static List<ContactData> contactProviders() throws IOException {
        var result = new ArrayList<ContactData>();
        /*for (int i = 1; i < 5; i++) {
            result.add(new ContactData().withFirstName( commonfunctions.randomString(i * 10)).withLastName(commonfunctions.randomString(i*10)).withPhoto(commonfunctions.randomfile("src/test/resources/images/")));
        }*/
        ObjectMapper mapper = new ObjectMapper();
        var json = Files.readString(Paths.get("contacts.json"));
        var value = mapper.readValue(json, new TypeReference<List<ContactData>>() {
        });
        result.addAll(value);
        return result;
    }


    @ParameterizedTest
    @MethodSource("contactProviders")
    public void CreateContacts(ContactData contact) {
        var oldContact=app.contact().GetList();
        app.contact().createContact(contact);
        var newContact=app.contact().GetList();
        Comparator<ContactData> compareById = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };
        newContact.sort(compareById);
        var expectedList = new ArrayList<>(oldContact);
        newContact.sort(compareById);
        expectedList.add(contact.withId(newContact.get(newContact.size()-1).id()).withPhoto(null));
        expectedList.sort(compareById);
        Assertions.assertEquals(newContact ,expectedList);
    }
    @Test
    public void CreateContactsInGroup() {
        var contact = new ContactData().withFirstName(commonfunctions.randomString(10)).withLastName(commonfunctions.randomString(10)).withPhoto(commonfunctions.randomfile("src/test/resources/images/"));
        if (app.hbm().getGroupCount() == 0)
        {
            app.hbm().CreateGroup(new GroupData("", "name", "header", "footer"));
        }
        var group=app.hbm().getGroupList().get(0);
        var oldRelated = app.hbm().getContactsInGroup(group);
        app.contact().createContactinGroup(contact, group);
        var newRelated = app.hbm().getContactsInGroup(group);
        Assertions.assertEquals(oldRelated.size()+1,newRelated.size());

    }

}
