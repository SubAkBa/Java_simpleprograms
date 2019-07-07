import java.util.Scanner;

public class PhoneProjectMain implements INIT_MENU
{	
	public static void main(String[] args) throws MenuChoiceException
	{
		Scanner sc = new Scanner(System.in);
		PhoneBookManager manager = PhoneBookManager.creatInst();

		while(true)
		{
			try
			{
				manager.showMenu();
				int num = sc.nextInt();
				sc.nextLine();
			
				if(num < INIT_MENU.INPUT || num > INIT_MENU.EXIT)
					throw new MenuChoiceException(num);

				switch(num)
				{
				case INIT_MENU.INPUT:
					manager.makeData();
					break;
				case INIT_MENU.SEARCH:
					manager.findData();
					break;
				case INIT_MENU.DELETE:
					manager.deleteData();
					break;
				case INIT_MENU.SHOW:
					manager.showAllData();
					break;
				case INIT_MENU.EXIT:
					return;
				}
			}
			catch(MenuChoiceException e)
			{
				System.out.println(e.getMessage());
				e.showWrongNumber();
				System.out.println("메뉴 선택을 처음부터 다시 진행합니다.\n");
			}
		}
	}
}