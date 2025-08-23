package manager;

import model.ContactData;
import org.openqa.selenium.By;


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



      public void removeContact()
      {
          click(By.name("selected[]"));
          click(By.cssSelector("div.left:nth-child(8) > input:nth-child(1)"));

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
            type(By.name("address"), contact.address());
            type(By.name("home"), contact.homePhone());
            type(By.name("mobile"), contact.mobilePhone());
            type(By.name("work"), contact.workPhone());
            type(By.name("fax"), contact.fax());
            type(By.name("email"), contact.email());
            type(By.name("email2"), contact.email2());
            type(By.name("email3"), contact.email3());

    }

    private void initContactAdd() {
        click(By.linkText("add new"));
    }




}
