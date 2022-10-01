package com.hitsounds;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigSection;

@ConfigGroup("hitsounds")
public interface HitSoundsConfig extends Config
{

	@ConfigSection(
			position = 1,
			name = "Hitsplat Toggles",
			description = "Select which hitsplats should have sounds"
	)
	String hitsplatToggleSection = "hitsplatToggleSection";

	@ConfigItem(
			keyName = "normalHitBoolean",
			name = "Normal",
			description = "Enable/Disable Normal Hit Sounds",
			section = "hitsplatToggleSection",
			position = 1
	)
	default boolean normalHitBoolean() {return true;}


	@ConfigItem(
			keyName = "maxHitBoolean",
			name = "Max",
			description = "Enable/Disable Max Hit Sounds",
			section = "hitsplatToggleSection",
			position = 2
	)
	default boolean maxHitBoolean() {return true;}


	@ConfigItem(
			keyName = "poisonHitBoolean",
			name = "Poison",
			description = "Enable/Disable Poison Hit Sounds",
			section = "hitsplatToggleSection",
			position = 3
	)
	default boolean poisonHitBoolean() {return true;}


	@ConfigItem(
			keyName = "venomHitBoolean",
			name = "Venom",
			description = "Enable/Disable Venom Hit Sounds",
			section = "hitsplatToggleSection",
			position = 4
	)
	default boolean venomHitBoolean() {return true;}


	@ConfigItem(
			keyName = "diseaseHitBoolean",
			name = "Disease",
			description = "Enable/Disable Disease Hit Sounds",
			section = "hitsplatToggleSection",
			position = 5
	)
	default boolean diseaseHitBoolean() {return true;}


	@ConfigItem(
			keyName = "corruptionHitBoolean",
			name = "Corruption",
			description = "Enable/Disable Corruption Hit Sounds",
			section = "hitsplatToggleSection",
			position = 6
	)
	default boolean corruptionHitBoolean() {return true;}


	@ConfigItem(
			keyName = "stunHitBoolean",
			name = "Stun",
			description = "Enable/Disable Stun Hit Sounds",
			section = "hitsplatToggleSection",
			position = 7
	)
	default boolean stunHitBoolean() {return true;}


	@ConfigItem(
			keyName = "missHitBoolean",
			name = "Miss",
			description = "Enable/Disable Miss Hit Sounds",
			section = "hitsplatToggleSection",
			position = 8
	)
	default boolean missHitBoolean() {return true;}


	@ConfigItem(
			keyName = "armorHitBoolean",
			name = "Armor",
			description = "Enable/Disable Armor Hit Sounds",
			section = "hitsplatToggleSection",
			position = 9
	)
	default boolean armorHitBoolean() {return true;}


	@ConfigItem(
			keyName = "chargeHitBoolean",
			name = "Charge",
			description = "Enable/Disable Charge Hit Sounds",
			section = "hitsplatToggleSection",
			position = 10
	)
	default boolean chargeHitBoolean() {return true;}


	@ConfigItem(
			keyName = "unchargeHitBoolean",
			name = "Uncharge",
			description = "Enable/Disable Uncharge Hit Sounds",
			section = "hitsplatToggleSection",
			position = 11
	)
	default boolean unchargeHitBoolean() {return true;}


	@ConfigItem(
			keyName = "poiseHitBoolean",
			name = "Poise",
			description = "Enable/Disable Poise Hit Sounds",
			section = "hitsplatToggleSection",
			position = 12
	)
	default boolean poiseHitBoolean() {return true;}


	@ConfigItem(
			keyName = "healingHitBoolean",
			name = "Healing",
			description = "Enable/Disable Healing Hit Sounds",
			section = "hitsplatToggleSection",
			position = 13
	)
	default boolean healingHitBoolean() {return true;}


	@ConfigItem(
			keyName = "otherHitBoolean",
			name = "Other",
			description = "Enable/Disable Other Hit Sounds",
			section = "hitsplatToggleSection",
			position = 14
	)
	default boolean otherHitBoolean() {return true;}

}
