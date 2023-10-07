package model

data class Note(val noteName: String, var content: String) {
    override fun toString(): String {
        return "Название - '$noteName'\nСодержание - '$content')"
    }
}
