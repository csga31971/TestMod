package xyz.csga.testmod.command;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;

import java.util.logging.Logger;

public class TestCommand extends CommandBase{

    private String commandName = "util";
    private String commangUsage = "/util click the options!";

    @Override
    public int getRequiredPermissionLevel(){
        return 0;
    }

    @Override
    public String getCommandName() {
        return commandName;
    }

    @Override
    public String getCommandUsage(ICommandSender p_71518_1_) {
        return commangUsage;
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) {
        Logger log = Logger.getLogger("a");
        for (int i = 0; i < args.length; i++) {
            log.info(args[i]);
        }
        MinecraftServer.getServer().getCommandManager().executeCommand(sender,
                "/tellraw @p [\"\"," +
                        "{\"text\":\"[food] \",\"color\":\"red\",\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/give @p cooked_beef 64\"}}," +
                        "{\"text\":\"[weapon] \",\"color\":\"white\",\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/give @p diamond_sword 1\"}}," +
                        "{\"text\":\"[nightvision] \",\"color\":\"red\",\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/effect @p 16 60 1\"}}," +
                        "{\"text\":\"[speed] \",\"color\":\"white\",\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/effect @p 1 60 2\"}}" +
                        "{\"text\":\"[speed++] \",\"color\":\"red\",\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/effect @p 1 60 10\"}}" +
                        "{\"text\":\"[clear] \",\"color\":\"white\",\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/effect @p clear\"}}" +
                        "]");
    }
}
