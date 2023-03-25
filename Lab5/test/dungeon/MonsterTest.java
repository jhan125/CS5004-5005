/**
 * Name: Jiali Han
 * Course: CS5008-5009
 * Lab5: Building Dungeons
 */

package dungeon;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MonsterTest {
    Monster m;
    @BeforeEach
    public void setUp() {
        m = new Monster("Monster", "Horrible Monster", 10);
    }

    @Test
    public void testMonster() {
        m = new Monster("Monster", "Horrible Monster", 10);
    }

    @Test
    public void testGetName() {
        assertEquals("Monster", m.getName());
    }

    @Test
    public void testGetDescription() {
        assertEquals("Horrible Monster", m.getDescription());
    }

    @Test
    public void testGetHitpoints() {
        assertEquals(10, m.getHitpoints());
    }

    @Test
    public void testToString() {
        String s = "Monster (hitpoints = 10) is a Horrible Monster";
        assertEquals(s, m.toString());
    }
}