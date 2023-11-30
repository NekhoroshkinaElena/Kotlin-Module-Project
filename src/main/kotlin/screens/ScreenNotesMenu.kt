package screens

import NoteApplication.Companion.scan
import managers.ScreenManager
import model.Archive.Companion.getArchive
import model.Note
import screenInterface.ScreenMenu

class ScreenNotesMenu(private val numberArchive: Int) : ScreenMenu {
    override val listOfItems = mutableListOf(
        "АРХИВ ${getArchive(numberArchive).name}",
        "1 - Создать новую заметку",
        "2 - Просмотреть заметки",
        "0 - Назад",
        "\nВыберите нужный пункт:"
    )

    private val funcCreate: () -> Unit = {
        while (true) {
            println("Введите название заметки или 0 для перехода к предыдущему меню")
            val nameNote = scan.nextLine()
            if (nameNote == "0") {
                println("Заметка не создана, возвращаемся к предыдущему меню")
                break
            }
            if (nameNote.isBlank()) {
                println("Название не может быть пустым")
                continue
            }
            while (true) {
                println(
                    "Введите описание заметки или 0 что бы отменить создание заметки " +
                            "и вернуться в предыдущее меню"
                )
                val contentNote = scan.nextLine()
                if (contentNote == "0") {
                    println("Заметка не создана, возвращаемся к предыдущему меню")
                    break
                }
                if (contentNote.isBlank()) {
                    println("Содержание заметки не может быть пустым")
                    continue
                }
                getArchive(numberArchive).notes.add(Note(nameNote, contentNote))
                println("Заметка успешно создана")
                break
            }
            break
        }
    }

    private val funView: () -> Unit = {
        ScreenManager(NoteSelectScreen(numberArchive)).startScreen()
    }

    override val listFunction = mutableMapOf(Pair(1, funcCreate), Pair(2, funView))
    override var currentCommand: Int = -1
    override val maxValue = listFunction.size
}
