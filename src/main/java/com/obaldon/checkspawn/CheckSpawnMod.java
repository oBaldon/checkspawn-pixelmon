package com.obaldon.checkspawn;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.RegisterCommandsEvent;
import net.neoforged.neoforge.eventbus.api.SubscribeEvent;
import org.slf4j.Logger;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;

@Mod(CheckSpawnMod.MODID)
public class CheckSpawnMod {
    public static final String MODID = "checkspawn";
    private static final Logger LOGGER = LogUtils.getLogger();

    public static final Map<String, List<SpawnEntry>> SPAWN_DATA = new HashMap<>();

    public CheckSpawnMod(IEventBus modEventBus) {
        loadSpawns();
        modEventBus.register(this);
    }

    private void loadSpawns() {
        InputStream stream = getClass().getResourceAsStream("/assets/" + MODID + "/data/spawns.json");
        if (stream == null) {
            LOGGER.warn("spawns.json not found");
            return;
        }
        try (InputStreamReader reader = new InputStreamReader(stream, StandardCharsets.UTF_8)) {
            JsonObject root = new Gson().fromJson(reader, JsonObject.class);
            for (Map.Entry<String, JsonElement> entry : root.entrySet()) {
                List<SpawnEntry> list = new ArrayList<>();
                JsonArray arr = entry.getValue().getAsJsonArray();
                for (JsonElement el : arr) {
                    list.add(SpawnEntry.fromJson(el.getAsJsonObject()));
                }
                SPAWN_DATA.put(entry.getKey().toLowerCase(Locale.ROOT), list);
            }
            LOGGER.info("Loaded spawn data for {} pokemon", SPAWN_DATA.size());
        } catch (Exception e) {
            LOGGER.error("Failed to load spawns.json", e);
        }
    }

    @SubscribeEvent
    public void onRegisterCommands(RegisterCommandsEvent event) {
        CheckSpawnCommand.register(event.getDispatcher());
    }
}
