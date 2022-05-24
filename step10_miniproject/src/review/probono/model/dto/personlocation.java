package review.probono.model.dto;

public class personlocation {
	

	//주소명
	private String address;
	
	//위성좌표
	private int gpsno;
	
	public personlocation(){}
	public personlocation(String address, int gpsno){
		super();
		this.address=address;
		this.gpsno=gpsno;	
	}
	
	public void setAddress(String add) {
		this.address=add;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setGpsno(int gpsno) {
		this.gpsno=gpsno;
	}
	
	public int getGpsno() {
		return gpsno;
	}
	
	public String toString() {
		StringBuilder p = new StringBuilder();
		p.append("| 주소명 : ");
		p.append(address);
		p.append("|위성좌표 :");
		p.append(gpsno);
		return p.toString();
	}
	
	

}
