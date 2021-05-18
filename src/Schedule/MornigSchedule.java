package Schedule;

import java.util.Scanner;

public class MornigSchedule extends Schedule{  //'Schedule' class를 상속 받음, 'Scheduleinput'을 implements함
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7634534292981384258L;


	public MornigSchedule(ScheduleKind kind) {
		super(kind);
	}
	//'Scheduleinput' 에 있는 함수를 오버라이드 함
    public void getUserInput(Scanner input) {
		
		this.setSchedule(input);  //'schedule'값을 'setSchedule'함수를 이용해 'schedule'에 저장
		setSchueduleMemoYN(input);
		
	}
    
    public void setSchueduleMemoYN(Scanner input) {
    	char answer = 'X';
		while(answer != 'y' && answer != 'Y' && answer != 'n' && answer != 'N') {
			System.out.println("Do you have anything to memo? (Y/N)");
			
			answer = input.next().charAt(0);
			//'answer'이 Yes인 경우
			if (answer == 'y' || answer == 'Y') {
				this.setMemo(input);  //'memo'값을 'setMemo'함수를 이용해 'memo'에 저장
				break;
			
			}
			//'answer'이 No인 경우
			else if(answer == 'n' || answer == 'N') {
				break;
			}
			//'answer'이 Yes 나 No가 아닌경우
			else {
				System.out.println("Chek your answer");
			}
		}	
    }
    
    
	//Schedule printInfo 함수 오버라이드
    public void printInfo(int i) {
		String skind = getKindString();
		System.out.println(i+". kind : " +skind + " Day : 20"+this.day+"\tSchedule : "+this.schedule+"\tmemo: "+this.memo);
	}

	
	
		

}
