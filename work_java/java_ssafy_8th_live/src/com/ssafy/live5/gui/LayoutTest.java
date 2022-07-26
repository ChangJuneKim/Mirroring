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
        // @@TODOBLOCK: 결과를 보여줄 panel을 구성하시오.
        JPanel panel = new JPanel();
        panel.add(new JLabel("정답 개수: "));
        lCorrectCnt = new JLabel("0");
        panel.add(lCorrectCnt);
        panel.add(new JLabel("오답 개수: "));
        lWrongCnt = new JLabel("0");
        panel.add(lWrongCnt);
        this.add(panel, BorderLayout.SOUTH);
        // @@END:
    }


    
    private void makeProblemPanel() {
        // @@TODOBLOCK: 문제를 출제할 패널을 구성하시오.
        JPanel panel = new JPanel();
        lNum1 = new JLabel();
        lNum2 = new JLabel();
        tfAns = new JTextField(10);
        panel.add(lNum1);
        panel.add(new JLabel("*"));
        panel.add(lNum2);
        panel.add(new JLabel("="));
        panel.add(tfAns);
        tfAns.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == 10) {
                    try {
                        int val = Integer.parseInt(tfAns.getText());
                        if (val == answer) {
                            lCorrectCnt.setText(Integer.parseInt(lCorrectCnt.getText())+1 + "");
                        } else {
                            lWrongCnt.setText(Integer.parseInt(lWrongCnt.getText() )+1 + "");
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        lWrongCnt.setText(Integer.parseInt(lWrongCnt.getText())+1 + "");
                    } finally {
                        makeProblem();
                    }
                }
            }
        });
        makeProblem();
        this.add(panel, BorderLayout.CENTER);
        // @@END:
    }


}
