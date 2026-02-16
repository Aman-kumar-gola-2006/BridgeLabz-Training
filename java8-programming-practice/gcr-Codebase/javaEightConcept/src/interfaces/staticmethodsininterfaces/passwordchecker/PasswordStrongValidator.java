package interfaces.staticmethodsininterfaces.passwordchecker;

public class PasswordStrongValidator {
	public static void main(String[] args) {
		String password = "236578DFGHJ";
		
		SecurityUtils.isPasswordStrong(password);
	}
}
