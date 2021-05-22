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
	private static final long serialVersionUID = 1810731276601538818L; //�ø����� �־���
	static EventLogger logger = new EventLogger("log.txt"); //EventLogger ��ü�� �����ϰ� ���ڷ� �����̸��� log.txt�� ����

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		ScheduleManager schedulemanager = getObject("schedulemanager.ser");//schedulemanager.ser�� ����Ǿ��ִ� ������ ������ schedulemanager�� ������
		if(schedulemanager==null) {//schedulemanager�� ����ִ� ���
			schedulemanager = new ScheduleManager(input);   //'ScheduleManager' ��ü�� �����Ͽ� 'schedulemamager'������ �����ϰ� input�� ���ڷ� ��
		}
				
		selectMenu(input, schedulemanager);
		putObject(schedulemanager,"schedulemanager.ser");//schedulemanager���� schedulemanager.ser�� ����
	}
	
	public static void selectMenu(Scanner input,ScheduleManager schedulemanager) {
		int num = -1;
		while (num != 5) {
			try {
				showMenu();
				if(input == null) {
					input = new Scanner(System.in);
				}
				num = input.nextInt();   //���� �Է¹���
			
				switch(num) {
				case 1:      //���� 1�ΰ��
					schedulemanager.addSchedule();
					logger.log("add a Schedule"); //�α׿� �߰�
					break;
				case 2:     //���� 2�� ���
					schedulemanager.deleteSchedule();
					logger.log("delete a Schedule");//�α׿� �߰�
					break;
				case 3:     //���� 3�ΰ��
					schedulemanager.editSchedule();
					logger.log("edit a Schedule");//�α׿� �߰�
					break;
				case 4:     //���� 4�� ���
					schedulemanager.viewSchedules();
					logger.log("view a list of Schedule");//�α׿� �߰�
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
	
	//��ü������ ����ִ� ������ �������� �Լ�
	public static ScheduleManager getObject(String filename) {
		ScheduleManager schedulemanager = null;
		
		try {
			FileInputStream file = new FileInputStream(filename); //������ �����ü� �ִ� ��ü�� ������
			ObjectInputStream in = new ObjectInputStream(file);//������ object������ ������ �� �ִ� ��ü�� ������
			
			schedulemanager=(ScheduleManager) in.readObject();//��ü�� ������ schedulmanage�� ����
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
		return schedulemanager;//schedulemangager�� ��������

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
