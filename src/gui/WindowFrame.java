package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Management.ScheduleManager;

public class WindowFrame extends JFrame{
	
	ScheduleManager schedulemanager;//ScheduleManager��ü�� ������
	
	MenuSelection menuselection;
	ScheduleAdder scheduleadder;
	ScheduleViewer scheduleViewer;

	public WindowFrame(ScheduleManager schedulemanager) {
		//frame ����
		this.setSize(500, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.schedulemanager = schedulemanager;//schedule��ü ����
		this.menuselection = new MenuSelection(this);//menuSelection��ü ����
		this.scheduleadder = new ScheduleAdder(this,this.schedulemanager);//scheduleAdder��ü ����
		this.scheduleViewer = new ScheduleViewer(this,this.schedulemanager);//scheduleViewer��ü ����

		
		this.add(menuselection);//frame�� menuselection�� ����
		
		this.setVisible(true);
	}
	
	public void setupPanel(JPanel panel) {
		this.getContentPane().removeAll();//�г��� ��� ����
		this.getContentPane().add(panel);//�޾ƿ� �г��� �ٽ� ����
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
