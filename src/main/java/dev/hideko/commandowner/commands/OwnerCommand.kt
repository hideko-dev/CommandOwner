package dev.hideko.commandowner.commands

import dev.hideko.commandowner.CommandOwner
import org.bukkit.Bukkit
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class OwnerCommand : CommandExecutor {

    override fun onCommand(sender: CommandSender, cmd: Command, label: String, args: Array<out String>?): Boolean {

        if (sender !is Player) return false

        if (sender.isOp) {
            val config = CommandOwner.getInstance().getConfiguration().config()
            val commandSections = config.getConfigurationSection("command")
            if (commandSections != null) {
                for (commandName in commandSections.getKeys(false)) {
                    if (commandName == args?.get(0)) {
                        val commandList = config.getStringList("command.$commandName")
                        for (player in Bukkit.getOnlinePlayers()) {
                            val playerName = player.name
                            var players = 0
                            for (command in commandList) {
                                players++
                                val formattedCommand = command.replace("<player>", playerName)
                                player.performCommand(formattedCommand)
                            }
                            sender.sendMessage("§a合計${players}人のプレイヤーに実行しました。")
                        }
                    }
                }
            }
            return false
        } else {
            sender.sendMessage("§c管理者権限を持っているプレイヤーしか使用できません。")
            return false
        }
    }
}
