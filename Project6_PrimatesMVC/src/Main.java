/**
 * Name: Jiali Han
 * Project 6: Primates MVC
 * Reference:
 * How to build JARs from IntelliJ:
 * https://stackoverflow.com/questions/1082580/how-to-build-jars-from-intellij-properly
 */

import model.SanctuaryImpl;
import view.JFrameView;
import controller.ControllerImpl;

/**
 * This main class is to run the whole program
 * and connects Model, View, and Controller.
 */
public class Main {
    public static void main(String[] args) {
        SanctuaryImpl model = new SanctuaryImpl();
        JFrameView view = new JFrameView("Primates Sanctuary");
        ControllerImpl controller = new ControllerImpl(model, view);
    }
}