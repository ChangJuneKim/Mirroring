package com.ssafy.live5.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.ssafy.live5.parse.BoxOffice;
import com.ssafy.live5.parse.dom.BoxOfficeDomParser;

public class BoxOfficeUi extends JFrame {

    private static final long serialVersionUID = 1L;
    // 컴포넌트 선언
    JButton button = null;
    JTable table = null;

    // table의 데이터를 관리하는 객체
    DefaultTableModel model = null;

    public static void main(String[] args) {
        BoxOfficeUi ui = new BoxOfficeUi();
        ui.launchUi();
    }

    private void launchUi() {
        button = new JButton("읽기");

        // 테이블 구성
        table = new JTable();
        String[] header = {"랭킹", "제목", "개봉일", "누적관객"};
        model = (DefaultTableModel) table.getModel();
        model.setColumnIdentifiers(header);

        // 이벤트 listener 등록 처리
        addEventListener();

        // 요소 배치
        this.add(new JScrollPane(table), BorderLayout.CENTER);
        this.add(button, BorderLayout.SOUTH);

        this.setTitle("오늘의 영화 랭킹 Top 10");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 300);
        this.setVisible(true);
    }

    private void addEventListener() {
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 기존 자료 삭제
                model.setRowCount(0);
                // 새로운 자료 조회
                BoxOfficeDomParser parser = new BoxOfficeDomParser();
                List<BoxOffice> list = parser.getBoxOffice();
                for (BoxOffice info : list) {
                    model.addRow(new Object[] {info.getRank(), info.getMovieNm(), info.getOpenDt(), info.getAudiAcc()});
                }
                // model의 데이터가 변경되었음을 알림
                model.fireTableDataChanged();
            }
        });

        // TODO:테이블에서 발생하는 click event 처리를 위한 listener 등록
        // END:
    }

}
