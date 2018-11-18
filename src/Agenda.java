import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Agenda {

    private static final String FIRST_NAME = "FIRST_NAME";
    private static final String LAST_NAME = "LAST_NAME";
    private static final String PHONE_NUMBER = "PHONE_NUMBER";
    private Map<String, ContactGroup> contactGroups = new TreeMap<>();



    public Map<String, ContactGroup> getContactGroups() {
        return contactGroups;
    }

    public static String getFirstName() {
        return FIRST_NAME;
    }

    public static String getLastName() {
        return LAST_NAME;
    }

    public static String getPhoneNumber() {
        return PHONE_NUMBER;
    }

    public void addContact(Contact c) {

        String firstLetter = c.getLastName().substring(0, 1);
        ContactGroup gr = contactGroups.get(firstLetter);

        if (gr == null) {
            gr = new ContactGroup();
            contactGroups.put(firstLetter, gr);
        }

        gr.addContact(c);
    }


    public void removeContact(Contact c) {

        String firstLetter = c.getLastName().substring(0, 1);
        ContactGroup gr = contactGroups.get(firstLetter);

        if (gr != null) {
            gr.getContacts().remove(c);
        }

        writeAgendaToFile();
    }

    public void editContact(Contact c) {
        Scanner sc = new Scanner(System.in);
        String firstLetter = c.getLastName().substring(0, 1);
        ContactGroup gr = contactGroups.get(firstLetter);


        if (gr != null) {

            for (Contact contact : gr.getContacts()) {
                if (contact.equals(c)) {
                    System.out.println("edit last name: ");
                    contact.setLastName(sc.nextLine());
                    System.out.println("edit first name: ");
                    contact.setFirstName(sc.nextLine());
                    System.out.println("edit number: ");
                    contact.setNumber(sc.nextLine());
                    break;
                }
            }
        }
    }

    public void listContacts() {
        for (Map.Entry<String, ContactGroup> entry : contactGroups.entrySet()) {
            System.out.println("\n" + entry.getKey());
            entry.getValue().getContacts().forEach(System.out::println);

        }
    }


    public Optional<Contact> searchContact(Contact c) {

        String firstLetter = c.getLastName().substring(0, 1);
        ContactGroup gr = contactGroups.get(firstLetter);

        if (gr != null) {
            return gr.getContacts().stream()
                    .filter(contact -> contact.equals(c))
                    .findFirst();
        }
        return Optional.empty();
    }

    public List<Contact> searchListContact(String name) {
        String firstLetter = name.substring(0, 1);
        ContactGroup gr = contactGroups.get(firstLetter);

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
        ContactGroup gr = contactGroups.get(firstLetter);
//        try {
        if (gr.getContacts().contains(c)) {
            System.out.println(searchContact(c));
        } else if (gr.getContacts().contains(name)) {
            System.out.println(searchListContact(name));

            System.out.println("");

        }

    }

    public void readFile() {

        try (BufferedReader reader = new BufferedReader(new FileReader("ListContact.txt"))) {

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


    }

    public void writeFile(Contact c) {
        addContact(c);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("ListContact.txt", true))) {
            String[] stringArr = {c.getFirstName(), ",", c.getLastName(), ",", c.getNumber()};
            String line = "";

            for (int i = 0; i < stringArr.length; i++) {
                line = stringArr[i];
                writer.append(line);
            }

        } catch (IOException ex) {
            System.out.println("Failed to write content to file " + "ListContact.txt" + "\n" + ex);

        }

    }

//    public void deleteContactFile(Contact c) {
//        for (Map.Entry<String, ContactGroup> entry : contactGroups.entrySet()) {
//            entry.getValue().getContacts().stream().collect(Collectors.toList());
//        }
//
//        try (BufferedWriter bW = new BufferedWriter(new FileWriter("ListContact.txt"))) {
//            List<String> lines = new ArrayList<>();
//            String lineIg = c.getFirstName() + "," + c.getLastName() + "," + c.getNumber();
//            for (String line : lines) {
//                if (!lines.contains(lineIg)) {
//                    bW.write(line);
//                }
//            }
//        } catch (IOException ex) {
//            System.out.println("Failed to write content to file " + "ListContact.txt" + "\n" + ex);
//
//        }
//    }

    public void writeAgendaToFile() {
//        List<Contact> contacts = contactGroups.values().stream()
//                .map(gr -> gr.getContacts())
//                .flatMap(Collection::stream)
//                .collect(Collectors.toList());

        List<Contact> contacts = new ArrayList<>();
        for (ContactGroup group : contactGroups.values()) {
            contacts.addAll(group.getContacts());
        }

        try (BufferedWriter bW = new BufferedWriter(new FileWriter("ListContact.txt"))) {
            bW.write("FIRST_NAME,LAST_NAME,PHONE_NUMBER");
            bW.newLine();
            // first line is file header
            // next lines are contacts from contact groups
            for (Contact contact : contacts) {
                bW.write(contact.getFirstName() + "," + contact.getLastName() + "," + contact.getNumber());
                bW.newLine();
            }
        } catch (IOException ex) {
            System.out.println("Failed to write content to file " + "ListContact.txt" + "\n" + ex);
        }
    }

}




