
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
	public static final RegistryObject<Item> ENT_CAT_SPAWN_EGG = REGISTRY.register("ent_cat_spawn_egg", () -> new ForgeSpawnEggItem(CacModEntities.ENT_CAT, -16777216, -205, new Item.Properties()));
	public static final RegistryObject<Item> CAC_TEST_ITEM = REGISTRY.register("cac_test_item", () -> new CacTestItemItem());
}
