import javax.sql.rowset.Predicate;
import java.util.*;

public class Agenda {
    private Map<String, ContactGroup> agenda = new TreeMap<>();
    private Set<ContactGroup> contactGroups = new TreeSet<ContactGroup>();
    private List<Contact> contactGroup = new ArrayList<>();
    private Contact c= new Contact();
    Scanner sc = new Scanner(System.in);

    public Map<String, ContactGroup> getAgenda() {
        return agenda;
    }

//    public Contact addContact() {
//        System.out.println("Enter first name");
//        String firstName = sc.nextLine();
//        System.out.println("Enter last name");
//        String lastName = sc.nextLine();
////        System.out.println("Enter prefix(Ex. RO, GR, etc)");
//        System.out.println("Enter the number");
//        String number = sc.nextLine();
//        Contact c = new Contact(firstName, lastName, number);
////        System.out.println(c);
//        return c;
//    }

    public List<Contact> addContactGroup() {
        System.out.println("Enter first name");
        String firstName = sc.nextLine();
        System.out.println("Enter last name");
        String lastName = sc.nextLine();
        System.out.println("Enter the number");
        String number = sc.nextLine();
        Contact c = new Contact(firstName, lastName, number);
//        for (Contact c : contactGroup) {
            if ((c.getFirstName().compareTo(firstName) == -1
                    || c.getFirstName().compareTo(firstName) == 0) && (c.getLastName().compareTo(lastName) == -1
                    || c.getLastName().compareTo(lastName) == 0) && (c.getNumber().compareTo(number) == -1)
                    || c.getNumber().compareTo(number) == 0) {
                contactGroup.add(c);
            }
//            System.out.println(c);
//        }

        return contactGroup;
    }

    public void showContactGroup() {
        for (Contact c : addContactGroup()) {
            System.out.println(c);
        }
    }

    public List<Contact> deleteContact() {
        System.out.println("Enter the first name:");
        String firstName = sc.nextLine();
        System.out.println("Enter the last name:");
        String lastName = sc.nextLine();
        for (Contact c : contactGroup) {
            if (c.getFirstName().equals(firstName) && c.getLastName().equals(lastName))
                contactGroup.remove(c);
        }
        return contactGroup;
    }

//    public Set<ContactGroup> addContactGroups() {
//        for(ContactGroup cG:contactGroups){
//            contactGroups.add(addContactGroup());
//        }
//        return contactGroups;
//    }


}
