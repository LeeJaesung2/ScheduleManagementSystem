package Schedule;

import java.util.Scanner;

public class AfternoonSchedule extends Schedule{//'MorningSchedule' class�� ��� ����, 'Scheduleinput'�� implements��
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5808761588636092093L;

	public AfternoonSchedule(ScheduleKind kind) {
		super(kind);
	}

	@Override
	public void printInfo(int i) {
		String skind = getKindString();
		System.out.println(i+". kind : " +skind + " Day : 20"+this.day+"\tSchedule : "+this.schedule+"\tmemo: "+this.memo);
	
	}

	@Override
	public void getUserInput(Scanner input) {
		this.setSchedule(input);  //'schedule'���� 'setSchedule'�Լ��� �̿��� 'schedule'�� ����
		this.setMemo(input);
	
	}
}
