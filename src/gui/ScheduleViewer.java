package gui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ScheduleViewer extends JPanel{
	
	WindowFrame frame;

	public ScheduleViewer(WindowFrame frame) {
		this.frame = frame;

		DefaultTableModel model = new DefaultTableModel(); //ǥ�� ����
		model.addColumn("Day");//day �� ����
		model.addColumn("Kind");//kind ��
		model.addColumn("Schedule");//schedule��
		model.addColumn("Memo");//memo��

		JTable table = new JTable(model);//���̺� ������� model�� ����
		JScrollPane sp = new JScrollPane(table);
		
		this.add(sp);
		
	}

}
