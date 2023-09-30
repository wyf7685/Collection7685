package top.wyf7685.collection7685.modules;

import com.mojang.brigadier.CommandDispatcher;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;
import top.wyf7685.collection7685.Config;

import static net.minecraft.server.command.CommandManager.*;

public class Command extends BaseModule {
    @Override
    public void onInit() {
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
            // Register all the commands here
            registerOreDispenseCommand(dispatcher);
        });
    }
    public void registerOreDispenseCommand(CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register(literal("oredispense")
                .requires(source -> source.hasPermissionLevel(4))
                .executes(context -> {
                    if (Config.doOreDispense) {
                        Config.doOreDispense = false;
                        context.getSource().sendMessage(Text.literal("[Collection7685] doOreDispense set to false."));
                    } else {
                        Config.doOreDispense = true;
                        context.getSource().sendMessage(Text.literal("[Collection7685] doOreDispense set to true."));
                    }
                    return 1;
                }));
    }
}
