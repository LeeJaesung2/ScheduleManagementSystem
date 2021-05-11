package Schedule;

import java.util.Scanner;

public abstract class Schedule implements Scheduleinput{
	
	
	protected ScheduleKind kind = ScheduleKind.Mornig;  //'ScheduleKind'class�� �����ϰ� default ���� 'Mornig'���� ��
	protected int day;
	protected String schedule;
	protected String memo;
	
	//�����ڸ� ����
	public Schedule() {}
	
	public Schedule(ScheduleKind kind) {
		this.kind = kind;
	}
	
	//���ڰ��� �����ϴ� �����ڸ� ����
	public Schedule(ScheduleKind kind, int day, String schedule, String memo) {
		this.kind = kind;
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
	public void setSchedule(Scanner input) {
		System.out.println("Schedule : ");
		String schedule = input.next();  //�Է°��� 'schedule'������ ����
		this.schedule = schedule;
	}
	//'memo'�� return�ϴ� �Լ�
	public String getMemo() {
		return memo;
	}
	//'memo'�� �����ϴ� �Լ�
	public void setMemo(Scanner input) {
		System.out.println("Memo : ");
		String memo = input.next();	 //�Է°��� 'memo'������ ������
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

	//������ ����ϴ� �Լ�
	public abstract void printInfo(int i);
	
	//������� �Է°��� �����ϴ� �Լ�
	public abstract void getUserInput(Scanner input);
}