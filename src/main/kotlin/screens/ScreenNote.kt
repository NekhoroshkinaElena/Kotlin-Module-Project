package screens

import NoteApplication.Companion.scan
import model.Archive.Companion.getNoteArchive
import screenInterface.ScreenMenu

class ScreenNote(currentNote: Int, currentArchive: Int) : ScreenMenu {
    private val note = getNoteArchive(currentArchive, currentNote)

    override var currentCommand: Int = -1

    override val listOfItems = mutableListOf(
        "ЗАМЕТКА - ${getNoteArchive(currentArchive, currentNote).noteName}",
        "1 - Просмотреть",
        "2 - Изменить текст",
        "0 - Назад",
        "\nВыберите нужный пункт:"
    )

    private val funcShow: () -> Unit = {
        while (true) {
            println(note)
            println("Для перехода к предыдущему меню введите 0")
            if (scan.nextLine() == "0") {
                break
            }
        }
    }

    private val updateNote: () -> Unit = {
        while (true){
            println("Введите текст для изменения или 0 для перехода к предыдущему меню")
            val input = scan.nextLine()
            if (input.isBlank()) {
                println("Текст не может быть пустым")
                continue
            } else if (input != "0") {
                note.content = input
                println("Текст заметки изменён")
                break
            }
            break
        }
    }

    override val listFunction = mutableMapOf(Pair(1, funcShow), Pair(2, updateNote))

    override val maxValue = listFunction.size
}
