package manager;

import model.ContactData;
import model.GroupData;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;


public class ContactHelper extends HelperBase {
    public ContactHelper(ApplicationManager manager){
        super(manager);
    }

    //public  boolean isFileExists(String path) {
     // try {
      //  File file = new File(path);
       // return file.exists() && file.isFile();
     // } catch (SecurityException e) {
      //  return false;
     // }
   // }



      public void removeContact(ContactData contact)
      {
          selectContact(contact);
          click(By.cssSelector("div.left:nth-child(8) > input:nth-child(1)"));

      }

    private void selectContact(ContactData contact) {
        click(By.cssSelector(String.format("[id='%s']", contact.id())));
    }

    public int countContact()
    {
        return manager.driver.findElements(By.name("selected[]")).size();

    }

    public void createContact(ContactData contact){
        initContactAdd();
        fillContactData(contact);
        submitContactData();
        returnToContactPage();
    }

    private void returnToContactPage() {
        click(By.cssSelector("#nav > ul:nth-child(1) > li:nth-child(1) > a:nth-child(1)"));
    }

    private void submitContactData() {
        click(By.cssSelector("#content > form:nth-child(2) > input:nth-child(75)"));
    }

        private void fillContactData(ContactData contact) {
            type(By.name("firstname"), contact.firstName());
            type(By.name("lastname"), contact.lastName());
            //type(By.name("address"), contact.address());
           // type(By.name("home"), contact.homePhone());
            //type(By.name("mobile"), contact.mobilePhone());
           // type(By.name("work"), contact.workPhone());
           // type(By.name("fax"), contact.fax());
           // type(By.name("email"), contact.email());
           // type(By.name("email2"), contact.email2());
            //type(By.name("email3"), contact.email3());

    }

    private void initContactAdd() {
        click(By.linkText("add new"));
    }

    private void openHomePage() {
        click(By.cssSelector("#nav > ul:nth-child(1) > li:nth-child(1) > a:nth-child(1)"));
    }

    public List<ContactData> GetList() {
        openHomePage();
        var contacts = new ArrayList<ContactData>();
        var entry = manager.driver.findElements(By.cssSelector("tr[name='entry']"));
        for (var tr : entry) {
            var checkbox = tr.findElement(By.name("selected[]"));
            var id = checkbox.getAttribute("id");
            var firstName = tr.findElement(By.cssSelector("td:nth-child(3)")).getText();
            var lastName = tr.findElement(By.cssSelector("td:nth-child(2)")).getText();
            contacts.add(new ContactData().withId(id).withFirstName(firstName).withLastName(lastName));
        }
            return contacts;
    }


        public void modifyContact(ContactData contact,ContactData modifiedContact) {
            openHomePage();
            initContactModification(contact);
            fillContactData(modifiedContact);
            submitContactModify();
            openHomePage();

    }

    private void submitContactModify() {
        click(By.name("update"));
    }

    private void initContactModification(ContactData contact) {
        var elementId = manager.driver.findElement(By.id(contact.id()));

        String xpath = String.format("//*[@id='%s']/ancestor::tr//td[8]", contact.id());
        var editButton = manager.driver.findElement(By.xpath(xpath));
        editButton.click();

    }
}
