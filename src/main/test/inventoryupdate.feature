Feature: Inventory Update
  # a conjured item quality decreases twice the normal rate

Scenario: items update
    Given I have a new inventory
     Then the quality of the conjured item is 6
     Then the quality of the Sulfura item is 80
     Then the quality of the Elixir item is 6
     Then the quality of the AgedBrie item is 0
     Then the quality of the Vest item is 20
     Then the sellIn of the Conjured item 6
     Then the sellIn of the Sulfura item is 0
     Then the sellIn of the Vest item is 10
     Then the sellIn of the AgedBrie item is 2
     Then the sellIn of the Vest item is 10
     When I update the inventory

     Then the quality of the conjured item is 4
     Then the quality of the Sulfura item is 80
     Then the quality of the Elixir item is 6
     Then the quality of the AgedBrie item is 0
     Then the quality of the Vest item is 19
     Then the sellIn of the Conjured item is 6
     Then the sellIn of the Sulfura item is 0
     Then the sellIn of the Vest item is 9
     Then the sellIn of the AgedBrie item is 1
     Then the sellIn of the Vest item is 9