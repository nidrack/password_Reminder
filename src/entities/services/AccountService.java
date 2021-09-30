package entities.services;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AccountService {
	

	private static final String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
	private static Pattern pattern = Pattern.compile(regex);
	
	public static boolean loginValidation(String login) {
		Matcher matcher = pattern.matcher(login);
		return matcher.matches();
	}
}
