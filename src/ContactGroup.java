import javax.sql.rowset.Predicate;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class ContactGroup {
    private Set<Contact> contactGroup;


    public ContactGroup() {
        this.contactGroup = new TreeSet<Contact>();;
    }

    public Set<Contact> getContacts() {
        return contactGroup;
    }

    public void addContact(Contact contact) {
        contactGroup.add(contact);
    }

    public Set<Contact> getContactGroup() {
        return contactGroup;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactGroup that = (ContactGroup) o;
        return Objects.equals(contactGroup, that.contactGroup);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contactGroup);
    }
}
