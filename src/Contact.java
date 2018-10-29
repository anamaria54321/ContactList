import java.util.Objects;

public class Contact {
   private String firstName;
   private String lastName;
   private Prefix prefix;
   private String number;

    public Contact(String firstName, String lastName, Prefix prefix, String number) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.prefix = prefix;
        this.number = number;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Prefix getPrefix() {
        return prefix;
    }

    public void setPrefix(Prefix prefix) {
        this.prefix = prefix;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(firstName, contact.firstName) &&
                Objects.equals(lastName, contact.lastName) &&
                prefix == contact.prefix &&
                Objects.equals(number, contact.number);
    }

    @Override
    public int hashCode() {

        return Objects.hash(firstName, lastName, prefix, number);
    }
}
