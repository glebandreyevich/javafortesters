package tests;
import common.commonfunctions;
import model.ContactData;
import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Random;

public class DeleteContact extends TestBase {

    @Test
    public void removeContact() {
        if (app.hbm().getContactCount()==0) {
            app.contact().createContact(new ContactData(" ", "firstname", "lastname", " ", "", "", "", "", "", "", "", ""));
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
    @Test
    public void removeContactFromGroup() {
        if(app.hbm().getGroupCount()==0){
            app.groups().CreateGroup(new GroupData("", "name", "header", "footer"));
        }
        var group = app.hbm().getGroupList().get(0);
        if (app.hbm().getContactsInGroup(group).isEmpty()) {
           var contact = new ContactData()
                    .withFirstName(commonfunctions.randomString(10))
                    .withLastName(commonfunctions.randomString(10))
                    .withPhoto("src/test/resources/images/avatar.png");
            app.contact().createContactinGroup(contact, group);
        }
        var contact = app.hbm().getContactList().get(0);
        contact = app.hbm().getContactsInGroup(group).get(0);
        var oldRelated = app.hbm().getContactsInGroup(group);
        app.contact().removeContactFromGroup(contact, group);
        var newRelated = app.hbm().getContactsInGroup(group);
        Assertions.assertEquals(oldRelated.size()-1,newRelated.size());
    }
}



