package Schedule;

import java.util.Scanner;

//�� �Լ��� �����ص� �������̽�
public interface Scheduleinput {
	
	public void setDay(int day);
	
	public int getDay();
	
	public void setSchedule(Scanner input);
	
	public String getSchedule();
	
	public void setMemo(Scanner input);
	
	public String getMemo();
	
	public void setKind(ScheduleKind kind);
	
	public String getKindString();
	
	public void printInfo(int i);
	
	public void getUserInput(Scanner input);
	
}
