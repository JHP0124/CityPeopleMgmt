package review.probono.view;

import java.util.ArrayList;

import review.probono.model.dto.totaloverall;

public class successview {
	
			public static void view(totaloverall tv) {
				if(tv != null)
				{
					System.out.println(tv); //tv.toString으로 출력
				}else {
					System.out.println("해당 주민정보는 없습니다.");
				}
			}
			public static void listview( ArrayList<totaloverall> tv) {
				int index=0;
				for(totaloverall t: tv)
				{
					System.out.println("주민정보 ["+(index+1)+"] :" +t.toString());
					index++;
				}
			}
			
			public static void successmessage(String s) {
				System.out.println("진행상황 "+ s);
			}
			
}
