package Workspaces_Canary_Canary2.buildTypes

import jetbrains.buildServer.configs.kotlin.v10.*
import jetbrains.buildServer.configs.kotlin.v10.buildFeatures.CommitStatusPublisher
import jetbrains.buildServer.configs.kotlin.v10.buildFeatures.CommitStatusPublisher.*
import jetbrains.buildServer.configs.kotlin.v10.buildFeatures.commitStatusPublisher
import jetbrains.buildServer.configs.kotlin.v10.buildSteps.ScriptBuildStep
import jetbrains.buildServer.configs.kotlin.v10.buildSteps.ScriptBuildStep.*
import jetbrains.buildServer.configs.kotlin.v10.buildSteps.script
import jetbrains.buildServer.configs.kotlin.v10.triggers.VcsTrigger
import jetbrains.buildServer.configs.kotlin.v10.triggers.VcsTrigger.*
import jetbrains.buildServer.configs.kotlin.v10.triggers.vcs

object Workspaces_Canary_Canary2_CbaANp0900044othNpdCanary1 : BuildType({
    uuid = "330c196c-bbd6-4f11-99c5-e6c9bd17c23c"
    extId = "Workspaces_Canary_Canary2_CbaANp0900044othNpdCanary1"
    name = "cba-a-np-0900044-oth-npd-canary_1"
    description = "Canary2 Nonp Mgmt"

    allowExternalStatus = true
    maxRunningBuilds = 1

    params {
        param("env.TC_AgentAMI", "%system.ec2.ami-id%")
        param("env.TC_AgentName", "%teamcity.agent.name%")
        param("env.TC_BuildBranch", "%teamcity.build.branch%")
        param("env.TC_BuildCommit", "%build.vcs.number%")
        param("env.TC_BuildName", "%system.teamcity.buildConfName%")
        param("env.TC_BuildNum", "%system.build.number%")
        param("env.TC_BuildUser", "%teamcity.build.triggeredBy.username%")
        param("env.TC_ProjectName", "%system.teamcity.projectName%")
        param("env.TC_Version", "%system.teamcity.version%")
    }

    vcs {
        root(Workspaces_Canary_Canary2.vcsRoots.Vcs_Workspaces_Canary_Canary2_CbaANp0900044othNpdCanary1)

        checkoutMode = CheckoutMode.ON_AGENT
        cleanCheckout = true
    }

    steps {
        script {
            name = "Test Step"

        }
        script {
            name = "Run Playbook"

        }
    }

    triggers {
        vcs {
            enabled = false
            branchFilter = """
                +:*
                -:<default>
            """.trimIndent()
        }
    }


})
