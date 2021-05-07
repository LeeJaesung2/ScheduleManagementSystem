package Schedule;

import java.util.Scanner;

public class EveningSchedule extends Schedule implements Scheduleinput { //'Schedule' class를 상속 받음, 'Scheduleinput'을 implements함
	public EveningSchedule(ScheduleKind kind) {
		super(kind);
	}
	//'Scheduleinput' 에 있는 함수를 오버라이드 함
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	
	public void getUserInput(Scanner input) {
		
		
		System.out.println("Schedule : ");
		String schedule = input.next();  //입력값을 'schedule' 변수에 저장
		this.setSchedule(schedule);  //'schedule'값을 'setSchedule'함수를 이용해 'schedule'에 저장
		
		char answer = 'X';
		while(answer != 'y' && answer != 'Y' && answer != 'n' && answer != 'N') {
			System.out.println("Do you have anything to memo? (Y/N)");
			
			answer = input.next().charAt(0);
			//'answer'이 Yes인 경우
			if (answer == 'y' || answer == 'Y') {
				System.out.println("Memo : ");
				String memo = input.next();	 //입력값을 'memo'배열에 저장함
				this.setMemo(memo);  //'memo'값을 'setMemo'함수를 이용해 'memo'에 저장
				break;
			
			}
			//'answer'이 No인 경우
			else if(answer == 'n' || answer == 'N') {
				this.setMemo(""); //'setMemo'함수에 'memo'값을 공백으로 둠
				break;
			}
			//'answer'이 Yes 나 No가 아닌경우
			else {
				System.out.println("Chek your answer");
			}
		}
		
		
	}
	public void printInfo(int i) {
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
		System.out.println(i+". kind : " +skind + " Day : 20"+this.day+"\tSchedule : "+this.schedule+"\tmemo: "+this.memo);
	}

}
