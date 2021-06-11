package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import gui.ScheduleAdder;
import gui.ScheduleViewer;
import gui.WindowFrame;

public class ScheduleAdderCancelListener implements ActionListener {
	
	WindowFrame frame;
	//frame을 받아오는 생성자
	public ScheduleAdderCancelListener(WindowFrame frame) {
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		frame.getContentPane().removeAll();
		frame.getContentPane().add(frame.getMenuselection());
		frame.revalidate();
		frame.repaint();
	}

}
