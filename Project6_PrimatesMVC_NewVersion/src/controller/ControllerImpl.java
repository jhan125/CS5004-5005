/**
 * Name: Jiali Han
 * Project 6: Primates MVC
 */

package controller;

import model.SanctuaryImpl;
import model.Monkey;
import model.Species;
import view.JFrameView;

/**
 * This class implements Controller Interface and
 * is used to handle user input and interact with the model and view.
 */
public class ControllerImpl implements Controller {
    private final SanctuaryImpl model;
    private final JFrameView view;

    /**
     * Construct the controller with give model and view.
     *
     * @param model of this program
     * @param view of this program
     */
    public ControllerImpl(SanctuaryImpl model, JFrameView view) {
        this.model = model;
        this.view = view;
        view.connectController(this);
    }

    @Override
    public void createMonkey() {
        try {
            // 1) create a monkey by user's input of each field
            // params: String name, Species species, Sex sex, Size size, double weight, int age, Food favFood, boolean health
            Monkey m = model.createMonkey(view.getName(), view.getSpecies(), view.getSex(), view.getSizeFromInput(), view.getWeight(),
                    view.getAge(), view.getFavFood(), view.getHealth());
            // 2) add this monkey to isolation
            model.addMonkeyFirstToSanctuary(m);
            // 3) update monkeys in the sanctuary
            view.updateMonkey(model.getMonkeyList());
            // 4) if this action succeeds, print a success message to user
            view.showMessage("You registered a monkey successfully!");
        } catch (Exception e) {
            // 5) if fails, print a warning/error message
            view.showWarning(e.getMessage());
        }
        // 6) reset & clear all input fields
        view.resetMonkey();
    }

    @Override
    public void addToIsolation() {
        try {
            // 1) find this monkey by user's input of monkey's name
            Monkey m = model.getMonkey(view.getMoveName());
            // 2) add this monkey to isolation
            model.addMonkeyToIsolation(m);
            // 3) if this action succeeds, print a success message to user
            view.showMessage("You moved a monkey to ISOLATION successfully!");
        } catch (Exception e) {
            // 4) if fails, print a warning/error message
            view.showWarning(e.getMessage());
        }
        // 5) reset & clear the move action
        view.resetMove();
    }

    @Override
    public void addToEnclosure() {
        try {
            // 1) find this monkey by user's input of monkey's name
            Monkey m = model.getMonkey(view.getMoveName());
            // 2) add this monkey to enclosure
            model.addMonkeyToEnclosure(m);
            // 3) if this action succeeds, print a success message to user
            view.showMessage("You moved a monkey to ENCLOSURE successfully!");
        } catch (Exception e) {
            // 4) if fails, print a warning/error message
            view.showWarning(e.getMessage());
        }
        // 5) reset & clear the move action
        view.resetMove();
    }

    @Override
    public void treatMonkey() {
        try {
            // 1) find this monkey by user's input of monkey's name
            Monkey m = model.getMonkey(view.getTreatName());
            // 2) treat this monkey
            model.treatMonkey(m);
            // 3) if this action succeeds, print a success message to user
            view.showMessage("You treated this monkey successfully!");
        } catch (Exception e) {
            // 4) if fails, print a warning/error message
            view.showWarning(e.getMessage());
        }
    }

    @Override
    public void getEnclosureList() {
        try {
            // 1) get the species in the enclosure
            Species s = view.getSpeciesInEnclosure();
            // 2) get this single enclosure list by species
            String enclosure = model.getSingleEnclosureList(s);
            // 3) if this action succeeds, print a success message to user
            view.showList(enclosure);
        } catch (Exception e) {
            // 4) if fails, print a warning/error message
            view.showWarning(e.getMessage());
        }
        // 5) reset & clear the species field
        view.resetSpecies();
    }

    @Override
    public void getSanctuaryList() {
        try {
            // 1) get the list of monkeys in the sanctuary
            String s = model.getAlphabetMonkeyList();
            // 2) if this action succeeds, print a success message to user
            view.showList(s);
        } catch (Exception e) {
            // 3) if fails, print a warning/error message
            view.showWarning(e.getMessage());
        }
    }

    @Override
    public void getIsolationList() {
        try {
            // 1) get the list of monkeys in the isolation
            String s = model.getIsolationMonkeyList();
            // 2) if this action succeeds, print a success message to user
            view.showList(s);
        } catch (Exception e) {
            // 3) if fails, print a warning/error message
            view.showWarning(e.getMessage());
        }
    }
}
