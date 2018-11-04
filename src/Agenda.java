import javax.sql.rowset.Predicate;
import java.security.Key;
import java.util.*;

public class Agenda {
    private Map<String, ContactGroup> agenda = new TreeMap<>();


    public Map<String, ContactGroup> getAgenda() {
        return agenda;
    }


    public void addContact(Contact c) {

//        Contact c = new Contact(firstName, lastName, number);

        String firstLetter = c.getLastName().substring(0, 1);
        ContactGroup gr = agenda.get(firstLetter);

        if (gr == null) {
            gr = new ContactGroup();
            agenda.put(firstLetter, gr);
        }

        gr.addContact(c);
    }
//    String firstName, String lastName, String number
    public void removeContact(Contact c ) {
//        Contact c = new Contact(firstName, lastName, number);

        String firstLetter = c.getLastName().substring(0, 1);
        ContactGroup gr = agenda.get(firstLetter);

        if (gr != null) {
            gr.getContacts().remove(c);
        }
    }

    public void editContact(Contact c) {


        String firstLetter = c.getLastName().substring(0, 1);
        ContactGroup gr = agenda.get(firstLetter);

//        if (gr != null) {
//            if(gr.getContacts().contains(c)){
//                c.setFirstName();
//            };
//        }
    }

    public void listContacts() {
        for (Map.Entry<String, ContactGroup> entry : agenda.entrySet()) {
            System.out.println("\n" + entry.getKey());
            entry.getValue().getContactGroup().forEach(System.out::println);

        }
    }

//    String firstName, String lastName, String number
    public void searchContact(Contact c ) {
//        Contact c = new Contact(firstName, lastName, number);

        String firstLetter = c.getLastName().substring(0, 1);
        ContactGroup gr = agenda.get(firstLetter);

        if (gr != null) {
            gr.getContacts().stream()
                    .filter(Contact -> (c.getLastName().equals(Contact.getLastName())
                            && (c.getFirstName().equals(Contact.getFirstName()))))
                    .forEach(System.out::println);

        }
    }

}



