package screenInterface;

interface ScreenMenu {

    val listOfItems: MutableList<String>

    val listFunction: MutableMap<Int, () -> Unit>

    var currentCommand: Int

    val maxValue: Int
}
