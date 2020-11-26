package application;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class VLBinarySearchTree {

	Person root = null;

	GridPane grid;

	public Person getRoot() {
		return root;
	}

	public void setRoot(Person root) {
		this.root = root;
	}

	public void addPerson(Person p) { // sets up the scene for the call of the recursive add method
		root = addPerson(root, p);

	}

	public Person addPerson(Person current, Person newP) {

		if (current == null) {
			current = newP;
		} else {
			if (current.compareTo(newP) >= 1) {
				current.setLeft(addPerson(current.getLeft(), newP));
			} else {
				current.setRight(addPerson(current.getRight(), newP));
			}

		}

		return current;

	}

	public GridPane getGrid() {
		return grid;
	}

	public void setGrid(GridPane grid) {
		this.grid = grid;
	}

	public void inOrderPrintNames(Person current, ArrayList<Text> texts) {
		if (current != null) {

			inOrderPrintNames(current.getLeft(), texts);

			// System.out.println(current.getFirstName() + " " + current.getLastName());

			Text t = new Text(current.getFirstName() + " " + current.getLastName());
			texts.add(t);

			inOrderPrintNames(current.getRight(), texts);
		}

	}

	public void inOrderPrintAll() {
		ArrayList<Text> texts = new ArrayList<Text>();

		this.inOrderPrintNames(root, texts);

		int yPos = 0;
		int xPos = 0;
		for (int i = 0; i < texts.size(); i++) {
			if (i % 10 == 0) {
				xPos = 0;
				yPos++;
			}

			grid.add(texts.get(i), xPos + (i % 10), yPos);
		}

	}

	public void prePrintNames(Person current, ArrayList<Text> texts) {
		if (current != null) {

			// System.out.println(current.getFirstName() + " " + current.getLastName());
			Text t = new Text(current.getFirstName() + " " + current.getLastName());
			texts.add(t);

			prePrintNames(current.getLeft(), texts);
			prePrintNames(current.getRight(), texts);
		}

	}

	public void prePrintAll() {
		ArrayList<Text> texts = new ArrayList<Text>();

		this.prePrintNames(root, texts);

		int yPos = 0;
		int xPos = 0;
		for (int i = 0; i < texts.size(); i++) {
			if (i % 10 == 0) {
				xPos = 0;
				yPos++;
			}
			grid.add(texts.get(i), xPos + (i % 10), yPos);
		}

	}

	public void postPrintNames(Person current, ArrayList<Text> texts) {
		if (current != null) {

			postPrintNames(current.getLeft(), texts);
			postPrintNames(current.getRight(), texts);

			Text t = new Text(current.getFirstName() + " " + current.getLastName());
			texts.add(t);

			// System.out.println(current.getFirstName() + " " + current.getLastName());
		}

	}

	public void postPrintAll() {
		ArrayList<Text> texts = new ArrayList<Text>();

		this.postPrintNames(root, texts);

		int yPos = 0;
		int xPos = 0;
		for (int i = 0; i < texts.size(); i++) {
			if (i % 10 == 0) {
				xPos = 0;
				yPos++;
			}
			grid.add(texts.get(i), xPos + (i % 10), yPos);
		}

	}

	public void printBreadth(Person p, ArrayList<Text> texts) {

		if (root == null)
			return;

		ArrayList list = new ArrayList();
		list.add(root);
		list.add(null);

		while (list.size() > 1) {
			if (list.get(0) == null) {
				list.add(null);
				// System.out.println("");
			} else {
				p = (Person) list.get(0);
				if (p.getLeft() != null)
					list.add(p.getLeft());
				if (p.getRight() != null)
					list.add(p.getRight());
				// System.out.print(p + " ");
				Text t = new Text(p.getFirstName() + " " + p.getLastName());
				texts.add(t);
			}
			list.remove(0);

		}

	}

	public void bFPrintAll() {
		ArrayList<Text> texts = new ArrayList<Text>();

		this.printBreadth(root, texts);

		int yPos = 0;
		int xPos = 0;
		for (int i = 0; i < texts.size(); i++) {
			if (i % 10 == 0) {
				xPos = 0;
				yPos++;
			}
			grid.add(texts.get(i), xPos + (i % 10), yPos);
		}

	}

	public void searchByFNameLength(Person current, int length, List<Person> results) {

		if (current != null) {
			if (current.getFirstName().length() == length) {
				results.add(current);
			}
			searchByFNameLength(current.getLeft(), length, results);
			searchByFNameLength(current.getRight(), length, results);
		}

	}

	public void searchByLNameLength(Person current, int length, List<Person> results) {

		if (current != null) {
			if (current.getLastName().length() == length) {
				results.add(current);
			}
			searchByLNameLength(current.getLeft(), length, results);
			searchByLNameLength(current.getRight(), length, results);
		}

	}

	public void searchByFName(Person current, String fName, List<Person> results) {

		if (current != null) {
			if (current.getFirstName().toLowerCase().equals(fName)) {
				results.add(current);
			}

			searchByFName(current.getLeft(), fName, results);
			searchByFName(current.getRight(), fName, results);

		}
	}

	public void searchByLName(Person current, String lName, List<Person> results) {

		if (current != null) {
			if (current.getLastName().toLowerCase().equals(lName)) {
				results.add(current);
			}

			searchByLName(current.getLeft(), lName, results);
			searchByLName(current.getRight(), lName, results);
		}

	}

	public void deleteLeaves(Person current) { // method to clear BST
		if (current == null)
			return;

		if (current.getLeft() != null)
			current.setLeft(null);

		else
			deleteLeaves(current.getLeft());

		if (current.getRight() != null)
			current.setRight(null);

		else
			deleteLeaves(current.getRight());
	}

	public void clearAll() {

		this.deleteLeaves(root);

	}

	public void test() {
		Person p1 = new Person("Neeha", "A");
		Person p2 = new Person("Deepa", "B");
		Person p3 = new Person("Pui-Li", "Lee");
		Person p4 = new Person("Van", "Le");
		Person p5 = new Person("Ali", "Ahmed");
		Person p6 = new Person("Michael", "Hommer");
		Person p7 = new Person("Karsten", "Lundqvist");
		addPerson(p1);
		addPerson(p2);
		addPerson(p3);
		addPerson(p4);
		addPerson(p5);
		addPerson(p6);
		addPerson(p7);

		// test search for First Name
//
//		Person pp = searchByFName(getRoot(), "Ali");
//		if (pp != null)
//			System.out.println("Found: " + pp);
//		else
//			System.out.println("Not found");
//
//		pp = searchByLName(getRoot(), "Ahmed");
//		if (pp != null)
//			System.out.println("Found: " + pp);
//		else
//			System.out.println("Not found");

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// System.out.println("hey");

		// (new VLBinarySearchTree()).test();

	}

}