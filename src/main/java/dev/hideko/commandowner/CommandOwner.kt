package dev.hideko.commandowner

import dev.hideko.commandowner.commands.OwnerCommand
import org.bukkit.configuration.file.FileConfiguration
import org.bukkit.configuration.file.YamlConfiguration
import org.bukkit.plugin.java.JavaPlugin
import java.io.File

class CommandOwner : JavaPlugin() {

    companion object {
        private lateinit var instance: CommandOwner
        fun getInstance(): CommandOwner {
            return instance
        }
    }

    private lateinit var configFile: File
    private lateinit var config: FileConfiguration

    class PluginConfig(private val config: FileConfiguration, private val configFile: File) {
        fun config(): FileConfiguration { return config }
        fun file(): File { return configFile }
    }

    fun getConfiguration(): PluginConfig {
        return PluginConfig(config, configFile)
    }


    override fun onEnable() {
        instance = this
        loadConfig()

        val commands = listOf(
            "commandowner" to OwnerCommand(),
        )
        commands.forEach { (name, cmd) -> getCommand(name)?.setExecutor(cmd) }
    }

    private fun loadConfig() {
        configFile = File(dataFolder, "config.yml")
        if(!configFile.exists()) {
            configFile.parentFile.mkdirs()
            saveResource("config.yml", false)
        }
        config = YamlConfiguration.loadConfiguration(configFile)
    }

    override fun onDisable() {
    }
}
