package edu.esilv.gilded.Items;

public class Elixir implements Strategy {
    private String name;
    private int quality;
    private int sellIn;
    Elixir(String name, int quality, int sellIn)
    {
        this.name=name;
        this.quality=quality;
        this.sellIn=sellIn;
    }
    @Override
    public void update(){
        System.out.print("This is an Elixir");
    }
}
