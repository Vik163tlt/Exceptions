import java.util.Objects;

public class CredentialsValidator {
    private static final String INVALID_LENGTH = "Длинна может быть от 1 до 20";
    private static final String INVALID_SYMBOL = "Поле должно содержать только латинские буквы, цифры и знак нижнего подчеркивания";
    private static final String PASSWORD_NOT_MATCH = "Пароль и подтверждение пароля на совпадают";
    private static boolean isLengthNotINRange(String value, int min, int max) {
        if (value == null) {
            return true;
        }
        int length = value.length();
        return length < min || length > max;
    }
    private static boolean isValid(String value) {
        if (value == null || value.isEmpty() || value.isBlank()) {
            return false;
        }
        return value.matches("^[a-zA-Z0-9_]{1,20}$");
        }
        private static boolean isLengthNotInRange(String value,int min,int max) {
        if (value == null){
            return true;
        }
        int lenght = value.length();
        return lenght < min || lenght > max;
        }
    private static boolean isSymbolsNotValid(String value) {
        if (value == null || value.isEmpty() || value.isBlank()) {
            return true;
        }
        for (char c : value.toCharArray()) {
            boolean symbolMatches = (c >= 'a' && c <= 'z')
                    || (c >= 'A' && c <= 'Z')
                    || (Character.isDigit(c))
                    || (c == '_');
            if (!symbolMatches) {
                return true;
            }
        }
        return false;
    }
    public static boolean validateCredentials(
            String login,
            String password,
            String confirmPassword){
        if (isLengthNotINRange(login,1,20)){
            throw new WrongLoginException(INVALID_LENGTH);
        }
        if (isSymbolsNotValid(login)){
            throw new WrongLoginException(INVALID_SYMBOL);
        }
        if (isLengthNotInRange(password,1,20)) {
            throw new WrongPasswordException(INVALID_LENGTH);
        }
        if (isSymbolsNotValid(password)) {
            throw new WrongPasswordException(INVALID_SYMBOL);
        }
        if (!Objects.equals(password,confirmPassword)) {
            throw new WrongPasswordException(PASSWORD_NOT_MATCH);
        }
        return true;
    }
}
