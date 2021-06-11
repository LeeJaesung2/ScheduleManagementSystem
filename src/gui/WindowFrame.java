package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Management.ScheduleManager;

public class WindowFrame extends JFrame{
	
	ScheduleManager schedulemanager;//ScheduleManager객체를 생성함
	
	MenuSelection menuselection;
	ScheduleAdder scheduleadder;
	ScheduleViewer scheduleViewer;

	public WindowFrame(ScheduleManager schedulemanager) {
		//frame 설정
		this.setSize(500, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.schedulemanager = schedulemanager;//schedule객체 생성
		this.menuselection = new MenuSelection(this);//menuSelection객체 생성
		this.scheduleadder = new ScheduleAdder(this,this.schedulemanager);//scheduleAdder객체 생성
		this.scheduleViewer = new ScheduleViewer(this,this.schedulemanager);//scheduleViewer객체 생성

		
		this.add(menuselection);//frame에 menuselection을 넣음
		
		this.setVisible(true);
	}
	
	public void setupPanel(JPanel panel) {
		this.getContentPane().removeAll();//패널을 모두 지움
		this.getContentPane().add(panel);//받아온 패널을 다시 넣음
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
