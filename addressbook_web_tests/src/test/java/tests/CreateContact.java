package tests;
import model.ContactData;
import org.junit.jupiter.api.Test;


public class CreateContact extends TestBase  {


  @Test
  public void test() {
    app.contact().createContact(new ContactData("firstname", "lastname", "address", "homephone", "321", "321", "@w", "@f", "@f", "333"));
  }

}
