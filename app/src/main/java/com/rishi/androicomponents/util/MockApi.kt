package com.rishi.androicomponents.util

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch

object MockApi {
    fun hitApi(scope: CoroutineScope, updateNotification: (String) -> Unit) {
        scope.launch {
            while (isActive) {
                val data = fetchMockData()
                delay(4000)
                updateNotification(data)
            }
        }
    }

    private fun fetchMockData(): String {
        val list = listOf(
            "Apple", "Banana", "Cherry", "Date", "Elderberry",
            "Fig", "Grapes", "Honeydew", "Iced-Tea", "Jackfruit",
            "Kiwi", "Lemon", "Mango", "Nectarine", "Orange",
            "Papaya", "Quince", "Raspberry", "Strawberry", "Tomato",
            "Ugli Fruit", "Vanilla Bean", "Watermelon", "Xigua", "Yellow Passion Fruit",
            "Zucchini", "Avocado", "Blackberry", "Cantaloupe", "Dragon Fruit",
            "Elderberry", "Feijoa", "Guava", "Huckleberry", "Indian Fig",
            "Jujube", "Kumquat", "Lime", "Mulberry", "Nance",
            "Olive", "Pineapple", "Rambutan", "Salak", "Tamarind",
            "Uva", "Velvet Apple", "Wolfberry", "Ximenia", "Yamamomo",
            "Ziziphus", "Longan", "Lychee", "Persimmon", "Pitaya",
            "Pomegranate", "Starfruit", "Passionfruit", "Cranberry", "Coconut"
        )
        return list.random()
    }
}