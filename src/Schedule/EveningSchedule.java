package Schedule;

import java.util.Scanner;

public class EveningSchedule extends Schedule{ //'Schedule' class를 상속 받음, 'Scheduleinput'을 implements함
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7251361046177853465L;

	public EveningSchedule(ScheduleKind kind) {
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
