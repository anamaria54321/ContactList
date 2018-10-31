import javax.sql.rowset.Predicate;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class ContactGroup {
    private String name;
    public Set<Contact> contactGroup = new TreeSet<Contact>();


    public ContactGroup(String name, Set<Contact> contacts) {
        this.name = name;
        this.contactGroup = contacts;
    }

    public String getName() {
        return name;
    }

    public Set<Contact> getContacts() {
        return contactGroup;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactGroup that = (ContactGroup) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(contactGroup, that.contactGroup);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, contactGroup);
    }
}
