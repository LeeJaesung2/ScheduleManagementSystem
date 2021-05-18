package Schedule;

import java.util.Scanner;

public class MornigSchedule extends Schedule{  //'Schedule' class�� ��� ����, 'Scheduleinput'�� implements��
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7634534292981384258L;


	public MornigSchedule(ScheduleKind kind) {
		super(kind);
	}
	//'Scheduleinput' �� �ִ� �Լ��� �������̵� ��
    public void getUserInput(Scanner input) {
		
		this.setSchedule(input);  //'schedule'���� 'setSchedule'�Լ��� �̿��� 'schedule'�� ����
		setSchueduleMemoYN(input);
		
	}
    
    public void setSchueduleMemoYN(Scanner input) {
    	char answer = 'X';
		while(answer != 'y' && answer != 'Y' && answer != 'n' && answer != 'N') {
			System.out.println("Do you have anything to memo? (Y/N)");
			
			answer = input.next().charAt(0);
			//'answer'�� Yes�� ���
			if (answer == 'y' || answer == 'Y') {
				this.setMemo(input);  //'memo'���� 'setMemo'�Լ��� �̿��� 'memo'�� ����
				break;
			
			}
			//'answer'�� No�� ���
			else if(answer == 'n' || answer == 'N') {
				break;
			}
			//'answer'�� Yes �� No�� �ƴѰ��
			else {
				System.out.println("Chek your answer");
			}
		}	
    }
    
    
	//Schedule printInfo �Լ� �������̵�
    public void printInfo(int i) {
		String skind = getKindString();
		System.out.println(i+". kind : " +skind + " Day : 20"+this.day+"\tSchedule : "+this.schedule+"\tmemo: "+this.memo);
	}

	
	
		

}
