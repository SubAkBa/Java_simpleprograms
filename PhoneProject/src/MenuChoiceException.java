
class MenuChoiceException extends Exception
{
	int wrongnum;
	public MenuChoiceException(int num)
	{
		super("�߸��� ������ �̷�������ϴ�.");
		wrongnum = num;
	}
	public void showWrongNumber()
	{
		System.out.println(wrongnum + "�� �ش��ϴ� ������ �������� �ʽ��ϴ�.");
	}
}
