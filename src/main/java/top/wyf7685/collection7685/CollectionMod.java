package top.wyf7685.collection7685;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import top.wyf7685.collection7685.modules.ModuleInitializer;

public class CollectionMod implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("Collection7685");
    @Override
    public void onInitialize() {
        LOGGER.info("Initializing Collection7685...");
        ModuleInitializer.initModules();
    }
}
