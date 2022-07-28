package com.ssafy.live5.gui;

import java.awt.BorderLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LayoutTest extends JFrame {
    private static final long serialVersionUID = 1L;
    private JLabel lNum1, lNum2, lCorrectCnt, lWrongCnt;
    private JTextField tfAns;
    private int answer;

    public static void main(String[] args) {
        LayoutTest lt = new LayoutTest();
        lt.launchUi();
    }

    private void launchUi() {
        this.add(new JLabel("구구단을 외자!"), BorderLayout.NORTH);
        
        makeResultPanel();
        makeProblemPanel();
        // Frame 기본 설정
        this.setTitle("layout test");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }
    
    private void makeProblem() {
        Random rand = new Random();
        int num1 = rand.nextInt(9) + 1;
        int num2 = rand.nextInt(9) + 1;
        this.answer = num1 * num2;
        lNum1.setText(num1 + "");
        lNum2.setText(num2 + "");
        tfAns.setText("");
    }
    
    private void makeResultPanel() {
        // TODO: 결과를 보여줄 panel을 구성하시오.
        // END:
    }


    
    private void makeProblemPanel() {
        // TODO: 문제를 출제할 패널을 구성하시오.
        // END:
    }


}
