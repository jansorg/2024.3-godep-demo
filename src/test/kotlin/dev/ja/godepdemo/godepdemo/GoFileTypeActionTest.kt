package dev.ja.godepdemo.godepdemo

import com.goide.GoFileType
import com.intellij.openapi.fileTypes.FileTypeManager
import com.intellij.testFramework.fixtures.LightPlatformCodeInsightFixture4TestCase
import org.junit.Test

class GoFileTypeActionTest : LightPlatformCodeInsightFixture4TestCase() {
    @Test
    fun goFileType() {
        assertEquals("Go", GoFileType.INSTANCE.name)

        assertEquals(GoFileType.INSTANCE, FileTypeManager.getInstance().getFileTypeByExtension("go"))
        assertEquals(GoFileType.INSTANCE, FileTypeManager.getInstance().getFileTypeByFileName("_.go"))

        val file = myFixture.createFile("_.go", "")
        assertEquals(GoFileType.INSTANCE, file.fileType)
    }
}