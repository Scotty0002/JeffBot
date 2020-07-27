package Events;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.io.File;

public class OnWord extends ListenerAdapter {
    /**
     * Looks for keywords in sentences and responds appropriately
     * @param event
     */
    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event){
        if(event.getMember().getUser().isBot()){return;}
        String[] msg = event.getMessage().getContentRaw().split(" ");
        for(int i = 0; i<msg.length; i++){
            if (msg[i].equalsIgnoreCase("cheese")) {
                event.getChannel().sendMessage("I really like cheese " + event.getMessage().getAuthor().getAsMention()).queue();
                return;
            }
        }
    }

}
