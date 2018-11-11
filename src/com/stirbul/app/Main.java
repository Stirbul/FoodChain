package com.stirbul.app;

import com.stirbul.app.animals.bird.Eagle;
import com.stirbul.app.animals.bird.Owl;
import com.stirbul.app.animals.bird.Pigeon;
import com.stirbul.app.animals.mammal.Elk;
import com.stirbul.app.animals.mammal.Fox;
import com.stirbul.app.animals.mammal.Mouse;
import com.stirbul.app.animals.mammal.Wolf;

import java.util.Arrays;
/*
                            <<---Main Idea--->>
                 ArrayList<Animal> animalAdjList = {

              LinkedList<Animal> preys  <-  wolf,  -> LinkedList<Animal> predators;
              LinkedList<Animal> preys  <-  eagle, -> LinkedList<Animal> predators;
                                             ...
                 }

    After creating an object of a class you need to specify its Preys and Predators
        or you can specify it using Builder method predator() or prey() --> look owl inst
    Do this by using methods [objectName].setPrey(Animal... preyArray) and
                             [objectName].setPredator(Animal... predatorArray)
    Then add this animal using Service.getAnimalAdjList().{add(), addAll()}
    Service methods are described in Service class
 */

public class Main {
    public static void main(String[] args) {
        //Creating objects with the help of Builder Design Pattern
        Wolf grayWolf = new Wolf.Builder("Gray Wolf")
                .brainWeight(12.3)
                .build();

        Elk forestElk = new Elk.Builder("Forest Elk")
                .hasHorns(true)
                .brainWeight(23.5)
                .build();

        Mouse fieldMouse = new Mouse.Builder("Field Mouse")
                .eyeColour("red")
                .habitat("Field")
                .build();

        Fox redFox = new Fox.Builder("Red Fox")
                .agilityLevel("high")
                .habitat("Forest")
                .build();

        Eagle goldenEagle = new Eagle.Builder("Golden Eagle")
                .vision(100)
                .divingSpeed(241)
                .habitat("Mountain")
                .build();

        Pigeon passengerPigeon = new Pigeon.Builder("Passenger Pigeon")
                .canSitOnBranch(false)
                .hasATail(true)
                .build();

        Owl barnOwl = new Owl.Builder("Barn Owl")
                .eyesMotion(false)
                .headRotate("270")
                .habitat("Forest")
                .predator(redFox)
                .build();

        //Setting predators and preys
        goldenEagle.setPrey(redFox, grayWolf, fieldMouse, passengerPigeon, barnOwl, redFox);
        // goldenEagle.setPredator(grayWolf);

        grayWolf.setPrey(forestElk, fieldMouse, redFox, goldenEagle, passengerPigeon, barnOwl);
        grayWolf.setPredator(goldenEagle);

        redFox.setPrey(fieldMouse, passengerPigeon, barnOwl);
        redFox.setPredator(grayWolf, goldenEagle);

        forestElk.setPredator(grayWolf);

        fieldMouse.setPredator(redFox,goldenEagle,barnOwl);

        barnOwl.setPrey(fieldMouse, passengerPigeon);
        barnOwl.setPredator(grayWolf, goldenEagle);

        passengerPigeon.setPredator(grayWolf, redFox, barnOwl, goldenEagle);


        //Adding all objects to Adjacency List
        Service.getAnimalAdjList().addAll(Arrays.asList(grayWolf,barnOwl,forestElk,fieldMouse,redFox,
                goldenEagle,passengerPigeon));

        //Traverse Predator Adjacency List
        System.out.println("\t\tPredator Adjacency List: \n");
        Service.traversePredatorAdjList();
        System.out.println("\n");

        //Traverse Predators
        System.out.println("\t\tTraverse Predators: \n");
        Service.traversePredatorDFT(passengerPigeon);
        System.out.println();
        Service.traversePredatorDFT(fieldMouse);
        System.out.println();
        System.out.println("\n");

        //Traverse Prey Adjacency List
        System.out.println("\t\tPrey Adjacency List: \n");
        Service.traversePreysAdjList();
        System.out.println();
        System.out.println("\n");

        //Traverse Preys
        System.out.println("\t\tTraverse Preys: \n");
        Service.traversePreyDFT(goldenEagle);
        Service.traversePreyDFT(grayWolf);
        System.out.println();
        System.out.println("\n");

        //checking Sibling
        System.out.println("\t\tSibling Check: \n");
        System.out.println(Service.Sibling(passengerPigeon, forestElk));
        System.out.println(Service.Sibling(goldenEagle,grayWolf));
        System.out.println("\n");

        //Finding Loop
        System.out.println("\t\tFinding Loop: \n");
        Service.findLoop(passengerPigeon);
        Service.findLoop(goldenEagle);
        Service.findLoop(forestElk);
        System.out.println("\n");

        //Checking for preys and predators
        System.out.println("\t\tChecking preys and predators: \n");
        System.out.println(Service.isPredatorOf(grayWolf,redFox));
        System.out.println(Service.isPredatorOf(forestElk,grayWolf));
        System.out.println(Service.isPreyOf(barnOwl,goldenEagle));
        System.out.println("\n");

        System.out.println("\t\thashCode() and equals() : \n");
        System.out.println("Gray Wolf hashCode() = " + grayWolf.hashCode());
    }
}
