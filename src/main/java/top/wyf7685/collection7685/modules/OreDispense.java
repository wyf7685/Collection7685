package top.wyf7685.collection7685.modules;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.DispenserBlock;
import net.minecraft.block.dispenser.FallibleItemDispenserBehavior;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPointer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.event.GameEvent;
import top.wyf7685.collection7685.Config;

public class OreDispense extends BaseModule {
    public void onInit() {
        initDispenserBehavior();
    }
    public boolean doOreDispense() {return Config.doOreDispense;}
    public void registerOreDispense(Item item, Block block) {
        DispenserBlock.registerBehavior(item, new FallibleItemDispenserBehavior() {
            @Override
            protected ItemStack dispenseSilently(BlockPointer pointer, ItemStack stack) {
                if (doOreDispense()) {
                    ServerWorld world = pointer.getWorld();
                    Direction direction = pointer.getBlockState().get(DispenserBlock.FACING);
                    BlockPos blockPos = pointer.getPos().offset(direction);
                    if (world.isAir(blockPos)) {
                        world.setBlockState(blockPos, block.getDefaultState());
                        world.emitGameEvent(null, GameEvent.BLOCK_PLACE, blockPos);
                        stack.decrement(1);
                        setSuccess(true);
                    } else {
                        setSuccess(false);
                    }
                    return stack;
                } else {
                    return super.dispenseSilently(pointer, stack);
                }
            }
        });
        LOGGER.info("Register dispenser behavior for Block" + block.getName());
    }

    public void initDispenserBehavior() {
        // Coal Ore
        registerOreDispense(Items.COAL_ORE, Blocks.COAL_ORE);
        registerOreDispense(Items.DEEPSLATE_COAL_ORE, Blocks.DEEPSLATE_COAL_ORE);
        // Iron Ore
        registerOreDispense(Items.IRON_ORE, Blocks.IRON_ORE);
        registerOreDispense(Items.DEEPSLATE_IRON_ORE, Blocks.DEEPSLATE_IRON_ORE);
        // Copper Ore
        registerOreDispense(Items.COPPER_ORE, Blocks.COPPER_ORE);
        registerOreDispense(Items.DEEPSLATE_COPPER_ORE, Blocks.DEEPSLATE_COPPER_ORE);
        // Gold Ore
        registerOreDispense(Items.GOLD_ORE, Blocks.GOLD_ORE);
        registerOreDispense(Items.DEEPSLATE_GOLD_ORE, Blocks.DEEPSLATE_GOLD_ORE);
        // Redstone Ore
        registerOreDispense(Items.REDSTONE_ORE, Blocks.REDSTONE_ORE);
        registerOreDispense(Items.DEEPSLATE_REDSTONE_ORE, Blocks.DEEPSLATE_REDSTONE_ORE);
        // Emerald Ore
        registerOreDispense(Items.EMERALD_ORE, Blocks.EMERALD_ORE);
        registerOreDispense(Items.DEEPSLATE_EMERALD_ORE, Blocks.DEEPSLATE_EMERALD_ORE);
        // Lapis Ore
        registerOreDispense(Items.LAPIS_ORE, Blocks.LAPIS_ORE);
        registerOreDispense(Items.DEEPSLATE_LAPIS_ORE, Blocks.DEEPSLATE_LAPIS_ORE);
        // Diamond Ore
        registerOreDispense(Items.DIAMOND_ORE, Blocks.DIAMOND_ORE);
        registerOreDispense(Items.DEEPSLATE_DIAMOND_ORE, Blocks.DEEPSLATE_DIAMOND_ORE);
        // Nether Gold Ore
        registerOreDispense(Items.NETHER_GOLD_ORE, Blocks.NETHER_GOLD_ORE);
        // Nether Quartz Ore
        registerOreDispense(Items.NETHER_QUARTZ_ORE, Blocks.NETHER_QUARTZ_ORE);
    }
}
