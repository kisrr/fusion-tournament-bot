package me.kisr.commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.buttons.Button;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Commands extends ListenerAdapter {

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        String command = event.getName();

        if (command.equals("sendtournament")) {
            if (event.getMember().hasPermission(Permission.ADMINISTRATOR)) {
                EmbedBuilder embed = new EmbedBuilder();
                embed.setTitle("Tournament");
                embed.setColor(Color.RED);
                embed.setDescription("Click the button below to enter the tournament");
                List<net.dv8tion.jda.api.interactions.components.buttons.Button> buttons = new ArrayList<>();
                buttons.add(Button.primary("enter-tournament", "📩"));
                event.getChannel().sendMessageEmbeds(embed.build()).addActionRow(buttons).queue();

                event.reply("Tournament embed has been sent!").setEphemeral(true).queue();
            } else {
                event.reply("No permission!").setEphemeral(true).queue();
            }
        }
    }
}
