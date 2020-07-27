package Events;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.io.File;

public class OnImage extends ListenerAdapter {

    /**
     * On user message containing an image bot will reply to the message with an image of its own.
     * @param event
     */
    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event){
        if(event.getMessage().getAttachments().size()>0){
            if(!event.getMember().getUser().isBot()){
                // EmbedBuilder embed = new EmbedBuilder();
                File file = new File("src\\main\\resources\\1526499905784.png");
                //embed.setImage("attachment://1526499905784.png").setDescription("Kinda cringe bro");
                // event.getChannel().sendFile(file, "1526499905784.png").embed(embed.build()).queue();
                event.getChannel().sendFile(file,"1526499905784.png").complete();
            }
        }
    }
}
