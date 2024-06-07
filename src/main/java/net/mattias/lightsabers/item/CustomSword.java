package net.mattias.lightsabers.item;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.ForgeRegistries;
import net.mattias.lightsabers.sound.ModSounds;

public class CustomSword extends SwordItem {

    public CustomSword(Tier tier, int attackDamage, float attackSpeed, Properties properties) {
        super(tier, attackDamage, attackSpeed, properties);
    }

    public static final Tier CUSTOM_TIER = new Tier() {
        @Override
        public int getLevel() {
            return 3; // Diamond level
        }

        @Override
        public int getUses() {
            return 1561; // Durability
        }

        @Override
        public float getSpeed() {
            return 8.0F;
        }

        @Override
        public float getAttackDamageBonus() {
            return 3.0F;
        }

        @Override
        public int getEnchantmentValue() {
            return 10;
        }

        @Override
        public Ingredient getRepairIngredient() {
            return Ingredient.of(net.minecraft.world.item.Items.DIAMOND); // Can be repaired with diamonds
        }
    };

    @Override
    public void inventoryTick(ItemStack stack, Level world, Entity entity, int itemSlot, boolean isSelected) {
        if (isSelected && entity instanceof Player) {
            Player player = (Player) entity;
            if (world.getGameTime() % 20 == 0) {  // Adjust time interval as needed
                world.playSound(null, player.getX(), player.getY(), player.getZ(),
                        ModSounds.LIGHT_SABER_HOLD.get(), net.minecraft.sounds.SoundSource.PLAYERS, 1.0F, 1.0F);
            }
        }
        super.inventoryTick(stack, world, entity, itemSlot, isSelected);
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (attacker instanceof Player) {
            attacker.level().playSound(null, attacker.getX(), attacker.getY(), attacker.getZ(),
                    ModSounds.LIGHT_SABER_SWING.get(), net.minecraft.sounds.SoundSource.PLAYERS, 1.0F, 1.0F);
        }
        return super.hurtEnemy(stack, target, attacker);
    }
}
