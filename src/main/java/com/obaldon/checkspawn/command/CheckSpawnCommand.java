package com.obaldon.checkspawn.command;

import com.obaldon.checkspawn.CheckSpawnMod;
import com.obaldon.checkspawn.SpawnEntry;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class CheckSpawnCommand {

    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("checkspawn")
                .then(Commands.argument("pokemon", StringArgumentType.word())
                        .suggests(CheckSpawnCommand::suggestPokemon)
                        .executes(ctx -> execute(ctx.getSource(), StringArgumentType.getString(ctx, "pokemon")))));
    }

    private static int execute(CommandSourceStack source, String search) {
        String lower = search.toLowerCase(Locale.ROOT);
        List<String> matches = new ArrayList<>();
        for (String name : CheckSpawnMod.SPAWN_DATA.keySet()) {
            if (name.contains(lower)) {
                matches.add(name);
            }
        }

        if (matches.isEmpty()) {
            source.sendSystemMessage(Component.literal("\u274C Nenhum Pok\u00E9mon corresponde \u00E0 busca '" + search + "'."));
            return 0;
        }

        if (matches.size() > 1) {
            source.sendSystemMessage(Component.literal("\u2705 M\u00FAltiplos resultados encontrados: " + String.join(", ", matches)));
            return matches.size();
        }

        String pokemon = matches.get(0);
        List<SpawnEntry> entries = CheckSpawnMod.SPAWN_DATA.get(pokemon);
        for (SpawnEntry entry : entries) {
            source.sendSystemMessage(entry.toComponent());
        }
        return entries.size();
    }

    private static java.util.concurrent.CompletableFuture<com.mojang.brigadier.suggestion.Suggestions> suggestPokemon(com.mojang.brigadier.context.CommandContext<CommandSourceStack> context, SuggestionsBuilder builder) {
        String remaining = builder.getRemaining().toLowerCase(Locale.ROOT);
        for (String name : CheckSpawnMod.SPAWN_DATA.keySet()) {
            if (name.contains(remaining)) {
                builder.suggest(name);
            }
        }
        return builder.buildFuture();
    }
}
