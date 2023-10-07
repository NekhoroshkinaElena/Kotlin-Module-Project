package model

import NoteApplication.Companion.archives

class Archive(val name: String) {
    var notes = mutableListOf<Note>()

    companion object{
        fun getArchive(numberArchive: Int): Archive {
            return archives[numberArchive - 1]
        }

        fun getNotesArchive(numberArchive: Int): List<Note> {
            return getArchive(numberArchive).notes
        }

        fun getNoteArchive(numberArchive: Int, numberNote: Int): Note {
            return getArchive(numberArchive).notes[numberNote - 1]
        }
    }
}
