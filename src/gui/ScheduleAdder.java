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
		//day작성란
		JLabel labelDay = new JLabel("Day: ",JLabel.TRAILING);//label생성
		JTextField fieldDay = new JTextField(8);//textfield생성
		labelDay.setLabelFor(fieldDay);//라벨에 필드를 넣음
		panel.add(labelDay);//panel에 라벨을 넣음
		panel.add(fieldDay);//panel에 field를 넣음
		//kind작성란
		JLabel labelKind = new JLabel("Kind: ",JLabel.TRAILING);
		JTextField fieldKind = new JTextField(8);
		labelDay.setLabelFor(fieldKind);
		panel.add(labelKind);
		panel.add(fieldKind);
		//schedule작성란
		JLabel labelSchedule = new JLabel("Schedule: ",JLabel.TRAILING);
		JTextField fieldSchedule = new JTextField(8);
		labelDay.setLabelFor(fieldSchedule);
		panel.add(labelSchedule);
		panel.add(fieldSchedule);
		//memo작성란
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
