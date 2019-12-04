package Workspaces.buildTypes

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

object Workspaces_BuildVerificationTesting : Template({
    uuid = "29371359-11da-483e-8b9c-de6d64a59821"
    extId = "Workspaces_BuildVerificationTesting"
    name = "build-verification-testing"

    allowExternalStatus = true
    artifactRules = """
        report.xml
        report.html
        inventory.log
    """.trimIndent()

    params {
        param("env.BUILD_NUMBER", "%build.number%")
    }

    vcs {
        root("Workspaces_Preview_Test_CbaACl0737249isTstPreviewTest_Tests_BuildVerificationTes")

        cleanCheckout = true
    }

    steps {
        script {
            name = "Install dependencies"
            id = "RUNNER_216"
            scriptContent = """
                set -e
                
                #pipenv --bare --rm || true
                pipenv --bare sync
            """.trimIndent()
        }
        script {
            name = "Run tests"
            id = "RUNNER_217"
            scriptContent = """
                pipenv run py.test --create-instances tests/processes
                #pipenv run py.test --runslow tests/bootstrap -m rhel
                #--runslow tests/ami tests/dns tests/processes tests/proxy tests/ssh tests/bootstrap
                #pipenv run py.test --runslow tests/ami tests/dns tests/processes tests/proxy tests/ssh
                #--runslow tests/bootstrap
            """.trimIndent()
        }
        script {
            name = "Terminate created resources"
            id = "RUNNER_218"
            executionMode = BuildStep.ExecutionMode.RUN_ON_FAILURE
            scriptContent = "pipenv run cleanup"
        }
    }

    triggers {
        vcs {
            id = "vcsTrigger"
            branchFilter = "+:<default>"
            watchChangesInDependencies = true
        }
    }

    failureConditions {
        javaCrash = false
        errorMessage = true
    }

    features {
        commitStatusPublisher {
            id = "BUILD_EXT_29"
            publisher = github {
                githubUrl = "https://vcs.cnsga.aws.prod.au.internal.cba/api/v3"
                authType = personalToken {
                    token = "zxx59a101063d2c9c585dd657b8cdbbf474e46cc21fd5e5c4c35830598cf19b055ac3a9bfbc6efde453775d03cbe80d301b"
                }
            }
        }
    }

    requirements {
        contains("cloud.amazon.agent-name-prefix", "testing", "RQ_115")
        startsWith("cloud.amazon.agent-name-prefix", "cns-ga-prod-oc-mgmt", "RQ_119")
    }
})
