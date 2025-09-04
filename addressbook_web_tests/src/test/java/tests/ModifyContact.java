package tests;

import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class ModifyContact extends TestBase{


    @Test
    void canModifyContact(){
        if (app.contact().countContact() == 0)
        {
            app.contact().createContact(new ContactData( " ","firstname", "LastName", " "));
        }
        var oldContact=app.contact().GetList();
        var rnd = new Random();
        var index = rnd.nextInt(oldContact.size());
        var testData = new ContactData().withFirstName("modified first name").withLastName("Modified Last Name");
        app.contact().modifyContact(oldContact.get(index), testData);
        var newContact = app.contact().GetList();
        var expectedList = new ArrayList<>(oldContact);
        expectedList.set(index,testData.withId(oldContact.get(index).id()));
        Comparator<ContactData> compareById = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };
        newContact.sort(compareById);
        expectedList.sort(compareById);
        Assertions.assertEquals(newContact ,expectedList);
    }

}
