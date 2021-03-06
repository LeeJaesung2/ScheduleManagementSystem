package Management;
import java.io.Serializable;
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

public class ScheduleManager  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 220317111176900069L;//시리얼을 넣어줌
	
	transient Scanner input; //scanner는 저장하지 않음
	ArrayList <Scheduleinput> schedules = new ArrayList<Scheduleinput>();  //'Scheduleinput' 객체를 arraylist로 만듦
	
//	'input'을 인자로 하는 생성자
	ScheduleManager(Scanner input){
		this.input= input;
	}
	
	
	public int dayinput() throws DateFormatException{ //DateFromatException에러 조건을 만들어줌
		if(input == null) { //input값이 null이면 새로 생성해줌
			input = new Scanner(System.in);
		}
		int day = input.nextInt();
		int length = (int)(Math.log10(day)+1); //입력받은 day의 길이
		if(length != 6) {//6자리 수가아니면 오류메세지를 던짐
			throw new DateFormatException();
		}
		return day;
	}
	
	public int kindinput() {
		if(input == null) { //input값이 null이면 새로 생성해줌
			input = new Scanner(System.in);
		}
		System.out.println("1. Mornig");
		System.out.println("2. Afternoon");
		System.out.println("3. Evenig");
		System.out.println("4. Night");
		System.out.println("Select Time between 1~4 : ");
		int kind = input.nextInt();
		return kind;
	}
	
	public void addSchedule(String day, String kind, String schedule, String memo) {
		Scheduleinput scheduleinput = new MornigSchedule(ScheduleKind.Mornig);
		scheduleinput.getUserInput(input);
		schedules.add(scheduleinput);
	}
	
	public void addSchedule(Scheduleinput scheduleinput) {
		schedules.add(scheduleinput);
	}
	
    //'addSchedule' 함수
	public void addSchedule() {       
		
		
		System.out.println("Day : 20XX.XX.XX");
		int day = 0;
		while((int)(Math.log10(day)+1)!=6) { //day가 6자리 수가 아니면 에러메세지를 출력, 다시 입력받음
			try {
				day = dayinput();
			} catch (DateFormatException e) {
				System.out.println("Date in Incorrect. Put date again");
				System.out.println("Day : 20XX.XX.XX");
			}
		}
		int kind = -1;
		Scheduleinput scheduleinput;
	    while(kind < 1 || kind > 4) {  //'kind'를 1,2,3중의 값을 입력받을때까지 실행 
	    	try {
		    	kind = kindinput();
		    	
		    	switch(kind) {
		    	//Mornig 인 경우
		    	case 1:
		    		scheduleinput = new MornigSchedule(ScheduleKind.Mornig);  //'MornigSchedule' 객체를 만들어 'schedule'에 저장
					scheduleinput.getUserInput(input);  //'getUserIput'함수 실행
					scheduleinput.setDay(day);  //입력받은 'day'를 저장함
					schedules.add(scheduleinput);  //'schedules'콜렉션에 'schedule'값 저장
					break;
				//Afternoon인 경우
		    	case 2:
		    		scheduleinput = new AfternoonSchedule(ScheduleKind.Afternoon);
					scheduleinput.getUserInput(input);
					scheduleinput.setDay(day);
					schedules.add(scheduleinput);
					break;
				//Evenig인 경우
		    	case 3:
		    		scheduleinput = new EveningSchedule(ScheduleKind.Evening);
					scheduleinput.getUserInput(input);
					scheduleinput.setDay(day);
					schedules.add(scheduleinput);
					break;
				//Night인 경우
		    	case 4:
		    		scheduleinput = new NightSchedule(ScheduleKind.Night);
					scheduleinput.getUserInput(input);
					scheduleinput.setDay(day);
					schedules.add(scheduleinput);
					break;
		    	}//switch 문
	    	}//try 문
	    	catch(InputMismatchException e){  //InputMismatchException이 발생시 다시 입력받음
	    		System.out.println("Please put an integer between 1 and 4 !");
				if (input.hasNext()) {
					input.next();
				}
				kind = -1;
	    	}//catch문
	    }//while문
		
	}//add함수
	//_____________________________________________________________________________________________________________
	
	//'deleteSchedule'함수
	public void deleteSchedule() {
		int day = 0;
		System.out.println("Day : 20XX.XX.XX");
		while((int)(Math.log10(day)+1)!=6) {//day가 6자리 수가 아니면 에러메세지를 출력, 다시 입력받음
			try {
				day = dayinput();
			} catch (DateFormatException e) {
				System.out.println("Date in Incorrect. Put date again");
				System.out.println("Day : 20XX.XX.XX");
			}
		}
		int kindnum = kindinput();
		String kind = null;
		switch(kindnum) {
		case 1:
			kind = "Mornig";
		case 2:
			kind = "Afternoon";
		case 3:
			kind = "Evening";
		case 4:
			kind = "Night";
		}
		int index = findIndex(day, kind);
		removefromSchedule(index, day);
	}
	
	//deleteSchedule에 필요한 함수
	public int findIndex(int day, String kind) {
		int index = -1;
		for(int i = 0; i<schedules.size();i++) {  //'collection'의 크기만큼 실행
			Scheduleinput schedule = schedules.get(i);
			if(schedule.getDay()==day && schedule.getKindString().equals(kind)) {  //입력받은 날짜와 일치하는 경우
				index = i;  //인덱스 저장
				break;
			
			}
		}
		return index;
	}
	
	public int removefromSchedule(int index,int day) {
		if(index>=0) {  //인덱스가 있는경우
			schedules.remove(index);  //값을 지움
			System.out.println("the shcdule 20"+day+" is deleted");
			return 1;
		}
	
		
		else
			System.out.println("The Schedule has not been registered");   //'Schedule' class에 저장되지 않았음을 알림
		return -1;
		
	}
	//_____________________________________________________________________________________________________________
	//'editSchedule'함수
	public void editSchedule() {
		System.out.println("Day : 20XX.XX.XX");
		int day = 0;    //수를 입력받아 'day'에 저장함
		while((int)(Math.log10(day)+1)!=6) {//day가 6자리 수가 아니면 에러메세지를 출력, 다시 입력받음
			try {
				day = dayinput();
			} catch (DateFormatException e) {
				System.out.println("Date in Incorrect. Put date again");
				System.out.println("Day : 20XX.XX.XX");
			}
		}
		int kindnum = kindinput();
		String kind = null;
		switch(kindnum) {
		case 1:
			kind = "Mornig";
		case 2:
			kind = "Afternoon";
		case 3:
			kind = "Evening";
		case 4:
			kind = "Night";
		}
		
		for(int i = 0; i<schedules.size();i++) {  //'collection'의 크기만큼 실행
			Scheduleinput schedule = schedules.get(i);
			if(schedule.getDay() == day && schedule.getKindString().equals(kind)) {  //'schedule'의 'day'와 입력받은'day'가 일치하는 경우
				int num = -1;
				try {
					while(num!=4) {  //어떤것을 수정할 것인지 입력 받음
						showEditMenu();
						num = input.nextInt();
						
						switch(num) {
						//'day'를 수정함
						case 1:
							setScheduleDay(schedule,input);
							break;
						//'schedule'을 수정함
						case 2:
							setSchedule(schedule,input);
							break;
							//'memo'를 수정함
						case 3:
							setScheduleMemo(schedule, input);
							break;
						default:
							continue;
						}
					}//while
				} catch (InputMismatchException e) {
					System.out.println("Please put an integer between 1 and 3 !");
					if (input.hasNext()) {
						input.next();
					}
				}
				break;
			}//if
		}//for
		
			
		
	}			
	
	//editSchedule에 필요한 함수
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
	
	//'viewScheudles'함수
	public void viewSchedules() {
		for(int i = 0; i<schedules.size();i++) {
			schedules.get(i).printInfo(i);
		}
				
	}
	//schedules list의 크기를 구하는 함수
	public int size() {
		return schedules.size();
	}
	//list중 특정 객체를 반환하는 함수	
	public Scheduleinput get(int index) {
		return schedules.get(index);
	}
		
}