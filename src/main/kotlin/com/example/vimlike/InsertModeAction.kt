package com.example.vimlike

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent


class InsertModeAction : AnAction() {

    override fun actionPerformed(e: AnActionEvent) {
        showNotification("inside action perform$e")

    }
}
