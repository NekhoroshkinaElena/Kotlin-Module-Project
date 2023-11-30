package screens

import NoteApplication.Companion.archives
import managers.ScreenManager
import model.Archive
import screenInterface.ScreenMenu

class ArchiveSelectScreen : ScreenMenu {

    override val listFunction = mutableMapOf<Int, () -> Unit>()

    override var currentCommand = -1

    override val maxValue = archives.size

    override val listOfItems = mutableListOf(
        "АРХИВЫ:",
        getListArchives(archives)
    )

    init {
        for (i in 1 until archives.size + 1) {
            listFunction[i] = {
                ScreenManager(ScreenNotesMenu(currentCommand)).startScreen()
            }
        }
    }

    private fun getListArchives(archives: List<Archive>): String {
        if (archives.isEmpty()) {
            return "Cписок архивов пуст, введите 0 для перехода к предыдущему меню"
        }
        var string = ""
        archives.forEachIndexed { index, archive ->
            string += "${index + 1} - ${archive.name}\n"
        }
        return "$string\nВведите номер архива для просмотра или 0, для перехода к предыдущему меню"
    }
}
