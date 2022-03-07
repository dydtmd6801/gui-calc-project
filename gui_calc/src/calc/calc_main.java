package calc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class calc_main extends JFrame {
    private JPanel top = new JPanel();
    private JPanel bottom = new JPanel();

    private JButton[] num_button = new JButton[10];

    private TextField textField = new TextField(18);

    private Font font = new Font("Noto sans KR",Font.BOLD,16);

    calc_main(){
        this.setTitle("계산기");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.formDesign();
        this.eventHandler();
        this.setSize( 300, 400);
        this.setVisible(true);
    }

    public void formDesign() {
        this.setLayout(new BorderLayout());

        this.add(top, BorderLayout.NORTH);
        this.add(bottom, BorderLayout.CENTER);

        top.setLayout(new FlowLayout());

        textField.setText("0");
        textField.setFont(font);
        textField.setSize(200, 80);
        top.add(textField);

        bottom.setLayout(new GridLayout(4, 4, 5, 5));
        bottom.setBackground(Color.cyan);
    }

    public void eventHandler() {}

    public static void main(String[] args) {
        new calc_main();
    }
}
