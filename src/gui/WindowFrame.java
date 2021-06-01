package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class WindowFrame extends JFrame{
	
	MenuSelection menuselection;
	ScheduleAdder scheduleadder;
	ScheduleViewer scheduleViewer;
	

	public WindowFrame() {
		this.menuselection = new MenuSelection(this);
		this.scheduleadder = new ScheduleAdder(this);
		this.scheduleViewer = new ScheduleViewer(this);
		//frame ����
		this.setSize(500, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		this.setupPanel(menuselection);
		
		this.setVisible(true);
	}
	
	public void setupPanel(JPanel panel) {
		this.getContentPane().removeAll();
		this.getContentPane().add(panel);
		this.revalidate();
		this.repaint();
		
	}
	
	public MenuSelection getMenuselection() {
		return menuselection;
	}

	public void setMenuselection(MenuSelection menuselection) {
		this.menuselection = menuselection;
	}

	public ScheduleAdder getScheduleadder() {
		return scheduleadder;
	}

	public void setScheduleadder(ScheduleAdder scheduleadder) {
		this.scheduleadder = scheduleadder;
	}

	public ScheduleViewer getScheduleViewer() {
		return scheduleViewer;
	}

	public void setScheduleViewer(ScheduleViewer scheduleViewer) {
		this.scheduleViewer = scheduleViewer;
	}


}