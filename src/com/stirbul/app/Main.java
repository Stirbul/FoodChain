package com.stirbul.app;

import com.stirbul.app.Animals.Bird.Eagle;
import com.stirbul.app.Animals.Bird.Owl;
import com.stirbul.app.Animals.Bird.Pigeon;
import com.stirbul.app.Animals.Mammal.Elk;
import com.stirbul.app.Animals.Mammal.Fox;
import com.stirbul.app.Animals.Mammal.Mouse;
import com.stirbul.app.Animals.Mammal.Wolf;

import java.util.Arrays;
/*
                            <<---Main Idea--->>
                 ArrayList<Animal> animalAdjList = {

              LinkedList<Animal> prays  <-  wolf,  -> LinkedList<Animal> predators;
              LinkedList<Animal> prays  <-  eagle, -> LinkedList<Animal> predators;
                                             ...
                 }

    After creating an object of a class you need to specify its Prays and Predators
        or you can specify it using Builder method predator() or pray() --> look owl inst
    Do this by using methods [objectName].setPray(Animal... prayArray) and
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

        //Setting predators and prays
        goldenEagle.setPray(redFox, grayWolf, fieldMouse, passengerPigeon, barnOwl, redFox);
        goldenEagle.setPredator(grayWolf);

        grayWolf.setPray(forestElk, fieldMouse, redFox, goldenEagle, passengerPigeon, barnOwl);
        grayWolf.setPredator(goldenEagle);

        redFox.setPray(fieldMouse, passengerPigeon, barnOwl);
        redFox.setPredator(grayWolf, goldenEagle);

        forestElk.setPredator(grayWolf);

        fieldMouse.setPredator(redFox,goldenEagle,barnOwl);

        barnOwl.setPray(fieldMouse, passengerPigeon);
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

        //Traverse Pray Adjacency List
        System.out.println("\t\tPray Adjacency List: \n");
        Service.traversePraysAdjList();
        System.out.println();
        System.out.println("\n");

        //Traverse Prays
        System.out.println("\t\tTraverse Prays: \n");
        Service.traversePrayDFT(goldenEagle);
        Service.traversePrayDFT(grayWolf);
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

        //Checking for prays and predators
        System.out.println("\t\tChecking prays and predators: \n");
        System.out.println(Service.isPredatorOf(grayWolf,redFox));
        System.out.println(Service.isPredatorOf(forestElk,grayWolf));
        System.out.println(Service.isPrayOf(barnOwl,goldenEagle));
        System.out.println("\n");
    }
}
