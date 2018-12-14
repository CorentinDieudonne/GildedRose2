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
    private Item sulfura;
    private Item backstage;
    private Item elixir;
    private Item agedbrie;

    @Given("^I have a new inventory$")
    public void iHaveANewInventory() throws Throwable {
        inventory = new Inventory();
        items = inventory.getItems();
        conjured = items[5];
        sulfura =items[3];
        backstage=items[4];
        elixir=items[2];
        vest=items[0];
        agedbrie=items[1];
    }

    @Then("^the quality of the conjured item is (\\d+)$")
    public void theQualityOfTheConjuredIs(int conjuredQuality) throws Throwable {
        Assert.assertThat(conjured.getQuality(), Is.is(conjuredQuality));
    }

    @Then("^the quality of the backstage passes is (\\d+)$")
    public void theQualityOfTheBackstagePassesIs(int backstageQuality) throws Throwable {
        Assert.assertThat(backstage.getQuality(), Is.is(backstageQuality));
    }

    @Then("^the quality of the Sulfura item is (\\d+)$")
    public void theQualityOfTheSulfuraIs(int sulfuraQuality) throws Throwable {
        Assert.assertThat(sulfura.getQuality(), Is.is(sulfuraQuality));

    }

    @Then("^the quality of the Elixir item is (\\d+)$")
    public void theQualityOfTheElixirIs(int elixirQuality) throws Throwable {
        Assert.assertThat(elixir.getQuality(), Is.is(elixirQuality));
    }

    @Then("^the quality of the AgedBrie item is (\\d+)$")
    public void theQualityOfTheAgedBrieIs(int agedbrieQuality) throws Throwable {
        Assert.assertThat(agedbrie.getQuality(), Is.is(agedbrieQuality));

    }

    @Then("^the quality of the Vest item is (\\d+)$")
    public void theQualityOfTheVestIs(int vestQuality) throws Throwable {
        Assert.assertThat(vest.getQuality(), Is.is(vestQuality));

    }

    @Then("^the sellIn of the Conjured item (\\d+)$")
    public void theSellInOfTheConjured(int conjuredSellIn) throws Throwable {
        Assert.assertThat(conjured.getSellIn(), Is.is(conjuredSellIn));

    }

    @Then("^the sellIn of the Sulfura item is (\\d+)$")
    public void theSellInOfTheSulfuraIs(int sulfuraSellIn) throws Throwable {
        Assert.assertThat(sulfura.getSellIn(), Is.is(sulfuraSellIn));
    }

    @Then("^the sellIn of the Vest item is (\\d+)$")
    public void theSellInOfTheVestIs(int vestSellIn) throws Throwable {
        Assert.assertThat(vest.getSellIn(), Is.is(vestSellIn));
    }

    @Then("^the sellIn of the AgedBrie item is (\\d+)$")
    public void theSellInOfTheAgedBrieIs(int AgedBrieSellIn) throws Throwable {
        Assert.assertThat(agedbrie.getSellIn(), Is.is(AgedBrieSellIn));
    }


    @When("^I update the inventory$")
    public void iUpdateTheInventory() throws Throwable {
        inventory.updateQuality();
    }

    @Then("^the quality of the conjured item is (\\d+)$")
    public void theQualityOfTheConjuredItemIs(int conjuredQuality) throws Throwable {
        Assert.assertThat(conjured.getQuality(), Is.is(conjuredQuality));
    }

    @Then("^the quality of the backstage passes is (\\d+)$")
    public void theQualityOfTheBackstagePassesItemIs(int backstageQuality) throws Throwable {
        Assert.assertThat(backstage.getQuality(), Is.is(backstageQuality));
    }

    @Then("^the quality of the Sulfura item is (\\d+)$")
    public void theQualityOfTheSulfuraItemIs(int sulfuraQuality) throws Throwable {
        Assert.assertThat(sulfura.getQuality(), Is.is(sulfuraQuality));

    }

    @Then("^the quality of the Elixir item is (\\d+)$")
    public void theQualityOfTheElixirItemIs(int elixirQuality) throws Throwable {
        Assert.assertThat(elixir.getQuality(), Is.is(elixirQuality));
    }

    @Then("^the quality of the AgedBrie item is (\\d+)$")
    public void theQualityOfTheAgedBrieItemIs(int agedbrieQuality) throws Throwable {
        Assert.assertThat(agedbrie.getQuality(), Is.is(agedbrieQuality));

    }

    @Then("^the quality of the Vest item is (\\d+)$")
    public void theQualityOfTheVestItemIs(int vestQuality) throws Throwable {
        Assert.assertThat(vest.getQuality(), Is.is(vestQuality));

    }

    @Then("^the sellIn of the Conjured item (\\d+)$")
    public void theSellInOfTheConjuredItem(int conjuredSellIn) throws Throwable {
        Assert.assertThat(conjured.getSellIn(), Is.is(conjuredSellIn));

    }

    @Then("^the sellIn of the Sulfura item is (\\d+)$")
    public void theSellInOfTheSulfuraItemIs(int sulfuraSellIn) throws Throwable {
        Assert.assertThat(sulfura.getSellIn(), Is.is(sulfuraSellIn));
    }

    @Then("^the sellIn of the Vest item is (\\d+)$")
    public void theSellInOfTheVestItemIs(int vestSellIn) throws Throwable {
        Assert.assertThat(vest.getSellIn(), Is.is(vestSellIn));
    }

    @Then("^the sellIn of the AgedBrie item is (\\d+)$")
    public void theSellInOfTheAgedBrieItemIs(int AgedBrieSellIn) throws Throwable {
        Assert.assertThat(agedbrie.getSellIn(), Is.is(AgedBrieSellIn));
    }
}