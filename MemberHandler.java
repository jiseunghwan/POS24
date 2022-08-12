package POS24;

import java.util.Scanner;

public class MemberHandler {
	private MemberInfo[] members;
	private int idx;

	public MemberHandler(int num){
		Scanner sc = new Scanner(System.in);
		members = new MemberInfo[num];
		idx = 0;
	}

	public void memberInsert(){ //회원가입용 메소드
		String uid, pwd, name;
		Scanner sc = new Scanner(System.in);
		System.out.print("아이디 : "); uid = sc.nextLine();
		if (!isUniqueID(uid)) // 아이디가 중복되었으면
		{
			System.out.println("이미 사용중인 아이디 입니다. \n");
			return;
		}
		System.out.print("암 호 : "); pwd = sc.nextLine();
		System.out.print("이 름 : "); name = sc.nextLine();

		members[idx] = new MemberInfo(uid, pwd, name);
		idx++;
		System.out.println("가입 완료!! \n");
	}

	private boolean isUniqueID(String uid){ // 아이디의 중복 여부를 리턴
		if (idx == 0) return true;

		for (int i = 0 ; i < idx ; i ++)
		{
			if (members[i].getUid().equals(uid))
			{
				return false;
			}
		}
		return true;
	}

	public void memberLoginEx(){ // 회원로그인용 메소드
		Scanner sc = new Scanner(System.in);
		System.out.print("아이디 : "); String uid = sc.nextLine();
		System.out.print("패스워드 : "); String pwd = sc.nextLine();

		for (int i = 0 ; i < idx ; i++)
		{
			if (members[i].getUid().equals(uid) && members[i].getPwd().equals(pwd))
			{
				System.out.println("환영합니다.");
				System.out.println("로그인에 성공하였습니다. \n");
				return;
			}else if (!members[i].getUid().equals(uid))
			{
				System.out.println("존재하지 않는 아이디입니다. \n");
				return;
			}
			else if (members[i].getUid().equals(uid) && !members[i].getPwd().equals(pwd))
			{
				System.out.println("암호가 잘못되었습니다. \n");
				return;
			}
		}
		
	}

	public void memberLogin(){
		Scanner sc = new Scanner(System.in);
		System.out.print("아이디 : "); String uid = sc.nextLine();
		System.out.print("패스워드 : "); String pwd = sc.nextLine();
		String msg = "존재하지 않는 아이디 입니다.";

		for (int i = 0 ; i < idx ; i++ )
		{
			if (members[i].getUid().equals(uid))
			{// members배열에 입력한 아이디가 있으면
				if (members[i].getPwd().equals(pwd))
				{
					System.out.println("로그인 성공! \n");
					System.out.println(members[i].getName() + "님 반갑습니다.\n");
					
					new MenuHandler().totalService();
				} else{
					msg = "암호가 잘못되었습니다.";
				}
			}
		}
		System.out.println(msg);
	}


}
