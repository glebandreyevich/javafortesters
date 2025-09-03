package tests;
import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.ArrayList;
import java.util.List;


public class CreateContact extends TestBase {


    public static List<ContactData> contactProviders() {
        var result = new ArrayList<ContactData>();
        for (int i = 0; i < 5; i++) {
            result.add(new ContactData().withFirstName( randomString(i * 10)).withLastName(randomString(i*10)));
        }
        return result;
    }


    @ParameterizedTest
    @MethodSource("contactProviders")
    public void CreateContacts(ContactData contact) {
        int ContactCount = app.contact().countContact();
        app.contact().createContact(contact);
        int newContactCount = app.contact().countContact();
        Assertions.assertEquals(ContactCount + 1, newContactCount);
    }

}
