package com.obaldon.checkspawn.command;

import com.obaldon.checkspawn.CheckSpawnMod;
import com.obaldon.checkspawn.SpawnEntry;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;

import java.util.List;

public class CheckSpawnCommand {

    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("checkspawn")
                .then(Commands.argument("pokemon", StringArgumentType.word())
                        .executes(ctx -> execute(ctx.getSource(), StringArgumentType.getString(ctx, "pokemon")))));
    }

    private static int execute(CommandSourceStack source, String pokemon) {
        List<SpawnEntry> entries = CheckSpawnMod.SPAWN_DATA.get(pokemon.toLowerCase());
        if (entries == null) {
            source.sendSystemMessage(Component.literal("\u274C Pok\u00E9mon n\u00E3o encontrado."));
            return 0;
        }
        for (SpawnEntry entry : entries) {
            source.sendSystemMessage(entry.toComponent());
        }
        return entries.size();
    }
}
