package com.example.vimlike

import com.intellij.ide.IdeEventQueue
import com.intellij.notification.Notification
import com.intellij.notification.NotificationType
import com.intellij.notification.Notifications
import java.awt.AWTEvent
import java.awt.event.KeyEvent
fun show(input: String) {
    val notification = Notification(
        "com.example.vimlike",
        "Vim like.",
        input,
        NotificationType.INFORMATION
    )
    Notifications.Bus.notify(notification, null)
}
class MyEventDispatcher : IdeEventQueue.EventDispatcher {
    override fun dispatch(event: AWTEvent): Boolean {
        if (event is KeyEvent) {
            show("Key event detected: ${event.keyChar}, Code: ${event.keyCode}")
            println("Key event detected: ${event.keyChar}, Code: ${event.keyCode}")
        }
        return false // Return true if you want to consume the event and prevent it from being processed further
    }
}