package com.example.vimlike

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.editor.actionSystem.TypedAction


class EditorHandlerIllustration : AnAction() {
    init {
        //val originalHandler = TypedAction.getInstance().handler
        showNotification("Initialized")
        val typedAction = TypedAction.getInstance()
        typedAction.setupRawHandler(MyTypedActionHandler())
    }

    override fun actionPerformed(e: AnActionEvent) {
        showNotification("Vim like handler toggled.")
    }

}