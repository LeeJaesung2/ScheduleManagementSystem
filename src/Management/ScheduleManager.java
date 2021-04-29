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
	ArrayList <Schedule> schedules = new ArrayList<Schedule>();  //'Schedule' 객체를 가리키는 'schedule' 배열을 만듦
	
	//'input'을 인자로 하는 생성자
	ScheduleManager(Scanner input){
		this.input= input;
	}
	
	
    //'addSchedule' 함수
	public void addSchedule() {       
		
		
		System.out.println("Day : 20XX.XX.XX");
		int day = input.nextInt();   //입력값을 'day'에 저장함
		int kind = 0;
		Schedule schedule;
	    while(kind != 1 && kind != 2 && kind != 3) {  //'kind'를 1,2,3중의 값을 입력받을때까지 실행 
	    	System.out.println("1. Mornig");
			System.out.println("2. Afternoon");
			System.out.println("3. Night");
			System.out.println("Select Time between 1~3 : ");
			kind = input.nextInt();
			//Mornig 인 경우
			if (kind==1){
				schedule = new MornigSchedule(ScheduleKind.Mornig);  //'MornigSchedule' 객체를 만들어 'schedule'에 저장
				schedule.getUserInput(input);  //'getUserIput'함수 실행
				schedule.setDay(day);  //입력받은 'day'를 저장함
				schedules.add(schedule);  //'schedules'콜렉션에 'schedule'값 저장
				break;
			}
			//Afternoon인 경우
			else if(kind ==2) {
				schedule = new AfternoonSchedule(ScheduleKind.Afternoon);
				schedule.getUserInput(input);
				schedule.setDay(day);
				schedules.add(schedule);
				break;
			}
			//Night인 경우
			else if(kind == 3) {
				schedule = new NightSchedule(ScheduleKind.Night);
				schedule.getUserInput(input);
				schedule.setDay(day);
				schedules.add(schedule);
				break;
			}
			else {
				System.out.println("Select Time between 1~3 : ");
			}//else문
	    }//while문
		
	}//add함수
	
	//'deleteSchedule'함수
	public void deleteSchedule() {
		
		System.out.println("Day : 20XX.XX.XX");
		int day = input.nextInt();    //수를 입력받아 'day'에 저장함
		int index = -1;
		for(int i = 0; i<schedules.size();i++) {  //'collection'의 크기만큼 실행
			if(schedules.get(i).getDay()==day) {  //입력받은 날짜와 일치하는 경우
				index = i;  //인덱스 저장
				break;
			
			}
		}
		
		if(index>=0) {  //인덱스가 있는경우
			schedules.remove(index);  //값을 지움
			System.out.println("the shcdule 20"+day+ " is deleted");
			
		}
	
		
		else
			System.out.println("The Schedule has not been registered");   //'Schedule' class에 저장되지 않았음을 알림

	}
		
	//'editSchedule'함수
	public void editSchedule() {
		System.out.println("Day : 20XX.XX.XX");
		int day = input.nextInt();    //수를 입력받아 'day'에 저장함
		for(int i = 0; i<schedules.size();i++) {  //'collection'의 크기만큼 실행
			Schedule schedule = schedules.get(i); 
			if(schedule.getDay() == day) {  //'schedule'의 'day'와 입력받은'day'가 일치하는 경우
				int num = -1;
				while(num!=4) {  //어떤것을 수정할 것인지 입력 받음
					System.out.println("** Schedule Edit Menu **");
					System.out.println("1. Edit day");
					System.out.println("2. Edit Schedule");
					System.out.println("3. Edit Memo");
					System.out.println("4. Exit Edit");
					System.out.println("Select one number between 1~4");
					num = input.nextInt();
					
					//'day'를 수정함
					if (num == 1 ) {
						System.out.println("Day : ");
						int dayedit = input.nextInt();
						schedule.setDay(dayedit);
					}
					//'schedule'을 수정함
					else if (num == 2) {
						System.out.println("Schedule : ");
						String scheduleedit = input.next();
						schedule.setSchedule(scheduleedit);
					}
					//'memo'를 수정함
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
	
    //'viewScheudles'함수
	public void viewSchedules() {
		for(int i = 0; i<schedules.size();i++) {
			schedules.get(i).printInfo(i);
		}
			
	}
		
		
}