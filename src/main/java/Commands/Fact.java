package Commands;


import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.io.IOException;

import java.net.URI;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Fact extends ListenerAdapter {

    /**
     * This even listener looks for the !Fact command
     * When the command is parsed sends an http request to the UselessFacts website
     * @param event an update from the discord the bot is connected to
     */
    public void onGuildMessageReceived(GuildMessageReceivedEvent event){
        if(event.getMessage().getContentRaw().equalsIgnoreCase("!fact")) {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .GET()
                    .uri(URI.create("https://uselessfacts.jsph.pl/random.txt?language=en"))
                    .build();
            try {
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
               // String[] out = response.body().split("");
               // System.out.println(out[0]);
               // System.out.println(response.body());
                event.getChannel().sendMessage(response.body()).queue();
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
