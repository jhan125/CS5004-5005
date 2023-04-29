/**
 * Name: Jiali Han
 * Project 6: Primates MVC
 * Reference:
 * GUI Designer Basics:
 * https://www.jetbrains.com/help/idea/gui-designer-basics.html
 */

package view;
import controller.Controller;
import model.Monkey;
import model.Species;
import model.Sex;
import model.Size;
import model.Food;
import java.util.*;

/**
 * This interface defines the methods that the view
 * will use to interact with the controller.
 */
public interface View {

    /**
     * Shows error message in the window.
     *
     * @param message in String format
     */
    void showWarning(String message);

    /**
     * Shows success message in the window.
     *
     * @param successMessage in String format
     */
    void showMessage(String successMessage);

    /**
     * Shows the list in the window.
     *
     * @param list of monkeys in String format
     */
    void showList(String list);

    /**
     * Connects controller to this view.
     *
     * @param controller of this program
     */
    void connectController(Controller controller);

    /**
     * Update the monkeys in the Sanctuary after remove a monkey.
     *
     * @param monkeys a list of current housing monkeys
     */
    void updateMonkey(List<Monkey> monkeys);

    /**
     * Get user's input for the name of the monkey.
     *
     * @return name of this monkey in String format
     */
    String getName();

    /**
     * Get user's input for the weight of the monkey.
     *
     * @return weight of this monkey as double type
     */
    double getWeight();

    /**
     * Get user's input for the age of the monkey.
     *
     * @return age of this monkey as int type
     */
    int getAge();

    /**
     * Get user's input for the species of the monkey.
     *
     * @return species of this monkey as Species enum type
     */
    Species getSpecies();

    /**
     * Get user's input for the sex of the monkey.
     *
     * @return sex of this monkey as Sex enum type
     */
    Sex getSex();

    /**
     * Get user's input for the size of the monkey.
     *
     * @return size of this monkey as Size enum type
     */
    Size getSizeFromInput();

    /**
     * Get user's input for the favorite food of the monkey.
     *
     * @return species of this monkey as Food enum type
     */
    Food getFavFood();

    /**
     * Get user's input for the health status of the monkey.
     *
     * @return health status of this monkey as boolean type
     */
    boolean getHealth();

    /**
     * Reset & clear the attribute text fields for creating a monkey.
     */
    void resetMonkey();


    /**
     * Reset & clear the box for moving a monkey.
     */
    void resetMove();

    /**
     * Get all species in the enclosure.
     */
    Species getSpeciesInEnclosure();

    /**
     * Update the species for single enclosure list
     * after printing a species.
     */
    void resetSpecies();

    /**
     * Get the name of the monkey that the user want to move.
     *
     * @String name of the monkey that the user want to move
     */
    String getMoveName();

    /**
     * Get the name of the monkey that the user want to treat.
     *
     * @String name of the monkey that the user want to treat
     */
    String getTreatName();
}
