package screens

import NoteApplication.Companion.archives
import NoteApplication.Companion.scan
import managers.ScreenManager
import model.Archive
import screenInterface.ScreenMenu

class ScreenMainMenu : ScreenMenu {
    override val listOfItems = mutableListOf(
        "ГЛАВНОЕ МЕНЮ",
        "1 - Создать новый архив",
        "2 - Просмотреть архивы",
        "0 - Выход",
        "\nВыберите нужный пункт:"
    )

    override var currentCommand: Int = -1

    private val createArchive: () -> Unit = {
        while (true){
            println("Введите название архива или 0 что бы вернуться к предыдущему меню")
            val nameArchive = scan.nextLine()
            if (nameArchive.isBlank()) {
                println("Нельзя создать архив с пустым именем")
                continue
            } else if (nameArchive != "0") {
                archives.add(Archive(nameArchive))
                println("Архив успешно создан")
                break
            }
            break
        }
    }

    private val funcView: () -> Unit = {
        ScreenManager(ArchiveSelectScreen()).startScreen()
    }

    override val listFunction = mutableMapOf(Pair(1, createArchive), Pair(2, funcView))

    override val maxValue = listFunction.size
}
