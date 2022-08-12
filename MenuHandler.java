package POS24;

import java.util.Scanner;

public class MenuHandler {
	
	Scanner sc = new Scanner(System.in);
	MenuManager mm = MenuManager.getInstance();
	int sel, sel2, sel3;
	
	//시간 시작
	long startTime = System.currentTimeMillis();
	
	public void totalService() {
		
		while(true) {
			
			System.out.println("무엇을 도와드릴까요??");
			System.out.println("1. 판매자");
			System.out.println("2. 구매자");
			System.out.println("9. 종료하기");
			System.out.println("입력 : ");
			
			int sel = sc.nextInt();
			if(sel==1) {
				sellerService();
			}
				else if(sel==2) {
				buyerService();
			}
				else if(sel==9) {
				quit();
				}
			
				else {
				System.out.println("다시 입력해주세요.");
				}

			}
		
		}
		public void quit() {	
			//시간 끝
			//시분초 설정
			long endTime = System.currentTimeMillis();
			long time = (endTime - startTime)/1000;
			
			long hour, minute, second;
			
			hour = time/(60*60);
			minute = time/60;
			second = time%60;
			
			System.out.println(hour + " 시 " +minute + " 분 " + second + " 초 일하셨습니다.");
			System.out.println("분급은 " + (minute*9800) + "원 입니다.");
			
			System.out.println("오늘 하루도 수고하셨습니다.");
			System.out.println("-----종료-----");
			
			System.exit(0);
			
		}
		//판매자 시스템
		public void sellerService() {
			System.out.println("-----판매자 시스템-----");
			System.out.println("----- 기능 선택 -----");
			System.out.println("1. 등록");
			System.out.println("2. 삭제");
			System.out.println("3. 목록");
			System.out.println("4. 검색");
			System.out.println("0. 뒤로가기");
			
			sel2 = sc.nextInt();
			
			if(sel2==1) {
				System.out.println("물품 정보 입력");
				
				System.out.println("상품 이름 : ");
				String Mname = sc.next();
				
				System.out.println("상품 원산지 : ");
				String Mfrom = sc.next();
				
				System.out.println("상품 바코드 : ");
				String Mbacord = sc.next();
				
				System.out.println("상품 가격 : ");
				int Mprice = sc.nextInt();
				
				System.out.println("폐기날짜 : ");
				String Mdate = sc.next();
				
				System.out.println("성인(Y/N) : ");
				String M19 = sc.next();
				
				System.out.println("상품 수량 : ");
				int Mamount = sc.nextInt();
				
				mm.add(Mname, Mfrom, Mbacord, Mprice, Mdate, M19, Mamount);
			}
			
			else if (sel2==2) {
				System.out.println("삭제할 상품의 바코드를 입력하세요.");
				sc.nextLine();
				String Mbacord = sc.nextLine();
				mm.remove(Mbacord);
			}
			
			else if(sel2==3) {
				mm.list();
			}
			
			else if(sel2==4) {
				System.out.println("검색할 상품 바코드를 입력하세요.");
				sc.nextLine();
				String Mbacord = sc.nextLine();
				mm.search(Mbacord);
			}
			else if(sel2==0) {
				totalService();
			}
			else {
				System.out.println("다시 입력해주세요.");
			}
		}
		//구매자 시스템
		public void buyerService() {
			
				System.out.println("-----구매자 시스템-----");
				System.out.println("-----기능 선택-----");
				System.out.println("1. 구매하기");
				System.out.println("0. 뒤로가기");
				
				sel3 = sc.nextInt();
				
				if(sel3==1) {

					System.out.println("구매할 상품의 이름을 입력하세요");
	
					sc.nextLine();
					String Mname = sc.nextLine();
					mm.search(Mname);
					
					System.out.println("구매할 개수를 입력하세요");
					int num = sc.nextInt();
					
					System.out.println("카드로 결제하시겠습니까? (Y/N)");
					String YorN = sc.next();

					mm.update(Mname, num);

				}
				else if(sel3==0) {
					totalService();
				}
				else {
					System.out.println("다시 입력해주세요.");
				}
		}
}
	
