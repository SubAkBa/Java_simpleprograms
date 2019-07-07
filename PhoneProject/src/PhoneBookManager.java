import java.util.Scanner;

public class PhoneBookManager implements INIT_SELECT{
	Scanner sc = new Scanner(System.in);
	final int MAX_NUM = 100;
	PhoneInfo[] person = new PhoneInfo[MAX_NUM];
	int pernum = 0;
	
	private static PhoneBookManager pbminst = null;
	public static PhoneBookManager creatInst()
	{
		if(pbminst == null)
			pbminst = new PhoneBookManager();
		
		return pbminst;
	}
	public void showMenu()
	{
		System.out.println("*** 전화번호 관리 프로그램 ***");
		System.out.println("1.데이터 입력");
		System.out.println("2.데이터 검색");
		System.out.println("3.데이터 삭제");
		System.out.println("4.모든 데이터 출력");
		System.out.println("5.프로그램 종료");
		System.out.print("선택 : ");
	}
	public void makeData() throws MenuChoiceException
	{
		try
		{
			System.out.println();
			System.out.println("데이터 입력을 시작합니다.");
			System.out.println("1.일반, 2.대학, 3.회사");
			System.out.print("선택 : ");
			int num = sc.nextInt();
			sc.nextLine();
		
			if(num < INIT_SELECT.NORMAL || num > INIT_SELECT.COMPANY)
				throw new MenuChoiceException(num);

			switch(num)
			{
			case INIT_SELECT.NORMAL:
				makeGeneralInfo();
				break;
			case INIT_SELECT.UNIV:
				makeUnivInfo();
				break;
			case INIT_SELECT.COMPANY:
				makeCompanyInfo();
				break;
			}
		}
		catch(MenuChoiceException e)
		{
			System.out.println(e.getMessage());
			e.showWrongNumber();
			System.out.println("메뉴 선택을 처음부터 다시 시작합니다.\n");
		}
	}
	private void makeGeneralInfo()
	{
		System.out.print("이름 : ");
		String name = sc.nextLine();
		System.out.print("전화번호 : ");
		String pnumber = sc.nextLine();
		System.out.println("데이터 입력이 완료되었습니다.\n");
		
		person[pernum++] = new PhoneInfo(name,pnumber);
	}
	private void makeUnivInfo()
	{
		System.out.print("이름 : ");
		String name = sc.nextLine();
		System.out.print("전화번호 : ");
		String pnumber = sc.nextLine();
		System.out.print("전공 : ");
		String major = sc.nextLine();
		System.out.print("학년 : ");
		int year = sc.nextInt();
		sc.nextLine();
		System.out.println("데이터 입력이 완료되었습니다.\n");
		
		person[pernum++] = new PhoneUnivInfo(name,pnumber,major,year);
	}
	private void makeCompanyInfo()
	{
		System.out.print("이름 : ");
		String name = sc.nextLine();
		System.out.print("전화번호 : ");
		String pnumber = sc.nextLine();
		System.out.print("회사 : ");
		String company = sc.nextLine();
		System.out.println("데이터 입력이 완료되었습니다.\n");
		
		person[pernum++] = new PhoneCompanyInfo(name,pnumber,company);		
	}
	public void findData()
	{
		String name;
		
		System.out.println();
		System.out.println("데이터 검색을 시작합니다.");
		System.out.print("이름 : ");
		name = sc.nextLine();
		
		for(int i=0;i<pernum;i++)
		{
			if(name.compareTo(person[i].name) == 0)
			{
				person[i].showInfo();
				System.out.println("데이터 검색이 완료되었습니다.\n");
				return;
			}
		}
		System.out.println("데이터가 없습니다.\n");
	}
	public void deleteData()
	{
		String name;
		
		System.out.println();
		System.out.println("데이터를 삭제 합니다.");
		System.out.print("이름 : ");
		name = sc.nextLine();
		
		for(int i=0;i<pernum;i++)
		{
			if(name.compareTo(person[i].name) == 0)
			{
				for(int j=i;j<pernum-1;j++)
					person[j] = person[j+1];
				pernum--;
				System.out.println("데이터 삭제가 완료되었습니다.\n");
				return;
			}
		}
		System.out.println("데이터가 없어 데이터 삭제가 불가능 합니다.\n");
	}
	public void showAllData()
	{
		for(int i=0;i<pernum;i++)
		{
			person[i].showInfo();
			System.out.println();
		}
	}
}
