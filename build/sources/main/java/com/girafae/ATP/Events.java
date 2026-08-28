package com.girafae.ATP;

import net.minecraft.client.Minecraft;
import net.minecraft.client.shader.Framebuffer;
import net.minecraft.util.ScreenShotHelper;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class Events {
    public static final String Style = "<style>body {background-color: #222222;}*{font-family: Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;}.Day {color: #e9eeee;font-size: 5ch;height: 1vh;}.Content {text-align: center;background-color: #191920;border-radius: .5vh;width: 95%;margin: auto;border: 2px solid #e6e6e6;margin: 2vh;}.PlayerName {font-size: 2ch;font-family: 'Courier New', Courier, monospace;color: #e9eeee;}.PlayerName::before {content: \"<\";color: #f85742;}.PlayerName::after {content: \">\";color: #f85742;}.Time {color: #e9eeee;font-size: 2ch;}.Message {color: #e6e6e6;font-family: Arial, Helvetica, sans-serif;}</style>\n";
    @SubscribeEvent
    public void OnChat(ClientChatReceivedEvent event) throws InterruptedException, IOException {
        try {
            Minecraft mc = Minecraft.getMinecraft();
            PrintWriter write = new PrintWriter(new FileWriter(mc.mcDataDir + "/Historic/index.html", true));
            String AllBytes = new String(Files.readAllBytes(Paths.get(mc.mcDataDir + "/Historic/index.html")));
            if (!AllBytes.contains(Style)) {write.println(Style); }
            Functions FunctionModule = new Functions();
            String Message = event.message.getUnformattedText();
            write.println("<section class=\"Content\">" + "<p class=\"Day\">" + FunctionModule.GetData("Day",Message) + "</p>" + "<p class=\"Time\">" + FunctionModule.GetData("Time",Message) + "</p>" + "<p class=\"Message\">" + FunctionModule.GetData("Completed",Message) + "</p>" + "</section>");
            write.flush();
        }catch (Exception e){
            return; 
        }
    }
}
