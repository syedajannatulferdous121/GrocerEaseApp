import java.util.Scanner

class GrocerEase {
    private val groceryList = mutableListOf<String>()

    fun addGroceryItem(item: String) {
        groceryList.add(item)
    }

    fun removeGroceryItem(item: String) {
        groceryList.remove(item)
    }

    fun displayGroceryList() {
        println("Grocery List:")
        for (item in groceryList) {
            println("- $item")
        }
    }

    fun clearGroceryList() {
        groceryList.clear()
        println("Grocery List cleared.")
    }

    fun searchItem(item: String): Boolean {
        return groceryList.contains(item)
    }

    fun countItems(): Int {
        return groceryList.size
    }

    fun sortGroceryList() {
        groceryList.sort()
        println("Grocery List sorted.")
    }

    fun editGroceryItem(oldItem: String, newItem: String) {
        val index = groceryList.indexOf(oldItem)
        if (index != -1) {
            groceryList[index] = newItem
            println("Item edited successfully.")
        } else {
            println("Item not found in the grocery list.")
        }
    }
}

fun main() {
    val scanner = Scanner(System.`in`)
    val grocerEase = GrocerEase()

    while (true) {
        println("GrocerEase - Grocery Shopping and List Management App")
        println("1. Add item to grocery list")
        println("2. Remove item from grocery list")
        println("3. Display grocery list")
        println("4. Clear grocery list")
        println("5. Search item in grocery list")
        println("6. Count items in grocery list")
        println("7. Sort grocery list")
        println("8. Edit grocery item")
        println("0. Exit")

        print("Enter your choice: ")
        val choice = scanner.nextInt()
        scanner.nextLine() // Clear the newline character from the input

        when (choice) {
            1 -> {
                print("Enter item to add: ")
                val item = scanner.nextLine()
                grocerEase.addGroceryItem(item)
                println("Item added to the grocery list.")
            }
            2 -> {
                print("Enter item to remove: ")
                val item = scanner.nextLine()
                grocerEase.removeGroceryItem(item)
                println("Item removed from the grocery list.")
            }
            3 -> grocerEase.displayGroceryList()
            4 -> {
                grocerEase.clearGroceryList()
            }
            5 -> {
                print("Enter item to search: ")
                val item = scanner.nextLine()
                val found = grocerEase.searchItem(item)
                if (found) {
                    println("Item '$item' found in the grocery list.")
                } else {
                    println("Item '$item' not found in the grocery list.")
                }
            }
            6 -> {
                val itemCount = grocerEase.countItems()
                println("Total items in the grocery list: $itemCount")
            }
            7 -> {
                grocerEase.sortGroceryList()
            }
            8 -> {
                print("Enter item to edit: ")
                val oldItem = scanner.nextLine()
                print("Enter new item: ")
                val newItem = scanner.nextLine()
                grocerEase.editGroceryItem(oldItem, newItem)
            }
            0 -> {
                println("Exiting GrocerEase. Have a great day!")
                return
            }
            else -> println("Invalid choice. Please try again.")
        }

        println()
    }
}
