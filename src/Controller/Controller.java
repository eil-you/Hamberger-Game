package Controller;

import model.HamburgerGameDAO;
import model.Hamburger;
import model.User;
import java.util.ArrayList;

public class Controller {
	String recipe = "";
	String view_recipe = "";

	Hamburger h = null;
	Hamburger h1 = null;
	HamburgerGameDAO dao = new HamburgerGameDAO();
	User u = null;

	public void insert(Hamburger h) {
		// return row ---> int

		int row = dao.insert(h);

		if (row > 0) {
			System.out.println("������ �߰� ����");

		} else {
			System.out.println("������ �߰� ���� ");
		}
	}

	public void ingredient() {
		dao.ingredient();
	}

	public void inName(char i) {
		System.out.println(dao.inName(i));
	}

	public boolean login(User u) {
		return dao.login(u);
	}

	public void rankTop10() {

		ArrayList<Hamburger> listTop10 = dao.rankTop10();

		for (Hamburger h : listTop10) {

			System.out.println("  "+h.getRank() +"��" + "\t"+ "\t" + h.getId() + "\t" + "\t" + h.getScore()+"��");

		}

	}

	public void rankMine(String id) {

		Hamburger listMine = dao.rankMine(id);
		if (listMine == null) {
			System.out.println("������ �����ϴ�.");

		} else {

			System.out.println("  "+listMine.getRank() + "��" +  "\t"+ "\t" + listMine.getId() + "\t" + "\t" + listMine.getScore()+"��");
			      
		}

	}

	public String easyGame() {
		//
//	      ArrayList<Hamburger> list = dao.easyList();
//	      for (Hamburger easy : list) {
//	         System.out.println(easy.getE_num()+"\t"+easy.getMenu()+"\t"+easy.getRecipe());
//	      }
		ArrayList<Hamburger> easyQ = dao.easyGame();
		for (Hamburger h : easyQ) {
			System.out.println("�޴��̸� : " + h.getMenu());
			System.out.print("������ : ");
			for (int i = 0; i < h.getRecipe().length(); i++) {
				char a = h.getRecipe().charAt(i);
				System.out.print(dao.inName(a) + " ");
			}
			System.out.println();
			recipe = h.getRecipe();
		}
		return recipe;
	}

	public String easySol() {
		return recipe;
	}

	public String norSol() {
		return recipe;
	}

	public String hardSol() {
		return recipe;
	}

	public String normalGame() {
		ArrayList<Hamburger> normalQ = dao.normalGame();

		for (Hamburger h : normalQ) {
			System.out.println(h.getMenu());
			System.out.print("������ : ");
			for (int i = 0; i < h.getRecipe().length() ; i++) {
				char a = h.getRecipe().charAt(i);
				System.out.print(dao.inName(a) + " ");
			}
			System.out.println();
			recipe = h.getRecipe();
		}

		return recipe;

	}

	public String hardGame() {
		ArrayList<Hamburger> hardQ = dao.hardGame();
		for (Hamburger h : hardQ) {
			System.out.println(h.getMenu());
			System.out.print("������ : ");
			for (int i = 0; i < h.getRecipe().length() ; i++) {
				char a = h.getRecipe().charAt(i);
				System.out.print(dao.inName(a) + " ");
			}
			System.out.println();
			recipe = h.getRecipe();
		}

		return recipe;
	}

	public int score(String answer_input, int s3, int salary) {
		String answer = "";
		if (s3 == 1) {
			answer = easySol();
		} else if (s3 == 2) {
			answer = norSol();
		} else {
			answer = hardSol();
		}

		if (answer.equals(answer_input)) { // 1�� �������� ������ ������

			if (s3 == 1) {

				answer = recipe;
				salary += 500 * 1; // 2�� ���̵��� ���� ���� ���ϱ�
			} else if (s3 == 2) {
				answer = recipe;
				salary += 500 * 2;
			} else {
				answer = recipe;
				salary += 500 * 3;
			}

			System.out.println("���ߴµ� �� ���� ����󱸤Ѥ���^^");
			System.out.println("����޿� : " +salary  );
			
		} else {
			if (s3 == 1) {
				salary -= 500 * 2; // 2�� ���̵��� ���� ���� ���ϱ�
				answer = recipe;
			} else if (s3 == 2) {
				answer = recipe;
				salary -= 500 * 3;
			} else {
				answer = recipe;
				salary -= 500 * 4;
			}

			System.out.println("�� ���� ���Ƹ�����!  \n����޿� :  " + salary );
		}
		return salary;
	}

	public String getId(User u) {
		String status = dao.getId(u);
		
		return status;
	}
	
	public int getScore(User u) {
		int score = dao.getScore(u);
		return score;
	}
	
	public void updateScore(User u) {
		int row = dao.updateScore(u);
		if(row >0 ) {
			System.out.println("������ ������Ʈ ����!");
		}else {
			System.out.println("������ ������Ʈ ����!");
		}
		
	}

	public void addScore(User u) {

		System.out.println(u.getId());
		int row = dao.addScore(u);

		if (row > 0) {
			
			System.out.println("���̵�, ���� ������ �߰� ����");

		} else {
			System.out.println("���̵�, ���� ������ �߰� ����");

		}
		}


}