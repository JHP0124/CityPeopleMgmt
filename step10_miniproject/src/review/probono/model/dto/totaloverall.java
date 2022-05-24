package review.probono.model.dto;

public class totaloverall {
	/*주민번호*/
	private int key;
	private String EngName;
	/*시민정보 : 이름(name),생일(date)*/
	private Personinfo citypersoninfo;
	/*시민위치 : 주소명(address),좌표(gpsno)*/
	private personlocation citypersonlocation;
	
	public totaloverall() {
		super();
	}
	public totaloverall(int key, String EngName, Personinfo citypersoninfo, personlocation citypersonlocation) {
		super();
		this.key=key;
		this.EngName=EngName;
		this.citypersoninfo=citypersoninfo;
		this.citypersonlocation=citypersonlocation;
	}

	public int getKey() {
		return key;
	}
	
	public void setKey(int k) {
		this.key=k;
	}
	public String getEngName() {
		return EngName;
	}
	
	public void setEngName(String n) {
		this.EngName=n;
	}
	
	
	public Personinfo getCitypersoninfo() {
		return citypersoninfo;
	}
	
	public void setCitypersoninfo(Personinfo p) {
		this.citypersoninfo=p;
	}
	
	public personlocation getCitypersonlocation() {
		return citypersonlocation;
	}
	
	public void setCitypersonlocation(personlocation l) {
		this.citypersonlocation=l;
	}
	
	//재정의
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("|주민번호 : ");
		builder.append(key);
		builder.append("|영문이름 : ");
		builder.append(EngName);
		builder.append("   [시민정보 : ");
		builder.append(citypersoninfo);
		builder.append("] [시민위치 : ");
		builder.append(citypersonlocation);	
		builder.append("]");
		return builder.toString();
		
	}
}
