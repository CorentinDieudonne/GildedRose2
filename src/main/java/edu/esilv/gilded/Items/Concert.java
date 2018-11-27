package edu.esilv.gilded.Items;

public class Concert implements Strategy {
    public int sellIn;
    public int quality;
    @Override
    public void update(){
        System.out.print("This is a Concert");
    }
}
