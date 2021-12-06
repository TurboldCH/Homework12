/*
 * This program uses Serialization to create Presenter objects
 * and store and retrieve them from a binary file
 *    Assignment:	11
 * 	Name:		Turbold Chuluunbaatar
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Serialization {
	
	static ArrayList<Presenter> prList = new ArrayList<>();
	public static void main(String[] args) throws FileNotFoundException, IOException {

		Scanner input = new Scanner(System.in);
		System.out.println("1. Add information into a file");
		System.out.println("2. Retrieve information from a file and display them");
		System.out.println("3. Delete information");
		System.out.println("4. Update information");
		System.out.println("5. Exit");
		System.out.print("Choose your option: ");

		while (true) {
			int option = input.nextInt();
			if (option == 1) {
				System.out.print("Enter name: "); String name = input.next();
				System.out.print("Enter phone number: " ); String phone = input.next();
				System.out.print("Enter DOB: "); String dob = input.next();
				System.out.print("Enter email: " ); String email = input.next();
				Presenter pr = new Presenter(name, phone, dob, email);
				try {
					writeToFile(pr);
				}
				catch (IOException e){
					e.printStackTrace();
				}
			}
			else if (option == 2) {
				try {
					readFile();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			else if (option == 3) {
				System.out.print("Order of the deleting item: ");
				int index = input.nextInt();
				prList.remove(index);
				writeArrayList(prList);
				System.out.println("Deletion successful...");
			}
			else if (option == 4) {
				System.out.print("Order of the updating item: ");
				int index = input.nextInt();
				System.out.print("Enter new name: "); String name = input.next();
				System.out.print("Enter new phone number: " ); String phone = input.next();
				System.out.print("Enter new DOB: "); String dob = input.next();
				System.out.print("Enter new email: " ); String email = input.next();
				prList.get(index).setName(name);
				prList.get(index).setPhoneN(phone);
				prList.get(index).setDOB(dob);
				prList.get(index).setEmail(email);
				writeArrayList(prList);
				System.out.println("Update successful...");
			}
			else {
				break;
			}
			System.out.println("1. Add information into a file");
			System.out.println("2. Retrieve information from a file and display them");
			System.out.println("3. Delete information");
			System.out.println("4. Update information");
			System.out.println("5. Exit");
			System.out.print("Choose your option: ");
		}
	}
	//Adds an ArrayList to the file
	public static void writeArrayList(ArrayList<Presenter> p) throws IOException{
		ObjectOutputStream outputStream = new ObjectOutputStream(
				new FileOutputStream("Presenter.bin"));

		outputStream.writeObject(p);
		outputStream.close();
	}
	//Adds objects one at a time
	public static void writeToFile(Presenter pr) throws IOException{
		ObjectOutputStream outputStream = new ObjectOutputStream(
				new FileOutputStream("Presenter.bin"));

		prList.add(pr);
		outputStream.writeObject(prList);
		outputStream.close();
	}
	//Retrieves all objects from the file
	public static void readFile() throws IOException, ClassNotFoundException{
		ObjectInputStream inputStream = new ObjectInputStream(
				new FileInputStream("Presenter.bin"));
		prList.clear();
		prList = (ArrayList<Presenter>)inputStream.readObject();
		
		for(Presenter pr: prList) {
			System.out.println(pr);
		}
		inputStream.close();
	}

}

