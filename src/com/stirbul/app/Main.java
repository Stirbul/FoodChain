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
    Do this by using methods [objectName].setPray(Animal... prayArray) and
                             [objectName].setPredator(Animal... predatorArray)
    Then add this animal using Service.getAnimalAdjList().{add(), addAll()}
    Service methods are described in Service class
 */

public class Main {
    public static void main(String[] args) {
        //Creating objects
//        Wolf grayWolf = new Wolf("Gray Wolf",4,true,18,"forest",
//                30.0,55.0,2.0,"black",2,2);
        Wolf grayWolf = new Wolf.Builder("Gray Wolf")
                .hairColour("black")
                .numberOfLegs(4)
                .hasATail(true)
               ;

        Elk forestElk = new Elk("Forest Elk",4,true,18,"forest",
                50.0,95.0, 1.0,"brown",2,true,30);

        Mouse fieldMouse = new Mouse("Field Mouse",4,true,7, "Field",
                0.07,0.03,0.005,"grey",2, true,"red");

        Fox redFox = new Fox("Red Fox",4,true,18,"Forest",
                5.0,0.35, 0.3,"red",2,"high");

        Eagle goldenEagle = new Eagle("Golden Eagle",2,true,45,
                "mountain", 6.0, 4.0, 10000.0,2.03,"Curved",
                100,241);

        Pigeon passengerPigeon = new Pigeon("Passenger Pigeon",2,true,20,
                "Field",0.36,0.08, 3.0,0.5,"Straight",
                1000.0,false);

        Owl barnOwl = new Owl("Barn Owl",2,true,30,"forest",
                4.0,0.5, 5.0,0.7,"Curved","270",false);

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
        barnOwl.setPredator(redFox, grayWolf, goldenEagle);

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
