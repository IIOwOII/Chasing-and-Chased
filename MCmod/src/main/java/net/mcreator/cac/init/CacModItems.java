
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.cac.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.ForgeSpawnEggItem;

import net.minecraft.world.item.Item;

import net.mcreator.cac.item.CacTestItemItem;
import net.mcreator.cac.CacMod;

public class CacModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, CacMod.MODID);
	public static final RegistryObject<Item> ENT_CAT_SPAWN_EGG = REGISTRY.register("ent_cat_spawn_egg", () -> new ForgeSpawnEggItem(CacModEntities.ENT_CAT, -16777216, -65536, new Item.Properties()));
	public static final RegistryObject<Item> CAC_TEST_ITEM = REGISTRY.register("cac_test_item", () -> new CacTestItemItem());
	public static final RegistryObject<Item> ENT_PLAYER_MOUSE_SPAWN_EGG = REGISTRY.register("ent_player_mouse_spawn_egg", () -> new ForgeSpawnEggItem(CacModEntities.ENT_PLAYER_MOUSE, -1, -16711936, new Item.Properties()));
	public static final RegistryObject<Item> ENT_MOUSE_SPAWN_EGG = REGISTRY.register("ent_mouse_spawn_egg", () -> new ForgeSpawnEggItem(CacModEntities.ENT_MOUSE, -16777216, -16711936, new Item.Properties()));
	public static final RegistryObject<Item> ENT_PLAYER_CAT_SPAWN_EGG = REGISTRY.register("ent_player_cat_spawn_egg", () -> new ForgeSpawnEggItem(CacModEntities.ENT_PLAYER_CAT, -1, -65536, new Item.Properties()));
}
