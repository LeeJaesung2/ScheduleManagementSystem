package gui;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class ScheduleAdder extends JPanel{

	WindowFrame frame;
	
	public ScheduleAdder(WindowFrame frame) {
		this.frame = frame;
		JPanel panel = new JPanel();
		panel.setLayout(new SpringLayout());
		//day�ۼ���
		JLabel labelDay = new JLabel("Day: ",JLabel.TRAILING);//label����
		JTextField fieldDay = new JTextField(8);//textfield����
		labelDay.setLabelFor(fieldDay);//�󺧿� �ʵ带 ����
		panel.add(labelDay);//panel�� ���� ����
		panel.add(fieldDay);//panel�� field�� ����
		//kind�ۼ���
		JLabel labelKind = new JLabel("Kind: ",JLabel.TRAILING);
		JTextField fieldKind = new JTextField(8);
		labelDay.setLabelFor(fieldKind);
		panel.add(labelKind);
		panel.add(fieldKind);
		//schedule�ۼ���
		JLabel labelSchedule = new JLabel("Schedule: ",JLabel.TRAILING);
		JTextField fieldSchedule = new JTextField(8);
		labelDay.setLabelFor(fieldSchedule);
		panel.add(labelSchedule);
		panel.add(fieldSchedule);
		//memo�ۼ���
		JLabel labelMemo = new JLabel("Memo: ",JLabel.TRAILING);
		JTextField fieldMemo = new JTextField(8);
		labelDay.setLabelFor(fieldMemo);
		panel.add(labelMemo);
		panel.add(fieldMemo);
		
		panel.add(new JButton("save"));
		panel.add(new JButton("cancel"));
		
		SpringUtilities.makeCompactGrid(panel, 5, 2, 6, 6, 6, 6 );
		
		this.add(panel);
		this.setVisible(true);
	}

}
