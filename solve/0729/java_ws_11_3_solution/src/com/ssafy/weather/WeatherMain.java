package com.ssafy.weather;


import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class WeatherMain {
	JFrame f = new JFrame("Weather Info");
	JButton b = new JButton("call Weather");
	JList li = new JList();
	WeatherDAO dao;

	public WeatherMain(){
		dao = WeatherDAO.getWeatherDAO();	// singleton
		createGUI();
		addEvent();
	}

	private void addEvent() {
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				showList();
			}
		});
	}

	protected void showList() {
		String url = "http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=2920063700";
		java.util.List<Weather> datas = dao.getWeatherList(url);
		li.removeAll();
		li.setListData(datas.toArray());
	}

	private void createGUI() {
		f.add(b, "North");
		f.add(li);
		f.setSize(400, 500);
		f.setVisible(true);
	}

	public static void main(String[] args) {
		new WeatherMain();
	}

}
