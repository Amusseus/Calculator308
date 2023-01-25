import javax.swing.*;
import java.awt.*;

public class Calculator extends JFrame {

    private void createButtons(){
        
    }

    public Calculator() {
        super("Calculator");
        GridLayout layout = new GridLayout(5, 1);
        setLayout(layout);
        JTextField text = new JTextField("");
        add(text);

        for(int i = 0 ; i < 4; i++){
            JPanel panel = new JPanel();
            GridLayout panelLayout = new GridLayout(1,4);
            panel.setLayout(panelLayout);
            JButton buttons[] = new JButton [4];
            for(int j = 0; j < 4; j++){
                buttons[j] = new JButton(i * j + "");
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