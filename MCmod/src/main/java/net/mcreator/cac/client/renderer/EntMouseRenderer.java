
package net.mcreator.cac.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.SilverfishModel;

import net.mcreator.cac.entity.EntMouseEntity;

public class EntMouseRenderer extends MobRenderer<EntMouseEntity, SilverfishModel<EntMouseEntity>> {
	public EntMouseRenderer(EntityRendererProvider.Context context) {
		super(context, new SilverfishModel(context.bakeLayer(ModelLayers.SILVERFISH)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(EntMouseEntity entity) {
		return new ResourceLocation("cac:textures/entities/silverfish.png");
	}
}
