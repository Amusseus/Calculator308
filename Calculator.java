import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


/**
 * Creates a calculator that can perform basic arithmetic calculations.
 * @author Nicholas Zarate, Giovanni Librizzi, Umair Pathan, Jin Wu, Amogh Prajapati
 */
public class Calculator extends JFrame {

    Operation operation;
    public static List<String> operators = List.of("+", "-", "*", "/", "=", "C");
    public static String[][] values = {{"7", "8", "9", "+"},{ "4","5", "6", "-"},{ "1","2","3","*"}, {"C", "0", "=", "/"}};

    /**
     * Constructor for Calculator class
     *
     */
    public Calculator() {
        super("Calculator");

        // Initializes layout to be 5x1
        // Keeps first Row for displaying text
        GridLayout layout = new GridLayout(5, 1);
        setLayout(layout);

        JTextField textDisplay = new JTextField("");
        add(textDisplay);

        operation = new Operation();

        // Creates 4 Rows of 4 buttons
        String label = "";
        for(int i = 0 ; i < 4; i++) {
            JPanel panel = new JPanel();
            GridLayout panelLayout = new GridLayout(1,4);
            panel.setLayout(panelLayout);
            JButton[] buttons = new JButton [4];
            // Assign buttons a string with either an operator, a number, or =
            for(int j = 0; j < 4; j++){

                label = values[i][j];

                buttons[j] = new JButton(label);
                buttons[j].addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        JButton b = (JButton)e.getSource();
                        String buttonText = b.getText();
                        operation.Process(buttonText);
                        textDisplay.setText(operation.GetCurrentNumStr());

                    }
                });
                panel.add(buttons[j]);
            }
            add(panel);
        }
    }

    /**
     * Main method creates a Calculator object and sets JFrame
     * @param args
     */
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        calculator.setSize(500, 500);
        calculator.setVisible(true);
    }
}