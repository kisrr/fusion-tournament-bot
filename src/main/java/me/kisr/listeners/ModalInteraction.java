package me.kisr.listeners;

import me.kisr.Main;
import net.dv8tion.jda.api.events.interaction.ModalInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.io.FileWriter;

public class ModalInteraction extends ListenerAdapter {

    @Override
    public void onModalInteraction(ModalInteractionEvent event) {
        String modal = event.getModalId();

        /*
        enter-tournament modal
         */

        if (modal.equals("enter-tournament")) {
            try {
                FileWriter writer = new FileWriter(Main.filePlayers.getName());
                Main.players.append(event.getValue("ign").getAsString() + "\n");

                writer.write(Main.players.toString());
                writer.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                FileWriter writer = new FileWriter(Main.fileEntered.getName());
                Main.entered.append(event.getMember().getId() + "\n");

                writer.write(Main.entered.toString());
                writer.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

            event.reply("You have entered the tournament!").setEphemeral(true).queue();
        }
    }
}
