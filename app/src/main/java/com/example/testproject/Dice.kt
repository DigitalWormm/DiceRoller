class Dice (var sides:Int = 6) {
    private fun roll():Int = (1..sides).random()
    fun logAndRoll ():Int {
        val result = roll()
        println("Your $sides sided dice rolled a/an ${result}!")
        return result
    }
}