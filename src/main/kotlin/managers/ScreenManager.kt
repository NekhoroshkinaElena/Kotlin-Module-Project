package managers

import NoteApplication
import screenInterface.ScreenMenu

class ScreenManager<T>(private val t: T) where T : ScreenMenu {
    private var command: Int = -1

    private fun printMenu() {
        println("-------------------")
        for (i in t.listOfItems) {
            println(i)
        }
    }

    private fun readUserInput() {
        val input = NoteApplication.scan.nextLine()
        try {
            command = input.toInt()
        } catch (e: NumberFormatException) {
            println("Некорректный ввод, пожалуйста введите число.")
            return
        }
        if (command !in 0..t.maxValue) {
            println("Такой команды не существует. Пожалуйста повторите попытку.")
        }
    }

    private fun selectAction() = t.listFunction[command]?.invoke()

    fun startScreen() {
        while (true) {
            this.printMenu()
            this.readUserInput()
            if (this.command == 0) break
            t.currentCommand = command
            this.selectAction()
        }
    }
}
