package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.JButton;

import Management.ScheduleManager;
import gui.ScheduleViewer;
import gui.WindowFrame;

public class ButtonViewListener implements ActionListener {
	
	WindowFrame frame;

	public ButtonViewListener(WindowFrame frame) {
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//JButton b = (JButton)e.getSource();
		ScheduleViewer scheduleViewer = frame.getScheduleViewer();
		ScheduleManager schedulemanager = getObject("schedulemanager.ser");
		scheduleViewer.setSchedulemanager(schedulemanager);
		
		frame.getContentPane().removeAll();
		frame.getContentPane().add(scheduleViewer);
		frame.revalidate();
		frame.repaint();

	}
	
	public static ScheduleManager getObject(String filename) {
		ScheduleManager schedulemanager = null;
		
		try {
			FileInputStream file = new FileInputStream(filename); //파일을 가져올수 있는 객체를 생성함
			ObjectInputStream in = new ObjectInputStream(file);//파일을 object단위로 가져올 수 있는 객체를 생성함
			
			schedulemanager=(ScheduleManager) in.readObject();//객체를 가져와 schedulmanage에 넣음
			in.close();
			file.close();
		} catch (FileNotFoundException e) {
			return schedulemanager;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return schedulemanager;//schedulemangager을 리턴해줌

	}

}
