import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class AgendaTester {
    public static final String originalFile = "ListContact.txt";

    public static void main(String[] args) {

        Agenda agenda = new Agenda();
        BackupManager backupManager = new BackupManager();
        agenda.readFile();
        showMenu(backupManager, agenda);
    }

    public static void showMenu(BackupManager backupManager, Agenda agenda) {

        System.out.println(" -----------------------------------------------");
        System.out.println("|          Welcome to the Ana Agenda   |");
        System.out.println(" -----------------------------------------------");
        System.out.println();
        System.out.println("                    MAIN MENU                   ");
        System.out.println("1. Add contact");
        System.out.println("2. List all contacts");
        System.out.println("3. Remove contact");
        System.out.println("4. Edit contact");
        System.out.println("5. Search contact");
        System.out.println("6. Backups");
        System.out.println("7. Exit");
        showOptionsMenu(backupManager, agenda);
    }

    public static void showOptionsMenu(BackupManager backupManager, Agenda agenda) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Select an action from below:");
            int number = sc.nextInt();
            switch (number) {
                case 1:
                    agenda.writeFile(createContact());
//                    agenda.addContact(createContact());
                    showMenu(backupManager, agenda);
                    break;
                case 2:
                    agenda.listContacts();
                    showMenu(backupManager, agenda);
                    break;
                case 3:
                    agenda.removeContact(createContact());
                    showMenu(backupManager, agenda);
                    break;
                case 4:
                    agenda.editContact(createContact(),createContact());
                    break;
                case 5:
                    agenda.searchContact(createContact());
                    agenda.searchListContact(createName());
                    showMenu(backupManager, agenda);
                    break;
                case 6:
                    showBackups(backupManager, agenda);
                    break;
                case 7:
                    System.exit(0);
                    break;
            }
        } catch (Exception InputMismatchException) {
            System.out.println("Enter a number from 1 to 6");
            showMenu(backupManager, agenda);
        }
    }

    public static Contact createContact() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first name");
        String firstName = sc.nextLine();
        System.out.println("Enter last name");
        String lastName = sc.nextLine();
        System.out.println("Enter the number");
        String number = sc.nextLine();
        Contact c = new Contact(firstName, lastName, number);
        return c;
    }

    public static String createName() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name");
        String name = sc.nextLine();
        return name;
    }

    public static void showBackups(BackupManager backupManager, Agenda agenda) throws IOException {

        System.out.println(" -----------------------------------------------");
        System.out.println("|                   Backups                    |");
        System.out.println(" -----------------------------------------------");
        System.out.println();
        System.out.println("                    MAIN MENU                   ");
        System.out.println("1. Create");
        System.out.println("2. View");
        System.out.println("3. Load");
        System.out.println("4. Remove");
        System.out.println("5. Back to previous menu");
        showOptionsMenuBackups(backupManager, agenda);
    }

    public static void showOptionsMenuBackups(BackupManager backupManager, Agenda agenda) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Select an action from below:");
        int number = sc.nextInt();
        switch (number) {
            case 1:
                backupManager.createBackup(new File(originalFile));
                showBackups(backupManager, agenda);
                break;
            case 2:
                backupManager.viewBackup();
                showBackups(backupManager, agenda);
                break;
            case 3:
                backupManager.loadBackup();
                showBackups(backupManager, agenda);
                break;
            case 4:
                backupManager.removeBackup();
                showBackups(backupManager, agenda);
                break;
            case 5:
                showMenu(backupManager, agenda);
                break;

        }
    }
}
