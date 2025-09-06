package tests;
import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Random;

public class DeleteContact extends TestBase {

    @Test
    public void removeContact() {
        if (app.hbm().getContactCount()==0) {
            app.contact().createContact(new ContactData(" ", "firstname", "lastname", " "));
        }
        var oldContact = app.hbm().getContactList();
        var random = new Random();
        var index = random.nextInt(oldContact.size());
        app.contact().removeContact(oldContact.get(index));
        var newContact = app.hbm().getContactList();
        var expectedList = new ArrayList<>(oldContact);
        expectedList.remove(index);
        Assertions.assertEquals(newContact, expectedList);

    }

}



