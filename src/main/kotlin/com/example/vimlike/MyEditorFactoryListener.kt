package com.example.vimlike

import com.intellij.openapi.editor.event.EditorFactoryEvent
import com.intellij.openapi.editor.event.EditorFactoryListener
import org.jetbrains.annotations.NotNull
import java.awt.event.KeyAdapter
import java.awt.event.KeyEvent


class MyEditorFactoryListener : EditorFactoryListener {
    override fun editorCreated(@NotNull event: EditorFactoryEvent) {
        val editor = event.editor
        editor.contentComponent.addKeyListener(object : KeyAdapter() {
            override fun keyPressed(e: KeyEvent) {
                // Handle key press events for all keys
                println("Key Pressed: " + KeyEvent.getKeyText(e.keyCode))
                showNotification("Key Pressed: " + KeyEvent.getKeyText(e.keyCode))
            }
        })
    }

    override fun editorReleased(@NotNull event: EditorFactoryEvent) {
        val editor = event.editor
        // Clean up listener if necessary
        for (kl in editor.contentComponent.keyListeners) {
            editor.contentComponent.removeKeyListener(kl)
        }
    }
}
