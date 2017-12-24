import components.map.Map;
import components.map.Map1L;

/**
 * Implementation of {@code EmailAccount}.
 *
 * @author Henrique Painhas
 *
 */
public final class EmailAccount1 implements EmailAccount {

    /*
     * Private members --------------------------------------------------------
     */

    /**
     * Map containing people's last name plus their respective dot number.
     */
    private static Map<String, Integer> lastNameAndNumber = new Map1L<String, Integer>();

    /**
     * Person's first name.
     */
    private String fName;

    /**
     * Person's last name.
     */
    private String lName;

    /**
     * Person's dot number.
     */
    private int number;

    /*
     * Constructor ------------------------------------------------------------
     */

    /**
     * Constructor.
     *
     * @param firstName
     *            the first name
     * @param lastName
     *            the last name
     */
    public EmailAccount1(String firstName, String lastName) {

        this.fName = firstName;
        this.lName = lastName;
        this.number = 1;
        String key = this.lName.toLowerCase();

        if (EmailAccount1.lastNameAndNumber.hasKey(key)) {
            this.number = EmailAccount1.lastNameAndNumber.value(key) + 1;
            EmailAccount1.lastNameAndNumber.replaceValue(key, this.number);
        } else {
            EmailAccount1.lastNameAndNumber.add(key, 1);
        }

    }

    /*
     * Methods ----------------------------------------------------------------
     */

    @Override
    public String name() {
        return this.fName + " " + this.lName;
    }

    @Override
    public String emailAddress() {
        return this.lName.toLowerCase() + "." + this.number + "@osu.edu";
    }

    @Override
    public String toString() {
        return "Name: " + this.name() + ", Email: " + this.emailAddress();
    }

}
