
class MenuChoiceException extends Exception
{
	int wrongnum;
	public MenuChoiceException(int num)
	{
		super("잘못된 선택이 이루어졌습니다.");
		wrongnum = num;
	}
	public void showWrongNumber()
	{
		System.out.println(wrongnum + "에 해당하는 선택은 존재하지 않습니다.");
	}
}
