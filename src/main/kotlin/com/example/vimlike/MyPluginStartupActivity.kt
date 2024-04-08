package com.example.vimlike

import com.intellij.ide.IdeEventQueue
import com.intellij.openapi.project.Project
import com.intellij.openapi.startup.StartupActivity

class MyPluginStartupActivity : StartupActivity.DumbAware {
    override fun runActivity(project: Project) {

        IdeEventQueue.getInstance().addDispatcher(MyEventDispatcher(), project)

    }
}