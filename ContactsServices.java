package contactsChallange;

import java.util.ArrayList;
import java.util.Scanner;

public class ContactsServices {

    private static Scanner sc = new Scanner(System.in);
    private static ArrayList<Contacts> contactsList = new ArrayList();

    //adding an emergency contact by default
    static {
        contactsList.add(new Contacts("emergency", 100));
    }

    public static boolean containsContact(String name){
        for (Contacts contact: contactsList){
            if (contact.getName().equals(name)){
                return true;
            }
        }
        return  false;
    }

    public static int getContactByName(String name){
        int indexOfcontact=-1;
        for (int i=0; i<contactsList.size();i++){
            if (containsContact(name)){
                indexOfcontact = i;
            }
        }
        return  indexOfcontact;
    }

    public static void addContact(String name, long number){ //there is a bug in this function
        if (containsContact(name)==false){ //every input is satifying the condition
            contactsList.add(new Contacts(name, number));
            System.out.println(name+"'s contact added");
        } else {
            contactsList.get(getContactByName(name)).setMobileNumber(number);
            System.out.println("mobile number of "+contactsList.get(getContactByName(name)).getName()+" is edited");
        }
    }

    public static void deleteContact(String name){
        if (containsContact(name)){
            contactsList.remove(getContactByName(name));
            System.out.println(name+"'s contact is deleted");
        } else {
            System.out.println("contact doesn't exist!");
        }
    }

    public static void printContactsList() {
        if (contactsList.isEmpty()){
            System.out.println("Contacts List is empty. Select option 2 to add.");
        } else {
            for (Contacts contact: contactsList){
                System.out.println(contact);
            }
        }
    }
}
