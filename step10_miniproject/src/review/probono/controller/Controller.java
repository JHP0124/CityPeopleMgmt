package review.probono.controller;

import java.util.ArrayList;

import probono.exception.NotFoundProjectException;
import review.probono.model.dto.Personinfo;
import review.probono.model.dto.personlocation;
import review.probono.model.dto.totaloverall;
import review.probono.model.service.Model;
import review.probono.view.Failview;
import review.probono.view.successview;

public class Controller {

	private static Controller cont = new Controller();

	private Controller() {
	}

	public static Controller getInstance() {
		return cont;
	}

	/////////////////////////////////////////////////////
	public static Model service = Model.getInstance(); // service : model의 주소값을 넣어 모델의 메서드를 부르는 중개역

	/* 시민정보 삽입 */
	public static void cityPersonInsert(totaloverall tv) {
		if (tv != null) {
			service.totaloverallInsert(tv);
		} else {
			Failview.printFail("유효하지 않은 정보가 입력되었으니 확인바랍니다.");
		}
	}

	/* 모든 시민 리스트 출력 */
	public static void citypersonlist() {
		ArrayList<totaloverall> tv = service.getlistinfo();
		if (tv.size() != 0) {
			successview.listview(tv);
		} else {
			Failview.printFail("현재 입력된 시민정보는 없습니다.");
		}

	}

	/* 주민번호로 시민정보 찾아내서 출력하기 */
	public static void getcityperson(int k) {
		try {
			successview.view(service.getCityperson(k));

		} catch (NotFoundProjectException e) {
			// e.printStackTrace();
			Failview.printFail(e.getMessage());
		}
	}

	/* key인 주민의 정보변경 */
	public static void personinfoupdate(int key, Personinfo i) {
		if (key != 0 && i != null) {
			try {
				service.personinfoupdate(key, i);// 메서드 예외발생시 아래문장 실행 불가
				successview.successmessage("해당 주민번호의 정보를 변경하였습니다.");
			} catch (NotFoundProjectException e) {
				// e.printStackTrace();
				Failview.printFail(e.getMessage());
			}
		}

	}

	public static void personlocationupdate(int key, personlocation l) {
		if (key != 0 && l != null) {
			try {
				service.personlocationupdate(key, l);
			} catch (NotFoundProjectException e) {
				e.printStackTrace();
				Failview.printFail(e.getMessage());
			}
		}

	}

	public static void psersoninfodelete(int k) {
		if (k != 0) {
			try {
				service.citypersondelete(k);
				successview.successmessage("해당 주민정보를 삭제하였습니다.");
			} catch (NotFoundProjectException e) {
				// e.printStackTrace();
				Failview.printFail(e.getMessage());
			}
		} else {
			Failview.printFail("삭제하려는 주민번호를 다시 확인해주세요.");
		}
	}

	public static void translate(int k) {
		if (k != 0) {
			try {
				service.CityTranslate(k);
				successview.successmessage("해당 시민의 이름을 별도의 칸에 영어로 번역하였습니다.");
			} catch (NotFoundProjectException e) {
				// e.printStackTrace();
				Failview.printFail(e.getMessage());
			}

		} else {
			Failview.printFail("이름을 영어로 번역하려는 시민의 주민번호를 다시 확인해주세요.");
		}
	}

}
