
package services;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import repositories.ShoutRepository;
import security.LoginService;
import security.UserAccount;
import domain.Shout;

@Service
@Transactional
public class ShoutService {

	@Autowired
	private ShoutRepository	shoutRepository;


	public Collection<Shout> findAll() {

		Collection<Shout> result;
		result = this.shoutRepository.findAll();

		return result;
	}

	public Shout create() {
		Shout result;
		UserAccount userAccount;
		String username;

		userAccount = LoginService.getPrincipal();
		username = userAccount.getUsername();

		result = new Shout();
		result.setUsername(username);
		result.setLink("");
		result.setText("");

		return result;

	}

	public void save(final Shout shout) {
		this.shoutRepository.save(shout);
	}

}
