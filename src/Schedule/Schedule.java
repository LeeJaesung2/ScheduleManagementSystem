package Schedule;

import java.util.Scanner;

public abstract class Schedule implements Scheduleinput{
	
	
	protected ScheduleKind kind = ScheduleKind.Mornig;  //'ScheduleKind'class를 생성하고 default 값을 'Mornig'으로 함
	protected int day;
	protected String schedule;
	protected String memo;
	
	//생성자를 만듦
	public Schedule() {}
	
	public Schedule(ScheduleKind kind) {
		this.kind = kind;
	}
	
	//인자값을 저장하는 생성자를 만듦
	public Schedule(ScheduleKind kind, int day, String schedule, String memo) {
		this.kind = kind;
		this.day = day;
		this.schedule = schedule;
		this.memo = memo;
		
	}
	//'kind'를 return 하는 함수
	public ScheduleKind getKind() {
		return kind;
	}
    //'kind'를 설정하는 함수
	public void setKind(ScheduleKind kind) {
		this.kind = kind;
	}
	//'day'를 return하는 함수
	public int getDay() {
		return day;
	}
    //'day'를 설정하는 함수
	public void setDay(int day) {
		this.day = day;
	}
	//'schedule'을 return하는 함수
	public String getSchedule() {
		return schedule;
	}
	//'schedule'을 설정하는 함수
	public void setSchedule(Scanner input) {
		System.out.println("Schedule : ");
		String schedule = input.next();  //입력값을 'schedule'변수에 저장
		this.schedule = schedule;
	}
	//'memo'를 return하는 함수
	public String getMemo() {
		return memo;
	}
	//'memo'를 설정하는 함수
	public void setMemo(Scanner input) {
		System.out.println("Memo : ");
		String memo = input.next();	 //입력값을 'memo'변수에 저장함
		this.memo = memo;
	}
	
	public String getKindString() {
		String skind = "none";
		switch(this.kind) {
		case Mornig:
			skind = "Mornig";
			break;
		case Afternoon:
			skind="Afternoon";
			break;
		case Night:
			skind="Night";
			break;
		case Evening:
			skind="Evening";
			break;
		default:
			break;
		}
		return skind;
	}

	//내용을 출력하는 함수
	public abstract void printInfo(int i);
	
	//사용자의 입력값을 저장하는 함수
	public abstract void getUserInput(Scanner input);
}