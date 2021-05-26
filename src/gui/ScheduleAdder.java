package gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class ScheduleAdder extends JFrame{
	
	public ScheduleAdder() {
		JPanel panel = new JPanel();
		panel.setLayout(new SpringLayout());
		
		JLabel labelDay = new JLabel("Day: ",JLabel.TRAILING);
		JTextField fieldDay = new JTextField(8);
		labelDay.setLabelFor(fieldDay);
		panel.add(labelDay);
		panel.add(fieldDay);
		
		JLabel labelKind = new JLabel("Kind: ",JLabel.TRAILING);
		JTextField fieldKind = new JTextField(8);
		labelDay.setLabelFor(fieldKind);
		panel.add(labelKind);
		panel.add(fieldKind);
		
		JLabel labelSchedule = new JLabel("Schedule: ",JLabel.TRAILING);
		JTextField fieldSchedule = new JTextField(8);
		labelDay.setLabelFor(fieldSchedule);
		panel.add(labelSchedule);
		panel.add(fieldSchedule);
		
		JLabel labelMemo = new JLabel("Memo: ",JLabel.TRAILING);
		JTextField fieldMemo = new JTextField(8);
		labelDay.setLabelFor(fieldMemo);
		panel.add(labelMemo);
		panel.add(fieldMemo);
		
		panel.add(new JButton("save"));
		panel.add(new JButton("cancel"));
		
		SpringUtilities.makeCompactGrid(panel, 5, 2, 6, 6, 6, 6 );
		
		this.setSize(300, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(panel);
		this.setVisible(true);
	}

}
