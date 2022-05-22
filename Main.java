package contactsChallange;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main  extends ContactsServices{

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean quit = false;
        while (!quit){
            switch (readQuery()){
                case 1:
                    printContactsList();
                    break;
                case 2 :
                case 3 :
                    addOrEditContact();
                    break;
                case 4:
                    System.out.println("Enter the contact name:");
                    String nameDelete = sc.next();
                    if (containsContact(nameDelete)){
                        deleteContact(nameDelete);
                    } else {
                        System.out.println("Contact doesn't Exits!");
                    }
                    break;
                case 5:
                    quit = true;
                    System.out.println("Thank you for using!");
                    break;

                default:
                    System.out.println("Incorrect Input! Try again!!");
                    quit=true;
                    break;
            }
        }
    }

    private static void addOrEditContact(){
        System.out.println("Enter the name of a contact:");
        String name = sc.next();
        System.out.println("Enter mobile number: ");
        long number = sc.nextLong();
        addContact(name, number);
    }

    private static int readQuery(){
        int query = 0;
        System.out.println("Select your query: ");
        System.out.println("\t 1. View Contacts.");
        System.out.println("\t 2. Add Contact.");
        System.out.println("\t 3. Edit a Contact.");
        System.out.println("\t 4. Delete a Contact.");
        System.out.println("\t 5. Quit");
        try{
            query = sc.nextInt();
        } catch (InputMismatchException e){
            System.out.println("Entered value is not a number");
        }
        return query;
    }
}
