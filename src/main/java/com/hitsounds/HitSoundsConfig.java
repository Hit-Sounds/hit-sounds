package com.hitsounds;

import com.hitsounds.enums.SoundEffectSelectionEnum;
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
			description = "Toggle hitsplat sounds on and off"
	)
	String hitsplatToggleSection = "hitsplatToggleSection";

	@ConfigSection(
			position = 2,
			name = "Default Hitsplat Sounds",
			description = "Select default in-game hitsplat sounds"
	)
	String defaultHitsplatSection = "defaultHitsplatSection";

	@ConfigSection(
			position = 3,
			name = "Custom Hitsplat Sounds",
			description = "Select the path to your custom hitsplat sound [.wav], overrides default sounds!"
	)
	String customHitsplatSection = "customHitsplatSection";

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
			keyName = "missHitBoolean",
			name = "Miss",
			description = "Enable/Disable Miss Hit Sounds",
			section = "hitsplatToggleSection",
			position = 6
	)
	default boolean missHitBoolean() {return true;}


	@ConfigItem(
			keyName = "healingHitBoolean",
			name = "Healing",
			description = "Enable/Disable Healing Hit Sounds",
			section = "hitsplatToggleSection",
			position = 7
	)
	default boolean healingHitBoolean() {return true;}


	@ConfigItem(
			keyName = "otherHitBoolean",
			name = "Other",
			description = "Enable/Disable Other Hit Sounds",
			section = "hitsplatToggleSection",
			position = 8
	)
	default boolean otherHitBoolean() {return true;}

	@ConfigItem(
			keyName = "normalDefaultHitSound",
			name = "Normal",
			description = "Set Default Normal Hit Sound",
			section = "defaultHitsplatSection",
			position = 1
	)
	default SoundEffectSelectionEnum normalHitSound() {return SoundEffectSelectionEnum.TINDER_STRIKE;}

	@ConfigItem(
			keyName = "maxDefaultHitSound",
			name = "Max",
			description = "Set Default Max Hit Sound",
			section = "defaultHitsplatSection",
			position = 2
	)
	default SoundEffectSelectionEnum maxHitSound() {return SoundEffectSelectionEnum.ROCK_SKIN;}

	@ConfigItem(
			keyName = "poisonDefaultHitSound",
			name = "Poison",
			description = "Set Default Poison Hit Sound",
			section = "defaultHitsplatSection",
			position = 3
	)
	default SoundEffectSelectionEnum poisonHitSound() {return SoundEffectSelectionEnum.GE_DECREMENT;}

	@ConfigItem(
			keyName = "venomDefaultHitSound",
			name = "Venom",
			description = "Set Default Venom Hit Sound",
			section = "defaultHitsplatSection",
			position = 4
	)
	default SoundEffectSelectionEnum venomHitSound() {return SoundEffectSelectionEnum.ANVIL_TONK;}

	@ConfigItem(
			keyName = "diseaseDefaultHitSound",
			name = "Disease",
			description = "Set Default Disease Hit Sound",
			section = "defaultHitsplatSection",
			position = 5
	)
	default SoundEffectSelectionEnum diseaseHitSound() {return SoundEffectSelectionEnum.BELL_DING;}

	@ConfigItem(
			keyName = "missDefaultHitSound",
			name = "Miss",
			description = "Set Default Miss Hit Sound",
			section = "defaultHitsplatSection",
			position = 6
	)
	default SoundEffectSelectionEnum missHitSound() {return SoundEffectSelectionEnum.PICK_PLANT;}

	@ConfigItem(
			keyName = "healingDefaultHitSound",
			name = "Healing",
			description = "Set Default Healing Hit Sound",
			section = "defaultHitsplatSection",
			position = 7
	)
	default SoundEffectSelectionEnum healingHitSound() {return SoundEffectSelectionEnum.IMPROVED_REFLEXES;}

	@ConfigItem(
			keyName = "otherDefaultHitSound",
			name = "Other",
			description = "Set Default Other Hit Sound",
			section = "defaultHitsplatSection",
			position = 8
	)
	default SoundEffectSelectionEnum otherHitSound() {return SoundEffectSelectionEnum.MINING_TINK;}

	@ConfigItem(
			keyName = "customHitSound",
			name = "Set Custom Sound",
			description = "Instructions to set a custom sound",
			section = "customHitsplatSection",
			position = 1,
			warning = "Reset this field if you accidentally remove it."
	)
	default String customHitSound() {return "Adding a custom sound\n" +
			"1a. Navigate to your .runelite folder\n" +
			"1b. You can right-click the screenshot button in the top right of the runelite client.\n" +
			"1c. Then open screenshot folder, and navigate to the .runelite directory.\n" +
			"2. Create a folder called 'hitsounds'.\n" +
			"3. Add your sound as a {category}.wav file in /.runelite/hitsounds/ .\n" +
			"\n" +
			"Acceptable File Names:\n" +
			"normal.wav\n" +
			"max.wav\n" +
			"poison.wav\n" +
			"venom.wav\n" +
			"disease.wav\n" +
			"miss.wav\n" +
			"healing.wav\n" +
			"other.wav";}
}
