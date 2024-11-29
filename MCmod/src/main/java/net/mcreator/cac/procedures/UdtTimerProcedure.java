package net.mcreator.cac.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.cac.network.CacModVariables;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class UdtTimerProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level(), event.player);
		}
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (CacModVariables.MapVariables.get(world).Timer_time > 0) {
			CacModVariables.MapVariables.get(world).Timer_time = CacModVariables.MapVariables.get(world).Timer_time - 0.05;
			CacModVariables.MapVariables.get(world).syncData(world);
			if ((CacModVariables.MapVariables.get(world).Timer_show).equals("subtitle")) {
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands()
								.performPrefixedCommand(
										new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
												_ent.getDisplayName(), _ent.level().getServer(), _ent),
										("title " + "@a " + "subtitle " + "\"" + new java.text.DecimalFormat("##").format(Math.ceil(CacModVariables.MapVariables.get(world).Timer_time)) + "\""));
					}
				}
			} else if ((CacModVariables.MapVariables.get(world).Timer_show).equals("bar")) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal((new java.text.DecimalFormat("##").format(Math.ceil(CacModVariables.MapVariables.get(world).Timer_time)))), true);
			}
		} else {
			CacModVariables.MapVariables.get(world).Timer_time = 0;
			CacModVariables.MapVariables.get(world).syncData(world);
			CacModVariables.MapVariables.get(world).Timer_show = "none";
			CacModVariables.MapVariables.get(world).syncData(world);
			if (!((CacModVariables.MapVariables.get(world).Timer_event).equals("none") || (CacModVariables.MapVariables.get(world).Timer_event).equals(""))) {
				UdtEventStartProcedure.execute(world, entity);
			}
		}
	}
}
