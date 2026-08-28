package com.girafae.ATP;

import net.minecraft.client.Minecraft;
import net.minecraft.client.shader.Framebuffer;
import net.minecraft.util.ScreenShotHelper;

import javax.annotation.Nonnull;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Functions {


    public boolean Print() {
        try {
            Minecraft mc = Minecraft.getMinecraft();
            Framebuffer Img = mc.getFramebuffer();
            ScreenShotHelper.saveScreenshot(mc.mcDataDir, mc.displayWidth, mc.displayHeight, Img);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String GetData(String Data, String ContentMessage) {
        LocalDateTime now = LocalDateTime.now();
        if (Data.equals("Day")) {
            return now.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        }
        if (Data.equals("Time")) {
            return now.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        }
        if (Data.equals("Name")) {
            return ContentMessage.split("<")[1].split(">")[0];
        }
        if (Data.equals("Message")) {
            return ContentMessage.split("<")[1].split(">")[1];
        }
        if (Data.equals("Completed")) {
            return ContentMessage.replace("<","").replace(">","");
        }
        // if (Data.equals("Skin")) {return map.get(MinecraftProfileTexture.Type.SKIN).getUrl();} // ->  In Future? <- \\
        return "null";
    }
}
