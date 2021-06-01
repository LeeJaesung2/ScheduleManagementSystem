package gui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ScheduleViewer extends JPanel{
	
	WindowFrame frame;

	public ScheduleViewer(WindowFrame frame) {
		this.frame = frame;

		DefaultTableModel model = new DefaultTableModel(); //표를 생성
		model.addColumn("Day");//day 열 생성
		model.addColumn("Kind");//kind 열
		model.addColumn("Schedule");//schedule열
		model.addColumn("Memo");//memo열

		JTable table = new JTable(model);//테이블에 만들어진 model을 넣음
		JScrollPane sp = new JScrollPane(table);
		
		this.add(sp);
		
	}

}
