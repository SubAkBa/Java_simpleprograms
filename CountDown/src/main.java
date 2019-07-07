import java.util.*;

public class main 
{
	public static void main(String args[])
	{		
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자 입력");
		int num = sc.nextInt();
		CountDown cd = new CountDown(num);
		ThreadHandler t1 = new ThreadHandler(cd, "use 1");
		ThreadHandler t2 = new ThreadHandler(cd, "use 2");
		ThreadHandler t3 = new ThreadHandler(cd, "use 3");
		
		t1.start();
		t2.start();
		t3.start();
	}
}
