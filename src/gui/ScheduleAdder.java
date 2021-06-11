package gui;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import Management.ScheduleManager;
import listener.ScheduleAdderCancelListener;
import listener.ScheduleAdderListener;

public class ScheduleAdder extends JPanel{

	WindowFrame frame;
	ScheduleManager schedulemanager;
	
	public ScheduleAdder(WindowFrame frame, ScheduleManager schedulemanager) {
		this.frame = frame;
		this.schedulemanager = schedulemanager;
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
		
		JButton saveButton = new JButton("save");
		saveButton.addActionListener(new ScheduleAdderListener(fieldDay, fieldKind, fieldSchedule, fieldMemo, schedulemanager));
		JButton cancelButton = new JButton("cancel");
		cancelButton.addActionListener(new ScheduleAdderCancelListener(frame));
		panel.add(labelMemo);
		panel.add(fieldMemo);
		
		
		panel.add(saveButton);
		panel.add(cancelButton);
		
		SpringUtilities.makeCompactGrid(panel, 5, 2, 6, 6, 6, 6 );
		
		this.add(panel);
		this.setVisible(true);
	}

}
