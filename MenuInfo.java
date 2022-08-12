package POS24;

public class MenuInfo {

	private String Mname;	//상품 이름
	private String Mfrom;	//상품 원산지
	private String Mbacord;	//상품 바코드
	private int Mprice;	//상품 가격
	private String Mdate;	//상품 폐기날짜
	private String M19;		//상품 성인유무
	private int Mamount; 	//상품 수량
		

	public String getName() { return Mname; }
	public void setName( String Mname ) { this.Mname = Mname; }
	
	public String getFrom() { return Mfrom; }
	public void setFrom( String Mfrom ) { this.Mfrom = Mfrom; }
	
	public String getBacord() { return Mbacord; }
	public void setBacord( String Mbacord ) { this.Mbacord = Mbacord; }
	
	public int getPrice() { return Mprice; }
	public void setPrice( int Mprice ) { this.Mprice = Mprice; }
	
	public String getDate() { return Mdate; }
	public void setDate( String Mdate ) { this.Mdate = Mdate; }
	
	public String get19() { return M19; }
	public void set19( String M19 ) { this.M19 = M19; }
	
	public int getAmount() { return Mamount; }
	public void setAmount( int Mamount ) { this.Mamount = Mamount; }
	
	public String toString() {
		
		return "Menu [상품이름 = " + Mname + ", 원산지 = " + Mfrom + ", 바코드 = " + Mbacord +
				",가격 = " + Mprice + ", 폐기날짜 = " + Mdate + ", 성인 = " + M19 +
				", 수량 = " + Mamount + " ]";
	}
}
