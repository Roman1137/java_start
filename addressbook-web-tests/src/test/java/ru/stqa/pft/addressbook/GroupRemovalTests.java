package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;


public class GroupRemovalTests extends TestBase {

  @Test
  public void verifyTestGroupRemoval() {
    goToGroupPage();
    selectGroup();
    deleteSelectedGroups();
    returnToGroupPage();
  }

}
