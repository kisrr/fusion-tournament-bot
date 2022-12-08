package me.kisr.utils;

import me.kisr.Main;

import java.io.FileWriter;
import java.util.Scanner;

public enum FileUtils {
    ;

    public static void fileChecks() {

        /*
        players file check
         */

        try {
            Main.filePlayers.createNewFile();

            Scanner scanner = new Scanner(Main.filePlayers);

            while (scanner.hasNextLine()) {
                Main.players.append(scanner.nextLine() + "\n");
            }

            FileWriter writer = new FileWriter(Main.filePlayers.getName());
            writer.write(Main.players.toString());
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        /*
        entered file check
         */

        try {
            Main.fileEntered.createNewFile();

            Scanner scanner = new Scanner(Main.fileEntered);

            while (scanner.hasNextLine()) {
                Main.entered.append(scanner.nextLine() + "\n");
            }

            FileWriter writer = new FileWriter(Main.fileEntered.getName());
            writer.write(Main.entered.toString());
            writer.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
