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
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

@SuppressWarnings("serial")
class WeatherMain extends JFrame {
	JButton button = null;
	JTable table = null;
	DefaultTableModel model = null;

	public static void main(String[] args) {
		WeatherMain wm = new WeatherMain();
		wm.createGUI();
		// WeatherDAO w = new WeatherDAO();
		// List<Weather> list = w.getWeatherList();

	}

	void createGUI() {

		// GUI setting
		showList();

		// 버튼 눌렀을때 동작 정의
		addEvent();
	}

	void showList() {
		button = new JButton("불러오기");
		table = new JTable();

		String[] header = { "시간", "온도", "날씨", "습도" };

		TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(table.getModel());
		table.setRowSorter(sorter);

		model = (DefaultTableModel) table.getModel();
		model.setColumnIdentifiers(header);

		this.add(new JScrollPane(table), BorderLayout.CENTER);
		this.add(button, BorderLayout.SOUTH);
		this.setTitle("날씨");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500, 300);
		this.setVisible(true);
	}

	void addEvent() {
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 기존 자료 삭제 (없으면 누를 때 마다 row가 쌓임)
				model.setRowCount(0);
				// 새로운 자료 조회
				WeatherDAO parser = new WeatherDAO();
				List<Weather> list = parser.getWeatherList();
				for (Weather info : list) {
					model.addRow(new Object[] { info.getHour(), info.getTemp(), info.getWfKor(), info.getReh() });
				}
				// model의 데이터가 변경되었음을 알림
				model.fireTableDataChanged();
			}
		});

		// @@TODOBLOCK:테이블에서 발생하는 click event 처리를 위한 listener 등록
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				String nm = model.getValueAt(row, 1).toString();
				JOptionPane.showMessageDialog(WeatherMain.this, "선택된 요소: " + nm);
			}
		});

		// @@END:
	}

}