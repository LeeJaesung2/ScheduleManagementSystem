package Management;
 import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;

import log.EventLogger;

public class MenuManager implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1810731276601538818L;
	static EventLogger logger = new EventLogger("log.txt");

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		ScheduleManager schedulemanager = getObject("schedulemanager.ser");
		if(schedulemanager==null) {
			schedulemanager = new ScheduleManager(input);   //'ScheduleManager' ��ü�� �����Ͽ� 'schedulemamager'������ �����ϰ� input�� ���ڷ� ��
		}
				
		selectMenu(input, schedulemanager);
		putObject(schedulemanager,"schedulemanager.ser");
	}
	
	public static void selectMenu(Scanner input,ScheduleManager schedulemanager) {
		int num = -1;
		while (num != 5) {
			try {
				showMenu();
				num = input.nextInt();   //���� �Է¹���
			
				switch(num) {
				case 1:      //���� 1�ΰ��
					schedulemanager.addSchedule();
					logger.log("add a Schedule");
					break;
				case 2:     //���� 2�� ���
					schedulemanager.deleteSchedule();
					logger.log("delete a Schedule");
					break;
				case 3:     //���� 3�ΰ��
					schedulemanager.editSchedule();
					logger.log("edit a Schedule");
					break;
				case 4:     //���� 4�� ���
					schedulemanager.viewSchedules();
					logger.log("view a list of Schedule");
					break;
				case 5:    //���� 5�ΰ��
					continue;
					
				}
			}
			catch(InputMismatchException e) { //InputMismatchException�� �߻��� �ٽ� �Է¹���
				System.out.println("Please put an integer between 1 and 5 !");
				if (input.hasNext()) {
					input.next();
				}
				num = -1;
				
			}
		}

	}
	
	
	public static void showMenu() {
		System.out.println("*** Schedule Management System Menu ***");
		System.out.println("1. Add schedule");
		System.out.println("2. Delete schedule");
		System.out.println("3. Edit schedule");
		System.out.println("4. View schedules");
		System.out.println("5. Exit schedule");
		System.out.println("Select one number between 1 ~ 5");
		
	}
	
	public static ScheduleManager getObject(String filename) {
		ScheduleManager schedulemanager = null;
		
		try {
			FileInputStream file = new FileInputStream(filename);
			ObjectInputStream in = new ObjectInputStream(file);
			
			schedulemanager=(ScheduleManager) in.readObject();
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
		return schedulemanager;

	}
	
	public static void putObject(ScheduleManager schedulemanager, String filename) {
		try {
			FileOutputStream file = new FileOutputStream(filename);
			ObjectOutputStream out = new ObjectOutputStream(file);
			
			out.writeObject(schedulemanager);
			
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
