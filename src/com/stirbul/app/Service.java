package com.stirbul.app;

import com.stirbul.app.Animals.Animal;

import java.util.*;

/*
    <--traversePreysAdjList and traversePredatorAdjList-->
        Printing the Adjacency Lists of predators and preys
    <--Sibling-->
        If 2 animals have the same number of Predators, than they are siblings
    <--isPredatorOf and isPreyOf-->
        Check if one animal is predator(prey) of the other animal and return true/false
    <--findLoop-->
        Using util recursive method with the DFT logic
    <--TraversePredator and TraversePrey-->
        Methods use DFT logic to traverse till the end of food chain
        In TraversePredator and TraversePrey methods we use Random generation to pick every time different
        animal from the food chain, and by that pick different food chain
    <--   -->
        Methods getPrey() and getPredator() returns a LinkedList
        You can use it for every animal, cause the methods are from the super class Animal
 */

public class Service {

    private static ArrayList<Animal> animalAdjList = new ArrayList<>();

    static ArrayList<Animal> getAnimalAdjList() {
        return animalAdjList;
    }

    //printing the ajacencyList
    static void traversePreysAdjList(){
        for(var s : animalAdjList){
            System.out.print(s.getSpecies() + " : ");
            s.getPrey().preyListTraverse();
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

    static boolean isPredatorOf(Animal predatorObject, Animal preyObject){
        return predatorObject.getPrey().getPreysList().contains(preyObject);
    }

    static boolean isPreyOf(Animal preyObject ,Animal predatorObject){
        return preyObject.getPredator().getPredatorList().contains(predatorObject);
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
    static void traversePredatorDFT(Animal predatorObject) throws IllegalArgumentException{
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
        //iterating through predatorList
        //for (Animal n : animalAdjList.get(predatorIndex).getPredator().getPredatorList()) {
        Animal n = animalAdjList.get(predatorIndex).getPredator().getRandomPredator();
        try{
            if(n == null)
                throw new IllegalArgumentException();
            else {
                //if dont have next object || have next object,
                // but it is already in [visited] put new line, else arrow(->)
                if(!predatorObject.getPredator().getPredatorList().contains(n) ||
                        predatorObject.getPredator().getPredatorList().contains(n) &&
                                visited[animalAdjList.indexOf(n)])
                    System.out.println("\n");
                else
                    System.out.print(" -> ");
            }
        }catch (Exception e){
            System.out.println("\nException. The object does not" +
                    " have predator -- " + e.getMessage());
            return;
        }
        if (/*n!= null &&*/ !visited[animalAdjList.indexOf(n)])
            traversePredatorDFT_Util(n, visited);
        //}
    }

    //Prey Traversal
    static void traversePreyDFT(Animal preyObject){
        //create boolean array so we dont have loops
        boolean visited[] = new boolean[animalAdjList.size()];
        //calling util method
        traversePreyDFT_Util(preyObject, visited);
    }

    private static void traversePreyDFT_Util(Animal preyObject, boolean[] visited) {
        //index of predatorObject
        int preyIndex = animalAdjList.indexOf(preyObject);
        //make it true and print it
        visited[preyIndex] = true;
        System.out.print(preyObject.getSpecies());
        //iterating through predatorList
        //for (Animal n : animalAdjList.get(preyIndex).getPrey().getPreysList()) {
        Animal n = animalAdjList.get(preyIndex).getPrey().getRandomPrey();
        try{
            if(n == null)
                throw new IllegalArgumentException();
            else {
                //if dont have next object || have next object,
                // but it is already in [visited] put new line, else arrow(->)

                if(!preyObject.getPrey().getPreysList().contains(n) ||
                        preyObject.getPrey().getPreysList().contains(n) &&
                        visited[animalAdjList.indexOf(n)])
                    System.out.println("\n");
                else
                    System.out.print(" -> ");
            }
        }catch (Exception e){
            System.out.println("\nException. The object does not" +
                    " have prey -- " + e.getMessage());
            return;
        }
        if (/* n != null  && */ !visited[animalAdjList.indexOf(n)])
                traversePreyDFT_Util(n, visited);
        //}
    }
}
