package Workspaces_Canary_Canary2.vcsRoots

import jetbrains.buildServer.configs.kotlin.v10.*
import jetbrains.buildServer.configs.kotlin.v10.vcs.GitVcsRoot

object Workspaces_Canary_Canary2_CbaACl0900034othLabCanary11 : GitVcsRoot({
    uuid = "e7a67298-7c83-410a-9fbd-529ee8fd8ded"
    extId = "Workspaces_Canary_Canary2_CbaACl0900034othLabCanary11"
    name = "cba-a-cl-0900034-oth-lab-canary_11"
    pollInterval = 60
    url = "https://github.com/verinderpb/cba_clab_mgmt_canary_2.git"
    branchSpec = "+:refs/heads/*"
    authMethod = password {
        userName = "verinderpb"
        password = "credentialsJSON:92628d2f-abdf-4b4b-9066-dab7a0650293"
    }
})
