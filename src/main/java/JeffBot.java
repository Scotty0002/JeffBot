import Events.OnImage;
import Events.OnAt;
import Events.OnWord;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

import javax.security.auth.login.LoginException;
import java.io.*;

public class JeffBot {

    /**
     * BOT
     * @param args
     * @throws LoginException
     */
    public static void main(String args[]) throws  LoginException {
        try {
            BufferedReader read = new BufferedReader(new FileReader("src/main/java/config.txt"));
            String token =read.readLine();
            JDA jda = JDABuilder.createDefault(token).build();
            jda.addEventListener(new OnImage());
            jda.addEventListener(new OnAt());
            jda.addEventListener(new OnWord());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
