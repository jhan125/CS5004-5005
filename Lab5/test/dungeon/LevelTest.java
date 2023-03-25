/**
 * Name: Jiali Han
 * Course: CS5008-5009
 * Lab5: Building Dungeons
 */

package dungeon;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LevelTest {
    Level l1;
    Monster m;
    Treasure t;

    @BeforeEach
    public void setUp() {
        l1 = new Level(1);
        m = new Monster("Monster", "Horrible monster", 10);
        t = new Treasure("Treasure", 10);
    }

    @Test
    public void testLevel() {
        l1 = new Level(1);
    }

    @Test
    public void testGetLevelNumber() {
        assertEquals(1, l1.getLevelNumber());
    }

    /** Tests addRoom, addMonster, addTreasure, and toString methods.
     */
    @Test
    public void testToString() {

        for (int i = 0; i < 5; i++) {
            // add room one by one
            l1.addRoom("Room " + (i+1) + "\n");
            // add 1 monster to each room
            l1.addMonster(i, m);
            // add 1 treasure to each room
            l1.addTreasure(i, t);
        }

        String expected = "Level 1 contains 5 rooms:\n" +
                "Room 1\n" + "Monsters:\n" + "\tMonster (hitpoints = 10) is a Horrible monster\n" + "Treasures:\n" + "\tTreasure (value = 10)\n" + "\n" +
                "Room 2\n" + "Monsters:\n" + "\tMonster (hitpoints = 10) is a Horrible monster\n" + "Treasures:\n" + "\tTreasure (value = 10)\n" + "\n" +
                "Room 3\n" + "Monsters:\n" + "\tMonster (hitpoints = 10) is a Horrible monster\n" + "Treasures:\n" + "\tTreasure (value = 10)\n" + "\n" +
                "Room 4\n" + "Monsters:\n" + "\tMonster (hitpoints = 10) is a Horrible monster\n" + "Treasures:\n" + "\tTreasure (value = 10)\n" + "\n" +
                "Room 5\n" + "Monsters:\n" + "\tMonster (hitpoints = 10) is a Horrible monster\n" + "Treasures:\n" + "\tTreasure (value = 10)\n" + "\n";
        System.out.println(l1.toString());
        assertEquals(expected, l1.toString());
    }
}