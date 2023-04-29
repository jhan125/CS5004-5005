/**
 * Name: Jiali Han
 * Project 6: Primates MVC
 * References:
 * 1. Java Swing | Message Dialogs in Java (GUI)
 * https://www.geeksforgeeks.org/message-dialogs-java-gui/
 * 3. Java Swing | Creating Custom Message Dialogs
 * https://www.geeksforgeeks.org/java-swing-creating-custom-message-dialogs/?ref=lbp
 * 4. Java Swing | JComboBox with examples
 * https://www.geeksforgeeks.org/java-swing-jcombobox-examples/?ref=lbp
 * 5. Java Swing | lambda expression for ActionListener
 * https://www.codejava.net/java-core/the-java-language/java-8-lambda-listener-example
 * 6. Java Swing | Reset/Clear JButton
 * https://stackoverflow.com/questions/5328945/how-to-clear-the-jtextfield-by-clicking-jbutton
 * 7. Java Swing | Reset/Clear JComboBox
 * https://stackoverflow.com/questions/12048864/resetting-the-value-of-a-jcombobox
 * 8. Convert String to Double in Java
 * https://stackoverflow.com/questions/5769669/convert-string-to-double-in-java
 */

package view;
import javax.swing.*;
import java.awt.*;
import java.util.List;

import model.Monkey;
import model.Species;
import model.Sex;
import model.Food;
import model.Size;
import controller.Controller;


/**ß
 * This class extends JFrame and implements View Interface.
 * It is used to display data to the user.
 */
public class JFrameView extends JFrame implements View{

    // text fields and boxes for registering / creating a new monkey
    private JTextField name, weight, age;
    private JComboBox<Species> speciesFromInput;
    private JComboBox<Species> speciesForOutput;
    private JComboBox<Sex> sex;
    private JComboBox<Size> size;
    private JComboBox<Food> food;
    private JComboBox<Boolean> health;

    // button to confirm registering a new monkey
    private JButton createMonkey;

    // box for user to choose which monkey in the sanctuary to move
    private JComboBox<String> moveMonkey1;
    private JComboBox<String> moveMonkey2;

    // buttons for moving destinations
    private JButton addToIsolation;
    private JButton addToEnclosure;

    // button for treating monkey
    private JButton treatMonkey;

    // buttons for printing out monkey's lists
    private JButton sanctuaryList;
    private JButton enclosureList;
    private JButton isolationList;

    public JFrameView(String title) {
        super(title);
        this.setPreferredSize(new Dimension(1200, 600));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(1,20));

        // create 4 tabs on top of the frame
        JTabbedPane tabs = new JTabbedPane();
        this.add(tabs);

        // Panel 1: for registering a new monkey
        JPanel p1 = new JPanel();
        BoxLayout boxLayout = new BoxLayout(p1, BoxLayout.Y_AXIS);
        p1.setLayout(boxLayout);
        tabs.add("Register for a new monkey", p1);

        // Panel 2: for removing or moving a monkey
        JPanel p2 = new JPanel();
        boxLayout = new BoxLayout(p2, BoxLayout.Y_AXIS);
        p2.setLayout(boxLayout);
        tabs.add("Move an existing monkey", p2);

        // Panel 3: for treating an unhealthy monkey
        JPanel p3 = new JPanel();
        boxLayout = new BoxLayout(p3, BoxLayout.Y_AXIS);
        p3.setLayout(boxLayout);
        tabs.add("Treat an unhealthy monkey", p3);

        // Panel 4: for printing a monkey list
        JPanel p4 = new JPanel();
        boxLayout = new BoxLayout(p4, BoxLayout.Y_AXIS);
        p4.setLayout(boxLayout);
        tabs.add("Produce a monkey list", p4);

        // Panel 1: for registering a new monkey

        // 1) display instructions at top center of this window
        String ins = "To register a monkey, please give a name to this monkey and then enter the following fields in correct order: \n";
        JLabel label = new JLabel(ins);
        label.setFont(new Font("Serif", Font.BOLD, 20));
        p1.add(label);

        ins = "name, species, sex, size, weight(double), age(int), favorite food, whether is healthy(true/false)";
        label = new JLabel(ins);
        label.setFont(new Font("Serif", Font.BOLD, 20));
        p1.add(label);

        // Add vertical space between labels
        p1.add(Box.createVerticalStrut(10));

        String notice = "NOTICE:";
        label = new JLabel(notice);
        label.setFont(new Font("Serif", Font.PLAIN, 18));
        p1.add(label);

        // Add vertical space between labels
        p1.add(Box.createVerticalStrut(10));

        String text = "All monkeys must have different names. The program will show you a warning message if you give two monkeys the same name.\n" +
                "For monkey's SPECIES, you must only choose from these 8 kinds: DRILL, GUEREZA, HOWLER, MANGABEY, SAKI, SPIDER, SQUIRREL, TAMARIN.\n" +
                "For monkey's SEX, you must only choose from FEMALE or MALE.\n" +
                "For monkey's SIZE, you must only choose from LARGE, MEDIUM, or SMALL.\n" +
                "For monkey's WEIGHT, you must only enter POSITIVE double numbers.\n" +
                "For monkey's AGE, you must only enter NON-NEGATIVE integer numbers.\n" +
                "For monkey's FAVORITE FOOD, you must only choose from EGGS, FRUITS, INSECTS, LEAVES, NUTS, SEEDS, or TREE_SAP.";
        String[] lines = text.split("\n");
        for (String line: lines) {
            label = new JLabel(line);
            label.setFont(new Font("Serif", Font.PLAIN, 16));
            p1.add(label);
        }

        // Add vertical space between labels
        p1.add(Box.createVerticalStrut(10));

        // 2) display text fields and boxes get user's input
        name = new JTextField(10);
        name.setPreferredSize(new Dimension(50, 16));
        name.setFont(new Font("Serif", Font.PLAIN, 16));
        p1.add(name);

        speciesFromInput = new JComboBox<>();
        for (Species s: Species.values()) {
            speciesFromInput.addItem(s);
            speciesFromInput.setFont(new Font("Serif", Font.PLAIN, 16));
        }
        p1.add(speciesFromInput);

        sex = new JComboBox<>();
        for (Sex s: Sex.values()) {
            sex.addItem(s);
            sex.setFont(new Font("Serif", Font.PLAIN, 16));
        }
        p1.add(sex);

        size = new JComboBox<>();
        for (Size s: Size.values()) {
            size.addItem(s);
            size.setFont(new Font("Serif", Font.PLAIN, 16));
        }
        p1.add(size);

        weight = new JTextField(5);
        weight.setFont(new Font("Serif", Font.PLAIN, 16));
        p1.add(weight);

        age = new JTextField(5);
        age.setFont(new Font("Serif", Font.PLAIN, 16));
        p1.add(age);

        food = new JComboBox<>();
        for (Food s: Food.values()) {
            food.addItem(s);
            food.setFont(new Font("Serif", Font.PLAIN, 16));
        }
        p1.add(food);

        health = new JComboBox<>();
        health.addItem(false);
        health.addItem(true);
        health.setFont(new Font("Serif", Font.PLAIN, 16));
        p1.add(health);

        createMonkey = new JButton("Register");
        createMonkey.setFont(new Font("Serif", Font.PLAIN, 20));
        p1.add(createMonkey);

        // PANEL 2: for removing or moving a monkey

        // 1) display instructions at top center of this window
        ins = "To move a monkey, please choose the name of the monkey you want to move.";
        label = new JLabel(ins);
        label.setFont(new Font("Serif", Font.BOLD, 20));
        p2.add(label);

        // Add vertical space between labels
        p2.add(Box.createVerticalStrut(10));

        label = new JLabel(notice);
        label.setFont(new Font("Serif", Font.PLAIN, 18));
        p2.add(label);

        // Add vertical space between labels
        p2.add(Box.createVerticalStrut(10));

        String text2 = "When monkeys first arrive at the sanctuary, they must first move to ISOLATION.\n" +
                "Therefore, first-arrived monkeys are ALREADY in the ISOLATION and you don't need to move them again.\n" +
                "If the monkey you want to move does not exist, the program will show you a warning message.\n" +
                "If the monkey you want to move already exists in that housing, the program will show you a warning message.\n" +
                "If you want to move a monkey to a full ISOLATION, the program will show you a warning message.\n" +
                "If you want to move an unhealthy monkey to ENCLOSURE, the program will show you a warning message.";
        lines = text2.split("\n");
        for (String line: lines) {
            label = new JLabel(line);
            label.setFont(new Font("Serif", Font.PLAIN, 16));
            p2.add(label);
        }

        // Add vertical space between labels
        p2.add(Box.createVerticalStrut(20));

        // 2) choose box with existing monkeys in the sanctuary
        moveMonkey1 = new JComboBox<>();
        moveMonkey1.setPreferredSize(new Dimension(50, 25));

        p2.add(moveMonkey1);

        // Add vertical space between labels
        p2.add(Box.createVerticalStrut(10));

        // 3) buttons for moving destinations
        addToIsolation = new JButton("Move this monkey to ISOLATION");
        addToIsolation.setFont(new Font("Serif", Font.PLAIN, 20));
        p2.add(addToIsolation);

        // Add vertical space between labels
        p2.add(Box.createVerticalStrut(10));

        addToEnclosure = new JButton("Move this monkey to ENCLOSURE");
        addToEnclosure.setFont(new Font("Serif", Font.PLAIN, 20));
        p2.add(addToEnclosure);

        // Panel 3: for treating an unhealthy monkey

        // 1) display instructions at top center of this window
        ins = "To move a monkey to ENCLOSURE, you have to treat this monkey and make it healthy.";
        label = new JLabel(ins);
        label.setFont(new Font("Serif", Font.BOLD, 20));
        p3.add(label);

        // Add vertical space between labels
        p3.add(Box.createVerticalStrut(10));

        label = new JLabel(notice);
        label.setFont(new Font("Serif", Font.PLAIN, 18));
        p3.add(label);

        // Add vertical space between labels
        p3.add(Box.createVerticalStrut(10));

        String text3 = "To treat a monkey, choose the monkey by name you want to give medical treatment.\n" +
                "If the monkey you want to treat is already healthy, the program will show you a warning message.";
        lines = text3.split("\n");
        for (String line: lines) {
            label = new JLabel(line);
            label.setFont(new Font("Serif", Font.PLAIN, 16));
            p3.add(label);
        }

        // 2) choose box with existing monkeys in the sanctuary
        moveMonkey2 = new JComboBox<>();
        moveMonkey2.setPreferredSize(new Dimension(50, 25));
        p3.add(moveMonkey2);

        // 3) button for treating monkey
        treatMonkey = new JButton("Treat this Monkey");
        treatMonkey.setFont(new Font("Serif", Font.PLAIN, 20));
        p3.add(treatMonkey);

        // Panel 4: for printing a monkey list

        // 1) display instructions at top center of this window
        ins = "To print a monkey list, you have to first choose the housing type for monkeys.";
        label = new JLabel(ins);
        label.setFont(new Font("Serif", Font.BOLD, 20));
        p4.add(label);

        // Add vertical space between labels
        p4.add(Box.createVerticalStrut(10));

        label = new JLabel(notice);
        label.setFont(new Font("Serif", Font.PLAIN, 18));
        p4.add(label);

        // Add vertical space between labels
        p4.add(Box.createVerticalStrut(10));

        String text4 = "If there's no monkey in that housing, the program will show you a warning message.";
        label = new JLabel(text4);
        label.setFont(new Font("Serif", Font.PLAIN, 16));
        p4.add(label);

        // Add vertical space between labels
        p4.add(Box.createVerticalStrut(40));

        // 2) button for printing out monkey names lists in the sanctuary
        String text5 = "Click the button below to get an alphabetical list (by name) of all monkeys housed in the SANCTUARY.";
        label = new JLabel(text5);
        label.setFont(new Font("Serif", Font.PLAIN, 16));
        p4.add(label);

        sanctuaryList = new JButton("Get all monkeys in the SANCTUARY");
        sanctuaryList.setFont(new Font("Serif", Font.PLAIN, 20));
        p4.add(sanctuaryList);

        // Add vertical space between labels
        p4.add(Box.createVerticalStrut(20));

        // 3) button for printing out monkey names lists in the isolation
        String text6 = "Click the button below to get an alphabetical list (by name) of all monkeys housed in the ISOLATION.";
        label = new JLabel(text6);
        label.setFont(new Font("Serif", Font.PLAIN, 16));
        p4.add(label);

        isolationList = new JButton("Get all monkeys in the ISOLATION");
        isolationList.setFont(new Font("Serif", Font.PLAIN, 20));
        p4.add(isolationList);

        // Add vertical space between labels
        p4.add(Box.createVerticalStrut(20));

        // 4) button for printing out monkey lists with names and info in the enclosure
        String text7 = "Choose the specific species to get a list of all monkeys housed in that ENCLOSURE.\n" +
                "For every enclosure, there's a list for each individual monkey that is currently housing there.\n" +
                "For each individual monkey, the list includes their name, sex, and favorite food.";
        lines = text7.split("\n");
        for (String line: lines) {
            label = new JLabel(line);
            label.setFont(new Font("Serif", Font.PLAIN, 16));
            p4.add(label);
        }

        // ADD speciesFromInput to SpeciesForOutput
        speciesForOutput = new JComboBox<>();
        for (Species s: Species.values()) {
            speciesForOutput.addItem(s);
        }
        speciesForOutput.setPreferredSize(new Dimension(130, 25));
        p4.add(speciesForOutput);

        enclosureList = new JButton("Get all monkeys in the ENCLOSURE");
        enclosureList.setFont(new Font("Serif", Font.PLAIN, 20));
        p4.add(enclosureList);

        this.pack();
        this.setVisible(true);
    }

    @Override
    public void showWarning(String message) {
        // takes a parent component, a message text, a title, and a message type as parameter
        JOptionPane.showMessageDialog(this, message, "Warning", JOptionPane.WARNING_MESSAGE);
    }

    @Override
    public void showMessage(String successMessage) {
        JOptionPane.showMessageDialog(this, successMessage, "Information", JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void showList(String list) {
        JOptionPane.showMessageDialog(this, list);
    }

    @Override
    public void connectController(Controller controller) {
        // connect buttons to the corresponding controller's functions
        createMonkey.addActionListener(e -> controller.createMonkey());
        addToIsolation.addActionListener(e -> controller.addToIsolation());
        addToEnclosure.addActionListener(e -> controller.addToEnclosure());
        treatMonkey.addActionListener(e -> controller.treatMonkey());
        enclosureList.addActionListener(e -> controller.getEnclosureList());
        sanctuaryList.addActionListener(e -> controller.getSanctuaryList());
        isolationList.addActionListener(e -> controller.getIsolationList());
    }

    @Override
    public void updateMonkey(List<Monkey> monkeys) {
        moveMonkey1.removeAllItems();
        moveMonkey2.removeAllItems();
        for (Monkey m: monkeys) {
            moveMonkey1.addItem(m.getName());
            moveMonkey2.addItem(m.getName());
        }
    }

    @Override
    public String getName() {
        return name.getText();
    }

    @Override
    public double getWeight() {
        String input = age.getText();
        return Double.parseDouble(input);
    }

    @Override
    public int getAge() {
        String input = age.getText();
        return Integer.parseInt(input);
    }

    @Override
    public Species getSpecies() {
        return (Species)speciesFromInput.getSelectedItem();
    }

    @Override
    public Sex getSex() {
        return (Sex)sex.getSelectedItem();
    }

    @Override
    public Size getSizeFromInput() {
        return (Size)size.getSelectedItem();
    }

    @Override
    public Food getFavFood() {
        return (Food)food.getSelectedItem();
    }

    @Override
    public boolean getHealth() {
        return (boolean)health.getSelectedItem();
    }

    @Override
    public void resetMonkey() {
        name.setText(null);
        weight.setText(null);
        age.setText(null);
        speciesFromInput.setSelectedIndex(0);
        sex.setSelectedIndex(0);
        size.setSelectedIndex(0);
        food.setSelectedIndex(0);
        health.setSelectedIndex(0);
    }

    @Override
    public void resetMove() {
        moveMonkey1.setSelectedItem(null);
        moveMonkey2.setSelectedItem(null);
    }

    @Override
    public Species getSpeciesInEnclosure() {
        return (Species)speciesForOutput.getSelectedItem();
    }

    @Override
    public void resetSpecies() {
        speciesFromInput.setSelectedIndex(0);
    }

    @Override
    public String getMoveName() {
        return (String)moveMonkey1.getSelectedItem();
    }

    @Override
    public String getTreatName() {
        return (String)moveMonkey2.getSelectedItem();
    }
}

