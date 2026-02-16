package interfaces.staticmethodsininterfaces.passwordchecker;

public interface SecurityUtils {
	static void isPasswordStrong(String password) {
		String pattern = "^(?=.*[a-zA-Z])(?=.*\\d)[A-Za-z\\d!@#$%^&*_-]{8,}$";
		if(password.matches(pattern)) {
			System.out.println("Strong Password");
		}
		else {
			System.out.println("Weak Password");
		}
	}
}
