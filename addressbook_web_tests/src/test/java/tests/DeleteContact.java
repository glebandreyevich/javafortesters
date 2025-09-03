package tests;
import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DeleteContact extends TestBase {

    @Test
    public void removeContact() {
        if (app.contact().countContact()==0) {
            app.contact().createContact(new ContactData(" ", "firstname", "lastname"));
        }
        var oldContacts = app.contact().GetList();
        var random = new Random();
        var index = random.nextInt(oldContacts.size());
        app.contact().removeContact(oldContacts.get(index));
        var newContacts = app.contact().GetList();
        var expectedList = new ArrayList<>(oldContacts);
        expectedList.remove(index);
        Assertions.assertEquals(newContacts, expectedList);

    }

}



