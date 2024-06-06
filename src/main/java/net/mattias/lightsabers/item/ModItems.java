package net.mattias.lightsabers.item;

import net.mattias.lightsabers.Lightsabers;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Lightsabers.MODID);

    public static final RegistryObject<Item> LIGHT_SABER = ITEMS.register("light_saber",
            () -> new CustomSword(CustomSword.CUSTOM_TIER, 3, -2.4F, new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
