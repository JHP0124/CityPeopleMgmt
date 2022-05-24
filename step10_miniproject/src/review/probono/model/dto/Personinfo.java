package review.probono.model.dto;




public class Personinfo {
	
	//이름
	private String name;
	
	//생일
	private int date;
	
	public Personinfo(){};
	public Personinfo(String name, int date){
		super();
		this.name=name;
		this.date=date;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setDate(int date) {
		this.date=date;
	}
	
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append("|이름  : ");
		s.append(name);
		s.append("| 생일 : ");
		s.append(date);
		return s.toString();
	}


}
