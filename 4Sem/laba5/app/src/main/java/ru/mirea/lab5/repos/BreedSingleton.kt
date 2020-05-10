package ru.mirea.lab5.repos

import ru.mirea.lab5.model.BreedJsonModel
import java.util.*

class BreedSingleton {

    private var breeds: List<BreedJsonModel>? = null
    private fun setBreeds(breeds: List<BreedJsonModel>) {
        this.breeds = breeds
    }

    fun getBreedId(name: String): String {
        for (breed in breeds!!) {
            if (breed.name === name) {
                return breed.id
            }
        }
        return ""
    }

    val breedNames: List<String>
        get() {
            val names: MutableList<String> =
                LinkedList()
            for (breed in breeds!!) {
                names.add(breed.name)
            }
            return names
        }

    fun setBreed(name: String) {
        for (breed in breeds!!) {
            if (breed.name === name) {
                setCurrentBreed(breed)
            }
        }
    }

    companion object {
        var instance: BreedSingleton? = null
            private set
        private var currentBreed: BreedJsonModel? = null
        fun createInstance(breeds: List<BreedJsonModel>): BreedSingleton? {
            if (instance == null) {
                instance = BreedSingleton()
                instance!!.setBreeds(breeds)
            }
            return instance
        }

        fun setCurrentBreed(breed: BreedJsonModel?) {
            currentBreed = breed
        }
    }
}
