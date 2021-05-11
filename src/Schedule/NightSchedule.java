package Schedule;

import java.util.Scanner;

public class NightSchedule extends Schedule{//'MorningSchedule' class를 상속 받음, 'Scheduleinput'을 implements함
	public NightSchedule(ScheduleKind kind) {
		super(kind);
	}

	@Override
	public void printInfo(int i) {
		String skind = getKindString();
		System.out.println(i+". kind : " +skind + " Day : 20"+this.day+"\tSchedule : "+this.schedule+"\tmemo: "+this.memo);
		
	}

	@Override
	public void getUserInput(Scanner input) {
		this.setSchedule(input);  //'schedule'값을 'setSchedule'함수를 이용해 'schedule'에 저장
		this.setMemo(input);
		
	}

}
