package com.example.vimlike

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CommonDataKeys
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.editor.actionSystem.TypedAction
import com.intellij.openapi.project.Project
import org.jetbrains.annotations.NotNull


class EditorHandlerIllustration : AnAction() {
    init {
        //val originalHandler = TypedAction.getInstance().handler
        showNotification("Initialized")
        val typedAction = TypedAction.getInstance()
        typedAction.setupRawHandler(MyTypedActionHandler())


    }

    override fun actionPerformed(@NotNull e: AnActionEvent) {
        val editor: Editor = e.getRequiredData(CommonDataKeys.EDITOR)
        val project: Project? = e.project

        if (editor == null || project == null) {
            // Handle the case where there's no active editor or project
            return
        }


    }

}