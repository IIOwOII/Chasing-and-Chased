package net.mcreator.cac.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;

import net.mcreator.cac.network.CacModVariables;

public class AiCatProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (CacModVariables.MapVariables.get(world).Switch_Task) {
			if (!entity.getPersistentData().getBoolean("C_Touch")) {
				if (x - 8 <= CacModVariables.MapVariables.get(world).Pos_player_x && x + 8 >= CacModVariables.MapVariables.get(world).Pos_player_x && z - 8 <= CacModVariables.MapVariables.get(world).Pos_player_z
						&& z + 8 >= CacModVariables.MapVariables.get(world).Pos_player_z) {
					if (entity instanceof Mob _entity)
						_entity.getNavigation().moveTo(CacModVariables.MapVariables.get(world).Pos_player_x, y, CacModVariables.MapVariables.get(world).Pos_player_z, 1);
				}
			}
		}
	}
}
