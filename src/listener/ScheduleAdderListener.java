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
		//***********kind���Ͽ� ��ü ���� �ٸ��� �ش�
		
		Scheduleinput schedule;
		ScheduleKind kind;
		//�Է¹��� kind������ ������ �´� ��ü�� ��������
		switch(fieldKind.getText()) {
		case "Mornig":
			schedule = new MornigSchedule(ScheduleKind.Mornig);
			kind = ScheduleKind.Mornig;
			schedule.setDay(Integer.parseInt(fieldDay.getText()));
			schedule.setKind(kind);
			schedule.setSchedule(fieldSchedule.getText()); //************String������ ������ ���� �ʿ�
			schedule.setMemo(fieldMemo.getText()); //************String������ ������ ���� �ʿ�
			schedulemanager.addSchedule(schedule);
			putObject(schedulemanager,"schedulemanager.ser");
			break;
		case "Afternoon":
			schedule = new MornigSchedule(ScheduleKind.Mornig);
			kind = ScheduleKind.Afternoon;
			schedule.setDay(Integer.parseInt(fieldDay.getText()));
			schedule.setKind(kind);
			schedule.setSchedule(fieldSchedule.getText()); //************String������ ������ ���� �ʿ�
			schedule.setMemo(fieldMemo.getText()); //************String������ ������ ���� �ʿ�
			schedulemanager.addSchedule(schedule);
			putObject(schedulemanager,"schedulemanager.ser");
			break;
		case "Night":
			schedule = new MornigSchedule(ScheduleKind.Mornig);
			kind = ScheduleKind.Night;
			schedule.setDay(Integer.parseInt(fieldDay.getText()));
			schedule.setKind(kind);
			schedule.setSchedule(fieldSchedule.getText()); //************String������ ������ ���� �ʿ�
			schedule.setMemo(fieldMemo.getText()); //************String������ ������ ���� �ʿ�
			schedulemanager.addSchedule(schedule);
			putObject(schedulemanager,"schedulemanager.ser");
			break;
		case "Evening":
			schedule = new MornigSchedule(ScheduleKind.Mornig);
			kind = ScheduleKind.Evening;
			schedule.setDay(Integer.parseInt(fieldDay.getText()));
			schedule.setKind(kind);
			schedule.setSchedule(fieldSchedule.getText()); //************String������ ������ ���� �ʿ�
			schedule.setMemo(fieldMemo.getText()); //************String������ ������ ���� �ʿ�
			schedulemanager.addSchedule(schedule);
			putObject(schedulemanager,"schedulemanager.ser");
			break;
		}
		
		//schedule.printInfo(0);
		
	}
	
	
	//�Է¹��� ��ü�� ���Ͽ� �Է��Ͽ� �����ϴ� �Լ�
		public static void putObject(ScheduleManager schedulemanager, String filename) {
			try {
				FileOutputStream file = new FileOutputStream(filename,true);//������ �Է��Ҽ� �ִ� ��ü�� ������
				ObjectOutputStream out = new ObjectOutputStream(file);//������ object������ ������ �� �ִ� ��ü�� ������
				
				out.writeObject(schedulemanager);//schedulemanager�� �Է���
				
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

