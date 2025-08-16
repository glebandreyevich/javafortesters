package manager;

import model.GroupData;
import org.openqa.selenium.By;

public class GroupHelper extends HelperBase{
    ;

    public GroupHelper (ApplicationManager manager){
        super(manager);
    }

    public void openGroupPage() {
        if (!manager.isElementPresent(By.name("new"))) {
            returnToGroupsPage();
        }
    }

    public boolean IsGroupPresent(ApplicationManager manager) {
        openGroupPage();
        return !manager.isElementPresent(By.name("selected[]"));
    }

    public void CreateGroup(GroupData group) {
        openGroupPage();
        InitGroupCreation();
        fillGroupForm(group);
        SubmitGroupCreation();
        returnToGroupsPage();
    }
    public void modifyGroup(GroupData modifiedGroup) {
        openGroupPage();
        selectGroup();
        initGroupModification();
        fillGroupForm(modifiedGroup);
        submitGroupModification();
        returnToGroupsPage();
    }
    public void removeGroup() {
        openGroupPage();
        selectGroup();
        removeSelectedGroup();
        returnToGroupsPage();
    }

    private void SubmitGroupCreation() {
        click(By.name("submit"));
    }



    private void InitGroupCreation() {
        click(By.name("new"));
    }


    private void removeSelectedGroup() {
        click(By.name("delete"));
    }


    private void returnToGroupsPage() {
        click(By.linkText("groups"));
    }

    private void submitGroupModification() {
        click(By.name("update"));

    }

    private void fillGroupForm(GroupData group) {
        type(By.name("group_name"), group.name());
        type(By.name("group_header"), group.header());
        type(By.name("group_footer"), group.footer());

    }

    private void initGroupModification() {
        click(By.name("edit"));

    }

    private void selectGroup() {
        click(By.name("selected[]"));
    }
}
