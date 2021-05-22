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
	private static final long serialVersionUID = 1810731276601538818L; //시리얼을 넣어줌
	static EventLogger logger = new EventLogger("log.txt"); //EventLogger 객체를 생성하고 인자로 파일이름인 log.txt를 넣음

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		ScheduleManager schedulemanager = getObject("schedulemanager.ser");//schedulemanager.ser에 저장되어있는 정보를 가져와 schedulemanager에 저장함
		if(schedulemanager==null) {//schedulemanager이 비어있는 경우
			schedulemanager = new ScheduleManager(input);   //'ScheduleManager' 객체를 생성하여 'schedulemamager'변수에 연결하고 input을 인자로 함
		}
				
		selectMenu(input, schedulemanager);
		putObject(schedulemanager,"schedulemanager.ser");//schedulemanager값을 schedulemanager.ser에 저장
	}
	
	public static void selectMenu(Scanner input,ScheduleManager schedulemanager) {
		int num = -1;
		while (num != 5) {
			try {
				showMenu();
				if(input == null) {
					input = new Scanner(System.in);
				}
				num = input.nextInt();   //수를 입력받음
			
				switch(num) {
				case 1:      //수가 1인경우
					schedulemanager.addSchedule();
					logger.log("add a Schedule"); //로그에 추가
					break;
				case 2:     //수가 2인 경우
					schedulemanager.deleteSchedule();
					logger.log("delete a Schedule");//로그에 추가
					break;
				case 3:     //수가 3인경우
					schedulemanager.editSchedule();
					logger.log("edit a Schedule");//로그에 추가
					break;
				case 4:     //수가 4인 경우
					schedulemanager.viewSchedules();
					logger.log("view a list of Schedule");//로그에 추가
					break;
				case 5:    //수가 5인경우
					continue;
					
				}
			}
			catch(InputMismatchException e) { //InputMismatchException이 발생시 다시 입력받음
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
	
	//객체정보가 들어있는 파일을 가져오는 함수
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
