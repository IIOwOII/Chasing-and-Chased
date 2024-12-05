package net.mcreator.cac.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

public class EffOnStopMoveProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player) {
			_player.getAbilities().setFlyingSpeed(0.0f);
			_player.getAbilities().setWalkingSpeed(0.0f);
			_player.onUpdateAbilities();
		}
	}
}

