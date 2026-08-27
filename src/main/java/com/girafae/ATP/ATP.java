package com.girafae.ATP;

import net.minecraft.client.Minecraft;
import net.minecraft.client.shader.Framebuffer;
import net.minecraft.init.Blocks;
import net.minecraft.util.ScreenShotHelper;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Mod(modid = ATP.MODID, version = ATP.VERSION)
public class ATP {
    public static final String MODID = "AutoLog";
    public static final String VERSION = "0.0.1";

    @EventHandler
    public void init(FMLInitializationEvent event) throws IOException {
        System.out.println("Mod" + MODID + "[" + VERSION + "]" + "initialized with Success!");
        File Historic = new File(Minecraft.getMinecraft().mcDataDir + "/Historic");
        if (!Historic.exists()) { Historic.mkdir(); }
        MinecraftForge.EVENT_BUS.register(new Events());

    }


    ;

}
