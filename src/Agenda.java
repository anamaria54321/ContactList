import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Agenda {
    private static final String FIRST_NAME = "FIRST_NAME";
    private static final String LAST_NAME = "LAST_NAME";
    private static final String PHONE_NUMBER = "PHONE_NUMBER";
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

            foundContacts.addAll(gr.getContacts().stream()
                    .filter(contact -> contact.getLastName().contains(name))
                    .collect(Collectors.toList()));
        }

        return foundContacts;
    }

    public void showSearchListContact(Contact c, String name) {
        String firstLetter = c.getLastName().substring(0, 1);
        ContactGroup gr = agenda.get(firstLetter);
//        try {
        if (gr.getContactGroup().contains(c)) {
            System.out.println(searchContact(c));
        } else if (gr.getContactGroup().contains(name)) {
            System.out.println(searchListContact(name));

            System.out.println("");

        }

    }

    public void readFile() {

        try(BufferedReader reader = new BufferedReader(new FileReader("ListContact.txt"))) {

            List<String> lines = new ArrayList<>();
            String line;
            String[] splitedLine;
            Map<String, Integer> agendaPhone = new TreeMap<>();
            while ((line = reader.readLine()) != null) {
                lines.add(line);
                splitedLine = line.split(",");


                if (line.contains(FIRST_NAME) && line.contains(LAST_NAME) && line.contains(PHONE_NUMBER)) {
                    for (int i = 0; i < splitedLine.length; i++) {
                        switch (splitedLine[i]) {
                            case FIRST_NAME:
                                agendaPhone.put(FIRST_NAME, i);
                                break;
                            case LAST_NAME:
                                agendaPhone.put(LAST_NAME, i);
                                break;
                            case PHONE_NUMBER:
                                agendaPhone.put(PHONE_NUMBER, i);
                                break;
                        }
                    }
                } else {
                    Contact c = new Contact(splitedLine[agendaPhone.get(FIRST_NAME)],
                            splitedLine[agendaPhone.get(LAST_NAME)],
                            splitedLine[agendaPhone.get(PHONE_NUMBER)]);
                    addContact(c);
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("The file was not found\n" + e);
        } catch (IOException ex) {
            System.out.println("Failed to read content from file " + "ListContact.txt" + "\n" + ex);
        }
        listContacts();
    }

    public void writeFile(Contact c) {
        addContact(c);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("ListContact.txt",true))) {
            String[] stringArr ={c.getFirstName(),",",c.getLastName(),",",c.getNumber()};
            String line="";
            writer.newLine();
            for (int i=0;i<stringArr.length;i++){
            line=stringArr[i];
            writer.append(line);
            }
        } catch (IOException ex) {
            System.out.println("Failed to write content to file " + "ListContact.txt" + "\n" + ex);

        }
    }
}



