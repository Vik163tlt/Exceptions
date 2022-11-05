public class Main {
    public static void main(String[] args) {

        System.out.println(checkCredentials("login","password_","password_"));
        System.out.println(checkCredentials("login","password","Password"));
        System.out.println(checkCredentials("","password","password"));
        System.out.println(checkCredentials("login",null,null));
        System.out.println(checkCredentials("login","password/","password/"));
        System.out.println(checkCredentials("login.","password","password"));
    }

    public static boolean checkCredentials(String login,String password,String confirmPassword){
        try {
            return CredentialsValidator.validateCredentials(login, password, confirmPassword);
        } catch (WrongLoginException e) {
            System.out.println("Ошибка проверки логина: " + e.getMessage());
            return false;
        } catch (WrongPasswordException e) {
            System.out.println("Ошибка проверки пароля: " + e.getMessage());
            return false;
        }
    }
}