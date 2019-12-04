package Workspaces.buildTypes

import jetbrains.buildServer.configs.kotlin.v10.*
import jetbrains.buildServer.configs.kotlin.v10.buildFeatures.CommitStatusPublisher
import jetbrains.buildServer.configs.kotlin.v10.buildFeatures.CommitStatusPublisher.*
import jetbrains.buildServer.configs.kotlin.v10.buildFeatures.commitStatusPublisher

object Workspaces_Workspace : Template({
    uuid = "3fc12a6f-688e-44f2-a764-f499de06f681"
    extId = "Workspaces_Workspace"
    name = "workspace"

    allowExternalStatus = true
    maxRunningBuilds = 1

    features {
        commitStatusPublisher {
            id = "BUILD_EXT_30"
            publisher = github {
                githubUrl = "https://vcs.cnsga.aws.prod.au.internal.cba/api/v3/"
                authType = personalToken {
                    token = "zxx59a101063d2c9c585dd657b8cdbbf474e46cc21fd5e5c4c35830598cf19b055ac3a9bfbc6efde453775d03cbe80d301b"
                }
            }
        }
    }
})
