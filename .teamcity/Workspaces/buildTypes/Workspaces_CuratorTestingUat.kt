package Workspaces.buildTypes

import jetbrains.buildServer.configs.kotlin.v10.*
import jetbrains.buildServer.configs.kotlin.v10.buildFeatures.CommitStatusPublisher
import jetbrains.buildServer.configs.kotlin.v10.buildFeatures.CommitStatusPublisher.*
import jetbrains.buildServer.configs.kotlin.v10.buildFeatures.commitStatusPublisher
import jetbrains.buildServer.configs.kotlin.v10.buildSteps.ScriptBuildStep
import jetbrains.buildServer.configs.kotlin.v10.buildSteps.ScriptBuildStep.*
import jetbrains.buildServer.configs.kotlin.v10.buildSteps.script

object Workspaces_CuratorTestingUat : Template({
    uuid = "f92a181d-b4a8-40b5-b967-99f480f672b2"
    extId = "Workspaces_CuratorTestingUat"
    name = "curator-testing-uat"

    allowExternalStatus = true

    vcs {
        root("InfrastructureCurator_CuratorUatsRoot")

        cleanCheckout = true
    }

    steps {
        script {
            name = "Install dependencies"
            id = "RUNNER_220"
            scriptContent = """
                set -e
                
                pipenv --bare --rm || true
                pipenv --bare sync
            """.trimIndent()
        }
        script {
            name = "Run tests"
            id = "RUNNER_221"
            scriptContent = "pipenv run py.test curator_tests -v -s"
        }
    }

    features {
        commitStatusPublisher {
            id = "BUILD_EXT_28"
            publisher = github {
                githubUrl = "https://vcs.cnsga.aws.prod.au.internal.cba/api/v3"
                authType = personalToken {
                    token = "zxx28f7e6ed05e1dfa605f9db70e8fbc5ce424edf9201769c1897fdc43a1f78943690c78d678fd12a30775d03cbe80d301b"
                }
            }
        }
    }

    requirements {
        startsWith("cloud.amazon.agent-name-prefix", "cns-ga-prod-oc-mgmt", "RQ_137")
        contains("cloud.amazon.agent-name-prefix", "testing", "RQ_139")
    }
})
