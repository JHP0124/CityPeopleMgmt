package review.probono.model.service;

import java.util.ArrayList;

import probono.exception.NotFoundProjectException;
import review.probono.model.dto.Personinfo;
import review.probono.model.dto.personlocation;
import review.probono.model.dto.totaloverall;

public class Model {
	
	
	static String bf=null; //before
	static String af=null; //after

	private static Model instance = new Model(); // model클래스의 주소값

	private ArrayList<totaloverall> listinfo = new ArrayList<totaloverall>(); // listinfo : totaloverall 규격의 arraylist배열
																				// 주소값.

	public static Model getInstance() { // singleton pattern 방식
		return instance;
	}
	
	public static ApiExamTranslateNmt4 trans2 = ApiExamTranslateNmt4.getInstance();
	
	
	public static String before() {
		return bf;
	}
	
	

	public ArrayList<totaloverall> getlistinfo() {
		return listinfo;
	}

	public totaloverall getCityperson(int key) throws NotFoundProjectException {
		for (totaloverall t : listinfo) { // listinfo 배열에서 순서대로 주소값을 뽑아내어서 t에 넣고
			if (t.getKey() == key) { // t에서 얻은 키값과 key가 같은지 확인.
				return t; // 메서드 종료 //break는 반복문 for 종료
			}
		} // 반복문이 다 실행되고 나면 아래의 예외 상황을 발동시키는 문장이 실행되어서 try~catch문의 catch(){}가 실행된다.
		throw new NotFoundProjectException("존재하지 않는 주민번호거나 잘못된 주민번호를 입력하셨습니다.");
	}

	public void totaloverallInsert(totaloverall add) {
		listinfo.add(add);
	}

	public void personinfoupdate(int key, Personinfo i) throws NotFoundProjectException {
		for (totaloverall t : listinfo) {
			if (t.getKey() == key) {
				t.setCitypersoninfo(i);
				return;
			}
		}
		throw new NotFoundProjectException("잘못된 시민정보(주민번호)를 입력하셨습니다.");
	}

	public void personlocationupdate(int key, personlocation l) throws NotFoundProjectException {
		for (totaloverall t : listinfo) {
			if (t.getKey() == key) {
				t.setCitypersonlocation(l);
				return;
			}
		}
		throw new NotFoundProjectException("잘못된 시민위치를 입력하셨습니다.");
	}

	public void citypersondelete(int key) throws NotFoundProjectException {
		for (totaloverall t : listinfo) { // listinfo 배열안에 들어 있는 주소값을 순서대로 하나씩 뽑아서 t에 넣고
			if (t.getKey() == key) { // 주소값이 저장된 t(totaloverall클래스규격)에서 같은 키값을 반복문 for로 찾고
				listinfo.remove(t); // listinfo 배열에서 t주소값에 해당되는 배열을 제거한다. 제거되면 빈 배열로 뒷 배열값들이 앞으로 전진한다.
				return;
			}
		}
		throw new NotFoundProjectException("(" + key + ") : 해당 주민번호는 존재하지 않습니다.");
	}

	public int listinfosize() {
		return listinfo.size();
	}

	public void CityTranslate(int key) throws NotFoundProjectException {
		for (totaloverall t : listinfo) {
			if (t.getKey() == key && t.getEngName().equals("before")) {
				bf = t.getCitypersoninfo().getName();
				//before()메서드로 인해->> ApiExamTranslateNmt4의 text로 이동
				af = trans2.getResult(); 
				t.setEngName(af);
					 
			}
		}
		throw new NotFoundProjectException("(" + key + ") : 해당 주민번호는 존재하지 않거나 이미 번역되어 있습니다.");
	}

}
