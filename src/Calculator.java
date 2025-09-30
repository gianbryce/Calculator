import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener {

    JFrame frame;
    JTextField textField;
    JButton[] numberButtons = new JButton[10];
    JButton[] operatorButtons = new JButton[8];
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, equButton, delButton, clrButton;
    JPanel panel;

    Font myFont = new Font("Helvetica", Font.BOLD,30);
    double num1 = 0, num2 = 0, result = 0;
    char operator;

    Calculator() {
        //Define the characteristics of the frame
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null);

        //Define the characteristics of the text field
        textField = new JTextField();
        textField.setBounds(50, 25, 300, 50);
        textField.setFont(myFont);

        //Prevents the user from entering into the text field
        //We do this because we want to enter numbers via the buttons,
        //not by entering it into the text box.
        textField.setEditable(false);

        //Our operator buttons
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Delete");
        clrButton = new JButton("Clear");

        //Store each button in the array
        operatorButtons[0] = addButton;
        operatorButtons[1] = subButton;
        operatorButtons[2] = mulButton;
        operatorButtons[3] = divButton;
        operatorButtons[4] = decButton;
        operatorButtons[5] = equButton;
        operatorButtons[6] = delButton;
        operatorButtons[7] = clrButton;

        for (int i = 0; i < operatorButtons.length; i++) {
            //Add the button to the ActionListener
            operatorButtons[i].addActionListener(this);

            //Sets the font of the text contained in the button
            operatorButtons[i].setFont(myFont);

            //Disables outline when clicked
            operatorButtons[i].setFocusable(false);
        }

        for (int i = 0; i < numberButtons.length; i++) {
            //Create a new button with corresponding values to index
            //up to the size of the array (10)
            numberButtons[i] = new JButton(String.valueOf(i));

            //Add the button to the ActionListener
            numberButtons[i].addActionListener(this);

            //Set the font
            numberButtons[i].setFont(myFont);

            //Disables outline when clicked
            numberButtons[i].setFocusable(false);
        }

        //Manually setting the bounds of these buttons
        delButton.setBounds(50,430,145,50);
        clrButton.setBounds(205,430,145,50);

        //Add the buttons to the frame
        delButton.setFont(myFont);
        frame.add(delButton);

        clrButton.setFont(myFont);
        frame.add(clrButton);

        //Creating the panel (container)
        panel = new JPanel();
        panel.setBounds(50,100,300,300);
        panel.setLayout(new GridLayout(4,4,10,10));
        panel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        panel.setBackground(Color.GRAY);

        for (int i = 0; i < numberButtons.length; i++) {
            panel.add(numberButtons[i]);
        }
        frame.add(panel);

        //A text field has been created, however, it must be projected on to the frame
        frame.add(textField);

        //Makes the frame visible. Anything before this won't be visible
        frame.setVisible(true);
    };

    public static void main(String[] args) {
        Calculator calc= new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
