package net.mattias.lightsabers.item;

import net.mattias.lightsabers.KeyBindings;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class CustomSword extends SwordItem {
    private static final String EXTENDED_KEY = "Extended";
    public static final Tier CUSTOM_TIER = CustomTiers.LIGHTSABER;

    public CustomSword(Tier tier, int attackDamage, float attackSpeed, Properties properties) {
        super(tier, attackDamage, attackSpeed, properties);
    }

    @Override
    public void inventoryTick(ItemStack stack, Level world, Entity entity, int itemSlot, boolean isSelected) {
        if (entity instanceof Player player && isSelected) {
            if (KeyBindings.TOGGLE_LIGHTSABER.isDown()) {
                toggleExtended(stack);
            }
        }
        super.inventoryTick(stack, world, entity, itemSlot, isSelected);
    }

    private void toggleExtended(ItemStack stack) {
        CompoundTag tag = stack.getOrCreateTag();
        boolean extended = tag.getBoolean(EXTENDED_KEY);
        tag.putBoolean(EXTENDED_KEY, !extended);
        stack.setTag(tag);
    }

    public static boolean isExtended(ItemStack stack) {
        CompoundTag tag = stack.getTag();
        return tag != null && tag.getBoolean(EXTENDED_KEY);
    }

    @OnlyIn(Dist.CLIENT)
    public static void registerModelProperties() {
        ItemProperties.register(ModItems.LIGHT_SABER.get(), new ResourceLocation("extended"),
                (stack, world, entity, seed) -> isExtended(stack) ? 1.0F : 0.0F);
    }
}
