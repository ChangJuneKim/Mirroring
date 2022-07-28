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
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 버튼을 닫으면 종료하게 만드는 명령어
        this.pack();
        this.setVisible(true); // default가 invisible이라 visible을 true로 해줘야함
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
    	JPanel panel = new JPanel();
    	panel.add(new JLabel("정답 개수 : "));
    	lCorrectCnt = new JLabel("0");
    	panel.add(lCorrectCnt);
    	
    	panel.add(new JLabel("정답 개수 : "));
    	lWrongCnt = new JLabel("0");
    	panel.add(lWrongCnt);
    	
    	this.add(panel, BorderLayout.SOUTH);
        // END:
    }


    
    private void makeProblemPanel() {
        // TODO: 문제를 출제할 패널을 구성하시오.
    	JPanel panel = new JPanel();
    	
    	lNum1 = new JLabel();
    	lNum2 = new JLabel();
    	
    	panel.add(lNum1);
    	panel.add(new JLabel("*"));
    	panel.add(lNum2);
    	panel.add(new JLabel("="));
    	
    	tfAns = new JTextField(10);
    	panel.add(tfAns);
    	makeProblem();
    	
    	tfAns.addKeyListener(new KeyAdapter() {
    		@Override
    		public void keyReleased(KeyEvent e) {
    			if(e.getKeyCode() == 10) {
    				int val = Integer.parseInt(tfAns.getText());
    				
    				if (val == answer) {
    					int pre = Integer.parseInt(lCorrectCnt.getText());
    					lCorrectCnt.setText((pre + 1) + "");
    				} else {
    					int pre = Integer.parseInt(lWrongCnt.getText());
    					lWrongCnt.setText((pre + 1) + "");
    				}
    				
    				makeProblem();
    			}
    		}
		});
    	
    	this.add(panel, BorderLayout.CENTER);
        // END:
    }


}
