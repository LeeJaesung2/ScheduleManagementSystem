package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JTextField;

import Management.ScheduleManager;
import Schedule.MornigSchedule;
import Schedule.Schedule;
import Schedule.ScheduleKind;
import Schedule.Scheduleinput;

public class ScheduleAdderListener implements ActionListener {
	


	JTextField fieldDay;
	JTextField fieldKind;
	JTextField fieldSchedule;
	JTextField fieldMemo;
	
	ScheduleManager schedulemanager;
	
	public ScheduleAdderListener(
			JTextField fieldDay, 
			JTextField fieldKind, 
			JTextField fieldSchedule,
			JTextField fieldMemo, 
			ScheduleManager schedulemanager) {
		this.fieldDay = fieldDay;
		this.fieldKind = fieldKind;
		this.fieldSchedule = fieldSchedule;
		this.fieldMemo = fieldMemo;
		this.schedulemanager = schedulemanager;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(fieldDay.getText());
		System.out.println(fieldKind.getText());
		System.out.println(fieldSchedule.getText());
		System.out.println(fieldMemo.getText());
		//***********kind비교하여 객체 생성 다르게 해눔
		
		Scheduleinput schedule;
		ScheduleKind kind;
		//입력받은 kind에따라 각각에 맞는 객체를 생성해줌
		switch(fieldKind.getText()) {
		case "Mornig":
			schedule = new MornigSchedule(ScheduleKind.Mornig);
			kind = ScheduleKind.Mornig;
			schedule.setDay(Integer.parseInt(fieldDay.getText()));
			schedule.setKind(kind);
			schedule.setSchedule(fieldSchedule.getText()); //************String형식의 생성자 생성 필요
			schedule.setMemo(fieldMemo.getText()); //************String형식의 생성자 생성 필요
			schedulemanager.addSchedule(schedule);
			putObject(schedulemanager,"schedulemanager.ser");
			break;
		case "Afternoon":
			schedule = new MornigSchedule(ScheduleKind.Mornig);
			kind = ScheduleKind.Afternoon;
			schedule.setDay(Integer.parseInt(fieldDay.getText()));
			schedule.setKind(kind);
			schedule.setSchedule(fieldSchedule.getText()); //************String형식의 생성자 생성 필요
			schedule.setMemo(fieldMemo.getText()); //************String형식의 생성자 생성 필요
			schedulemanager.addSchedule(schedule);
			putObject(schedulemanager,"schedulemanager.ser");
			break;
		case "Night":
			schedule = new MornigSchedule(ScheduleKind.Mornig);
			kind = ScheduleKind.Night;
			schedule.setDay(Integer.parseInt(fieldDay.getText()));
			schedule.setKind(kind);
			schedule.setSchedule(fieldSchedule.getText()); //************String형식의 생성자 생성 필요
			schedule.setMemo(fieldMemo.getText()); //************String형식의 생성자 생성 필요
			schedulemanager.addSchedule(schedule);
			putObject(schedulemanager,"schedulemanager.ser");
			break;
		case "Evening":
			schedule = new MornigSchedule(ScheduleKind.Mornig);
			kind = ScheduleKind.Evening;
			schedule.setDay(Integer.parseInt(fieldDay.getText()));
			schedule.setKind(kind);
			schedule.setSchedule(fieldSchedule.getText()); //************String형식의 생성자 생성 필요
			schedule.setMemo(fieldMemo.getText()); //************String형식의 생성자 생성 필요
			schedulemanager.addSchedule(schedule);
			putObject(schedulemanager,"schedulemanager.ser");
			break;
		}
		
		//schedule.printInfo(0);
		
	}
	
	
	//입력받은 객체를 파일에 입력하여 저장하는 함수
		public static void putObject(ScheduleManager schedulemanager, String filename) {
			try {
				FileOutputStream file = new FileOutputStream(filename,true);//파일을 입력할수 있는 객체를 생성함
				ObjectOutputStream out = new ObjectOutputStream(file);//파일을 object단위로 저장할 수 있는 객체를 생성함
				
				out.writeObject(schedulemanager);//schedulemanager을 입력함
				
				out.close();
				file.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

}

