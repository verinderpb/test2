package Workspaces.buildTypes

import jetbrains.buildServer.configs.kotlin.v10.*

object Workspaces_CustomerTesting : Template({
    uuid = "db956af8-69f5-4d35-89f9-0b4345d1a4d0"
    extId = "Workspaces_CustomerTesting"
    name = "customer-testing"

    allowExternalStatus = true
})
