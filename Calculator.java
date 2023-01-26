import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame {


    String num1, num2, operator;

    String[] operators = {"+", "-", "*", "/"};
    private void createButtons(){
        
    }

    public Calculator() {
        super("Calculator");

        // Initializes layout to be 5x1
        // Keeps first Row for displaying text
        GridLayout layout = new GridLayout(5, 1);
        setLayout(layout);

        JTextField text = new JTextField("");
        add(text);

        // Creates 4 Rows of 4 buttons
        String label = "";
        for(int i = 0 ; i < 4; i++) {
            JPanel panel = new JPanel();
            GridLayout panelLayout = new GridLayout(1,4);
            panel.setLayout(panelLayout);
            JButton[] buttons = new JButton [4];
            // Assign buttons a string with either an operator, a number, or =
            for(int j = 0; j < 4; j++){
                if (j > 0) {
                    label = i * j + "";
                } else {
                    label = operators[i];
                }
                if (i == 0) {
                    if (j == 1) {
                        label = "=";
                    } else if (j == 3) {
                        label = "";
                    }
                }
                buttons[j] = new JButton(label);
                buttons[j].addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        JButton b = (JButton)e.getSource();
                        String buttonText = b.getText();

                        System.out.println(buttonText);
                    }
                });
                panel.add(buttons[j]);
            }
            add(panel);
        }
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        calculator.setSize(500, 500);
        calculator.setVisible(true);
    }
}