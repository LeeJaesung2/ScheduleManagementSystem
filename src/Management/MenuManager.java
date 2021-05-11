package Management;
 import java.util.Scanner;

public class MenuManager {

	public static void main(String[] args) {
		int num = 0;
		Scanner input = new Scanner(System.in);
		ScheduleManager schedulemanager = new ScheduleManager(input);   //'ScheduleManager' ��ü�� �����Ͽ� 'schedulemamager'������ �����ϰ� input�� ���ڷ� ��
		
		while (num != 5) {
			showMenu();
			num = input.nextInt();   //���� �Է¹���
		
			switch(num) {
			case 1:      //���� 1�ΰ��
				schedulemanager.addSchedule();
				break;
			case 2:     //���� 2�� ���
				schedulemanager.deleteSchedule();
				break;
			case 3:     //���� 3�ΰ��
				schedulemanager.editSchedule();
				break;
			case 4:     //���� 4�� ���
				schedulemanager.viewSchedules();
				break;
			case 5:    //���� 5�ΰ��
				continue;
				
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
