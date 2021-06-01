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
		panel.add(labelMemo);
		panel.add(fieldMemo);
		
		panel.add(new JButton("save"));
		panel.add(new JButton("cancel"));
		
		SpringUtilities.makeCompactGrid(panel, 5, 2, 6, 6, 6, 6 );
		
		this.add(panel);
		this.setVisible(true);
	}

}
