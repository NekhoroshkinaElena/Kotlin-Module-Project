package screens

import managers.ScreenManager
import model.Archive.Companion.getArchive
import model.Archive.Companion.getNotesArchive
import model.Note
import screenInterface.ScreenMenu

class NoteSelectScreen(private val numberArchive: Int) : ScreenMenu {

    override val listFunction = mutableMapOf<Int, () -> Unit>()

    private val listNotes = getListNotes(getNotesArchive(numberArchive))

    override val listOfItems = mutableListOf(
        "ЗАМЕТКИ:",
        listNotes
    )

    override var currentCommand = -1

    override val maxValue = getNotesArchive(numberArchive).size

    private fun getListNotes(notes: List<Note>): String {
        var string = ""
        notes.forEachIndexed { index, note -> string += "${index + 1} - ${note.noteName}\n" }
        if (notes.isEmpty()) {
            return "Cписок заметок пуст, введите 0 для перехода к предыдущему меню "
        }
        string += "\nВведите номер заметки или 0 для перехода в предыдущее меню"
        return string
    }

    init {
        val funMake: () -> Unit = {
            ScreenManager(ScreenNote(currentCommand, numberArchive)).startScreen()
        }
        val archive = getArchive(numberArchive)
        val notes = archive.notes
        var count = 1
        for (i in notes) {
            listFunction[count] = funMake
            count++
        }
    }
}
