package banking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Account implementation for commercial (business) customers.<br><br>
 *
 * Private Variables:<br>
 * {@link #authorizedUsers}: List&lt;Person&gt;<br>
 */
public class CommercialAccount extends Account {
	private Set<Person> authorizedUsers;

	public CommercialAccount(Company company, Long accountNumber, int pin, double startingDeposit) {
		super(company, accountNumber, pin, startingDeposit);
		authorizedUsers = new HashSet<>();
	}

	/**
	 * @param person The authorized user to add to the account.
	 */
	protected void addAuthorizedUser(Person person) {
		authorizedUsers.add(person);
	}

	/**
	 * @param person
	 * @return true if person matches an authorized user in {@link #authorizedUsers}; otherwise, false.
	 */
	public boolean isAuthorizedUser(Person person) {
        return authorizedUsers.contains(person);
	}
}
