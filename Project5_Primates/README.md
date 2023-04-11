# Project 05: Primates

## Objective
To design and implement the model of a complex problem using proper object-oriented practices.

## Overview
The Jungle Friends Primate Sanctuary provides a permanent home and high-quality sanctuary care for New World primates who have been cast-off from the pet trade, retired from research, or confiscated by authorities. They are seeking to replace all of their paper records with computer records where they can keep track of the individual animals that are in their care. Your task in this assignment is to design and implement the model for such a system that can satisfy their needs:

The Sanctuary consists of two different types of housing:
- **Isolation** - is used to keep monkeys when they first arrive at the sanctuary and anytime they are receiving medical attention. Isolation consists of a series of cages each of which can house a single animal.
- **Enclosures** - are much larger and can host a single troop (i.e., a group) of monkeys. Each troop consists of a single species that is found in the New World (some of which are pictured below): drill, guereza, howler, mangabey, saki, spider, squirrel, and tamarin.

## Functionalities

- Each enclosure is configured to house a particular species of monkeys.

- Monkeys that are received by the sanctuary must first go into isolation. At this time, each individual monkey is given a name, a species designation, a sex, a size, a weight, an approximate age, and a favorite food. The choices of favorite food include eggs, fruits, insects, leaves, nuts, seeds, and tree sap.

- Monkeys that have received medical attention may be moved to an enclosure.

- The Sanctuary has room for twenty monkeys in isolation (cages) and eight enclosure spaces (one for each species of of monkeys).

- Produce a list for every enclosure that shows each individual monkey that is currently housed there. For each individual monkey, the list should include their name, sex, and favorite food.

- Produce an alphabetical list (by name) of all of the monkeys housed in the Sanctuary.

## Features
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

## Assumptions
- All first arrived monkeys must be added to isolation before moving to enclosure.
- All monkeys must have different names. The program will throw exception if you add another monkey with same name in the sanctuary.
- For monkey's species, you must only choose from these 8 kinds: DRILL, GUEREZA, HOWLER, MANGABEY, SAKI, SPIDER, SQUIRREL, TAMARIN.
- For monkey's sex, you must only choose from FEMALE or MALE.
- For monkey's size, you must only choose from LARGE, MEDIUM, or SMALL.
- For monkey's age, you must only choose non-negative integer numbers.
- For monkey's favorite food, you must only choose from EGGS, FRUITS, INSECTS, LEAVES, NUTS, SEEDS, or TREE_SAP.

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