import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class ContactGroup {
    private Set<Contact> contacts;

    public ContactGroup() {
        this.contacts = new TreeSet<Contact>();
    }

    public Set<Contact> getContacts() {
        return contacts;
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactGroup that = (ContactGroup) o;
        return Objects.equals(contacts, that.contacts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contacts);
    }
}
