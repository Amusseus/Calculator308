import javax.swing.*;
import java.awt.*;

public class Calculator extends JFrame {

    public Calculator() {
        super("Calculator");
        GridLayout layout = new GridLayout();
        setLayout(layout);
        JTextField text = new JTextField("");
        add(text);
        JPanel panel = new JPanel();
        GridLayout panelLayout = new GridLayout(4,4);
        panel.setLayout(panelLayout);
        JButton buttons[] = new JButton [16];
        for(int i = 0; i < 16; i++){
            buttons[i] = new JButton(i + "");
            panel.add(buttons[i]);
        }
        add(panel);

    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        calculator.setSize(500, 500);
        calculator.setVisible(true);
    }
}