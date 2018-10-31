import javax.sql.rowset.Predicate;
import java.util.*;

public class Agenda {
    private Map<String, ContactGroup> agenda = new TreeMap<>();

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

    private void addContact(String firstName, String lastName, String number) {

        Contact c = new Contact(firstName, lastName, number);
        for (String key : agenda.keySet()) {
            if (key.equalsIgnoreCase(lastName.substring(0, 1))) {
                agenda.get(key).getContactGroup().add(c);
                return;
            }
        }
        agenda.put(lastName.substring(0, 1).toUpperCase(), new ContactGroup());
        agenda.get(lastName.substring(0, 1).toUpperCase()).getContactGroup().add(c);

    }

//    public void showContactGroup() {
//        for (Contact c : addContactGroup()) {
//            System.out.println(c);
//        }
//    }
//
//    public Collection<Contact> deleteContact() {
//        System.out.println("Enter the first name:");
//        String firstName = sc.nextLine();
//        System.out.println("Enter the last name:");
//        String lastName = sc.nextLine();
//        for (Contact c : contactGroup) {
//            if (c.getFirstName().equals(firstName) && c.getLastName().equals(lastName))
//                contactGroup.remove(c);
//        }
//        return contactGroup;
//    }
//
//    public Collection<ContactGroup> addContactGroups() {
//        for (ContactGroup cG : contactGroups) {
//            contactGroups.add(addContactGroup());
//        }
//        return contactGroups;
//    }


}
