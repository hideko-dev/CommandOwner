package dev.hideko.commandowner.config

import dev.hideko.commandowner.CommandOwner

class Configuration {
    fun saveConfig() {
        val config = CommandOwner.getInstance().getConfiguration()
        val a = config.config().get("hello", null)
    }
}