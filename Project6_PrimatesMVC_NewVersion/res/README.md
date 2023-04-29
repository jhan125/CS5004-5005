# Project 05: Primates

## About / Overview
The Jungle Friends Primate Sanctuary provides a permanent home and high-quality sanctuary care for New World primates who have been cast-off from the pet trade, retired from research, or confiscated by authorities. They are seeking to replace all of their paper records with computer records where they can keep track of the individual animals that are in their care. Your task in this assignment is to design and implement the model for such a system that can satisfy their needs:

The Sanctuary consists of two different types of housing:
- **Isolation** - is used to keep monkeys when they first arrive at the sanctuary and anytime they are receiving medical attention. Isolation consists of a series of cages each of which can house a single animal.
- **Enclosures** - are much larger and can host a single troop (i.e., a group) of monkeys. Each troop consists of a single species that is found in the New World (some of which are pictured below): drill, guereza, howler, mangabey, saki, spider, squirrel, and tamarin.

## List of Features

- Each enclosure is configured to house a particular species of monkeys.
- Monkeys that are received by the sanctuary must first go into isolation. At this time, each individual monkey is given a name, a species designation, a sex, a size, a weight, an approximate age, and a favorite food. The choices of favorite food include eggs, fruits, insects, leaves, nuts, seeds, and tree sap.
- Monkeys that have received medical attention may be moved to an enclosure.
- The Sanctuary has room for twenty monkeys in isolation (cages) and eight enclosure spaces (one for each species of of monkeys).
- Produce a list for every enclosure that shows each individual monkey that is currently housed there. For each individual monkey, the list should include their name, sex, and favorite food.
- Produce an alphabetical list (by name) of all of the monkeys housed in the Sanctuary.

### [Functionalities]
1. Create a `sanctuary` object with 20 `isolation` spaces (cages) and 8 `enclosure` spaces (one for each species of monkeys).
2. Create a `monkey` object given attributes of `name`, `species`, `sex`, `size`, `weight`, `age`, `favorite food`, and `health status`.
3. Add monkey to `isolation` when they first arrive at sanctuary.
4. Give warning if `isolation` already exists a monkey with same name.
5. Give warning if `isolation` is full and no more monkey can be added.
6. Remove monkey from `isolation` and add monkey to `enclosure` if they are healthy.
7. Give warning if `enclosure` already exists a monkey with same name.
8. Give warning if this monkey is not healthy to be added to `enclosure`.
9. Produce a `single enclosure list` that shows each individual monkey that is currently housed there. For each individual monkey, the list should include their name, sex, and favorite food.
10. Produce a `monkey list` as an alphabetical list (by name) of all monkeys housed in the Sanctuary.
11. Produce a `monkey list` as an alphabetical list (by name) of all monkeys housed in the Isolation.
12. Get a `monkey` object by its name attribute.
13. Treat a `monkey` and re-set its health status.
14. Check whether a `monkey` exists in the sanctuary, isolation, or enclosure.
15. Compare the names of `monkey` objects alphabetically.

## How to run this program

1. **Create a run configuration**
- Press `⌘ ⇧ A`, find and run the Edit Configurations action.
- In the `Run/Debug Configurations` dialog, click the `+` button and select `JAR Application`.
- Add a name for the new configuration.

2. **Execute the run configuration**
- On the toolbar, select the created configuration and click the `Run` button to the right of the run configuration selector. Alternatively, press ^ R if you prefer shortcuts.
- As before, the `Run` tool window opens and shows you the application output.
- If the process has exited successfully, then the application is packaged correctly.

***You can also find the .jar file from this path:***
```
📦Project6_PrimatesMVC
 ┗ 📂res
    ┗ 📂artifacts
       ┗ 📂Project6_PrimatesMVC_jar
          ┗ 📜Project6_PrimatesMVC.jar
```

- See detailed instructions with more screenshots:
https://www.jetbrains.com/help/idea/compiling-applications.html#run_packaged_jar

## How to use this program

1. **Register for a new monkey**

- To register a monkey, please use `tab1` and give a name to this monkey and then enter the following fields in correct ORDER: 
- name, species, sex, size, weight(double), age(int), favorite food, whether is healthy(true/false)
- Then click the button `Register`

```
Notice:
- All monkeys must have different names. The program will show you a warning message if you give two monkeys the same name.
- For monkey's SPECIES, you must only choose from these 8 kinds: DRILL, GUEREZA, HOWLER, MANGABEY, SAKI, SPIDER, SQUIRREL, TAMARIN.
- For monkey's SEX, you must only choose from FEMALE or MALE.
- For monkey's SIZE, you must only choose from LARGE, MEDIUM, or SMALL.
- For monkey's WEIGHT, you must only enter POSITIVE double numbers.
- For monkey's AGE, you must only enter NON-NEGATIVE integer numbers.
- For monkey's FAVORITE FOOD, you must only choose from EGGS, FRUITS, INSECTS, LEAVES, NUTS, SEEDS, or TREE_SAP.
```

2. **Move an existing monkey**

- To move a monkey, please use `tab2` and choose the name of the monkey you want to move from the combo box

- Then click one button below `Move this monkey to ISOLATION` / `Move this monkey to ENCLOSURE` 
```
Notice:
When monkeys first arrive at the sanctuary, they must first move to ISOLATION.
Therefore, first-arrived monkeys are ALREADY in the ISOLATION and you don't need to move them again.
If the monkey you want to move does not exist, the program will show you a warning message.
If the monkey you want to move already exists in that housing, the program will show you a warning message.
If you want to move a monkey to a full ISOLATION, the program will show you a warning message.
If you want to move an unhealthy monkey to ENCLOSURE, the program will show you a warning message.
        
```
3. **Treat an unhealthy monkey**

- To move a monkey to ENCLOSURE, you use `tab3` and treat this monkey to make it healthy.
- Choose the name of the monkey you want to treat from the combo box.
- Then click the button below `Treat this Monkey`

```
Notice:
To treat a monkey, choose the monkey by name you want to give medical treatment.
If the monkey you want to treat is already healthy, the program will show you a warning message.";     
```

4. **Produce a monkey list**

- To print a monkey list, you have to first choose the housing type from the combo box.
- Click the button `Get all monkeys in the SANCTUARY` to get an alphabetical list (by name) of all monkeys housed in the SANCTUARY.
- Click the button `Get all monkeys in the ISOLATION` to get an alphabetical list (by name) of all monkeys housed in the ISOLATION.
- Click the button `Get all monkeys in the ENCLOSURE` to get a list of all monkeys housed in that ENCLOSURE. For every enclosure, there's a list for each individual monkey that is currently housing there. For each individual monkey, the list includes their name, sex, and favorite food.

```
Notice:
If there's no monkey in that housing, the program will show you a warning message.   
```

## Design / Model Changes
1. When designing the `Model` for this program, I started with building 4 `enums` (i.e. Food, Species, Size, Sex) that will be used in this program.
2. Then I designed two Interfaces: `Housing interface` for Enclosure class and Isolation class, `Sanctuary interface` for SanctuaryImpl class, so I can maintain well-decoupled constructs.  
3. After that, I designed 4 `concrete classes` (i.e. Enclosure, Isolation, Monkey, SanctuaryImpl) that implement the corresponding interfaces. 
4. I decided to use `List` to store monkeys in Isolation and `Map` to store monkeys in Enclosure. Because Isolation only contains a collection of monkeys with no specific classification but Enclosure contains different species which needs to be stored as key-value pairs.
5. Based on those designs, I created a `UML diagram` to describe, analyze, and show program features and methods in the interfaces and classes. 
6. Then I wrote codes for each enum, interface and class.  
7. During this time, I made some `modifications` and `tests` to handle `exceptions` and `edge cases`.
8. After making sure my `Model` works as expected, I created a `Driver.class` to show a running example of my program.
9. Finally, I worked on building `Controller` and `View` while learning Swing, a Java GUI toolkit.
10. Last but not least, I tested and modified the program to make sure the `.jar file` shows important instructions and works as expected.

## Assumptions
- All first arrived monkeys are added to Isolation before moving to enclosure, so user doesn't need to move a first-arrived monkey to Isolation again.
- All monkeys must have different names. The program will throw exception if you add another monkey with same name in the sanctuary.
- User can name a monkey by numbers but the name will still be in String format and can't be the same.
- For monkey's SPECIES, user must only choose from these 8 kinds: DRILL, GUEREZA, HOWLER, MANGABEY, SAKI, SPIDER, SQUIRREL, TAMARIN.
- For monkey's SEX, user must only choose from FEMALE or MALE.
- For monkey's SIZE, user must only choose from LARGE, MEDIUM, or SMALL.
- For monkey's WEIGHT, user must only enter POSITIVE double numbers.
- For monkey's AGE, user must only enter NON-NEGATIVE integer numbers.
- For monkey's FAVORITE FOOD, user must only choose from EGGS, FRUITS, INSECTS, LEAVES, NUTS, SEEDS, or TREE_SAP.

## Limitations
1. Our program can't register for or hold monkeys who are given the same name.
2. Our program doesn't set a maximum capacity for each enclosure/species of monkeys.
3. Our program can't save records or data once you close the window and exit the program. 
4. Our program doesn't provide great appearance and can't be transferred easily to other UI development.

## Citations

Northeastern University. (n.d.). Project 6 - Primates MVC. Canvas. https://northeastern.instructure.com/courses/136689/assignments/1711175

Northeastern University. (n.d.). What Is A Readme. Canvas.https://northeastern.instructure.com/courses/136689/pages/what-is-a-readme

GeeksforGeeks. (2020, December 28). Sorting custom object by implementing comparable interface in Java. GeeksforGeeks. Retrieved April 12, 2023, from https://www.geeksforgeeks.org/sorting-custom-object-by-implementing-comparable-interface-in-java/

Level Up Coding. (2021, August 23). A Couple of Notes About Exceptions and Interfaces in Java. Medium. https://levelup.gitconnected.com/a-couple-of-notes-about-exceptions-and-interfaces-in-java-164775a22abc#:~:text=When%20writing%20an%20interface%2C%20you,provided%20for%20in%20the%20interface.

GeeksforGeeks. (2021, May 11). Java Swing | Creating Custom Message Dialogs. GeeksforGeeks. https://www.geeksforgeeks.org/java-swing-creating-custom-message-dialogs/?ref=lbp

GeeksforGeeks. (2021, May 11). Java Swing | JComboBox with examples. GeeksforGeeks. https://www.geeksforgeeks.org/java-swing-jcombobox-examples/?ref=lbp

GeeksforGeeks. (2021, May 11). Java Swing | lambda expression for ActionListener. GeeksforGeeks. https://www.codejava.net/java-core/the-java-language/java-8-lambda-listener-example

GeeksforGeeks. (2021, May 11). Java Swing | Reset/Clear JButton. GeeksforGeeks. https://stackoverflow.com/questions/5328945/how-to-clear-the-jtextfield-by-clicking-jbutton

GeeksforGeeks. (2021, May 11). Java Swing | Reset/Clear JComboBox. GeeksforGeeks. https://stackoverflow.com/questions/12048864/resetting-the-value-of-a-jcombobox

Level Up Coding. (2021, October 22). A Couple of Notes About Exceptions and Interfaces in Java. Medium. https://levelup.gitconnected.com/a-couple-of-notes-about-exceptions-and-interfaces-in-java-164775a22abc#:~:text=When%20writing%20an%20interface%2C%20you,provided%20for%20in%20the%20interface.


## Running Example
By implementing a Driver class (containing a main method), I showed how to use my solution classes and is capable of creating one run of my program that communicates to users how to specify commands to run the program.

This is a running example of my program.
It meets all the above specifications and requirements.

```
************************************************
Welcome to [Jungle Friends Primate Sanctuary] ;)
************************************************

Our Sanctuary has room for 20 monkeys in ISOLATION (cages)
and 8 ENCLOSURE spaces (one for each species of monkeys).

When monkeys first arrive at the sanctuary, they must first go into ISOLATION.
At this time, each individual monkey is given a name, a species designation, a sex, a size, a weight, an approximate age, and a favorite food.
The choices of favorite food include eggs, fruits, insects, leaves, nuts, seeds, and tree sap.

---------------------------------------------------
Yay! We got a new monkey in the sanctuary!!
name: Edward, sex: male, favorite food: leaves
---------------------------------------------------
Yay! We got a new monkey in the sanctuary!!
name: Finch, sex: male, favorite food: nuts
---------------------------------------------------
Yay! We got a new monkey in the sanctuary!!
name: Amy, sex: female, favorite food: fruits
---------------------------------------------------
Yay! We got a new monkey in the sanctuary!!
name: Betty, sex: female, favorite food: eggs
---------------------------------------------------
Yay! We got a new monkey in the sanctuary!!
name: Cecelia, sex: female, favorite food: nuts
---------------------------------------------------
Yay! We got a new monkey in the sanctuary!!
name: Donald, sex: male, favorite food: insects

-------------------------------------------------------------
NOTICE: If you try to put in a monkey with same name, e.g. Amy.
System will give you a warning.

-------------------------------------------------------------
WARNING: There exists a monkey with same name in the sanctuary already!

######################
#  SANCTUARY STATUS  #
######################
This is an alphabetical list (by name) of all monkeys housed in the Sanctuary.
Amy Betty Cecelia Donald Edward Finch

######################
#  ISOLATION STATUS  #
######################
This is an alphabetical list (by name) of all monkeys housed in the ISOLATION.
Amy Betty Cecelia Donald Edward Finch

######################
#  ENCLOSURE STATUS  #
######################
For every enclosure, there's a list for each individual monkey that is currently housed there.
For each individual monkey, the list includes their name, sex, and favorite food.

For Species.SQUIRREL:
There's no monkey under this species.

For Species.TAMARIN:
There's no monkey under this species.

For Species.DRILL:
There's no monkey under this species.

For Species.HOWLER:
There's no monkey under this species.

For Species.GUEREZA:
There's no monkey under this species.

--------------------------------------------------------------------------
Monkeys that are healthy may be moved to an ENCLOSURE.
--------------------------------------------------------------------------

######################
#  SANCTUARY STATUS  #
######################
This is an alphabetical list (by name) of all monkeys housed in the Sanctuary.
Amy Betty Cecelia Donald Edward Finch

######################
#  ISOLATION STATUS  #
######################
This is an alphabetical list (by name) of all monkeys housed in the ISOLATION.
Amy Betty

######################
#  ENCLOSURE STATUS  #
######################
For every enclosure, there's a list for each individual monkey that is currently housed there.
For each individual monkey, the list includes their name, sex, and favorite food.

For Species.SQUIRREL:
There's no monkey under this species.

For Species.TAMARIN:
name: Edward, sex: male, favorite food: leaves


For Species.DRILL:
There's no monkey under this species.

For Species.HOWLER:
name: Cecelia, sex: female, favorite food: nuts
name: Finch, sex: male, favorite food: nuts


For Species.GUEREZA:
name: Donald, sex: male, favorite food: insects


---------------------------------------------------
Unhealthy monkey is receiving a medical treatment!
---------------------------------------------------
Amy is healthy now!
Betty is healthy now!

--------------------------------------------------------------------------
Monkeys that have received medical attention may be moved to an ENCLOSURE.
--------------------------------------------------------------------------

######################
#  SANCTUARY STATUS  #
######################
This is an alphabetical list (by name) of all monkeys housed in the SANCTUARY.
Amy Betty Cecelia Donald Edward Finch

######################
#  ISOLATION STATUS  #
######################
This is an alphabetical list (by name) of all monkeys housed in the ISOLATION.
There's no monkey in the ISOLATION.

######################
#  ENCLOSURE STATUS  #
######################
For every enclosure, there's a list for each individual monkey that is currently housed there.
For each individual monkey, the list includes their name, sex, and favorite food.

For Species.SQUIRREL:
name: Amy, sex: female, favorite food: fruits


For Species.TAMARIN:
name: Edward, sex: male, favorite food: leaves


For Species.DRILL:
name: Betty, sex: female, favorite food: eggs


For Species.HOWLER:
name: Cecelia, sex: female, favorite food: nuts
name: Finch, sex: male, favorite food: nuts


For Species.GUEREZA:
name: Donald, sex: male, favorite food: insects


************************************************************
Thank you for visiting [Jungle Friends Primate Sanctuary] ;)
************************************************************


Process finished with exit code 0