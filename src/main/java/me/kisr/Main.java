package me.kisr;

import io.github.cdimascio.dotenv.Dotenv;
import me.kisr.commands.CommandManager;
import me.kisr.commands.Commands;
import me.kisr.listeners.ButtonInteraction;
import me.kisr.listeners.ModalInteraction;
import me.kisr.utils.FileUtils;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;

import java.io.File;

public class Main {

    /*
    variables
     */

    public static JDA jda;
    public static Dotenv config = Dotenv.configure().load();
    public static StringBuilder players = new StringBuilder();
    public static StringBuilder entered = new StringBuilder();
    public static File filePlayers = new File("players.txt");
    public static File fileEntered = new File("entered.txt");

    /*
    main
     */

    public static void main(String[] args) {
        FileUtils.fileChecks();

        jda = JDABuilder.createDefault(config.get("TOKEN"))
                .setStatus(OnlineStatus.DO_NOT_DISTURB)
                .setActivity(Activity.watching("Fusion"))
                .enableIntents(GatewayIntent.GUILD_MEMBERS, GatewayIntent.GUILD_MESSAGES, GatewayIntent.GUILD_PRESENCES, GatewayIntent.MESSAGE_CONTENT)
                .addEventListeners(new CommandManager(), new Commands(), new ButtonInteraction(), new ModalInteraction())
                .build();
    }

}
