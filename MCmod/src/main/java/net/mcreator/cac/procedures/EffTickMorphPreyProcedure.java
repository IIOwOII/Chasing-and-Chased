package net.mcreator.cac.procedures;

import net.minecraft.world.entity.Entity;

public class EffTickMorphPreyProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.setInvisible(true);
	}
}