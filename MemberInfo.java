package POS24;

public class MemberInfo {
	
	private String uid, pwd, name;
	
	public MemberInfo(String uid, String pwd, String name){
		this.uid = uid;
		this.pwd = pwd;
		this.name = name;
	}
	public String getUid(){ return uid; }
	public void setUid(String uid){ this.pwd = uid; }
	
	public String getPwd(){ return pwd; }
	public void setPwd(String pwd){ this.pwd = pwd; }
	
	public String getName(){ return name; }
	public void setName(String name){ this.name = name; }
}
