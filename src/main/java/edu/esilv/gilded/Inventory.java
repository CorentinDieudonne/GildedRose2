package edu.esilv.gilded;

import edu.esilv.gilded.Items.*;

import java.time.LocalDateTime;
import java.util.ArrayList;

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

    public AgedBrie[] ABries=new AgedBrie[10];
    public Concert[] Concerts=new Concert[10];

    public Inventory(Item[] items, AgedBrie[] ABries, Concert[] concerts, DexterityVest[] DVests, Elixir[] elixirs, ManaCake[] MCakes, Ragnaros[] hoRs) {
        this.items = items;
        this.ABries = ABries;
        Concerts = concerts;
        this.DVests = DVests;
        Elixirs = elixirs;
        this.MCakes = MCakes;
        HoRs = hoRs;
    }

    public DexterityVest[] DVests=new DexterityVest[10];
    public Elixir [] Elixirs=new Elixir[10];
    public ManaCake[] MCakes=new ManaCake[10];
    public Ragnaros[] HoRs=new Ragnaros[10];

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

    };

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

    public Inventory FillClasses(){
        Inventory inv=new Inventory();
        int i=0; int k=items.length; int j=0,j1=0,j2=0,j3=0,j4=0,j5=0;
        ArrayList<AgedBrie> abs=new ArrayList<AgedBrie>(); ArrayList<Concert> cs=new ArrayList<Concert>();
        ArrayList<DexterityVest> dvs=new ArrayList<DexterityVest>(); ArrayList<Elixir> es=new ArrayList<Elixir>();
        ArrayList<ManaCake> mcs=new ArrayList<ManaCake>(); ArrayList<Ragnaros> rs=new ArrayList<Ragnaros>();
        while(i<k)
        {
            if(items[i].getName().equals("Aged Brie")){
                AgedBrie a=new AgedBrie(null,0,0,0,null,null);
                a.setDate(items[i].getDate());
                a.setId(items[i].getId());
                a.setQuality(items[i].getQuality());
                a.setSellIn(items[i].getSellIn());
                inv.ABries[j]=a;
                abs.add(ABries[j]);
                j++;
            }
            if(items[i].getName().equals("Backstage passes to a TAFKAL80ETC concert")){
                Concert c=new Concert(null,0,0,0,null,null);
                c.setDate(items[i].getDate());
                c.setId(items[i].getId());
                c.setQuality(items[i].getQuality());
                c.setSellIn(items[i].getSellIn());
                inv.Concerts[j1]=c;
                cs.add(Concerts[j1]);
                j1++;
            }
            if(items[i].getName().equals("+5 Dexterity Vest")){
                DexterityVest d= new DexterityVest(null,0,0,0,null,null);
                d.setDate(items[i].getDate());
                d.setId(items[i].getId());
                d.setQuality(items[i].getQuality());
                d.setSellIn(items[i].getSellIn());
                inv.DVests[j2]=d;
                dvs.add(DVests[j2]);
                j2++;
            }
            if(items[i].getName().equals("Elixir of the Mongoose")){
                Elixir e=new Elixir(null,0,0,0,null,null);
                e.setDate(items[i].getDate());
                e.setId(items[i].getId());
                e.setQuality(items[i].getQuality());
                e.setSellIn(items[i].getSellIn());
                inv.Elixirs[j3]=e;
                es.add(Elixirs[j3]);
                j3++;
            }
            if(items[i].getName().equals("Conjured Mana Cake")){
                ManaCake m=new ManaCake(null,0,0,0,null,null);
                m.setDate(items[i].getDate());
                m.setId(items[i].getId());
                m.setQuality(items[i].getQuality());
                m.setSellIn(items[i].getSellIn());
                inv.MCakes[j4]=m;
                mcs.add(MCakes[j4]);
                j4++;
            }
            if(items[i].getName().equals("Sulfuras, Hand of Ragnaros")){
                Ragnaros r=new Ragnaros(null,0,0,0,null,null);
                r.setDate(items[i].getDate());
                r.setId(items[i].getId());
                r.setQuality(items[i].getQuality());
                r.setSellIn(items[i].getSellIn());
                inv.HoRs[j5]=r;
                rs.add(HoRs[j5]);
                j5++;
            }
            i++;
        }
        inv.ABries[0].setListe(abs);
        inv.Concerts[0].setListe(cs);
        inv.DVests[0].setListe(dvs);
        inv.Elixirs[0].setListe(es);
        inv.MCakes[0].setListe(mcs);
        inv.HoRs[0].setListe(rs);
        return inv;
    }
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        inventory=inventory.FillClasses();
        //inventory.updateQ();
        System.out.println(inventory.ABries[0].getName());
        inventory.printInventory();
    }
}
