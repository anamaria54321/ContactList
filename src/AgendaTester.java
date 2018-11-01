import java.util.Scanner;

public class AgendaTester {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        Contact c1 = new Contact("Ionescu", "Ana", Prefix.RO, "0745123256");
//        Contact c2 = new Contact("Dinescu", "Ana", Prefix.RO, "0744447895");
//        Contact c3 = new Contact("Gheorghe", "Gheorghe", Prefix.RO, "0756891235");
//        Contact c4 = new Contact("Bibescu", "Bibi", Prefix.IT, "0765877179");
//        Contact c5 = new Contact("Cicescu", "Cici", Prefix.IT, "0723568912");
//        Contact c6 = new Contact("Vivescu", "Vivi", Prefix.GR, "0723589547");
//        Contact c7 = new Contact("Didescu", "Didi", Prefix.DE, "0756982356");
        Agenda agenda = new Agenda();

        agenda.listContacts();
        agenda.addContact("Ionescu", "Ana","0745123256");
        agenda.editContact("Ionescu", "Ana","0745123256");
        agenda.removeContact("Ionescu", "Ana","0745123256");
        agenda.searchContact("Ionescu", "Ana","0745123256");



//

    }
    public static void showMenu() {

        System.out.println(" -----------------------------------------------");
        System.out.println("|          Welcome to the Ana Agenda   |");
        System.out.println(" -----------------------------------------------");
        System.out.println();
        System.out.println("                    MAIN MENU                   ");
        System.out.println("1. List all contacts");
        System.out.println("2. Add contact");
        System.out.println("3. Remove contact");
        System.out.println("4. Edit contact");
        System.out.println("5. Search contact");
        System.out.println("6. Exit");
    }
    public static void optionMenu(Scanner sc) {
        Agenda agenda = new Agenda();

            System.out.println("Select an action from below:");
            int number = sc.nextInt();
            switch (number) {
                case 1:
                    agenda.listContacts();
                    break;
                case 2:
                    agenda.addContact();
                    break;
                case 3:
                    agenda.removeContact();
                    break;
                case 4:
                    agenda.editContact();
                    break;
                case 5:
                    agenda.searchContact();
                    break;
                case 6:
                    System.exit(0);
                    break;
            }
}}
