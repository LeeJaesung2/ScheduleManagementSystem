package Schedule;

import java.util.Scanner;
//각 함수를 정의해둔 인터페이스
public interface Scheduleinput {
	public void getUserInput(Scanner input);
	public void setDay(int day);
	public int getDay();
	public void setSchedule(String schedule);
	public void setMemo(String memo);
	public void printInfo(int i);
}
