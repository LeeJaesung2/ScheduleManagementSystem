package Management;
 import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuManager {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		ScheduleManager schedulemanager = new ScheduleManager(input);   //'ScheduleManager' 객체를 생성하여 'schedulemamager'변수에 연결하고 input을 인자로 함
		selectMenu(input, schedulemanager);
	}
	
	public static void selectMenu(Scanner input,ScheduleManager schedulemanager) {
		int num = -1;
		while (num != 5) {
			try {
				showMenu();
				num = input.nextInt();   //수를 입력받음
			
				switch(num) {
				case 1:      //수가 1인경우
					schedulemanager.addSchedule();
					break;
				case 2:     //수가 2인 경우
					schedulemanager.deleteSchedule();
					break;
				case 3:     //수가 3인경우
					schedulemanager.editSchedule();
					break;
				case 4:     //수가 4인 경우
					schedulemanager.viewSchedules();
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

}
