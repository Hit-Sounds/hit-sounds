package com.hitsounds.enums;

import com.hitsounds.HitSoundsPlugin;

import java.io.File;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum HitSoundEnum {

    NORMAL("Normal", HitSoundsPlugin.NORMAL_FILE),
    MAX("Max", HitSoundsPlugin.MAX_FILE),
    POISON("Poison", HitSoundsPlugin.POISON_FILE),
    VENOM("Venom", HitSoundsPlugin.VENOM_FILE),
    DISEASE("Disease", HitSoundsPlugin.DISEASE_FILE),
    MISS("Miss", HitSoundsPlugin.MISS_FILE),
    HEALING("Healing", HitSoundsPlugin.HEALING_FILE),
    OTHER("Other", HitSoundsPlugin.OTHER_FILE);

    private final String hittype;
    private final File file;
}
