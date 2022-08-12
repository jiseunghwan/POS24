package POS24;

public class MenuManager {
	
	private static MenuManager instance;
	
	public static MenuManager getInstance() {
		if ( instance == null)
			instance = new MenuManager();
		return instance;
	}
	
	private MenuInfo[] mi;
	private int MAX_SIZE = 50;
	private int x;
	
	//최대값 정해주기
	private MenuManager() {
		mi = new MenuInfo[MAX_SIZE];
		x = 0;
	}
	
	//등록하기
	public void add(String Mname, String Mfrom, String Mbacord, 
			int Mprice, String Mdata, String M19 , int Amount) {
		MenuInfo m = new MenuInfo();
		
		m.setName(Mname);
		m.setFrom(Mfrom);
		m.setBacord(Mbacord);
		m.setPrice(Mprice);
		m.setDate(Mdata);
		m.set19(M19);
		m.setAmount(Amount);
		
		mi[x++] = m;
	}
	
	//삭제하기
	public void remove(String Mbacord) {
		for(int i=0;i<x;i++) {
			if(mi[i].getBacord().equals(Mbacord)) {
				for(;i<x;i++) {
					mi[i] = mi[i+1];
				}
				x--;
			}
		}
	}
	
	//목록보기
	public void list() {
		System.out.println("------------------");
		for(int i=0;i<x;i++)
			System.out.println(mi[i]);
		System.out.println("------------------");
	}
	
	//검색하기
	public void search(String Mbacord) {
		for(int i=0;i<x;i++) {
			if(mi[i].getBacord().equals(Mbacord)) {
				System.out.println("------------------");
				for(;i<x;i++) {
					System.out.println(mi[i]);
					System.out.println("------------------");
				}
			}
		}
	}
	
	//수량 업데이트
	public void update(String Mname, int num) {
		for(int i=0;i<x;i++) {
			if(mi[i].getName().equals(Mname)) {
				if((mi[i].getAmount()==0) || (mi[i].getAmount()-num)<0) {
					System.out.println("재고가 없습니다.");
				}
				else {
					mi[i].setAmount((mi[i].getAmount()-num));

					System.out.println("구매가 완료되었습니다.");
				}
			}
		}
	}
}
