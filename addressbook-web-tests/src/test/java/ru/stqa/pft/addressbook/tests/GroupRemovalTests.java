package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;


public class GroupRemovalTests extends TestBase {

  @Test
  public void verifyTestGroupRemoval() {
    app.getNavigationHelper().goToGroupPage();
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().deleteSelectedGroups();
    app.getGroupHelper().returnToGroupPage();
  }
}
