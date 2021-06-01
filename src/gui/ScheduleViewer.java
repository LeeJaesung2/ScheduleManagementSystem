package gui;

import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Management.ScheduleManager;
import Schedule.Scheduleinput;

public class ScheduleViewer extends JPanel{
	
	WindowFrame frame;
	
	ScheduleManager schedulemanager;

	public ScheduleViewer(WindowFrame frame, ScheduleManager schedulemanager) {
		this.frame = frame;
		this.schedulemanager = schedulemanager;
		
		System.out.println("****"+schedulemanager.size()+"****");
		
		DefaultTableModel model = new DefaultTableModel(); //표를 생성
		model.addColumn("Day");//day 열 생성
		model.addColumn("Kind");//kind 열
		model.addColumn("Schedule");//schedule열
		model.addColumn("Memo");//memo열
		
		for(int i=0;i<schedulemanager.size();i++) {
			Vector row = new Vector();
			Scheduleinput si = schedulemanager.get(i);
			row.add("20"+si.getDay());
			row.add(si.getKindString());
			row.add(si.getSchedule());
			row.add(si.getMemo());
			model.addRow(row);
		}

		JTable table = new JTable(model);//테이블에 만들어진 model을 넣음
		JScrollPane sp = new JScrollPane(table);
		
		this.add(sp);
		
	}

}
