package com.stirbul.app.AdditionalClasses;

import com.stirbul.app.Animals.Animal;

import java.util.*;

public class Pray {

    private LinkedList<Animal> prays = new LinkedList<>();

    public void prayOf(Animal... animalsArray){
        prays.addAll(Arrays.asList(animalsArray));
    }

    public Animal getRandomPray(){
        //check if there are objects in prays array
        if(prays.size() <= 0)
            return null;
        return prays.get(new Random().nextInt(prays.size()));
    }

    public LinkedList<Animal> getPraysList() {
        return prays;
    }

    public void prayListTraverse(){
        for(Animal a : prays){
            System.out.print(a.getSpecies());
            if(!prays.getLast().equals(a))
                System.out.print(" -> ");
        }
        System.out.println();
    }
}
