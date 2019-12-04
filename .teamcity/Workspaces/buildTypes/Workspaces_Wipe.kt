package Workspaces.buildTypes

import jetbrains.buildServer.configs.kotlin.v10.*
import jetbrains.buildServer.configs.kotlin.v10.buildSteps.ExecBuildStep
import jetbrains.buildServer.configs.kotlin.v10.buildSteps.ExecBuildStep.*
import jetbrains.buildServer.configs.kotlin.v10.buildSteps.ScriptBuildStep
import jetbrains.buildServer.configs.kotlin.v10.buildSteps.ScriptBuildStep.*
import jetbrains.buildServer.configs.kotlin.v10.buildSteps.exec
import jetbrains.buildServer.configs.kotlin.v10.buildSteps.script

object Workspaces_Wipe : Template({
    uuid = "f283d0ee-b558-49db-9992-133a44a55755"
    extId = "Workspaces_Wipe"
    name = "wipe"

    allowExternalStatus = true
    artifactRules = "inventory.log"

    params {
        param("env.workspace_repo_name", "%env.workspace_name%")
    }

    vcs {
        root("HttpsVcsCnsgaAwsProdAuInternalCbaCnsAnsibleAwsAccountWipeOutGit")

        cleanCheckout = true
    }

    steps {
        exec {
            name = "Install role dependencies and run playbook"
            id = "RUNNER_215"
            enabled = false
            path = "launch.sh"
        }
        script {
            id = "RUNNER_225"
            scriptContent = """
                ansible-galaxy install -c -f -p workspace/roles -r workspace/requirements.yml
                ansible-playbook -i workspace/roles/ansible-workspace-config/inventory playbook.yml -e wipe_hosts=${'$'}workspace_name -vvv
            """.trimIndent()
        }
    }
})
