package Workspaces_Canary_Canary2.vcsRoots

import jetbrains.buildServer.configs.kotlin.v10.*
import jetbrains.buildServer.configs.kotlin.v10.vcs.GitVcsRoot

object Vcs_Workspaces_Canary_Canary2_CbaANp0900044othNpdCanary1 : GitVcsRoot({
    uuid = "cec2f683-6a0d-4cb3-a80f-a3ce570b2345"
    extId = "Workspaces_Canary_Canary2_CbaANp0900044othNpdCanary1"
    name = "cba-a-np-0900044-oth-npd-canary_1"
    pollInterval = 60
    url = "https://github.com/verinderpb/cba_nonp_mgmt_canary_2.git"
    branchSpec = "+:refs/heads/*"
    authMethod = password {
        userName = "verinderpb"
        password = "credentialsJSON:92628d2f-abdf-4b4b-9066-dab7a0650293"
    }
})
