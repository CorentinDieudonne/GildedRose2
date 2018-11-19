package edu.esilv.gilded;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.hamcrest.core.Is;
import org.junit.Assert;


public class Stepdefs {
    // TODO (PBZ) : the feature file is not within the good directory. Have a look to the Maven Directory Layout
    private Inventory inventory;
    private Item[] items;
    private Item vest;
    private Item conjured;

    @Given("^I have a new inventory$")
    public void iHaveANewInventory() throws Throwable {
        inventory = new Inventory();
        items = inventory.getItems();
        conjured = items[5];
    }

    @Then("^the quality of the conjured item is (\\d+)$")
    public void theQualityOfTheConjuredIs(int conjuredQuality) throws Throwable {
        Assert.assertThat(conjured.getQuality(), Is.is(conjuredQuality));
    }

    @When("^I update the inventory$")
    public void iUpdateTheInventory() throws Throwable {
        inventory.updateQuality();
    }

    @Then("^the quality of the conjured item is (\\d+)$")
    public void theQualityOfTheConjuredItemIs(int conjuredQuality) throws Throwable {
        Assert.assertThat(conjured.getQuality(), Is.is(conjuredQuality));
    }
}