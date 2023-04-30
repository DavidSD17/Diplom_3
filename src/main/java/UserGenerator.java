
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;

public class UserGenerator {

    public static User generateRandomCredentials(){
        String email = RandomStringUtils.randomAlphabetic(7)+"@davids.crew";
        String password = RandomStringUtils.randomAlphabetic(8);
        String name = RandomStringUtils.randomAlphabetic(9);
        return new User(email,password,name);
    }

    public static User generateCredentialsNotEmail(){
        String email = "";
        String password = RandomStringUtils.randomAlphabetic(8);
        String name = RandomStringUtils.randomAlphabetic(9);
        return new User(email,password,name);
    }
    public static User generateCredentialsNotPassword(){
        String email = RandomStringUtils.randomAlphabetic(7)+"@davids.pass";
        String password = "";
        String name = RandomStringUtils.randomAlphabetic(8);

        return new User(email,password,name);
    }

    public static User generateCredentialsNotName(){
        String email = RandomStringUtils.randomAlphabetic(7)+"@davids.crew";
        String password = RandomStringUtils.randomAlphabetic(8);
        String name = "";
        return new User(email,password,name);
    }

    public static String nameGenerator(){
        String name = RandomStringUtils.randomAlphabetic(7);
        return name;
    }

    public static String emailGenerator(){
        String name = RandomStringUtils.randomAlphabetic(7);
        return name+"@yandex.ru";
    }

    public static String passGenerator(){
        String password = RandomStringUtils.randomAlphabetic(7);
        return password;
    }

    public static String incorrectPassGenerator(){
        String inPassword = RandomStringUtils.randomAlphabetic(5);
        return inPassword;
    }
}
