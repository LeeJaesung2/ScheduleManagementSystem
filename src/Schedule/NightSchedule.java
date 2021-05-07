package Schedule;

import java.util.Scanner;

public class NightSchedule extends MornigSchedule implements Scheduleinput{//'MorningSchedule' class�� ��� ����, 'Scheduleinput'�� implements��
	public NightSchedule(ScheduleKind kind) {
		super(kind);
	}
	//'Scheduleinput' �� �ִ� �Լ��� �������̵� ��
    public void getUserInput(Scanner input) {
		
		
		System.out.println("Schedule : ");
		String schedule = input.next();  //�Է°��� 'schedule' ������ ����
		this.setSchedule(schedule);  //'schedule'���� 'setSchedule'�Լ��� �̿��� 'schedule'�� ����
		
		char answer = 'X';
		while(answer != 'y' && answer != 'Y' && answer != 'n' && answer != 'N') {
			System.out.println("Do you have anything to memo? (Y/N)");
			
			answer = input.next().charAt(0);
			//'answer'�� Yes�� ���
			if (answer == 'y' || answer == 'Y') {
				System.out.println("Memo : ");
				String memo = input.next();	 //�Է°��� 'memo'�迭�� ������
				this.setMemo(memo);  //'memo'���� 'setMemo'�Լ��� �̿��� 'memo'�� ����
				break;
			
			}
			//'answer'�� No�� ���
			else if(answer == 'n' || answer == 'N') {
				this.setMemo(""); //'setMemo'�Լ��� 'memo'���� �������� ��
				break;
			}
			//'answer'�� Yes �� No�� �ƴѰ��
			else {
				System.out.println("Chek your answer");
			}
		}
		
		
	}

}
