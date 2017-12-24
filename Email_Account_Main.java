import components.queue.Queue;
import components.queue.Queue1L;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Simple program to exercise EmailAccount functionality.
 */
public final class EmailAccountMain {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private EmailAccountMain() {
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();

        Queue<String> accounts = new Queue1L<String>();

        out.print("Enter your full name: ");
        String fullName = in.nextLine();

        while (!fullName.equals("")) {
            int space = fullName.indexOf(" ");
            String firstName = fullName.substring(0, space);
            String lastName = fullName.substring(space + 1, fullName.length());
            EmailAccount myAccount = new EmailAccount1(firstName, lastName);
            /*
             * Should print: FirstName LastName
             */
            out.println(myAccount.name());
            /*
             * Should print: LastNameToLowerCase.#@osu.edu
             */
            out.println(myAccount.emailAddress());
            /*
             * Should print: Name: FirstName LastName, Email:
             * LastNameToLowerCase.#@osu.edu
             */
            accounts.enqueue(myAccount.toString());

            for (int i = 0; i < accounts.length(); i++) {
                String email = accounts.dequeue();
                out.println(email);
                accounts.enqueue(email);
            }
            out.println();
            out.print("Enter your full name: ");
            fullName = in.nextLine();
        }
        in.close();
        out.close();
    }
}
