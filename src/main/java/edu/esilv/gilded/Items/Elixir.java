package edu.esilv.gilded.Items;

import edu.esilv.gilded.Strategy;

public class Elixir implements Strategy {
    @Override
    public void update(){
        System.out.print("This is an Elixir");
    }
}
