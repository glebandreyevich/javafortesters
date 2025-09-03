package tests;
import model.ContactData;
import org.junit.jupiter.api.Test;


public class DeleteContact extends TestBase {

    @Test
    public void removeContact() {
        if (app.contact().countContact()==0) {
            app.contact().createContact(new ContactData(" ", "firstname", "lastname"));
        }
        app.contact().removeContact();

    }

}



