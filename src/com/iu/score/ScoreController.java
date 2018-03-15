package com.iu.score;

import java.util.*;

import com.iu.input.*;

public class ScoreController {

	private Scanner sc;
	private ScoreInput input;
	private View view;

	private ScoreService scoreService;

	public ScoreController() {
		sc = new Scanner(System.in);
		input = new ScoreInput();
		view = new View();
		scoreService = new ScoreService();
	}

	public void start() {
		while (true) {
			System.out.println("1.점수등록|2.점수삭제|3.점수조회|4.종료");
			int select = sc.nextInt();

			if (select == 1) {
				ScoreDTO dto=new ScoreDTO();
				dto=input.insert();
				String message=scoreService.insert(dto);
				view.view(message);
			} 
			else if (select == 2) {
				int num=input.delete();
				String message=scoreService.delete(num);
				view.view(message);
			}

			else if (select == 3) {
				ArrayList<ScoreDTO> arrayList=scoreService.selectAll();
				view.view(arrayList);
			}

			else {
				break;
			}
		}
		System.out.println("종료");
	}

}
