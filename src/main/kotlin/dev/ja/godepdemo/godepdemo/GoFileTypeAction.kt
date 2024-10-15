package dev.ja.godepdemo.godepdemo

import com.intellij.openapi.actionSystem.ActionUpdateThread
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.fileTypes.FileTypeManager
import com.intellij.openapi.ui.Messages

class GoFileTypeAction : AnAction() {
    override fun getActionUpdateThread(): ActionUpdateThread {
        return ActionUpdateThread.BGT
    }

    override fun actionPerformed(e: AnActionEvent) {
        val fileType = FileTypeManager.getInstance().getFileTypeByExtension("go")
        Messages.showInfoMessage("File type for .go: ${fileType.name}", "Go FileType Test")
    }
}