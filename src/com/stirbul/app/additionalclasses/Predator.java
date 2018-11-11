package com.stirbul.app.additionalclasses;

import com.stirbul.app.animals.Animal;

import java.util.*;

public class Predator {
    private LinkedList<Animal> predators = new LinkedList<>();

    public LinkedList<Animal> getPredatorList() {
        return predators;
    }

    public Animal getRandomPredator(){
        if(predators.size() <= 0)
            return null;
        return predators.get(new Random().nextInt(predators.size()));
    }

    public void predatorOf(Animal... predatorArray){
        for(Animal a : predatorArray){
            if(!predators.contains(a))
                predators.add(a);
        }
    }

    public void predatorListTraverse(){
        for(Animal a : predators){
            System.out.print(a.getSpecies());
            if(!predators.getLast().equals(a))
                System.out.print(" <-> ");
        }
        System.out.println();
    }
}
