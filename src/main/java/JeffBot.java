import Events.OnImage;
import Events.OnAt;
import Events.OnWord;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

import javax.security.auth.login.LoginException;

public class JeffBot {

    public static void main(String args[]) throws  LoginException {

        JDA jda = JDABuilder.createDefault("NzM3MTc4MTg0NDc0NDI3NDIy.Xx5krw.KF1GWn919wUPq60E7-P4Nf19VOs").build();
        jda.addEventListener(new OnImage());
        jda.addEventListener(new OnAt());
        jda.addEventListener(new OnWord());
    }
}
