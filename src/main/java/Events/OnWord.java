package Events;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.io.*;

public class OnWord extends ListenerAdapter {
    /**
     * Looks for keywords in sentences and responds appropriately.
     * Works as a chat filter
     * @param event
     */
    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event){
        try {
            BufferedReader read = new BufferedReader(new FileReader("src/main/java/profanity.txt"));
            String[] words = read.readLine().split(",");
            for(int i = 0; i< words.length; i++){
                String[] message = event.getMessage().getContentRaw().split(" ");
                for(int j = 0; j < message.length; j++){
                    if(words[i].equalsIgnoreCase(message[j])){
                        event.getMessage().delete().queue();
                        event.getChannel().sendMessage("Please don't use inappropriate language thanks").queue();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
