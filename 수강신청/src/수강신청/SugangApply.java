package ������û;

class SugangApply
{
	int count = 0;
	boolean b1 = false;
	StringBuffer sb = new StringBuffer();
	public synchronized void IngSugang(int ID)
	{
		System.out.println("System : ID : " + ID + " �л����� Java2 ������û�Դϴ�.");
		if(b1 == false)
		{
			System.out.println("System : ID : " + ID + " �л����� Java2 ������û�� �����Ͽ����ϴ�.\nUser : Java2 ������û �Ϸ�");
			sb.append("������û�� ������ ��� ID : " + ID + "\n");
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
