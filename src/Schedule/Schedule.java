package Schedule;

import java.util.Scanner;

public class Schedule {
	
	
	protected ScheduleKind kind = ScheduleKind.Mornig;  //'ScheduleKind'class�� �����ϰ� default ���� 'Mornig'���� ��
	protected int day;
	protected String schedule;
	protected String memo;
	
	//�����ڸ� ����
	public Schedule() {}
	
	//���ڰ��� �����ϴ� �����ڸ� ����
	public Schedule(int day, String schedule, String memo) {
		this.day = day;
		this.schedule = schedule;
		this.memo = memo;
		
	}
	//'kind'�� return �ϴ� �Լ�
	public ScheduleKind getKind() {
		return kind;
	}
    //'kind'�� �����ϴ� �Լ�
	public void setKind(ScheduleKind kind) {
		this.kind = kind;
	}
	//'day'�� return�ϴ� �Լ�
	public int getDay() {
		return day;
	}
    //'day'�� �����ϴ� �Լ�
	public void setDay(int day) {
		this.day = day;
	}
	//'schedule'�� return�ϴ� �Լ�
	public String getSchedule() {
		return schedule;
	}
	//'schedule'�� �����ϴ� �Լ�
	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}
	//'memo'�� return�ϴ� �Լ�
	public String getMemo() {
		return memo;
	}
	//'memo'�� �����ϴ� �Լ�
	public void setMemo(String memo) {
		this.memo = memo;
	}

	//������ ����ϴ� �Լ�
	public void printInfo(int i) {
		System.out.println(i+". Day : 20"+this.day+"\tSchedule : "+this.schedule+"\tmemo: "+this.memo);
	}
	
	//������� �Է°��� �����ϴ� �Լ�
	public void getUserInput(Scanner input) {
		System.out.println("Day : ");
		int day = input.nextInt();  //�Է°��� 'schedule'������ ����
		this.setDay(day);
		
		System.out.println("Schedule : ");
		String schedule = input.next();  //�Է°��� 'schedule'������ ����
		this.setSchedule(schedule);  //'schedule'���� 'setSchedule'�Լ��� �̿��� 'schedule'�� ����
		
		System.out.println("Memo : ");
		String memo = input.next();	 //�Է°��� 'memo'������ ������
		this.setMemo(memo);   //'memo'���� 'setMemo'�Լ��� �̿��� 'memo'�� ����
		
	}
}