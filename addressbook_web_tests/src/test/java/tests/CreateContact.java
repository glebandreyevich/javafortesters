package tests;
import common.commonfunctions;
import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class CreateContact extends TestBase {


    public static List<ContactData> contactProviders() {
        var result = new ArrayList<ContactData>();
        for (int i = 1; i < 5; i++) {
            result.add(new ContactData().withFirstName( commonfunctions.randomString(i * 10)).withLastName(commonfunctions.randomString(i*10)).withPhoto(randomfile("src/test/resources/images/")));
        }
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
        expectedList.add(contact.withId(newContact.get(newContact.size()-1).id()));
        expectedList.sort(compareById);
        Assertions.assertEquals(newContact ,expectedList);
    }

}
