package review.probono.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import exception.CodeException;
import review.probono.model.dto.Personinfo;
import review.probono.model.dto.personlocation;
import review.probono.model.dto.totaloverall;

public class Startview {

	static String a=" ";

	public static void main(String[] args) {

		
				

		// totaloverall규격 : 주민번호: **/ 시민정보(personinfo) [이름/생일]
		// /시민위치(personlocation)[주소명/위성좌표]

//		// 시민정보
//		Personinfo i1 = new Personinfo("가나다", 91);
//		Personinfo i2 = new Personinfo("라바사", 94);
//		Personinfo i3 = new Personinfo("ABC", 97);
//		// 시민위치
//		personlocation l1 = new personlocation("abc", 1234);
//		personlocation l2 = new personlocation("def", 5678);
//		personlocation l3 = new personlocation("XYZ", 0000);
//
//		// 종합정보
//		totaloverall t1 = new totaloverall(80, i1, l1);
//		totaloverall t2 = new totaloverall(90, i2, l2);
		

		while (a != null) {
			System.out.println("************************************************************");
			System.out.println("**********************주민정보관리 시스템************************");
			System.out.println("************************************************************");
			System.out.println("*****작업코드**************************************************");
			System.out.println("*****1. 도시 시민정보 생성***************************************");
			System.out.println("*****2. 모든 도시 시민정보 조회***********************************");
			System.out.println("*****3. 입력한 주민번호로 주민정보 조회*****************************");
			System.out.println("*****4. 입력한 주민번호와 일치하는 주민의 info(이름/생일) 변경*********");
			System.out.println("*****5. 입력한 주민번호와 일치하는 주민의 location 변경**************");
			System.out.println("*****6. 입력한 주민번호와 일치하는 주민 삭제*************************");
			System.out.println("*****7. 입력한 주민번호와 일치하는 주민의 영문이름 갱신****************");
			System.out.println("*****8. 시스템 종료********************************************");
			System.out.println("<<<작업코드(숫자만)를 입력하시오>>>");
			System.out.print("작업 코드 : ");
			 
				try {
					BufferedReader in =new BufferedReader(new InputStreamReader(System.in));
					try {
						a = in.readLine();
					} catch (IOException e) {
						e.printStackTrace();
					}
					Command.reqRes(Integer.parseInt(a));  //7 입력이라 가정 
					} catch (CodeException e) { 
						System.out.println(e.getMessage()); 
						//e.printStackTrace();
						return; //메서드 종료
						//break; //반복문 종료
					}
				}
//
//		System.out.println("*****01. 도시 시민정보 생성*********");
//		Controller.cityPersonInsert(t1);
//		Controller.cityPersonInsert(t2);
//
//		System.out.println("*****02. 모든 도시 시민정보 조회*********");
//		Controller.citypersonlist();
//
//		System.out.println("*****03. 주민번호가 90인 주민 조회*********");
//		Controller.getcityperson(90);
//
//		System.out.println("*****04. 주민번호가 80인 주민의 info 변경*********");
//		Controller.personinfoupdate(80, i3);
//		System.out.println("*****04. 주민번호가 80인 주민의 info 변경확인*********");
//		Controller.getcityperson(80);
//
//		System.out.println("*****05. 주민번호가 90인 주민의 location 변경*********");
//		Controller.personlocationupdate(90, l3);
//		System.out.println("*****05. 주민번호가 90인 주민의 location 변경확인*********");
//		Controller.getcityperson(90);
//		System.out.println("*****06. 주민번호가 80인 주민의 삭제*********");
//		Controller.psersoninfodelete(88);
//		System.out.println("*****06. 주민번호가 80인 주민의 삭제확인*********");
//		Controller.getcityperson(80);

	}

}
