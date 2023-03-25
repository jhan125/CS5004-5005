/**
 * Name: Jiali Han
 * Course: CS5008-5009
 * Lab5: Building Dungeons
 */

package dungeon;

import java.util.Arrays;

/** From Lab Instructions:
 *  This class is used to construct a level in a game that is set in a medieval fantasy.
 *  It will be  used to not only build a level for a game,
 *  but it will also ensure that all details of the game are consistent.
 */
public class MedievalLevelBuilder {
    // once this level is created, you can't change the target numbers in the game
    private final int numOfRooms;
    private final int numOfMonsters;
    private final int numOfTreasures;
    private final Level level;
    private int roomCount = 0;
    private int monsterCount = 0;
    private int treasureCount = 0;


    /**
     * MedievalLevelBuilder constructor.
     * Creates a MedievalLevelBuilder by taking the number of the levels
     * that is being created since most games have many levels.
     * It should also take non-negative values for the target number of rooms,
     * monsters, and treasures that the level is expected to have.
     *
     * @param numOfLevels The number of the level
     * @param numOfRooms  The target number of rooms
     * @param numOfMonsters  The target number of monsters
     * @param numOfTreasures The target number of treasures
     * @throws IllegalArgumentException  when any param value is negative
     */
    public MedievalLevelBuilder(int numOfLevels, int numOfRooms, int numOfMonsters,
                                int numOfTreasures) throws IllegalArgumentException {
        if (numOfLevels < 0 || numOfRooms < 0 || numOfMonsters < 0 || numOfTreasures < 0) {
            throw new IllegalArgumentException("Target numbers for MedievalLevelBuilder cannot be negative.");
        }
        this.numOfMonsters = numOfMonsters;
        this.numOfRooms = numOfRooms;
        this.numOfTreasures = numOfTreasures;
        this.level = new Level(numOfLevels);
    }

    /**
     * Adds a new room to this level.
     *
     * @param description the description of the room to add
     * @throws IllegalStateException  when there are too many rooms added to this level
     */
    public void addRoom(String description) throws IllegalStateException {
        if (roomCount + 1 > numOfRooms) {
            throw new IllegalStateException("Too many rooms are added to this level.");
        }
        level.addRoom(description);
        roomCount++;
    }

    /**
     * Adds a goblin-type monster to a room. (in Chinese: 妖精)
     * The addGoblins() method should add the specified number of goblins
     * to the specified room giving each 7 hit points.
     * They are quite numerous and often travel in packs.
     *
     * @param roomNumber the room number to add the monster to
     * @param numOfGoblins the number of goblins to add
     *
     * @throws IllegalArgumentException  when any param value is negative
     * @throws IllegalArgumentException  when the target room has not yet been created.
     * @throws IllegalStateException  when there are too many monsters added to this level
     */
    public void addGoblins(int roomNumber, int numOfGoblins)
            throws IllegalStateException, IllegalArgumentException {
        if (roomNumber < 0 || numOfGoblins < 0) {
            throw new IllegalArgumentException("Number of rooms and number of goblins cannot be negative.");
        }
        if (roomNumber + 1 > roomCount) {
            throw new IllegalArgumentException("Too many rooms are added to this level so the target room has not yet been created.");
        }
        if (monsterCount + numOfGoblins > this.numOfMonsters) {
            throw new IllegalStateException("Too many goblins are added to this level so the target number of monsters has already been reach.");
        }

        final String description = "mischievous and very unpleasant, vengeful, and greedy creature " +
                "whose primary purpose is to cause trouble to humankind.";
        final int goblinHitPoints = 7;
        final String name = "Goblin";

        // add goblins one by one to this room
        for (int i = 0; i < numOfGoblins; i++) {
            Monster monster = new Monster(name, description, goblinHitPoints);
            level.addMonster(roomNumber, monster);
            monsterCount++;
        }
    }

    /**
     * Adds an Orc-type monster to a room.(in Chinese: 半兽人)
     * The addOrc() method should add a single orc
     * to the specified room giving them 20 hit points.
     *
     * @param roomNumber the room number to add the monster to
     *
     * @throws IllegalArgumentException  when any param value is negative
     * @throws IllegalArgumentException  when the target room has not yet been created.
     * @throws IllegalStateException  when there are too many monsters added to this level
     */
    public void addOrc(int roomNumber)
            throws IllegalStateException, IllegalArgumentException {
        if (roomNumber + 1 > roomCount) {
            throw new IllegalArgumentException("Too many rooms are added to this level so the target room has not yet been created.");
        }
        if (monsterCount + 1 > this.numOfMonsters) {
            throw new IllegalStateException("Too many monsters are added to this level so the target number of monsters has already been reach.");
        }

        final String description = "brutish, aggressive, malevolent being serving evil "
                + "but tends to be more of a loner than the goblins.";
        final int orcHitPoints = 20;
        final String name = "Orc";

        // add orc to this room
        Monster monster = new Monster(name, description, orcHitPoints);
        level.addMonster(roomNumber, monster);
        monsterCount++;
    }

    /**
     * Adds an ogre-type monster to a room. (in Chinese: 食人魔)
     * The addOgre() method should add a single ogre
     * to the specified room giving them 50 hit points.
     *
     * @param roomNumber the room number to add the monster to
     *
     * @throws IllegalArgumentException  when any param value is negative
     * @throws IllegalArgumentException  when the target room has not yet been created.
     * @throws IllegalStateException  when there are too many monsters added to this level
     */
    public void addOgre(int roomNumber) throws IllegalStateException, IllegalArgumentException {
        if (roomNumber + 1 > roomCount) {
            throw new IllegalArgumentException("Too many rooms are added to this level so the target room has not yet been created.");
        }
        if (monsterCount + 1 > this.numOfMonsters) {
            throw new IllegalStateException("Too many monsters are added to this level so the target number of monsters has already been reach.");
        }

        final String description = "large, hideous man-like being that likes to eat humans for lunch.";
        final int ogreHitPoints = 50;
        final String name = "Ogre";

        // add ogre to this room
        Monster monster = new Monster(name, description, ogreHitPoints);
        level.addMonster(roomNumber, monster);
        monsterCount++;
    }

    /**
     * Adds a human-type monster to a room. (in Chinese: 人魔)
     * The addHuman() method should add a single human to the specified room.
     * The details of the human must be provided to the addHuman method.
     *
     * @param roomNumber the room number to add the monster to
     * @param name the name of human
     * @param description the description of human
     * @param humanHitPoints the final hit points of human
     *
     * @throws IllegalArgumentException  when any param value is negative
     * @throws IllegalArgumentException  when the target room has not yet been created.
     * @throws IllegalStateException  when there are too many monsters added to this level
     */
    public void addHuman(int roomNumber, String name, String description, final int humanHitPoints)
            throws IllegalStateException, IllegalArgumentException {
        if (roomNumber < 0) {
            throw new IllegalArgumentException("Number of rooms cannot be negative.");
        }
        if (roomNumber + 1 > roomCount) {
            throw new IllegalArgumentException("Too many rooms are added to this level so the target room has not yet been created.");
        }
        if (monsterCount + 1 > this.numOfMonsters) {
            throw new IllegalStateException("Too many monsters are added to this level so the target number of monsters has already been reach.");
        }

        // add human to this room
        Monster monster = new Monster(name, description, humanHitPoints);
        level.addMonster(roomNumber, monster);
        monsterCount++;
    }

    /**
     * Adds a potion-type treasure to a room. (in Chinese: 药水)
     * The addPotion method should add "a healing potion" (value = 1) to the specified room.
     *
     * @param roomNumber the room number to add the treasure to
     *
     * @throws IllegalArgumentException  when any param value is negative
     * @throws IllegalArgumentException  when the target room has not yet been created.
     * @throws IllegalStateException  when the target number of treasures has already been reach
     */
    public void addPotion(int roomNumber) throws IllegalStateException, IllegalArgumentException {
        if (roomNumber + 1 > roomCount) {
            throw new IllegalArgumentException("Too many rooms are added to this level so the target room has not yet been created.");
        }
        if (treasureCount + 1 > this.numOfTreasures) {
            throw new IllegalStateException("Too many treasures are added to this level so the target number of treasures has already been reach.");
        }

        final String description = "Healing potion";
        final int value = 1;

        // add treasure to this room
        Treasure treasure = new Treasure(description, value);
        level.addTreasure(roomNumber, treasure);
        treasureCount++;
    }

    /**
     * Adds a gold-type treasure to a room. (in Chinese: 金子)
     * The addGold method should add "pieces of gold" of the specified value to the specified room.
     *
     * @param roomNumber the room number to add the treasure to
     * @param value the value of gold treasure
     *
     * @throws IllegalArgumentException  when any param value is negative
     * @throws IllegalArgumentException  when the target room has not yet been created.
     * @throws IllegalStateException  when the target number of treasures has already been reach
     */
    public void addGold(int roomNumber, final int value) throws IllegalStateException, IllegalArgumentException {
        if (roomNumber + 1 > roomCount) {
            throw new IllegalArgumentException("Too many rooms are added to this level so the target room has not yet been created.");
        }
        if (treasureCount + 1 > this.numOfTreasures) {
            throw new IllegalStateException("Too many treasures are added to this level so the target number of treasures has already been reach.");
        }

        final String description = "Pieces of gold";

        // add treasure to this room
        Treasure treasure = new Treasure(description, value);
        level.addTreasure(roomNumber, treasure);
        treasureCount++;
    }

    /**
     * Adds a weapon-type treasure to a room. (in Chinese: 武器)
     * The addWeapon method should add the specified weapon to the specified room.
     * All weapons have a value equal to 10.
     *
     * @param roomNumber the room number to add the treasure to
     * @param description the description of weapon treasure
     *
     * @throws IllegalArgumentException  when any param value is negative
     * @throws IllegalArgumentException  when the target room has not yet been created.
     * @throws IllegalStateException  when the target number of treasures has already been reach
     */
    public void addWeapon(int roomNumber, final String description)
            throws IllegalStateException, IllegalArgumentException {
        if (roomNumber + 1 > roomCount) {
            throw new IllegalArgumentException("Too many rooms are added to this level so the target room has not yet been created.");
        }
        if (treasureCount + 1 > this.numOfTreasures) {
            throw new IllegalStateException("Too many treasures are added to this level so the target number of treasures has already been reach.");
        }

        final int value = 10;

        // add treasure to this room
        Treasure treasure = new Treasure(description, value);
        level.addTreasure(roomNumber, treasure);
        treasureCount++;
    }

    /**
     * Adds a special-type treasure to a room. (in Chinese: 特殊)
     * The addSpecial method should add "pieces of gold" of the specified value to the specified room.
     *
     * @param roomNumber the room number to add the treasure to
     * @param value the value of this special treasure
     *  @param description the description of this special treasure
     *
     * @throws IllegalArgumentException  when any param value is negative
     * @throws IllegalArgumentException  when the target room has not yet been created.
     * @throws IllegalStateException  when the target number of treasures has already been reach
     */
    public void addSpecial(int roomNumber, final String description, final int value) throws IllegalStateException, IllegalArgumentException {
        if (roomNumber < 0) {
            throw new IllegalArgumentException("Number of rooms cannot be negative.");
        }
        if (roomNumber + 1 > roomCount) {
            throw new IllegalArgumentException("Too many rooms are added to this level so the target room has not yet been created.");
        }
        if (treasureCount + 1 > this.numOfTreasures) {
            throw new IllegalStateException("Too many treasures are added to this level so the target number of treasures has already been reach.");
        }

        // add treasure to this room
        Treasure treasure = new Treasure(description, value);
        level.addTreasure(roomNumber, treasure);
        treasureCount++;
    }

    /**
     * Returns the level only after it has been completely constructed.
     *
     * @throws IllegalStateException  when it is called before completion
     */
    public Level build() throws IllegalStateException {
        if (roomCount != numOfRooms || monsterCount != numOfMonsters
                || treasureCount != numOfTreasures) {
            throw new IllegalStateException("Level is not completed yet, so the level cannot be build.");
        }
        return level;
    }
}
