package studentmanagementsystem;
import org.mindrot.jbcrypt.BCrypt;

public class SecurePassword {

    public static String hashPassword(String password) {
        // Generate a secure, random salt
        String salt = BCrypt.gensalt();

        // Hash the password with the salt
        String hashedPassword = BCrypt.hashpw(password, salt);

        return hashedPassword;
    }

    public static boolean verifyPassword(String rawPassword, String hashedPassword) {
        return BCrypt.checkpw(rawPassword, hashedPassword);
    }
}
