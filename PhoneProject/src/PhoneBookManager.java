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
		System.out.println("*** ��ȭ��ȣ ���� ���α׷� ***");
		System.out.println("1.������ �Է�");
		System.out.println("2.������ �˻�");
		System.out.println("3.������ ����");
		System.out.println("4.��� ������ ���");
		System.out.println("5.���α׷� ����");
		System.out.print("���� : ");
	}
	public void makeData() throws MenuChoiceException
	{
		try
		{
			System.out.println();
			System.out.println("������ �Է��� �����մϴ�.");
			System.out.println("1.�Ϲ�, 2.����, 3.ȸ��");
			System.out.print("���� : ");
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
			System.out.println("�޴� ������ ó������ �ٽ� �����մϴ�.\n");
		}
	}
	private void makeGeneralInfo()
	{
		System.out.print("�̸� : ");
		String name = sc.nextLine();
		System.out.print("��ȭ��ȣ : ");
		String pnumber = sc.nextLine();
		System.out.println("������ �Է��� �Ϸ�Ǿ����ϴ�.\n");
		
		person[pernum++] = new PhoneInfo(name,pnumber);
	}
	private void makeUnivInfo()
	{
		System.out.print("�̸� : ");
		String name = sc.nextLine();
		System.out.print("��ȭ��ȣ : ");
		String pnumber = sc.nextLine();
		System.out.print("���� : ");
		String major = sc.nextLine();
		System.out.print("�г� : ");
		int year = sc.nextInt();
		sc.nextLine();
		System.out.println("������ �Է��� �Ϸ�Ǿ����ϴ�.\n");
		
		person[pernum++] = new PhoneUnivInfo(name,pnumber,major,year);
	}
	private void makeCompanyInfo()
	{
		System.out.print("�̸� : ");
		String name = sc.nextLine();
		System.out.print("��ȭ��ȣ : ");
		String pnumber = sc.nextLine();
		System.out.print("ȸ�� : ");
		String company = sc.nextLine();
		System.out.println("������ �Է��� �Ϸ�Ǿ����ϴ�.\n");
		
		person[pernum++] = new PhoneCompanyInfo(name,pnumber,company);		
	}
	public void findData()
	{
		String name;
		
		System.out.println();
		System.out.println("������ �˻��� �����մϴ�.");
		System.out.print("�̸� : ");
		name = sc.nextLine();
		
		for(int i=0;i<pernum;i++)
		{
			if(name.compareTo(person[i].name) == 0)
			{
				person[i].showInfo();
				System.out.println("������ �˻��� �Ϸ�Ǿ����ϴ�.\n");
				return;
			}
		}
		System.out.println("�����Ͱ� �����ϴ�.\n");
	}
	public void deleteData()
	{
		String name;
		
		System.out.println();
		System.out.println("�����͸� ���� �մϴ�.");
		System.out.print("�̸� : ");
		name = sc.nextLine();
		
		for(int i=0;i<pernum;i++)
		{
			if(name.compareTo(person[i].name) == 0)
			{
				for(int j=i;j<pernum-1;j++)
					person[j] = person[j+1];
				pernum--;
				System.out.println("������ ������ �Ϸ�Ǿ����ϴ�.\n");
				return;
			}
		}
		System.out.println("�����Ͱ� ���� ������ ������ �Ұ��� �մϴ�.\n");
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
