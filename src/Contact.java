import java.util.Objects;

public class Contact implements Comparable<Contact> {
    private String firstName;
    private String lastName;
    //   private Prefix prefix;
    private String number;

    public Contact() {

    }

    public Contact(String firstName, String lastName, String number) {
        this.firstName = firstName;
        this.lastName = lastName;
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
                Objects.equals(number, contact.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, number);
    }

    @Override
    public String toString() {
        return lastName + "  " + firstName + "  " + number;
    }

    @Override
    public int compareTo(Contact o) {
        if (firstName.compareToIgnoreCase(o.firstName) != 0) {
            return firstName.compareToIgnoreCase(o.firstName);
        }
        if (lastName.compareToIgnoreCase(o.lastName) != 0) {
            return lastName.compareToIgnoreCase(o.lastName);
        }
        if (number.compareToIgnoreCase(o.number) != 0) {
            return number.compareToIgnoreCase(o.number);
        }
        return 0;
    }

}
