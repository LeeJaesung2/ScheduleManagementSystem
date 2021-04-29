package Management;
import java.util.ArrayList;
import java.util.Scanner;

import Schedule.AfternoonSchedule;
import Schedule.MornigSchedule;
import Schedule.NightSchedule;
import Schedule.Schedule;
import Schedule.ScheduleKind;

public class ScheduleManager {

	Scanner input;
	ArrayList <Schedule> schedules = new ArrayList<Schedule>();  //'Schedule' ��ü�� ����Ű�� 'schedule' �迭�� ����
	
	//'input'�� ���ڷ� �ϴ� ������
	ScheduleManager(Scanner input){
		this.input= input;
	}
	
	
    //'addSchedule' �Լ�
	public void addSchedule() {       
		
		
		System.out.println("Day : 20XX.XX.XX");
		int day = input.nextInt();   //�Է°��� 'day'�� ������
		int kind = 0;
		Schedule schedule;
	    while(kind != 1 && kind != 2 && kind != 3) {  //'kind'�� 1,2,3���� ���� �Է¹��������� ���� 
	    	System.out.println("1. Mornig");
			System.out.println("2. Afternoon");
			System.out.println("3. Night");
			System.out.println("Select Time between 1~3 : ");
			kind = input.nextInt();
			//Mornig �� ���
			if (kind==1){
				schedule = new MornigSchedule(ScheduleKind.Mornig);  //'MornigSchedule' ��ü�� ����� 'schedule'�� ����
				schedule.getUserInput(input);  //'getUserIput'�Լ� ����
				schedule.setDay(day);  //�Է¹��� 'day'�� ������
				schedules.add(schedule);  //'schedules'�ݷ��ǿ� 'schedule'�� ����
				break;
			}
			//Afternoon�� ���
			else if(kind ==2) {
				schedule = new AfternoonSchedule(ScheduleKind.Afternoon);
				schedule.getUserInput(input);
				schedule.setDay(day);
				schedules.add(schedule);
				break;
			}
			//Night�� ���
			else if(kind == 3) {
				schedule = new NightSchedule(ScheduleKind.Night);
				schedule.getUserInput(input);
				schedule.setDay(day);
				schedules.add(schedule);
				break;
			}
			else {
				System.out.println("Select Time between 1~3 : ");
			}//else��
	    }//while��
		
	}//add�Լ�
	
	//'deleteSchedule'�Լ�
	public void deleteSchedule() {
		
		System.out.println("Day : 20XX.XX.XX");
		int day = input.nextInt();    //���� �Է¹޾� 'day'�� ������
		int index = -1;
		for(int i = 0; i<schedules.size();i++) {  //'collection'�� ũ�⸸ŭ ����
			if(schedules.get(i).getDay()==day) {  //�Է¹��� ��¥�� ��ġ�ϴ� ���
				index = i;  //�ε��� ����
				break;
			
			}
		}
		
		if(index>=0) {  //�ε����� �ִ°��
			schedules.remove(index);  //���� ����
			System.out.println("the shcdule 20"+day+ " is deleted");
			
		}
	
		
		else
			System.out.println("The Schedule has not been registered");   //'Schedule' class�� ������� �ʾ����� �˸�

	}
		
	//'editSchedule'�Լ�
	public void editSchedule() {
		System.out.println("Day : 20XX.XX.XX");
		int day = input.nextInt();    //���� �Է¹޾� 'day'�� ������
		for(int i = 0; i<schedules.size();i++) {  //'collection'�� ũ�⸸ŭ ����
			Schedule schedule = schedules.get(i); 
			if(schedule.getDay() == day) {  //'schedule'�� 'day'�� �Է¹���'day'�� ��ġ�ϴ� ���
				int num = -1;
				while(num!=4) {  //����� ������ ������ �Է� ����
					System.out.println("** Schedule Edit Menu **");
					System.out.println("1. Edit day");
					System.out.println("2. Edit Schedule");
					System.out.println("3. Edit Memo");
					System.out.println("4. Exit Edit");
					System.out.println("Select one number between 1~4");
					num = input.nextInt();
					
					//'day'�� ������
					if (num == 1 ) {
						System.out.println("Day : ");
						int dayedit = input.nextInt();
						schedule.setDay(dayedit);
					}
					//'schedule'�� ������
					else if (num == 2) {
						System.out.println("Schedule : ");
						String scheduleedit = input.next();
						schedule.setSchedule(scheduleedit);
					}
					//'memo'�� ������
					else if (num ==3) {
						System.out.println("Memo : ");
						String memo = input.next();
						schedule.setMemo(memo);
					}
					else {
						continue;
					}//if
				}//while
				break;
			}//if
		}//for
		
			
		
	}	
	
    //'viewScheudles'�Լ�
	public void viewSchedules() {
		for(int i = 0; i<schedules.size();i++) {
			schedules.get(i).printInfo(i);
		}
			
	}
		
		
}