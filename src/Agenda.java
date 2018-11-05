import java.util.*;
import java.util.stream.Collectors;

public class Agenda {
    private Map<String, ContactGroup> agenda = new TreeMap<>();


    public Map<String, ContactGroup> getAgenda() {
        return agenda;
    }


    public void addContact(Contact c) {

        String firstLetter = c.getLastName().substring(0, 1);
        ContactGroup gr = agenda.get(firstLetter);

        if (gr == null) {
            gr = new ContactGroup();
            agenda.put(firstLetter, gr);
        }

        gr.addContact(c);
    }


    public void removeContact(Contact c) {

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


    public Optional<Contact> searchContact(Contact c) {

        String firstLetter = c.getLastName().substring(0, 1);
        ContactGroup gr = agenda.get(firstLetter);

        if (gr != null) {
            return gr.getContacts().stream()
                    .filter(contact -> contact.equals(c))
                    .findFirst();
        }
        return Optional.empty();
    }

    public List<Contact> searchListContact(String name) {
        String firstLetter = name.substring(0, 1);
        ContactGroup gr = agenda.get(firstLetter);

        List<Contact> foundContacts = new ArrayList<>();
        if (gr != null) {
            foundContacts.addAll( gr.getContacts().stream()
                    .filter(contact -> contact.getLastName().equals(name))
                    .collect(Collectors.toList()));
        }

        return foundContacts;
    }
    public void showSearchListContact(){
        if ()
        System.out.println(searchContact());

    }
}



