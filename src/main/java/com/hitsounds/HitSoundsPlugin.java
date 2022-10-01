package com.hitsounds;

import com.google.inject.Provides;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.events.HitsplatApplied;
import net.runelite.api.Hitsplat;
import net.runelite.api.HitsplatID;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

import javax.inject.Inject;

@Slf4j
@PluginDescriptor(
	name = "Hit Sounds",
	description = "This plugin will send a custom sound on hitsplat",
	tags = {"sound", "hitsplat", "max", "poison", "disease", "venom","damage","health"},
	enabledByDefault = true
)
public class HitSoundsPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private HitSoundsConfig config;

	@Override
	protected void startUp() throws Exception
	{
		log.info("Hit Sounds started!");
	}

	@Override
	protected void shutDown() throws Exception
	{
		log.info("Hit Sounds stopped!");
	}

	@Subscribe
	public void onHitsplatApplied(HitsplatApplied hitsplatApplied){
		switch(hitsplatApplied.getHitsplat().getHitsplatType()){
			case HitsplatID.DAMAGE_ME:
				break;
		}

		System.out.println(hitsplatApplied.getHitsplat().getHitsplatType());

	}


	@Provides
	HitSoundsConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(HitSoundsConfig.class);
	}
}
