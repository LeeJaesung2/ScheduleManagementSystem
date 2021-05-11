package Management;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import Schedule.AfternoonSchedule;
import Schedule.EveningSchedule;
import Schedule.MornigSchedule;
import Schedule.NightSchedule;
import Schedule.Schedule;
import Schedule.ScheduleKind;
import Schedule.Scheduleinput;
import exceptions.DateFormatException;

public class ScheduleManager {

	Scanner input;
	ArrayList <Scheduleinput> schedules = new ArrayList<Scheduleinput>();  //'Schedule' ��ü�� ����Ű�� 'schedule' �迭�� ����
	
	//'input'�� ���ڷ� �ϴ� ������
	ScheduleManager(Scanner input){
		this.input= input;
	}
	
	public int dayinput() throws DateFormatException{ //DateFromatException���� ������ �������
		int day = input.nextInt();
		int length = (int)(Math.log10(day)+1);
		if(length != 6) {
			throw new DateFormatException();
		}
		return day;
	}
	
	
    //'addSchedule' �Լ�
	public void addSchedule() {       
		
		
		System.out.println("Day : 20XX.XX.XX");
		int day = 0;
		while((int)(Math.log10(day)+1)!=6) { //day�� 6�ڸ� ���� �ƴϸ� �����޼����� ���, �ٽ� �Է¹���
			try {
				day = dayinput();
			} catch (DateFormatException e) {
				System.out.println("Date in Incorrect. Put date again");
				System.out.println("Day : 20XX.XX.XX");
			}
		}
		int kind = -1;
		Scheduleinput scheduleinput;
	    while(kind < 1 || kind > 4) {  //'kind'�� 1,2,3���� ���� �Է¹��������� ���� 
	    	try {
		    	System.out.println("1. Mornig");
				System.out.println("2. Afternoon");
				System.out.println("3. Evenig");
				System.out.println("4. Night");
				System.out.println("Select Time between 1~4 : ");
				kind = input.nextInt();
				//Mornig �� ���
				if (kind==1){
					scheduleinput = new MornigSchedule(ScheduleKind.Mornig);  //'MornigSchedule' ��ü�� ����� 'schedule'�� ����
					scheduleinput.getUserInput(input);  //'getUserIput'�Լ� ����
					scheduleinput.setDay(day);  //�Է¹��� 'day'�� ������
					schedules.add(scheduleinput);  //'schedules'�ݷ��ǿ� 'schedule'�� ����
					break;
				}
				//Afternoon�� ���
				else if(kind ==2) {
					scheduleinput = new AfternoonSchedule(ScheduleKind.Afternoon);
					scheduleinput.getUserInput(input);
					scheduleinput.setDay(day);
					schedules.add(scheduleinput);
					break;
				}
				//Evenig�� ���
				else if(kind ==3) {
					scheduleinput = new EveningSchedule(ScheduleKind.Evening);
					scheduleinput.getUserInput(input);
					scheduleinput.setDay(day);
					schedules.add(scheduleinput);
					break;
				}
				//Night�� ���
				else if(kind == 4) {
					scheduleinput = new NightSchedule(ScheduleKind.Night);
					scheduleinput.getUserInput(input);
					scheduleinput.setDay(day);
					schedules.add(scheduleinput);
					break;
				}
				else {
					System.out.println("Select Time between 1~3 : ");
				}//else��
	    	}//try ��
	    	catch(InputMismatchException e){
	    		System.out.println("Please put an integer between 1 and 4 !");
				if (input.hasNext()) {
					input.next();
				}
				kind = -1;
	    	}//catch��
	    }//while��
		
	}//add�Լ�
	//_____________________________________________________________________________________________________________
	
	//'deleteSchedule'�Լ�
	public void deleteSchedule() {
		int day = 0;
		System.out.println("Day : 20XX.XX.XX");
		while((int)(Math.log10(day)+1)!=6) {//day�� 6�ڸ� ���� �ƴϸ� �����޼����� ���, �ٽ� �Է¹���
			try {
				day = dayinput();
			} catch (DateFormatException e) {
				System.out.println("Date in Incorrect. Put date again");
				System.out.println("Day : 20XX.XX.XX");
			}
		}
		int index = findIndex(day);
		removefromSchedule(index, day);
	}
	
	//deleteSchedule�� �ʿ��� �Լ�
	public int findIndex(int day) {
		int index = -1;
		for(int i = 0; i<schedules.size();i++) {  //'collection'�� ũ�⸸ŭ ����
			if(schedules.get(i).getDay()==day) {  //�Է¹��� ��¥�� ��ġ�ϴ� ���
				index = i;  //�ε��� ����
				break;
			
			}
		}
		return index;
	}
	
	public int removefromSchedule(int index,int day) {
		if(index>=0) {  //�ε����� �ִ°��
			schedules.remove(index);  //���� ����
			System.out.println("the shcdule 20"+day+ " is deleted");
			return 1;
		}
	
		
		else
			System.out.println("The Schedule has not been registered");   //'Schedule' class�� ������� �ʾ����� �˸�
		return -1;
		
	}
	//_____________________________________________________________________________________________________________
	//'editSchedule'�Լ�
	public void editSchedule() {
		System.out.println("Day : 20XX.XX.XX");
		int day = 0;    //���� �Է¹޾� 'day'�� ������
		while((int)(Math.log10(day)+1)!=6) {//day�� 6�ڸ� ���� �ƴϸ� �����޼����� ���, �ٽ� �Է¹���
			try {
				day = dayinput();
			} catch (DateFormatException e) {
				System.out.println("Date in Incorrect. Put date again");
				System.out.println("Day : 20XX.XX.XX");
			}
		}
		for(int i = 0; i<schedules.size();i++) {  //'collection'�� ũ�⸸ŭ ����
			Scheduleinput schedule = schedules.get(i);
			if(schedule.getDay() == day) {  //'schedule'�� 'day'�� �Է¹���'day'�� ��ġ�ϴ� ���
				int num = -1;
				while(num!=4) {  //����� ������ ������ �Է� ����
					showEditMenu();
					num = input.nextInt();
					
					switch(num) {
					//'day'�� ������
					case 1:
						setScheduleDay(schedule,input);
						break;
					//'schedule'�� ������
					case 2:
						setSchedule(schedule,input);
						break;
						//'memo'�� ������
					case 3:
						setScheduleMemo(schedule, input);
						break;
					default:
						continue;
					}
				}//while
				break;
			}//if
		}//for
		
			
		
	}			
	
	//editSchedule�� �ʿ��� �Լ�
	public void setScheduleDay(Scheduleinput schedule,Scanner input) {
		System.out.println("Day : ");
		int dayedit = 0;
		while((int)(Math.log10(dayedit)+1)!=6) {
			try {
				dayedit = dayinput();
			} catch (DateFormatException e) {
				System.out.println("Date in Incorrect. Put date again");
				System.out.println("Day : 20XX.XX.XX");
			}
		}
		schedule.setDay(dayedit);
	}
	
	public void setSchedule(Scheduleinput schedule,Scanner input) {
		schedule.setSchedule(input);
	}
	
	public void setScheduleMemo(Scheduleinput schedule,Scanner input) {
		schedule.setMemo(input);
	}
	
	public void showEditMenu() {
		System.out.println("** Schedule Edit Menu **");
		System.out.println("1. Edit day");
		System.out.println("2. Edit Schedule");
		System.out.println("3. Edit Memo");
		System.out.println("4. Exit Edit");
		System.out.println("Select one number between 1~4");
		
	}
	//_____________________________________________________________________________________________________________
	
	//'viewScheudles'�Լ�
	public void viewSchedules() {
		for(int i = 0; i<schedules.size();i++) {
			schedules.get(i).printInfo(i);
		}
				
	}
		
		
}