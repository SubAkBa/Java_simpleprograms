package 수강신청;

public class 메인
{
	public static void main(String args[]) throws Exception
	{
		SugangApply sa = new SugangApply();
		ThreadHandler[] t = new ThreadHandler[50];
		for(int i=0;i<t.length;i++)
			t[i] = new ThreadHandler(sa, i+1);
		
		for(int i=0;i<t.length;i++)
			t[i].start();
		
		for(int i=0;i<t.length;i++)
			t[i].join();
		
		System.out.println(sa.SuccessList());
	}
}
