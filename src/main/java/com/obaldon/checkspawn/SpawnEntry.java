package com.obaldon.checkspawn;

import com.google.gson.JsonObject;
import net.minecraft.network.chat.Component;

public class SpawnEntry {
    public final String minLevel;
    public final String maxLevel;
    public final String times;
    public final String locationTypes;
    public final String biome;
    public final String antiBiome;
    public final double rarity;

    private SpawnEntry(String minLevel, String maxLevel, String times, String locationTypes, String biome, String antiBiome, double rarity) {
        this.minLevel = minLevel;
        this.maxLevel = maxLevel;
        this.times = times;
        this.locationTypes = locationTypes;
        this.biome = biome;
        this.antiBiome = antiBiome;
        this.rarity = rarity;
    }

    public static SpawnEntry fromJson(JsonObject obj) {
        String minLevel = obj.get("minLevel").getAsString();
        String maxLevel = obj.get("maxLevel").getAsString();
        String times = obj.get("Times").getAsString();
        String locationTypes = obj.get("LocationTypes").getAsString();
        String biome = obj.get("Biome").getAsString();
        String antiBiome = obj.get("AntiBiome").getAsString();
        double rarity = obj.get("Rarity").getAsDouble();
        return new SpawnEntry(minLevel, maxLevel, times, locationTypes, biome, antiBiome, rarity);
    }

    public Component toComponent() {
        String msg = String.format("Lvl %s-%s | Time: %s | Location: %s | Biome: %s | AntiBiome: %s | Rarity: %s",
                minLevel, maxLevel, times, locationTypes, biome, antiBiome, rarity);
        return Component.literal(msg);
    }
}
