package net.mattias.lightsabers.item;

import net.mattias.lightsabers.Lightsabers;
import net.mattias.lightsabers.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Lightsabers.MODID);

    public static final RegistryObject<CreativeModeTab> LIGHTSABERS = CREATIVE_MODE_TABS.register("lightsabers",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(Items.IRON_SWORD))
                    .title(Component.translatable("creativetab.lightsabers"))
                    .displayItems((pParameters, pOutput) -> {
                    pOutput.accept(ModItems.LIGHT_SABER.get());


                    })
                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}