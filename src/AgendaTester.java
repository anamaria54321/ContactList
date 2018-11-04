import java.util.Scanner;

public class AgendaTester {

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        Contact c1 = new Contact("Ionescu", "Ana", Prefix.RO, "0745123256");
//        Contact c2 = new Contact("Dinescu", "Ana", Prefix.RO, "0744447895");
//        Contact c3 = new Contact("Gheorghe", "Gheorghe", Prefix.RO, "0756891235");
//        Contact c4 = new Contact("Bibescu", "Bibi", Prefix.IT, "0765877179");
//        Contact c5 = new Contact("Cicescu", "Cici", Prefix.IT, "0723568912");
//        Contact c6 = new Contact("Vivescu", "Vivi", Prefix.GR, "0723589547");
//        Contact c7 = new Contact("Didescu", "Didi", Prefix.DE, "0756982356");
        Agenda agenda = new Agenda();


        agenda.addContact(createContact());
        agenda.addContact(createContact());
        agenda.addContact(createContact());
//        agenda.addContact("Ionescu", "Ana",  "0745123256");
//        agenda.addContact("Ionescu", "Ana",  "0745123256");
//        agenda.addContact("Dinescu", "Ana", "0744447895");
//        agenda.addContact("Ionescu", "Vivi", "0723589547");

        agenda.listContacts();
//        agenda.editContact("Ionescu", "Ana","0745123256");
        agenda.removeContact(createContact());
        agenda.listContacts();

        agenda.searchContact(createContact());


//
//        showMenu();
//        optionMenu();
    }

//    public static void showMenu() {
//
//        System.out.println(" -----------------------------------------------");
//        System.out.println("|          Welcome to the Ana Agenda   |");
//        System.out.println(" -----------------------------------------------");
//        System.out.println();
//        System.out.println("                    MAIN MENU                   ");
//        System.out.println("1. Add contact");
//        System.out.println("2. List all contacts");
//        System.out.println("3. Remove contact");
//        System.out.println("4. Edit contact");
//        System.out.println("5. Search contact");
//        System.out.println("6. Exit");
//        optionMenu();
//    }
//
//    public static void optionMenu() {
//        Agenda agenda = new Agenda();
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Select an action from below:");
//        int number = sc.nextInt();
//        switch (number) {
//            case 1:
//                agenda.addContact(createContact());
//                showMenu();
//                break;
//            case 2:
//                agenda.listContacts();
//                showMenu();
//                break;
//            case 3:
//                agenda.removeContact(createContact());
//                showMenu();
//                break;
//            case 4:
//                agenda.editContact(createContact());
//                break;
//            case 5:
//                agenda.searchContact(createContact());
//                showMenu();
//                break;
//            case 6:
//                System.exit(0);
//                break;
//        }
//    }

    public static Contact createContact() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first name");
        String firstName = sc.nextLine();
        System.out.println("Enter last name");
        String lastName = sc.nextLine();
//        System.out.println("Enter prefix(Ex. RO, GR, etc)");
        System.out.println("Enter the number");
        String number = sc.nextLine();
        Contact c = new Contact(firstName, lastName, number);
//        System.out.println(c);
        return c;
    }


}
