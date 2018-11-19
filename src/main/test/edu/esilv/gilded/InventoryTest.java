package edu.esilv.gilded;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import static org.junit.jupiter.api.Assertions.assertEquals;
@RunWith(Cucumber.class)
@CucumberOptions(  monochrome = true,
        features = "src/main/test/",
        format = { "pretty","html: cucumber-html-reports",
                "json: cucumber-html-reports/cucumber.json" },
        glue = "your_step_definition_location_package" )

class InventoryTest {
    // TODO (PBZ) : the directory layout doesn't respect the maven standard !
    @Test
    void updateQuality1() {
        //item("+5 Dexterity Vest", sellIn=9, quality=19),

        //SETUP
        Inventory testInventory = new Inventory();
        Item vest = testInventory.getItems()[0];
        assertEquals("+5 Dexterity Vest", vest.getName());
        assertEquals(10, testInventory.getItems()[0].getSellIn());

        //ACTION
        testInventory.updateQuality();

        //TEST
        assertEquals(9, testInventory.getItems()[0].getSellIn());
        //Je regarde la valeur du SellIn et je la compare à celle attendue. test fonctionnel après application des règles

        assertEquals(19, testInventory.getItems()[0].getQuality());
        //Idem
    }
    @Test
    void updateQuality2() {
        //item(" Aged Brie",sellIn=2, quality= 0)

        //SETUP
        Inventory testInventory = new Inventory();
        Item brie = testInventory.getItems()[1];
        assertEquals("Aged Brie", brie.getName());
        assertEquals(2, testInventory.getItems()[1].getSellIn());

        //ACTION
        testInventory.updateQuality();

        //TEST
        assertEquals(1, testInventory.getItems()[1].getSellIn());
        //On obtient la bonne valeur pour le sellin
        assertEquals(1, testInventory.getItems()[1].getQuality());
        //On prend en compte qu'il s'agit d'un brie, on ajoute donc pour la qualité et on obtient 1
    }

    @Test
    void updateQuality3() {
        //item(" Elixir of the Mongoose",sellIn=5, quality= 7)

        //SETUP
        Inventory testInventory = new Inventory();
        Item elixir = testInventory.getItems()[2];
        assertEquals("Elixir of the Mongoose", elixir.getName());
        assertEquals(5, testInventory.getItems()[2].getSellIn());

        //ACTION
        testInventory.updateQuality();

        //TEST
        assertEquals(4, testInventory.getItems()[2].getSellIn());
        //Pas de condition particulière sur ce test
        assertEquals(6, testInventory.getItems()[2].getQuality());
    }
    @Test
    void updateQuality4() {
        //item(" Sulfuras, Hand of Ragnaros",sellIn=0, quality= 80)

        //SETUP
        Inventory testInventory = new Inventory();
        Item Sulfuras = testInventory.getItems()[3];
        assertEquals("Sulfuras, Hand of Ragnaros", Sulfuras.getName());
        assertEquals(0, testInventory.getItems()[3].getSellIn());

        //ACTION
        testInventory.updateQuality();

        //TEST
        assertEquals(0, testInventory.getItems()[3].getSellIn());
        //On obitent la bonne valeur pour Sulfura, en prenant en compte que la quality et le sellin ne change pas
        assertEquals(80, testInventory.getItems()[3].getQuality());
    }

    @Test
    void updateQuality5() {
        //item(" Backstage passes to a TAFKAL80ETC concert",sellIn=15, quality= 20)

        //SETUP
        Inventory testInventory = new Inventory();
        Item Backstage = testInventory.getItems()[4];
        assertEquals("Backstage passes to a TAFKAL80ETC concert", Backstage.getName());
        assertEquals(15, testInventory.getItems()[4].getSellIn());

        //ACTION
        testInventory.updateQuality();

        //TEST
        assertEquals(14, testInventory.getItems()[4].getSellIn());
        //On obtient pour le concert la condition sur la qualitité qui augmente avec la durée qui raccourcit
        assertEquals(21, testInventory.getItems()[4].getQuality());
    }

    @Test
    void updateQuality6() {
        //item(" Conjured Mana Cake",sellIn=3, quality= 6)

        //SETUP
        Inventory testInventory = new Inventory();
        Item Cake = testInventory.getItems()[5];
        assertEquals("Conjured Mana Cake",Cake.getName());
        assertEquals(3, testInventory.getItems()[5].getSellIn());

        //ACTION
        testInventory.updateQuality();

        //TEST
        assertEquals(2, testInventory.getItems()[5].getSellIn());
        // Il s'agit d'un objet Conjured sa durée de vie descend de 2 par jour
        assertEquals(5, testInventory.getItems()[5].getQuality());
    }

}
