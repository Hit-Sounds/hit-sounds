/*
 * Copyright (c) 2016-2017, Adam <Adam@sigterm.info>
 * Copyright (c) 2022, Ferrariic <ferrariictweet@gmail.com>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.hitsounds;

import com.google.inject.Provides;
import com.hitsounds.enums.HitSoundEnum;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.HitsplatID;
import net.runelite.api.events.HitsplatApplied;
import net.runelite.client.RuneLite;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

import javax.inject.Inject;
import javax.sound.sampled.*;
import java.io.*;

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
	@Inject
	private ClientThread clientThread;
	private Clip clip = null;
	public static final File NORMAL_FILE = new File(RuneLite.RUNELITE_DIR, "normal.wav");
	public static final File MAX_FILE = new File(RuneLite.RUNELITE_DIR, "max.wav");
	public static final File POISON_FILE = new File(RuneLite.RUNELITE_DIR, "poison.wav");
	public static final File VENOM_FILE = new File(RuneLite.RUNELITE_DIR, "venom.wav");
	public static final File DISEASE_FILE = new File(RuneLite.RUNELITE_DIR, "disease.wav");
	public static final File MISS_FILE = new File(RuneLite.RUNELITE_DIR, "miss.wav");
	public static final File HEALING_FILE = new File(RuneLite.RUNELITE_DIR, "healing.wav");
	public static final File OTHER_FILE = new File(RuneLite.RUNELITE_DIR, "other.wav");

	private long lastClipMTime = CLIP_MTIME_UNLOADED;
	private static final long CLIP_MTIME_UNLOADED = -2;
	private static final long CLIP_MTIME_BUILTIN = -1;

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
			case HitsplatID.DAMAGE_ME_CYAN:
			case HitsplatID.DAMAGE_ME_ORANGE:
			case HitsplatID.DAMAGE_ME_WHITE:
			case HitsplatID.DAMAGE_ME_YELLOW:
			case HitsplatID.DAMAGE_OTHER:
			case HitsplatID.DAMAGE_OTHER_CYAN:
			case HitsplatID.DAMAGE_OTHER_WHITE:
			case HitsplatID.DAMAGE_OTHER_YELLOW:
			case HitsplatID.DAMAGE_OTHER_ORANGE:
				if (!config.normalHitBoolean()){
					break;
				}
				if (!playCustomSound(HitSoundEnum.NORMAL)){
					clientThread.invoke(() -> client.playSoundEffect(config.normalHitSound().getID()));
				};
				break;

			case HitsplatID.BLOCK_ME:
			case HitsplatID.BLOCK_OTHER:
				if (!config.missHitBoolean()){
					break;
				}
				if (!playCustomSound(HitSoundEnum.MISS)){
					clientThread.invoke(() -> client.playSoundEffect(config.missHitSound().getID()));
				}
				break;

			case HitsplatID.DAMAGE_MAX_ME:
			case HitsplatID.DAMAGE_MAX_ME_CYAN:
			case HitsplatID.DAMAGE_MAX_ME_ORANGE:
			case HitsplatID.DAMAGE_MAX_ME_WHITE:
			case HitsplatID.DAMAGE_MAX_ME_YELLOW:
				if (!config.maxHitBoolean()){
					break;
				}
				if (!playCustomSound(HitSoundEnum.MAX)){
					clientThread.invoke(() -> client.playSoundEffect(config.maxHitSound().getID()));
				}
				break;
			case HitsplatID.DISEASE:
				if (!config.diseaseHitBoolean()){
					break;
				}
				if (!playCustomSound(HitSoundEnum.DISEASE)){
					clientThread.invoke(() -> client.playSoundEffect(config.diseaseHitSound().getID()));
				}
				break;
			case HitsplatID.VENOM:
				if (!config.venomHitBoolean()){
					break;
				}
				if (!playCustomSound(HitSoundEnum.VENOM)){
					clientThread.invoke(() -> client.playSoundEffect(config.venomHitSound().getID()));
				}
				break;

			case HitsplatID.HEAL:
				if (!config.healingHitBoolean()){
					break;
				}
				if (!playCustomSound(HitSoundEnum.HEALING)){
					clientThread.invoke(() -> client.playSoundEffect(config.healingHitSound().getID()));
				}
				break;
			case HitsplatID.POISON:
				if (!config.poisonHitBoolean()){
					break;
				}
				if (!playCustomSound(HitSoundEnum.POISON)){
					clientThread.invoke(() -> client.playSoundEffect(config.poisonHitSound().getID()));
				}
				break;
			default:
				if (!config.otherHitBoolean()){
					break;
				}
				if (!playCustomSound(HitSoundEnum.OTHER)){
					clientThread.invoke(() -> client.playSoundEffect(config.otherHitSound().getID()));
				}
				break;
		}
	}


	// modified from the notifier default plugin:
	// https://github.com/runelite/runelite/blob/63dd8af9b51757eb8140674d361a0473cf7e0441/runelite-client/src/main/java/net/runelite/client/Notifier.java#L446-L512
	private boolean playCustomSound(HitSoundEnum hitSoundEnum)
	{
		long currentMTime = hitSoundEnum.getFile().exists() ? hitSoundEnum.getFile().lastModified() : CLIP_MTIME_BUILTIN;
		if (clip == null || currentMTime != lastClipMTime || !clip.isOpen())
		{
			if (clip != null)
			{
				clip.close();
			}
			try
			{
				clip = AudioSystem.getClip();
			}
			catch (LineUnavailableException e)
			{
				lastClipMTime = CLIP_MTIME_UNLOADED;
				log.warn("Unable to play sound", e);
				return false;
			}
			lastClipMTime = currentMTime;
			if (!tryLoadCustomSound(hitSoundEnum))
			{
				return false;
			}
		}
		clip.loop(1);
		return true;
	}

	private boolean tryLoadCustomSound(HitSoundEnum hitSoundEnum)
	{
		if (hitSoundEnum.getFile().exists())
		{
			try (InputStream fileStream = new BufferedInputStream(new FileInputStream(hitSoundEnum.getFile()));
				 AudioInputStream sound = AudioSystem.getAudioInputStream(fileStream))
			{
				clip.open(sound);
				return true;
			}
			catch (UnsupportedAudioFileException | IOException | LineUnavailableException e)
			{
				log.warn("Unable to load sound", e);
			}
		}
		return false;
	}

	@Provides
	HitSoundsConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(HitSoundsConfig.class);
	}
}
