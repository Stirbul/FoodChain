package com.stirbul.app;

import com.stirbul.app.Animals.Animal;

import java.util.*;

/*
    <--traversePraysAdjList and traversePredatorAdjList-->
        Pringting the Adjacency Lists of predators and prays
    <--Sinling-->
        If 2 animals have the same number of Predators, than they are siblings
    <--isPredatorof and isPrayOf-->
        Check if one animal is predator(pray) of the other animal and return true/false
    <--findLoop-->
        Using util recursive method with the DFT logic
    <--TraversePredator and TraversePray-->
        Methods use DFT logic to traverse till the end of food chain
        In TraversePredator and TraversePray methods we use Random generation to pick every time different
        animal from the food chain, and by that pick different food chain
    <--   -->
        Methods getPray() and getPredator() returns a LinkedList
        You can use it for every animal, cause the methods are from the super class Animal
 */

public class Service {

    private static ArrayList<Animal> animalAdjList = new ArrayList<>();

    static ArrayList<Animal> getAnimalAdjList() {
        return animalAdjList;
    }

    //printing the ajacencyList
    static void traversePraysAdjList(){
        for(var s : animalAdjList){
            System.out.print(s.getSpecies() + " : ");
            s.getPray().prayListTraverse();
        }
    }

    static void traversePredatorAdjList(){
        for(var s : animalAdjList){
            System.out.print(s.getSpecies() + " : ");
            s.getPredator().predatorListTraverse();
        }
    }

    //Sibling Determination
    static boolean Sibling(Animal o1, Animal o2){
        return o1.getPredator().getPredatorList().size() == o2.getPredator().getPredatorList().size();
    }

    static boolean isPredatorOf(Animal predatorObject, Animal prayObject){
        return predatorObject.getPray().getPraysList().contains(prayObject);
    }

    static boolean isPrayOf(Animal prayObject ,Animal predatorObject){
        return prayObject.getPredator().getPredatorList().contains(predatorObject);
    }

    static void findLoop(Animal object){
        ArrayList<Animal> arList = new ArrayList<>();
        Boolean loopFound = Boolean.FALSE;
        findLoopUtil(object, arList, loopFound);
        HashSet<Animal> set = new HashSet<>(arList);
        if(set.size() < arList.size()){ // means that loop is found
            set.clear();
            System.out.println("Loop is found");
            System.out.print("<> ");
            for(var a : arList){
                System.out.print(a.getSpecies() + " <> ");
                if(!set.contains(a))
                    set.add(a);
                else
                    break;
            }
            System.out.println();
        }
    }


    private static void findLoopUtil(Animal object, ArrayList<Animal> set, Boolean loopFound) {
        int index = animalAdjList.indexOf(object);
        set.add(object);
        for (Animal n : animalAdjList.get(index).getPredator().getPredatorList()) {
            if (!set.contains(n) && !loopFound)
                findLoopUtil(n,set, loopFound);
            else {
                loopFound = Boolean.TRUE;
                set.add(n);
            }
        }

    }

    //Predator Traversal
    //simple DFT
    static void traversePredatorDFT(Animal predatorObject){
        //create boolean array so we dont have loops
        boolean visited[] = new boolean[animalAdjList.size()];
        //calling util method
        traversePredatorDFT_Util(predatorObject, visited);
    }

    //DFT Utility recursive method
    private static void traversePredatorDFT_Util(Animal predatorObject, boolean[] visited) {
        //index of predatorObject
        int predatorIndex = animalAdjList.indexOf(predatorObject);
        //make it true and print it
        visited[predatorIndex] = true;
        System.out.print(predatorObject.getSpecies());
        //if dont have next object || have next object, but it is already in [visited] put new line, else arrow(<-)
        if(!animalAdjList.get(predatorIndex).getPredator().getPredatorList().listIterator().hasNext()
                || animalAdjList.get(predatorIndex).getPredator().getPredatorList().listIterator().hasNext()
                && visited[animalAdjList.indexOf(
                animalAdjList.get(predatorIndex).getPredator().getPredatorList().listIterator().next())])
            System.out.print("\n");
        else
            System.out.print(" <- ");

        //iterating through predatorList
        //for (Animal n : animalAdjList.get(predatorIndex).getPredator().getPredatorList()) {
        Animal n = animalAdjList.get(predatorIndex).getPredator().getRandomPredator();
            if (n != null && !visited[animalAdjList.indexOf(n)])
                traversePredatorDFT_Util(n, visited);
        //}
    }

    //Pray Traversal
    static void traversePrayDFT(Animal prayObject){
        //create boolean array so we dont have loops
        boolean visited[] = new boolean[animalAdjList.size()];
        //calling util method
        traversePrayDFT_Util(prayObject, visited);
    }

    private static void traversePrayDFT_Util(Animal prayObject, boolean[] visited) {
        //index of predatorObject
        int prayIndex = animalAdjList.indexOf(prayObject);
        //make it true and print it
        visited[prayIndex] = true;
        System.out.print(prayObject.getSpecies());
        //if dont have next object || have next object, but it is already in [visited] put new line, else arrow(->)
        if(!animalAdjList.get(prayIndex).getPray().getPraysList().listIterator().hasNext()
                || animalAdjList.get(prayIndex).getPray().getPraysList().listIterator().hasNext()
                && visited[animalAdjList.indexOf(
                animalAdjList.get(prayIndex).getPray().getPraysList().listIterator().next())])
            System.out.print("\n");
        else
            System.out.print(" -> ");

        //iterating through predatorList
        //for (Animal n : animalAdjList.get(prayIndex).getPray().getPraysList()) {
        Animal n = animalAdjList.get(prayIndex).getPray().getRandomPray();
            if (n != null && !visited[animalAdjList.indexOf(n)])
                traversePrayDFT_Util(n, visited);
        //}
    }
}
