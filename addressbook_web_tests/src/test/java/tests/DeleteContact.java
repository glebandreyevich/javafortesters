package tests;
import model.ContactData;
import org.junit.jupiter.api.Test;


public class DeleteContact extends TestBase {

    @Test
    public void removeContact() {
        if (app.contact().countContact()==0) {
            app.contact().createContact(new ContactData("firstname", "lastname", "address", "homephone", "321", "321", "@w", "@f", "@f", "333"));
        }
        app.contact().removeContact();

    }

}



