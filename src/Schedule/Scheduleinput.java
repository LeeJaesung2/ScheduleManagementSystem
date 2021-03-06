package Schedule;

import java.util.Scanner;

//각 함수를 정의해둔 인터페이스
public interface Scheduleinput {
	public ScheduleKind getKind();
	
	public void setDay(int day);
	
	public int getDay();
	
	public void setSchedule(Scanner input);
	
	public void setSchedule(String schedule);
	
	public String getSchedule();
	
	public void setMemo(Scanner input);
	
	public void setMemo(String memo);
	
	public String getMemo();
	
	public void setKind(ScheduleKind kind);
	
	public String getKindString();
	
	public void printInfo(int i);
	
	public void getUserInput(Scanner input);
	
}
