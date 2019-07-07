package 수강신청;

class SugangApply
{
	int count = 0;
	boolean b1 = false;
	StringBuffer sb = new StringBuffer();
	public synchronized void IngSugang(int ID)
	{
		System.out.println("System : ID : " + ID + " 학생께서 Java2 수강신청입니다.");
		if(b1 == false)
		{
			System.out.println("System : ID : " + ID + " 학생께서 Java2 수강신청이 성공하였습니다.\nUser : Java2 수강신청 완료");
			sb.append("수강신청이 성공한 사람 ID : " + ID + "\n");
			count++;
		}
		if(count>= 25)
			b1 = true;
	}
	public String SuccessList()
	{
		return sb.toString();
	}
}
