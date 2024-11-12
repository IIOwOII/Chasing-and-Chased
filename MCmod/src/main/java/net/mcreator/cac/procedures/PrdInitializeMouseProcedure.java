package net.mcreator.cac.procedures;

import net.minecraft.world.entity.Entity;

public class PrdInitializeMouseProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putString("C_Name", "Prey");
		entity.getPersistentData().putBoolean("C_Touch", false);
	}
}
