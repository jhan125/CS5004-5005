/**
 * Name: Jiali Han
 * Project 5: Primates & Project 6: MVC
 */

package model;

/**
 * This class (containing a main method) shows how to use your solution classes.
 * It is capable of creating at least one run of your program that communicates to us
 * how to specify commands to run your program to verify that it meets all of the above specifications.
 * This class does not need to rely on input from the keyboard.
 */
public class Driver {

    /**
     * This main method is used to run the program.
     */
    public static void main(String[] args) {
        // 1. initialize a sanctuary with isolation and enclosure housings
        SanctuaryImpl sanctuary = new SanctuaryImpl();

        System.out.println("\n************************************************");
        System.out.println("Welcome to [Jungle Friends Primate Sanctuary] ;)");
        System.out.println("************************************************\n");

        System.out.println("Our Sanctuary has room for 20 monkeys in ISOLATION (cages) \nand 8 ENCLOSURE spaces (one for each species of monkeys).\n");


        // 2. initialize 6 monkeys with different attributes
        Monkey m1 = sanctuary.createMonkey("Amy", Species.SQUIRREL, Sex.FEMALE, Size.SMALL, 10, 3, Food.FRUITS, false);
        Monkey m2 = sanctuary.createMonkey("Betty", Species.DRILL, Sex.FEMALE, Size.LARGE, 50, 10, Food.EGGS, false);
        Monkey m3 = sanctuary.createMonkey("Cecelia", Species.HOWLER, Sex.FEMALE, Size.MEDIUM, 30, 8, Food.NUTS, true);
        Monkey m4 = sanctuary.createMonkey("Donald", Species.GUEREZA, Sex.MALE, Size.LARGE, 80, 7, Food.INSECTS, true);
        Monkey m5 = sanctuary.createMonkey("Edward", Species.TAMARIN, Sex.MALE, Size.MEDIUM, 60, 6, Food.LEAVES, true);
        Monkey m6 = sanctuary.createMonkey("Finch", Species.HOWLER, Sex.MALE, Size.MEDIUM, 30, 8, Food.NUTS, true);

        // 3. add all first-arrived monkeys to isolation in non-alphabetical order
        System.out.println("When monkeys first arrive at the sanctuary, they must first go into ISOLATION.");
        System.out.println("At this time, each individual monkey is given a name, a species designation, a sex, a size, a weight, an approximate age, and a favorite food. \nThe choices of favorite food include eggs, fruits, insects, leaves, nuts, seeds, and tree sap.\n");

        sanctuary.addMonkeyToIsolation(m5);
        System.out.println("---------------------------------------------------");
        System.out.println("Yay! We got a new monkey in the sanctuary!!");
        System.out.println(m5.toString());

        sanctuary.addMonkeyToIsolation(m6);
        System.out.println("---------------------------------------------------");
        System.out.println("Yay! We got a new monkey in the sanctuary!!");
        System.out.println(m6.toString());

        sanctuary.addMonkeyToIsolation(m1);
        System.out.println("---------------------------------------------------");
        System.out.println("Yay! We got a new monkey in the sanctuary!!");
        System.out.println(m1.toString());

        sanctuary.addMonkeyToIsolation(m2);
        System.out.println("---------------------------------------------------");
        System.out.println("Yay! We got a new monkey in the sanctuary!!");
        System.out.println(m2.toString());

        sanctuary.addMonkeyToIsolation(m3);
        System.out.println("---------------------------------------------------");
        System.out.println("Yay! We got a new monkey in the sanctuary!!");
        System.out.println(m3.toString());

        sanctuary.addMonkeyToIsolation(m4);
        System.out.println("---------------------------------------------------");
        System.out.println("Yay! We got a new monkey in the sanctuary!!");
        System.out.println(m4.toString());

        // NOTICE: If you put another monkey with same name,
        // system will print there exists this monkey already in the sanctuary

        System.out.println("\n-------------------------------------------------------------");
        System.out.println("NOTICE: If you try to put in a monkey with same name, e.g. Amy.");
        System.out.println("System will give you a warning.");

        System.out.println("\n-------------------------------------------------------------");
        try {
            Monkey m7 = sanctuary.createMonkey("Amy", Species.SQUIRREL, Sex.FEMALE, Size.SMALL, 10, 3, Food.FRUITS, false);
            sanctuary.addMonkeyToIsolation(m7);
        } catch (Exception e) {
            System.out.println("WARNING: There exists a monkey with same name in the sanctuary already!");
        }


        // 4. print out current housing status

        // print out a monkey list of all monkeys living in sanctuary
        System.out.println();
        System.out.println("######################");
        System.out.println("#  SANCTUARY STATUS  #");
        System.out.println("######################");
        System.out.println("This is an alphabetical list (by name) of all monkeys housed in the Sanctuary.");
        System.out.println(sanctuary.getAlphabetMonkeyList());

        // print out a monkey list of all monkeys living in isolation (6 monkeys now)
        System.out.println();
        System.out.println("######################");
        System.out.println("#  ISOLATION STATUS  #");
        System.out.println("######################");
        try{
            System.out.println("This is an alphabetical list (by name) of all monkeys housed in the ISOLATION.");
            System.out.println(sanctuary.getIsolationMonkeyList());
        } catch (Exception e) {
            System.out.println("There's no monkey in the ISOLATION.");
        }

        // print out a monkey list of all monkeys living in enclosure (0 monkey now)
        System.out.println();
        System.out.println("######################");
        System.out.println("#  ENCLOSURE STATUS  #");
        System.out.println("######################");
        System.out.println("For every enclosure, there's a list for each individual monkey that is currently housed there.\n" +
                "For each individual monkey, the list includes their name, sex, and favorite food.\n");

        System.out.println("For Species.SQUIRREL:");
        try {
            System.out.println(sanctuary.getSingleEnclosureList(Species.SQUIRREL));
        } catch (Exception e) {
            System.out.println("There's no monkey under this species.");
        }

        System.out.println();
        System.out.println("For Species.TAMARIN:");
        try{
            System.out.println(sanctuary.getSingleEnclosureList(Species.TAMARIN));
        } catch (Exception e) {
            System.out.println("There's no monkey under this species.");
        }

        System.out.println();
        System.out.println("For Species.DRILL:");
        try{
            System.out.println(sanctuary.getSingleEnclosureList(Species.DRILL));
        } catch (Exception e) {
            System.out.println("There's no monkey under this species.");
        }

        System.out.println();
        System.out.println("For Species.HOWLER:");
        try{
            System.out.println(sanctuary.getSingleEnclosureList(Species.HOWLER));
        } catch (Exception e) {
            System.out.println("There's no monkey under this species.");
        }

        System.out.println();
        System.out.println("For Species.GUEREZA:");
        try{
            System.out.println(sanctuary.getSingleEnclosureList(Species.GUEREZA));
        } catch (Exception e) {
            System.out.println("There's no monkey under this species.");
        }

        // 5. put all healthy monkeys (3, 4, 5, 6) to enclosure
        System.out.println();
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("Monkeys that are healthy may be moved to an ENCLOSURE.");
        System.out.println("--------------------------------------------------------------------------");

        sanctuary.addMonkeyToEnclosure(m3);
        sanctuary.addMonkeyToEnclosure(m4);
        sanctuary.addMonkeyToEnclosure(m5);
        sanctuary.addMonkeyToEnclosure(m6);

        // 6. print out current housing status

        // print out a monkey list of all monkeys living in sanctuary
        // this is an alphabetical list (by name) of all monkeys housed in the Sanctuary.
        System.out.println();
        System.out.println("######################");
        System.out.println("#  SANCTUARY STATUS  #");
        System.out.println("######################");
        System.out.println("This is an alphabetical list (by name) of all monkeys housed in the Sanctuary.");
        System.out.println(sanctuary.getAlphabetMonkeyList());

        // print out a monkey list of all monkeys living in isolation (0 monkey)
        System.out.println();
        System.out.println("######################");
        System.out.println("#  ISOLATION STATUS  #");
        System.out.println("######################");
        System.out.println("This is an alphabetical list (by name) of all monkeys housed in the ISOLATION.");
        System.out.println(sanctuary.getIsolationMonkeyList().toString());

        // print out a monkey list of all monkeys living in enclosure

        // for every enclosure, there's a list shows each individual monkey that is currently housed there.
        // For each individual monkey, the list should include their name, sex, and favorite food.
        System.out.println();
        System.out.println("######################");
        System.out.println("#  ENCLOSURE STATUS  #");
        System.out.println("######################");
        System.out.println("For every enclosure, there's a list for each individual monkey that is currently housed there.\n" +
                "For each individual monkey, the list includes their name, sex, and favorite food.\n");

        System.out.println("For Species.SQUIRREL:");
        try {
            System.out.println(sanctuary.getSingleEnclosureList(Species.SQUIRREL));
        } catch (Exception e) {
            System.out.println("There's no monkey under this species.");
        }

        System.out.println();
        System.out.println("For Species.TAMARIN:");
        try{
            System.out.println(sanctuary.getSingleEnclosureList(Species.TAMARIN));
        } catch (Exception e) {
            System.out.println("There's no monkey under this species.");
        }

        System.out.println();
        System.out.println("For Species.DRILL:");
        try{
            System.out.println(sanctuary.getSingleEnclosureList(Species.DRILL));
        } catch (Exception e) {
            System.out.println("There's no monkey under this species.");
        }

        System.out.println();
        System.out.println("For Species.HOWLER:");
        try{
            System.out.println(sanctuary.getSingleEnclosureList(Species.HOWLER));
        } catch (Exception e) {
            System.out.println("There's no monkey under this species.");
        }

        System.out.println();
        System.out.println("For Species.GUEREZA:");
        try{
            System.out.println(sanctuary.getSingleEnclosureList(Species.GUEREZA));
        } catch (Exception e) {
            System.out.println("There's no monkey under this species.");
        }

        // 7. treat monkeys that are unhealthy
        System.out.println();
        System.out.println("---------------------------------------------------");
        System.out.println("Unhealthy monkey is receiving a medical treatment!");
        System.out.println("---------------------------------------------------");
        m1.makeHealthy();
        m2.makeHealthy();

        // 8. put treated monkeys to enclosure
        System.out.println();
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("Monkeys that have received medical attention may be moved to an ENCLOSURE.");
        System.out.println("--------------------------------------------------------------------------");

        sanctuary.addMonkeyToEnclosure(m1);
        sanctuary.addMonkeyToEnclosure(m2);

        // 7. print out current housing status

        // print out a monkey list of all monkeys living in sanctuary
        // this is an alphabetical list (by name) of all monkeys housed in the Sanctuary.
        System.out.println();
        System.out.println("######################");
        System.out.println("#  SANCTUARY STATUS  #");
        System.out.println("######################");
        System.out.println("This is an alphabetical list (by name) of all monkeys housed in the SANCTUARY.");
        System.out.println(sanctuary.getAlphabetMonkeyList());

        // print out a monkey list of all monkeys living in isolation (0 monkey)
        System.out.println();
        System.out.println("######################");
        System.out.println("#  ISOLATION STATUS  #");
        System.out.println("######################");
        try{
            System.out.println("This is an alphabetical list (by name) of all monkeys housed in the ISOLATION.");
            System.out.println(sanctuary.getIsolationMonkeyList());
        } catch (Exception e) {
            System.out.println("There's no monkey in the ISOLATION.");
        }

        // print out a monkey list of all monkeys living in enclosure

        // for every enclosure, there's a list shows each individual monkey that is currently housed there.
        // For each individual monkey, the list should include their name, sex, and favorite food.
        System.out.println();
        System.out.println("######################");
        System.out.println("#  ENCLOSURE STATUS  #");
        System.out.println("######################");
        System.out.println("For every enclosure, there's a list for each individual monkey that is currently housed there.\n" +
                            "For each individual monkey, the list includes their name, sex, and favorite food.\n");

        System.out.println("For Species.SQUIRREL:");
        try {
            System.out.println(sanctuary.getSingleEnclosureList(Species.SQUIRREL));
        } catch (Exception e) {
            System.out.println("There's no monkey under this species.");
        }

        System.out.println();
        System.out.println("For Species.TAMARIN:");
        try{
            System.out.println(sanctuary.getSingleEnclosureList(Species.TAMARIN));
        } catch (Exception e) {
            System.out.println("There's no monkey under this species.");
        }

        System.out.println();
        System.out.println("For Species.DRILL:");
        try{
            System.out.println(sanctuary.getSingleEnclosureList(Species.DRILL));
        } catch (Exception e) {
            System.out.println("There's no monkey under this species.");
        }

        System.out.println();
        System.out.println("For Species.HOWLER:");
        try{
            System.out.println(sanctuary.getSingleEnclosureList(Species.HOWLER));
        } catch (Exception e) {
            System.out.println("There's no monkey under this species.");
        }

        System.out.println();
        System.out.println("For Species.GUEREZA:");
        try{
            System.out.println(sanctuary.getSingleEnclosureList(Species.GUEREZA));
        } catch (Exception e) {
            System.out.println("There's no monkey under this species.");
        }


        System.out.println("\n************************************************************");
        System.out.println("Thank you for visiting [Jungle Friends Primate Sanctuary] ;)");
        System.out.println("************************************************************\n");
    }
}
