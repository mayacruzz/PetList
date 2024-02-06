
import java.util.List;
import java.util.Scanner;

import controller.ListPetHelper;
import model.ListPet;

public class StartProgram {

		static Scanner in = new Scanner(System.in);
		static ListPetHelper lph = new ListPetHelper();

		private static void addAnItem() {
			// TODO Auto-generated method stub
			System.out.print("Enter type of pet: ");
			String type = in.nextLine();
			System.out.print("Enter name of pet: ");
			String name = in.nextLine();
			System.out.print("Enter age of pet: ");
			int age = in.nextInt();
			
			ListPet toAdd = new ListPet(type, name, age);
			lph.insertItem(toAdd);

		}

		private static void deleteAnItem() {
			// TODO Auto-generated method stub
			System.out.print("Enter type of pet: ");
			String type = in.nextLine();
			System.out.print("Enter name of pet: ");
			String name = in.nextLine();
			System.out.print("Enter age of pet: ");
			int age = in.nextInt();
			
			ListPet toDelete = new ListPet(type, name, age); 
			lph.deleteItem(toDelete);


		}

		private static void editAnItem() {
			// TODO Auto-generated method stub
			System.out.println("How would you like to search? ");
			System.out.println("1 : Search by pet type");
			System.out.println("2 : Search by pet name");
			int searchBy = in.nextInt();
			in.nextLine();
			
			List<ListPet> foundItems;
			if (searchBy == 1) {
				System.out.print("Enter the pet type: ");
				String petType = in.nextLine();
				foundItems = lph.searchForPetByType(petType);
				
			} else {
				System.out.print("Enter the pet name: ");
				String petName = in.nextLine();
				foundItems = lph.searchForPetByName(petName);
				

			}

			if (!foundItems.isEmpty()) {
				System.out.println("Found Results.");
				for (ListPet l : foundItems) {
					System.out.println(l.getId() + " : " + l.toString());
				}
				System.out.print("Which ID to edit: ");
				int idToEdit = in.nextInt();

				ListPet toEdit = lph.searchForItemById(idToEdit);
				System.out.println("Retrieved " + toEdit.getName() + " from " + toEdit.getType());
				System.out.println("1 : Update pet type");
				System.out.println("2 : Update pet name");
				int update = in.nextInt();
				in.nextLine();

				if (update == 1) {
					System.out.print("New pet type: ");
					String newType = in.nextLine();
					toEdit.setType(newType);
				} else if (update == 2) {
					System.out.print("New pet name: ");
					String newName = in.nextLine();
					toEdit.setName(newName);
				}

				lph.updatePet(toEdit);

			} else {
				System.out.println("---- No results found");
			}

		}

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			runMenu();

		}

		public static void runMenu() {
			boolean goAgain = true;
		System.out.println("--- Welcome to my pet list! Enter a pet! ---");
			while (goAgain) {
				System.out.println("*  Select an item:");
				System.out.println("*  1 -- Add an item");
				System.out.println("*  2 -- Edit an item");
				System.out.println("*  3 -- Delete an item");
				System.out.println("*  4 -- View the list");
				System.out.println("*  5 -- Exit the pet program");
				System.out.print("*  Your selection: ");
				int selection = in.nextInt();
				in.nextLine();

				if (selection == 1) {
					addAnItem();
				} else if (selection == 2) {
					editAnItem();
				} else if (selection == 3) {
					deleteAnItem();
				} else if (selection == 4) {
					viewTheList();
				} else {
					lph.cleanUp();
					System.out.println("   Goodbye!   ");
					goAgain = false;
				}

			}

		}

		private static void viewTheList() {
			// TODO Auto-generated method stub
			List<ListPet> allItems = lph.showAllItems();
			for(ListPet singleItem : allItems){
				System.out.println(singleItem.returnPetDetails()); }

		}

	}