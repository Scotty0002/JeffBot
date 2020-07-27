package Events;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.io.File;

public class OnAt extends ListenerAdapter {

    /**
     * On user message @ing the bot, it will reply to the message with an image of its own.
     * @param event
     */
    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event){
//        System.out.println(event.getMessage().getContentRaw());
        if(event.getMessage().getContentRaw().equalsIgnoreCase("<@!737178184474427422>")){
            File file = new File("src\\main\\resources\\62NYl0C.png");
            event.getChannel().sendFile(file,"62NYl0C.png").complete();
        }
    }

}
