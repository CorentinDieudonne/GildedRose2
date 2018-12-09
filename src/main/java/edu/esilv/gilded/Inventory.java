package edu.esilv.gilded;

import edu.esilv.gilded.Items.*;

import java.time.LocalDateTime;
import java.util.List;

public class Inventory implements InventoryPart{
    public Item[] items;

    public AgedBrie[] getABries() {
        return ABries;
    }

    public void setABries(AgedBrie[] ABries) {
        this.ABries = ABries;
    }

    public Concert[] getConcerts() {
        return Concerts;
    }

    public void setConcerts(Concert[] concerts) {
        Concerts = concerts;
    }

    public DexterityVest[] getDVests() {
        return DVests;
    }

    public void setDVests(DexterityVest[] DVests) {
        this.DVests = DVests;
    }

    public ManaCake[] getMCakes() {
        return MCakes;
    }

    public void setMCakes(ManaCake[] MCakes) {
        this.MCakes = MCakes;
    }

    public Ragnaros[] getHoRs() {
        return HoRs;
    }

    public void setHoRs(Ragnaros[] hoRs) {
        HoRs = hoRs;
    }

    public AgedBrie[] ABries;
    public Concert[] Concerts;

    public Inventory(Item[] items, AgedBrie[] ABries, Concert[] concerts, DexterityVest[] DVests, Elixir[] elixirs, ManaCake[] MCakes, Ragnaros[] hoRs) {
        this.items = items;
        this.ABries = ABries;
        Concerts = concerts;
        this.DVests = DVests;
        Elixirs = elixirs;
        this.MCakes = MCakes;
        HoRs = hoRs;
    }

    public DexterityVest[] DVests;
    public Elixir [] Elixirs;
    public ManaCake[] MCakes;
    public Ragnaros[] HoRs;

    public Elixir[] getElixirs() {
        return Elixirs;
    }

    public void setElixirs(Elixir[] elixirs) {
        Elixirs = elixirs;
    }

    public Inventory(Item[] items) {
        super();
        this.items = items;
    }

    public Item[] getItems() {return items;}

// PBEZAULT@yahoo.fr

    public Inventory() {
        super();
        items = new Item[]{
                new Item("+5 Dexterity Vest", 10, 20,1, LocalDateTime.now()),
                new Item("Aged Brie", 2, 0,2,LocalDateTime.now()),
                new Item("Elixir of the Mongoose", 5, 7,3,LocalDateTime.now()),
                new Item("Sulfuras, Hand of Ragnaros", 0, 80,4,LocalDateTime.now()),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20,5,LocalDateTime.now()),
                new Item("Conjured Mana Cake", 3, 6,6,LocalDateTime.now()),
                new Item("+5 Dexterity Vest", 10, 20,7, LocalDateTime.now())
        };

    }

    private void printInventory() {
        System.out.println("***************");
        for (Item item : items) {
            System.out.println(item);
        }
        System.out.println("***************");
        System.out.println("\n");
    }
    public void updateQ(){
        int j=0,j1=0,j2=0,j3=0,j4=0,j5=0;
        while(j<ABries.length){
            ABries[j].update();
            j++;
        }
        while(j1<Concerts.length){
            Concerts[j1].update();
            j1++;
        }
        while(j2<DVests.length){
            DVests[j2].update();
            j2++;
        }
        while(j3<Elixirs.length){
            Elixirs[j3].update();
            j3++;
        }
        while(j4<MCakes.length){
            MCakes[j4].update();
            j4++;
        }
        while(j5<HoRs.length){
            HoRs[j5].update();
            j5++;
        }
    }
    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (!items[i].getName().equals("Aged Brie")
                    && !items[i].getName().equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (items[i].getQuality() > 0) {
                    if (!items[i].getName().equals("Sulfuras, Hand of Ragnaros")) {
                        items[i].setQuality(items[i].getQuality() - 1);
                    }
                }
                if(items[i].getSellIn()<0){
                    items[i].setQuality(items[i].getQuality()-2);
                }
            } else {
                if (items[i].getQuality() < 50) {
                    items[i].setQuality(items[i].getQuality() + 1);

                    if (items[i].getName().equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].getSellIn() < 11) {
                            if (items[i].getQuality() < 50) {
                                items[i].setQuality(items[i].getQuality() + 2);
                            }
                        }

                        if (items[i].getSellIn() < 6) {
                            if (items[i].getQuality() < 50) {
                                items[i].setQuality(items[i].getQuality() + 3);
                            }
                        }
                        if(items[i].getSellIn()<1){
                            items[i].setQuality(0);
                        }
                    }
                }
            }
            if (!items[i].getName().equals("Sulfuras, Hand of Ragnaros") && !items[i].getName().equals("Aged Brie")) {
                items[i].setSellIn(items[i].getSellIn() - 1);
            }

            if (items[i].getSellIn() < 0) {
                if (!items[i].getName().equals("Aged Brie")) {
                    if (!items[i].getName().equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].getQuality() > 0) {
                            if (!items[i].getName().equals("Sulfuras, Hand of Ragnaros")) {
                                items[i].setQuality(items[i].getQuality() - 1);
                            }
                        }
                    } else {
                        items[i].setQuality(0);
                    }
                } else {
                    if (items[i].getQuality() < 50) {
                        items[i].setQuality(items[i].getQuality() + 1);
                    }
                }
            }
            if("Aged Brie".equals(items[i].getName()) && items[i].getQuality()<50){
                items[i].setSellIn(items[i].getSellIn()-1);
            }
        }
    }
    public void accept(InventoryPartVisitor inventoryPartVisitor) { }

    public void FillTheClasses(){
        int i=0; int k=items.length; int j=0; int j1=0; int j2=0; int j3=0; int j4=0; int j5=0;
        List<AgedBrie> abs=null; List<Concert> cs=null; List<DexterityVest> dvs=null; List<Elixir> es=null; List<ManaCake> mcs=null; List<Ragnaros> rs=null;
        while(i<k)
        {
            if(items[i].getName().equals("Aged Brie")){
                ABries[j].setDate(items[i].getDate());
                ABries[j].setId(items[i].getId());
                ABries[j].setQuality(items[i].getQuality());
                ABries[j].setSellIn(items[i].getSellIn());
                abs.add(ABries[j]);
                j++;
            }
            if(items[i].getName().equals("Backstage passes to a TAFKAL80ETC concert")){
                Concerts[j1].setDate(items[i].getDate());
                Concerts[j1].setId(items[i].getId());
                Concerts[j1].setQuality(items[i].getQuality());
                Concerts[j1].setSellIn(items[i].getSellIn());
                cs.add(Concerts[j1]);
                j1++;
            }
            if(items[i].getName().equals("+5 Dexterity Vest")){
                DVests[j2].setDate(items[i].getDate());
                DVests[j2].setId(items[i].getId());
                DVests[j2].setQuality(items[i].getQuality());
                DVests[j2].setSellIn(items[i].getSellIn());
                dvs.add(DVests[j2]);
                j2++;
            }
            if(items[i].getName().equals("Elixir of the Mongoose")){
                Elixirs[j3].setDate(items[i].getDate());
                Elixirs[j3].setId(items[i].getId());
                Elixirs[j3].setQuality(items[i].getQuality());
                Elixirs[j3].setSellIn(items[i].getSellIn());
                es.add(Elixirs[j3]);
                j3++;
            }
            if(items[i].getName().equals("Conjured Mana Cake")){
                MCakes[j4].setDate(items[i].getDate());
                MCakes[j4].setId(items[i].getId());
                MCakes[j4].setQuality(items[i].getQuality());
                MCakes[j4].setSellIn(items[i].getSellIn());
                mcs.add(MCakes[j4]);
                j4++;
            }
            if(items[i].getName().equals("Sulfuras, Hand of Ragnaros")){
                HoRs[j5].setDate(items[i].getDate());
                HoRs[j5].setId(items[i].getId());
                HoRs[j5].setQuality(items[i].getQuality());
                HoRs[j5].setSellIn(items[i].getSellIn());
                rs.add(HoRs[j5]);
                j5++;
            }
            ABries[0].setListe(abs);
            Concerts[0].setListe(cs);
            DVests[0].setListe(dvs);
            Elixirs[0].setListe(es);
            MCakes[0].setListe(mcs);
            HoRs[0].setListe(rs);
        }
    }
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        for (int i = 0; i < 10; i++) {
            inventory.updateQuality();
            inventory.printInventory();
        }
    }
}
