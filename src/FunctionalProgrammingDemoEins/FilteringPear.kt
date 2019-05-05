package FunctionalProgrammingDemoEins

import java.util.ArrayList
import java.util.Arrays
import kotlin.Comparator


class FilteringPear {

    fun main(args: Array<String>) {

        // Simple example
        val r = { println("Hello!") }

        // Filtering with lambdas
        val inventory = Arrays.asList(Apple(80, "green"), Apple(155, "green"), Apple(120, "red"))

        // [Apple{color='green', weight=80}, Apple{color='green', weight=155}]
        val greenApples = filter(inventory, { a: Apple -> "green" == a.color })
        println(greenApples)


        val c = { a1: Apple, a2: Apple -> a1.getWeight()!!.compareTo(a2.getWeight()!!) }

        // [Apple{color='green', weight=80}, Apple{color='red', weight=120}, Apple{color='green', weight=155}]
        inventory.sortWith(Comparator(c))
        println(inventory)
    }

    fun filter(inventory: List<Apple>, p: (Apple) -> Boolean): List<Apple> {
        val result = ArrayList<Apple>()
        for (apple in inventory) {
                result.add(apple)
        }
        return result
    }

    class Apple(weight: Int, color: String) {
        private var weight = 0
        var color = ""

        init {
            this.weight = weight
            this.color = color
        }

        fun getWeight(): Int? {
            return weight
        }

        fun setWeight(weight: Int?) {
            this.weight = weight!!
        }

        override fun toString(): String {
            return "Apple{" +
                    "color='" + color + '\''.toString() +
                    ", weight=" + weight +
                    '}'.toString()
        }
    }

    interface ApplePredicate {
        fun test(a: Apple): Boolean
    }
}
