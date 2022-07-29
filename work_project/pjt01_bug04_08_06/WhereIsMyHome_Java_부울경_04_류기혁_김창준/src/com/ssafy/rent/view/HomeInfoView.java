package com.ssafy.rent.view;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import com.ssafy.rent.model.dao.EnvironmentDaoImpl;
import com.ssafy.rent.model.dto.EnvironmentInfo;
import com.ssafy.rent.model.dto.HomeDeal;
import com.ssafy.rent.model.dto.HomePageBean;
import com.ssafy.rent.model.service.HomeService;
import com.ssafy.rent.model.service.HomeServiceImpl;
import com.ssafy.rent.util.CSVHandler;

public class HomeInfoView {

	/** model들 */
	private HomeService homeService;

	/** main 화면 */
	private JFrame frame;

	/** 주택 목록 화면 */
	// JFrame owner;

	/** 창 닫기 버튼 */
	// private JButton closeBt;

	/** 주택 이미지 표시 Panel */
	private JLabel imgL;
	private JLabel[] homeInfoL;

	/** 조회 조건 */
	private JCheckBox[] chooseC;
	private JComboBox<String> findC;
	private JTextField wordTf;
	private JButton searchBt;
	private JButton envBt;
	private JButton offBt;

	/** 조회 내용 표시할 table */
	private DefaultTableModel homeModel;
	private JTable homeTable;
	private JScrollPane homePan;

	private DefaultTableModel envModel;
	private JTable envTable;
	private JScrollPane EnvPan;

	private String[] title = { "번호", "동", "아파트이름", "거래금액", "거래종류" };
	private String currentDong = null;

	/** 검색 조건 */
	private String key;

	/** 검색할 단어 */
	private String word;
	private boolean[] searchType = { true, true, true, true };
	private String[] choice = { "all", "dong", "name" };

	/** 화면에 표시하고 있는 주택 */
	private HomeDeal curHome;

	private void showHomeInfo(int code) {

		curHome = homeService.search(code);
		System.out.println("선택된 집 : " + curHome);

		// foodInfoL[0].setText(""+curfood.getCode());
		homeInfoL[0].setText("");
		homeInfoL[1].setText("");
		homeInfoL[2].setText(curHome.getAptName());
		homeInfoL[3].setText("" + curHome.getDealAmount());
		String rent = curHome.getRentMoney();
		if (rent == null) {
			homeInfoL[4].setText("없음");
		} else {
			homeInfoL[4].setText(curHome.getRentMoney());
		}
		homeInfoL[5].setText("" + curHome.getBuildYear());
		homeInfoL[6].setText(curHome.getArea() + "");
		homeInfoL[7].setText(
				String.format("%d년 %d월 %d일", curHome.getDealYear(), curHome.getDealMonth(), curHome.getDealDay()));
		homeInfoL[8].setText(curHome.getDong());
		homeInfoL[9].setText(curHome.getJibun());

		// System.out.println("###############" + curHome.getImg());

		ImageIcon icon = null;
		if (curHome.getImg() != null && curHome.getImg().trim().length() != 0) {
			icon = new ImageIcon("img/" + curHome.getImg());
			System.out.println("#####" + icon.toString() + "####");
		} else {
			icon = new ImageIcon("img/다세대주택.jpg");
		}

		imgL.setIcon(icon);

		Image img = null;
		try {
			img = ImageIO.read(new File("img/" + curHome.getImg()));
		} catch (IOException ex) {
			try {
				img = ImageIO.read(new File("img/다세대주택.jpg"));
			} catch (Exception e) {
			}
		}
		img = img.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		imgL.setIcon(new ImageIcon(img));
	}

	public HomeInfoView() {
		/* Service들 생성 */
		homeService = new HomeServiceImpl();

		/* 메인 화면 설정 */
		frame = new JFrame("WhereIsMyHome -- 아파트 거래 정보");
//		frame.addWindowListener(new WindowAdapter() {
//			public void windowClosing(WindowEvent e){
//				frame.dispose();
//			}
//		});

		setMain();

		frame.setSize(1200, 800);
		frame.setResizable(true);
		frame.setVisible(true);
		showHomeInfo(1);
		// showHomes();
	}

	/** 메인 화면인 주택 목록을 위한 화면 셋팅하는 메서드 */
	public void setMain() {

		/* 왼쪽 화면을 위한 설정 */
		JPanel left = new JPanel(new BorderLayout());
		JPanel leftCenter = new JPanel(new GridLayout(1, 2));
		JPanel leftR = new JPanel(new GridLayout(11, 2));
		leftR.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));

		envBt = new JButton("환경정보");
		offBt = new JButton("상권정보");
		leftR.add(envBt, "North");
		leftR.add(offBt, "North");

		String[] info = { "", "", "주택명", "거래금액", "월세금액", "건축연도", "전용면적", "거래일", "법정동", "지번" };
		int size = info.length;
		JLabel infoL[] = new JLabel[size];
		homeInfoL = new JLabel[size];
		for (int i = 0; i < size; i++) {
			infoL[i] = new JLabel(info[i]);
			homeInfoL[i] = new JLabel("");
			leftR.add(infoL[i]);
			leftR.add(homeInfoL[i]);
		}
		imgL = new JLabel();
		leftCenter.add(imgL);
		leftCenter.add(leftR);

		// leftCenter.add(new JButton("더 보기"));
		left.add(new JLabel("아파트 거래 정보", JLabel.CENTER), "North");

		left.add(leftCenter, "Center");

		/* 오른쪽 화면을 위한 설정 */
		JPanel right = new JPanel(new BorderLayout());
		JPanel rightTop = new JPanel(new GridLayout(4, 2));
		JPanel rightTop1 = new JPanel(new GridLayout(1, 4));
		String[] chooseMeg = { "아파트 매매", "아파트 전월세", "주택 매매", "주택 전월세" };
		chooseC = new JCheckBox[chooseMeg.length];
		for (int i = 0, len = chooseMeg.length; i < len; i++) {
			chooseC[i] = new JCheckBox(chooseMeg[i], true);
			rightTop1.add(chooseC[i]);
		}

		JPanel rightTop2 = new JPanel(new GridLayout(1, 3));
		String[] item = { "---all---", "동", "아파트 이름" };
		findC = new JComboBox<String>(item);
		wordTf = new JTextField();
		searchBt = new JButton("검색");

		rightTop2.add(findC);
		rightTop2.add(wordTf);
		rightTop2.add(searchBt);

		rightTop.add(new Label(""));
		rightTop.add(rightTop1);
		rightTop.add(rightTop2);
		rightTop.add(new Label(""));

		JPanel rightCenter = new JPanel(new BorderLayout());
		homeModel = new DefaultTableModel(title, 20);
		homeTable = new JTable(homeModel);
		// 테이블 정렬 기능
		TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(homeTable.getModel());
		homeTable.setRowSorter(sorter);
		homePan = new JScrollPane(homeTable);
		homeTable.setColumnSelectionAllowed(true);
		rightCenter.add(new JLabel("거래 내역", JLabel.CENTER), "North");
		rightCenter.add(homePan, "Center");

		right.add(rightTop, "North");
		right.add(rightCenter, "Center");

		JPanel mainP = new JPanel(new GridLayout(1, 2));

		mainP.add(left);
		mainP.add(right);

		mainP.setBorder(BorderFactory.createEmptyBorder(20, 10, 10, 10));
		frame.add(mainP, "Center");

		/* 이벤트 연결 */

		homeTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				int row = homeTable.getSelectedRow();
				System.out.println("선택된 row : " + row);
				System.out.println("선택된 row의 column 값 :" + homeModel.getValueAt(row, 0));
				int code = Integer.parseInt(((String) homeModel.getValueAt(row, 0)).trim());
				showHomeInfo(code);
				currentDong = curHome.getDong();
			}
		});

		// complete code #01
		// 아래의 코드를 참조하여 아래 라인을 uncomment 하고 searchBt.addActionList() 를 Lambda 표현식으로
		// 바꾸세요.
		searchBt.addActionListener(e -> actionPerformed(e));
		envBt.addActionListener(e -> actionPerformedEnv(e));

//		// 참조코드 시작 - 위 코드를 완성 후 삭제 또는 comment 처리하세요.
//		ActionListener buttonHandler = new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				searchHomes();
//			}
//		};
//		
//		searchBt.addActionListener( buttonHandler );
//		// 참조코드 종료

		showHomes();
	}

	private Object actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		searchHomes();
		return null;
	}

	// Test 창 출력
	private void actionPerformedEnv(ActionEvent e) {
		System.out.println("In");
		frame = new JFrame("asd");

		envTable = new JTable();

		String[] header = { "업체명", "지도점검일", "점검사항", "소재지주소" };
		envModel = (DefaultTableModel) envTable.getModel();
		envModel.setColumnIdentifiers(header);
		envModel.setRowCount(0);

		if (currentDong != null) {
			System.out.println(currentDong);
			List<EnvironmentInfo> list = homeService.searchEnv(currentDong);
			if (list != null) {
				for (EnvironmentInfo info : list) {
					envModel.addRow(new Object[] { info.getName(), info.getDate(), info.getDesc(), info.getAddr() });
				}
			}
			else {
				System.out.println("null");
			}

		}
		frame.add(new JScrollPane(envTable), BorderLayout.CENTER);
		frame.setTitle("날씨");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(500, 300);
		frame.setVisible(true);
//		
//		frame.setSize(1200, 800);
//		frame.setResizable(true);
//		frame.setVisible(true);
	}

	/** 검색 조건에 맞는 주택 정보 검색 */
	private void searchHomes() {
		for (int i = 0, size = chooseC.length; i < size; i++) {
			if (chooseC[i].isSelected()) {
				searchType[i] = true;
			} else {
				searchType[i] = false;
			}
		}
		word = wordTf.getText().trim();
		key = choice[findC.getSelectedIndex()];
		System.out.println("word:" + word + " key:" + key);
		showHomes();
	}

	/**
	 * 주택 목록을 갱신하기 위한 메서드
	 */
	public void showHomes() {
		HomePageBean bean = new HomePageBean();
		bean.setSearchType(searchType);
		if (key != null) {
			if (key.equals("dong")) {
				bean.setDong(word);
			} else if (key.equals("name")) {
				bean.setAptname(word);
			}
		}

		List<HomeDeal> deals = homeService.searchAll(bean);
		if (deals != null) {
			int i = 0;
			String[][] data = new String[deals.size()][5];
			for (HomeDeal deal : deals) {
				data[i][0] = "" + deal.getNo();
				data[i][1] = deal.getDong();
				data[i][2] = deal.getAptName();
				data[i][3] = deal.getDealAmount();
				data[i++][4] = deal.getType();
			}
			homeModel.setDataVector(data, title);
		}
	}
//	public static void main(String[] args) {
//		new HomeInfoView();
//	}

}
