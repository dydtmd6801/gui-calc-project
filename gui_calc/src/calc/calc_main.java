package calc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class calc_main extends JFrame implements ActionListener {
    private JPanel top = new JPanel();
    private JPanel bottom = new JPanel();
    private JPanel operation = new JPanel();

    private JLabel operate = new JLabel("0");
    private JLabel calc = new JLabel("");

    private JButton[] num_button = new JButton[10];

    private JButton add_button = new JButton("＋");
    private JButton sub_button = new JButton("－");
    private JButton mul_button = new JButton("×");
    private JButton div_button = new JButton("÷");
    private JButton eql_button = new JButton("＝");
    private JButton cle_button = new JButton("CE");

    private TextField textField = new TextField(11);

    private Font font = new Font("Noto sans KR",Font.BOLD,30);
    private Font btn_font = new Font("Noto sans KR", Font.PLAIN, 14);

    calc_main(){
        this.setTitle("계산기");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.formDesign();
        this.eventHandler();
        this.setSize( 300, 400);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    public void formDesign() {
        this.setLayout(new BorderLayout());

        this.add(top, BorderLayout.NORTH);
        this.add(bottom, BorderLayout.CENTER);
        this.add(operation, BorderLayout.SOUTH);

        operation.add(operate);

        top.setLayout(new FlowLayout());

        textField.setFont(font);
        textField.setSize(200, 80);
        top.add(textField);

        bottom.setLayout(new GridLayout(4, 4, 2, 2));

        for(int i = 0; i < 10; i++){
            num_button[i] = new JButton(Integer.toString(i));
            num_button[i].setFont(btn_font);
        }
        add_button.setFont(btn_font);
        sub_button.setFont(btn_font);
        mul_button.setFont(btn_font);
        div_button.setFont(btn_font);
        eql_button.setFont(btn_font);
        cle_button.setFont(btn_font);

        bottom.add(num_button[1]);
        bottom.add(num_button[2]);
        bottom.add(num_button[3]);
        bottom.add(div_button);

        bottom.add(num_button[4]);
        bottom.add(num_button[5]);
        bottom.add(num_button[6]);
        bottom.add(mul_button);

        bottom.add(num_button[7]);
        bottom.add(num_button[8]);
        bottom.add(num_button[9]);
        bottom.add(sub_button);

        bottom.add(num_button[0]);
        bottom.add(cle_button);
        bottom.add(eql_button);
        bottom.add(add_button);

        bottom.setBackground(Color.lightGray);
    }

    public void eventHandler() {
        for(int i = 0; i < 10; i++){
            num_button[i].addActionListener(this);
        }
        add_button.addActionListener(this);
        sub_button.addActionListener(this);
        mul_button.addActionListener(this);
        div_button.addActionListener(this);
        eql_button.addActionListener(this);
        cle_button.addActionListener(this);
    }

    public static void main(String[] args) {
        new calc_main();
    }

    public void actionPerformed(ActionEvent e){

        for(int i = 0; i < 10; i++){
            if(e.getSource() == num_button[i]){
                String last_num = operate.getText().substring(operate.getText().length() - 1);
                switch(last_num){
                    case "0":
                    case "1":
                    case "2":
                    case "3":
                    case "4":
                    case "5":
                    case "6":
                    case "7":
                    case "8":
                    case "9":
                        textField.setText(textField.getText()+i);
                        break;
                    default:
                        textField.setText(""+i);
                        break;
                }
                if(operate.getText() == "0"){
                    operate.setText(""+i);
                } else {
                    operate.setText(operate.getText()+i);
                }
            }
        }
        if(e.getSource() == add_button){
            textField.setText("＋");
            operate.setText(operate.getText()+"＋");
            calc.setText("＋");
        }
        if(e.getSource() == sub_button){
            textField.setText("－");
            operate.setText(operate.getText()+"－");
            calc.setText("－");
        }
        if(e.getSource() == mul_button){
            textField.setText("×");
            operate.setText(operate.getText()+"×");
            calc.setText("×");
        }
        if(e.getSource() == div_button){
            textField.setText("÷");
            operate.setText(operate.getText()+"÷");
            calc.setText("÷");
        }
        if(e.getSource() == cle_button){
            textField.setText("");
            operate.setText("0");
        }
        if(e.getSource() == eql_button){
            if(calc.getText() == "＋"){
                String[] array = operate.getText().split("＋");
                int front_num = Integer.parseInt(array[0]);
                int back_num = Integer.parseInt(array[1]);
                JOptionPane.showMessageDialog(null, front_num + back_num,"result", JOptionPane.PLAIN_MESSAGE);
                textField.setText("");
                operate.setText("0");
            }
            if(calc.getText() == "－"){
                String[] array = operate.getText().split("－");
                int front_num = Integer.parseInt(array[0]);
                int back_num = Integer.parseInt(array[1]);
                JOptionPane.showMessageDialog(null, front_num - back_num,"result", JOptionPane.PLAIN_MESSAGE);
                textField.setText("");
                operate.setText("0");
            }
            if(calc.getText() == "×"){
                String[] array = operate.getText().split("×");
                int front_num = Integer.parseInt(array[0]);
                int back_num = Integer.parseInt(array[1]);
                JOptionPane.showMessageDialog(null, front_num * back_num,"result", JOptionPane.PLAIN_MESSAGE);
                textField.setText("");
                operate.setText("0");
            }
            if(calc.getText() == "÷"){
                String[] array = operate.getText().split("÷");
                int front_num = Integer.parseInt(array[0]);
                int back_num = Integer.parseInt(array[1]);
                JOptionPane.showMessageDialog(null, front_num / back_num,"result", JOptionPane.PLAIN_MESSAGE);
                textField.setText("");
                operate.setText("0");
            }
        }
    }
}
