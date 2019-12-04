package Workspaces.buildTypes

import jetbrains.buildServer.configs.kotlin.v10.*

object Workspaces_Custom : Template({
    uuid = "2bf06cfc-08c2-4ff3-89b5-a8911cf714fb"
    extId = "Workspaces_Custom"
    name = "custom"

    allowExternalStatus = true
    maxRunningBuilds = 1
})
