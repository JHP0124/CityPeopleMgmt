package review.probono.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import exception.CodeException;
import review.probono.controller.Controller;
import review.probono.model.dto.Personinfo;
import review.probono.model.dto.personlocation;
import review.probono.model.dto.totaloverall;

public class Command {
	static String a=" ";
	static String b;
	
	public static Controller head= Controller.getInstance();
	
	public static void reqRes(int reqNo) throws CodeException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		if (reqNo == 1) {
			while (a != null) {
			try {
				System.out.println("1. 시민정보 생성 작업 모드");
				
				System.out.println("주민번호를 입력하세요. : ");
				String k = in.readLine();
				String EngName= "before";
				System.out.println("이름을 입력하세요. : ");
				String name = in.readLine();
				System.out.println("생일을 입력하세요. : ");
				String date = in.readLine();
				System.out.println("주소를 입력하세요. : ");
				String addr = in.readLine();
				System.out.println("위성좌표를 입력하세요. : ");
				String gpsno = in.readLine();
				
				Personinfo i = new Personinfo(name,Integer.parseInt(date));
				personlocation l = new personlocation(addr,Integer.parseInt(gpsno));
				totaloverall p = new totaloverall(Integer.parseInt(k),EngName,i,l);
				head.cityPersonInsert(p);
				System.out.println("모드를 종료하려면 [exit]를 입력하세요");
				System.out.println("계속하려면 아무키를 입력하세요");
				b=in.readLine();
				if(b.equals("exit")) {
					System.out.println("작업모드가 종료되었습니다.");
					return;// 메서드 종료
				}
			} catch (NumberFormatException | IOException e){
				e.printStackTrace();
			}
		}	
		
		} else if (reqNo == 2) {
			System.out.println("2. 시민정보 리스트");
			head.citypersonlist();
		
		} else if (reqNo == 3) {
			while (a != null) {
			System.out.println("3. 주민번호로 시민조회모드");
			System.out.println("조회하려는 주민번호를 입력하세요.");
			System.out.println("주민번호 :");
			try {
				String k = in.readLine();
				head.getcityperson(Integer.parseInt(k));
				System.out.println("모드를 종료하려면 [exit]를 입력하세요");
				System.out.println("계속하려면 아무키를 입력하세요");
				b=in.readLine();
				if(b.equals("exit")) {
					System.out.println("작업모드가 종료되었습니다.");
					return;// 메서드 종료
				}
			} catch (NumberFormatException | IOException e) {
				e.printStackTrace();
			}
			
			}
			
		} else if (reqNo == 4) {
			while (a != null) {
			try {
				System.out.println("4. 주민번호기반 시민정보(info) 변경모드");
				System.out.println("주민번호를 입력하세요.");
				String k = in.readLine();
				System.out.println("이름을 입력하세요.");
				String name=in.readLine();
				System.out.println("생일을 입력하세요.");
				int date=Integer.parseInt(in.readLine());
				Personinfo i = new Personinfo(name, date) ; 
				head.personinfoupdate(Integer.parseInt(k), i);				
				System.out.println("변경된 시민 정보 출력");
				head.getcityperson(Integer.parseInt(k));
				System.out.println("모드를 종료하려면 [exit]를 입력하세요");
				System.out.println("계속하려면 아무키를 입력하세요");
				b=in.readLine();
				if(b.equals("exit")) {
					System.out.println("작업모드가 종료되었습니다.");
					return;// 메서드 종료
				}
			} catch (NumberFormatException | IOException e) {
				e.printStackTrace();
			}
			}
			
		} else if (reqNo == 5) {
			while (a != null) {
			try {
				System.out.println("5. 주민번호기반 시민위치(location) 변경모드");
				System.out.println("주민번호를 입력하세요.");
				String k = in.readLine();
				System.out.println("주소명을 입력하세요.");
				String addr=in.readLine();
				System.out.println("위성좌표를 입력하세요.");
				int loca=Integer.parseInt(in.readLine());
				personlocation l = new personlocation(addr, loca) ; 
				head.personlocationupdate(Integer.parseInt(k), l);
				System.out.println("변경된 시민 정보 출력");
				head.getcityperson(Integer.parseInt(k));
				System.out.println("모드를 종료하려면 [exit]를 입력하세요");
				System.out.println("계속하려면 아무키를 입력하세요");
				b=in.readLine();
				if(b.equals("exit")) {
					System.out.println("작업모드가 종료되었습니다.");
					return;// 메서드 종료
				}
			} catch (NumberFormatException | IOException e) {
				e.printStackTrace();
			}
			}
			
		} else if (reqNo == 6) {
			while (a != null) {
			try {
				System.out.println("6. 주민번호기반 시민정보 삭제모드");
				System.out.println("삭제하려는 시민의 주민번호를 입력하세요.");
				String k = in.readLine();
				head.psersoninfodelete(Integer.parseInt(k));
				System.out.println("삭제 이후의 시민 정보 리스트 출력");
				head.citypersonlist();
				System.out.println("모드를 종료하려면 [exit]를 입력하세요");
				System.out.println("계속하려면 아무키를 입력하세요");
				b=in.readLine();
				if(b.equals("exit")) {
					System.out.println("작업모드가 종료되었습니다.");
					return;// 메서드 종료
				}
				
			}catch (NumberFormatException | IOException e) {
				e.printStackTrace();
			}
			}
			

		} else if (reqNo == 7) {
			while (a != null) {
				try {
			System.out.println( reqNo+". 주민번호 기반 이름->영문이름 자동번역 모드  ");
			System.out.println( "해외 출국시 영문이름이 필요한 시민을 위한 기능");
			System.out.println("해당 시민의 주민번호를 입력하세요.");
			System.out.print("입력 : ");
				b=in.readLine();
				
			    head.translate(Integer.parseInt(b));
			    
			    
			System.out.println("해당 변경된 주민의 리스트 출력");
				head.getcityperson(Integer.parseInt(b));    
			System.out.println("모드를 종료하려면 [exit]를 입력하세요");
			System.out.println("계속하려면 아무키를 입력하세요");
				b=in.readLine();
			if(b.equals("exit")) {
				System.out.println("작업모드가 종료되었습니다.");
				return;// 메서드 종료
			}
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}

		} 

		} else if (reqNo == 8) {
			System.out.println("정말로 작업을 종료하시겠습니까? 그렇다면 yes를 입력하세요.");
			System.out.println("yes말고 다른 문자를 입력하면 첫 화면으로 초기화됩니다.");
			System.out.print("입력 : ");
			try {
				b=in.readLine();
			} catch (IOException e) {
				//e.printStackTrace();
			}
			if(b.equals("yes")) {
				throw new CodeException("시스템이 종료되었습니다.");
			}

		}
		
		
		
		else {
			System.out.println("1~8 사이의 명령코드를 입력하세요");

		}
	}

}
