/**
 * Name: Jiali Han
 * Course: CS5008-5009
 * Lab5: Building Dungeons
 */

package dungeon;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


/**
 * This is a class that test constructor and methods
 * in MedievalLevelBuilder class.
 */
class MedievalLevelBuilderTest {
    // l1 is used to test the valid build
    MedievalLevelBuilder l1;
    // l2 is used to test exceptions in methods
    MedievalLevelBuilder l2;
    // l3 is used to test invalid build (when construction is not completed)
    MedievalLevelBuilder l3;

    @BeforeEach
    public void SetUp() {
        // l1 is to test legal build() method
        l1 = new MedievalLevelBuilder(1, 5, 25, 20);

        // l2 is to test IllegalStateExceptions in methods
        l2 = new MedievalLevelBuilder(2, 4, 20, 16);

        // l3 is to test Exception for build() method
        l3 = new MedievalLevelBuilder(3, 5, 25, 20);
    }

    /**
     * Test whether MedievalLevelBuilder can build Level object properly.
     */
    @Test
    public void testBuild() {
        // add 5 rooms, 25 monsters, and 20 treasures -> enough to build l1
        for (int i = 0; i < 5; i++) {
            // add room one by one
            l1.addRoom("Room " + i);
            // add 2 goblins to each room
            l1.addGoblins(i, 2);
            // add 1 orc to each room
            l1.addOrc(i);
            // add 1 ogre to each room
            l1.addOgre(i);
            // add 1 human to each room
            l1.addHuman(i, "Human " + i, "Human description", 10);
            // add 1 potion treasure to each room
            l1.addPotion(i);
            // add 1 gold treasure to each room
            l1.addGold(i, 10);
            // add 1 weapon treasure to each room
            l1.addWeapon(i, "Weapon " + i);
            // add 1 special treasure to each room
            l1.addSpecial(i, "Special " + i, 10);
        }

        // meet the requirement to build the level 1
        Level level1 = l1.build();
    }

    /**
     * Test the IllegalStateExceptions in the following methods:
     * addRoom, addGoblins, addOrc, addOgre, addHuman, addPotion, addGold, addWeapon, addSpecial
     */
    @Test
    public void testExceptions() throws IllegalStateException {
        // first add 4 rooms, 20 monsters, and 16 treasures to l2
        // this makes l2 full of rooms, monsters, and treasures, adding more room/monsters/treasures will throw Exception
        for (int i = 0; i < 4; i++) {
            // add room one by one 1*4=4
            l2.addRoom("Room");

            // add 2 goblins to each room 2*4=8
            l2.addGoblins(i, 2);
            // add 1 orc to each room 1*4 = 4
            l2.addOrc(i);
            // add 1 ogre to each room 1*4 = 4
            l2.addOgre(i);
            // add 1 human to each room 1*4 = 4
            l2.addHuman(i, "Human", "Human description", 10);

            // add 4 kind of treasures to each room 4*4 = 16
            l2.addPotion(i);
            l2.addGold(i, 10);
            l2.addWeapon(i, "Weapon");
            l2.addSpecial(i, "Special", 10);
        }

        // test Exception in AddRoom() method
        Exception exception = assertThrows(IllegalStateException.class, ()
                -> l2.addRoom("Room 5"), "Expected to throw IllegalStateException, but it didn't.");

        // test Exception in AddGoblins() method
        exception = assertThrows(IllegalStateException.class, ()
                -> l2.addGoblins(1,10), "Expected to throw IllegalStateException, but it didn't.");

        // test Exception in AddOrc() method
        exception = assertThrows(IllegalStateException.class, ()
                -> l2.addOrc(1), "Expected to throw IllegalStateException, but it didn't.");

        // test Exception in AddOgre() method
        exception = assertThrows(IllegalStateException.class, ()
                -> l2.addOgre(1), "Expected to throw IllegalStateException, but it didn't.");

        // test Exception in AddHuman() method
        exception = assertThrows(IllegalStateException.class, ()
                -> l2.addHuman(1, "Human", "Human description", 10), "Expected to throw IllegalStateException, but it didn't.");

        // test Exception in AddPotion() method
        exception = assertThrows(IllegalStateException.class, ()
                -> l2.addPotion(1), "Expected to throw IllegalStateException, but it didn't.");

        // test Exception in AddGold() method
        exception = assertThrows(IllegalStateException.class, ()
                -> l2.addGold(1, 10), "Expected to throw IllegalStateException, but it didn't.");

        // test Exception in AddWeapon() method
        exception = assertThrows(IllegalStateException.class, ()
                -> l2.addWeapon(1, "Weapon"), "Expected to throw IllegalStateException, but it didn't.");

        // test Exception in AddSpecial() method
        exception = assertThrows(IllegalStateException.class, ()
                -> l2.addSpecial(1, "Special ", 10), "Expected to throw IllegalStateException, but it didn't.");

    }

    /**
     * Test when MedievalLevelBuilder cannot complete building Level object.
     */
    @Test
    public void testBuildException() throws IllegalStateException {
        // only add 4 rooms, 20 monsters, and 16 treasures to l3
        // so the numbers of rooms, monsters, and treasures does not meet the numbers required
        for (int i = 0; i < 4; i++) {
            l3.addRoom("Room " + i);
            l3.addGoblins(i, 2);
            l3.addOrc(i);
            l3.addOgre(i);
            l3.addPotion(i);
            l3.addGold(i, 10);
            l3.addWeapon(i, "Weapon " + i);
            l3.addHuman(i, "Human", "Human description", 10);
        }

        // since it is called before completion, Exception will be thrown
        Exception exception = assertThrows(IllegalStateException.class, ()
                -> l3.build(), "Expected to throw IllegalStateException, but it didn't.");
    }
}