package top.wyf7685.collection7685.modules;

import org.slf4j.Logger;
import top.wyf7685.collection7685.CollectionMod;

public abstract class BaseModule {
    public static final Logger LOGGER = CollectionMod.LOGGER;
    public void init() {
        String name = getClass().getName();
        LOGGER.info("Initializing module " + name + "...");
        onInit();
        LOGGER.info("Initialize module " + name + " finished.");
    }
    public abstract void onInit();
}
