import javax.sql.rowset.Predicate;
import java.security.Key;
import java.util.*;

public class Agenda {
    private Map<String, ContactGroup> agenda = new TreeMap<>();



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

    public void addContact(String firstName, String lastName, String number) {

        Contact c = new Contact(firstName, lastName, number);

        String firstLetter = lastName.substring(0, 1);
        ContactGroup gr = agenda.get(firstLetter);

        if (gr == null) {
            gr = new ContactGroup();
            agenda.put(firstLetter, gr);
        }

        gr.addContact(c);
    }

    public void removeContact(String firstName, String lastName, String number) {
        Contact c = new Contact(firstName, lastName, number);
        for (Map.Entry<String, ContactGroup> entry : agenda.entrySet()) {
            System.out.println("\n" + entry.getKey());
            entry.getValue().getContactGroup().forEach(System.out::println);
//            if ((key.equalsIgnoreCase(lastName.substring(0, 1))
//                    && (c.getFirstName().equalsIgnoreCase(firstName)
//                    && (c.getLastName().equalsIgnoreCase(lastName))))) {
//                agenda.get(key).getContactGroup().remove(c);
        }

    }

    public void editContact(String firstName, String lastName, String number) {

    }

    public void listContacts() {
           for (Map.Entry<String, ContactGroup> entry : agenda.entrySet()) {
            System.out.println("\n" + entry.getKey());
            entry.getValue().getContactGroup().forEach(System.out::println);

        }
    }

    public void searchContact(String firstName, String lastName, String number) {

    }


    }
//
//    public Collection<ContactGroup> addContactGroups() {
//        for (ContactGroup cG : contactGroups) {
//            contactGroups.add(addContactGroup());
//        }
//        return contactGroups;
//    }


}
