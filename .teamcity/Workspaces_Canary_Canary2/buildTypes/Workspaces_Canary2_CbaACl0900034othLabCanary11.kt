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

object Workspaces_Canary2_CbaACl0900034othLabCanary11 : BuildType({
    uuid = "a94d7168-c060-4d2a-a8da-4164a03449b0"
    extId = "Workspaces_Canary2_CbaACl0900034othLabCanary11"
    name = "cba-a-cl-0900034-oth-lab-canary_11"
    description = "Canary2 Clab Mgmt"

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
        root(Workspaces_Canary_Canary2.vcsRoots.Workspaces_Canary_Canary2_CbaACl0900034othLabCanary11)

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

//    features {
//        commitStatusPublisher {
//            publisher = github {
//                githubUrl = "https://vcs.cnsga.aws.prod.au.internal.cba/api/v3/"
//                authType = personalToken {
//                    token = "zxx59a101063d2c9c585dd657b8cdbbf474e46cc21fd5e5c4c35830598cf19b055ac3a9bfbc6efde453775d03cbe80d301b"
//                }
//            }
//            param("secure:github_password", "zxxb1d2226fa204e41cf5710bb0e551cd86775d03cbe80d301b")
//            param("github_username", "teamcity")
//        }
//    }

//    requirements {
//        startsWith("cloud.amazon.agent-name-prefix", "cns-ga-prod-oc-mgmt")
//        endsWith("cloud.amazon.agent-name-prefix", "TEAMCITY-AGENT")
//    }
})
