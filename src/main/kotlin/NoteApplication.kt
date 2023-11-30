import managers.ScreenManager
import model.Archive
import screens.ScreenMainMenu
import java.util.*

class NoteApplication {
    companion object {
        val archives: MutableList<Archive> = mutableListOf()
        val scan = Scanner(System.`in`)
    }

    fun startApplication() {
        ScreenManager(ScreenMainMenu()).startScreen()
        scan.close()
    }
}
