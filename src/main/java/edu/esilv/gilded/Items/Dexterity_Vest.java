package edu.esilv.gilded.Items;

public class Dexterity_Vest implements Strategy {
    public int sellIn;
    public int quality;
    @Override
    public void update() {
        System.out.println("This is a dexterity vest");
    }
}
