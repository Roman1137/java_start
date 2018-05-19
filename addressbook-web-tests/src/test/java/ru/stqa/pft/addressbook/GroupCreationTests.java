package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;


public class GroupCreationTests extends TestBase{

  @Test
  public void verifyGroupCreating() {
    goToGroupPage();
    initGroupCreation();
    fillGroupForm(new GroupData("qwertyu", "qwerty", "qwerty"));
    submitGroupCreation();
    returnToGroupPage();
  }
}
