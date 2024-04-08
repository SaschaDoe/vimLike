package com.example.vimlike

import com.intellij.notification.Notification
import com.intellij.notification.NotificationType
import com.intellij.notification.Notifications
import com.intellij.openapi.actionSystem.DataContext
import com.intellij.openapi.command.WriteCommandAction
import com.intellij.openapi.editor.Document
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.editor.actionSystem.TypedActionHandler
import org.jetbrains.annotations.NotNull


fun showNotification(input: String) {
    val notification = Notification(
        "com.example.vimlike",
        "Vim like.",
        input,
        NotificationType.INFORMATION
    )
    Notifications.Bus.notify(notification, null)
}

class MyTypedActionHandler() : TypedActionHandler {
    private var isNormalMode = true
    private val chars: MutableList<Char> = mutableListOf()

    override fun execute(
        @NotNull editor: Editor,
        c: Char,
        @NotNull dataContext: DataContext
    ) {

        if(isNormalMode){
            if(c == 'i'){
                isNormalMode = false
                showNotification("insert mode")
                chars.clear()
            }else{
                addToChars(c)
                showNotification(chars.toString())
            }

        }else{

            addToChars(c)
            if(isInsertModeExit()){
                showNotification("normal mode")
                isNormalMode = true
                chars.clear()

            }else{
                val document: Document = editor.document
                val project = editor.project
                WriteCommandAction.runWriteCommandAction(project) {
                    // Iterate over all carets (supporting multiple cursors)
                    editor.caretModel.runForEachCaret { caret ->
                        val pos = caret.offset
                        document.insertString(pos, c.toString())
                        // Move caret to the right after insertion
                        caret.moveToOffset(pos + 1)
                    }
                }

            }

        }
    }

    private fun addToChars(c: Char){
        if(chars.count() == 10){
            chars.clear()
        }else{
            chars.add(c)
        }
    }

    private fun isInsertModeExit(): Boolean {
        return chars.takeLast(2) == listOf('j', 'k')
    }

}
