package com.stirbul.app.AdditionalClasses;

import com.stirbul.app.Animals.Animal;

import java.util.*;

public class Prey {

    private LinkedList<Animal> preys = new LinkedList<>();

    public void preyOf(Animal... animalsArray){
        for(Animal a : animalsArray){
            if(!preys.contains(a))
                preys.add(a);
        }
    }

    public Animal getRandomPrey(){
        //check if there are objects in preys array
        if(preys.size() <= 0)
            return null;
        return preys.get(new Random().nextInt(preys.size()));
    }

    public LinkedList<Animal> getPreysList() {
        return preys;
    }

    public void preyListTraverse(){
        for(Animal a : preys){
            System.out.print(a.getSpecies());
            if(!preys.getLast().equals(a))
                System.out.print(" <-> ");
        }
        System.out.println();
    }
}
