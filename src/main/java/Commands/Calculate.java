package Commands;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Calculate extends ListenerAdapter {

    public void onGuildMessageReceived(GuildMessageReceivedEvent event){
        if(event.getMessage().getAuthor().isBot()){return;}
        String[] args = event.getMessage().getContentRaw().split(" ");

        if(args[0].equalsIgnoreCase("!calculate") && args.length == 1){
            event.getChannel().sendMessage("This is the calculate command, you can use this command by typing !calculate (add,sub,multi or div) x   y").queue();
        }

        if(args[0].equalsIgnoreCase("!calculate") && args.length == 4){
            String op = args[1];
            Double x = Double.parseDouble(args[2]);
            Double y = Double.parseDouble(args[3]);
            Double Z;
            switch(op){
                case "add":
                    Z = x+y;
                    event.getChannel().sendMessage("Result: "+Z).queue();
                    break;
                case "multi":
                    Z = x*y;
                    event.getChannel().sendMessage("Result: "+Z).queue();
                    return;
                case "sub":
                    Z = x-y;
                    event.getChannel().sendMessage("Result: "+Z).queue();
                    break;
                case "div":
                    Z = x/y;
                    event.getChannel().sendMessage("Result: "+Z).queue();
                    break;
                default:
                    event.getChannel().sendMessage("Invalid operator(s) "+ args[1]+" "+args[2]+" "+args[3]).queue();
            }
        }


    }
}
