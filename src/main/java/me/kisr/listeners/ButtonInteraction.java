package me.kisr.listeners;

import me.kisr.Main;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.ActionRow;
import net.dv8tion.jda.api.interactions.components.text.TextInput;
import net.dv8tion.jda.api.interactions.components.text.TextInputStyle;
import net.dv8tion.jda.api.interactions.modals.Modal;

import java.util.ArrayList;
import java.util.List;

public class ButtonInteraction extends ListenerAdapter {

    @Override
    public void onButtonInteraction(ButtonInteractionEvent event) {
        String button = event.getButton().getId();

        /*
        enter-tournament button
         */

        if (button.equals("enter-tournament")) {
            if (!Main.entered.toString().contains(event.getMember().getId())) {

                List<ActionRow> modals = new ArrayList<>();

                TextInput ign = TextInput.create("ign", "IGN", TextInputStyle.SHORT)
                        .setRequired(true)
                        .setPlaceholder("Username")
                        .build();

                modals.add(ActionRow.of(ign));

                Modal modal = Modal.create("enter-tournament", "Tournament")
                        .addActionRows(modals)
                        .build();

                event.replyModal(modal).queue();
            } else {
                event.reply("You already entered this tournament!").setEphemeral(true).queue();
            }
        }
    }
}
