package com.example.lab5

import android.os.Parcel
import android.os.Parcelable

/**
 *   Created by Alexandr Cruglov
 *           6/4/19
 *
 */
data class Recipe(

        val name: String,
        val persons: Int,
        val images: List<String>,
        val ingredients: List<String>,
        val description: String,
        val time: String
): Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readInt(),
            parcel.createStringArrayList(),
            parcel.createStringArrayList(),
            parcel.readString(),
            parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeInt(persons)
        parcel.writeStringList(images)
        parcel.writeStringList(ingredients)
        parcel.writeString(description)
        parcel.writeString(time)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Recipe> {
        override fun createFromParcel(parcel: Parcel): Recipe {
            return Recipe(parcel)
        }

        override fun newArray(size: Int): Array<Recipe?> {
            return arrayOfNulls(size)
        }
    }
}


interface DataProvider<Data>{

    fun provider(): Data
}

class RecipeDataProvider : DataProvider<List<Recipe>>{

    override fun provider()= listOf(
            Recipe(
                    name = "First Dish",
                    persons = 3,
                    images = listOf(
                            "https://storage.commerage.ru/cache/780/585/85/crop/center/6/Ng1q_LaiZKodyxMcNsyiwEaVcRj0kcs6.jpg",
                            "https://www.gastronom.ru/binfiles/images/20170221/b7e3e0c9.jpg"
                    ),
                    description = "\n" +
                            "Из муки, молока, яйца и соли замесить довольно крутое тесто. Поставить в тихое место на часик. " +
                            "Пока тесто стоит в сторонке, на медленном огне потушить в глубокой сковороде очень мелко нарубленную капусту " +
                            "(без добавления масла и воды) до желтоватого цвета. Тушить непрерывно помешивая, не давая поджариться " +
                            "(иначе будет горчить)! Примерно процесс займёт минут 30.",
                    ingredients = listOf(
                            "Мука пшеничная - 1,5 стакана",
                            "Молоко - 0,5 стакана",
                            "Яйцо - 1 ш"
                    ),
                    time = "30 min"
            ),
            Recipe(
                    name = "Second Dish",
                    persons = 2,
                    images = listOf(
                            "https://s15.stc.all.kpcdn.net/share/i/12/10608869/inx960x640.jpg",
                            "https://ichef.bbci.co.uk/news/660/cpsprodpb/41F7/production/_105278861_gettyimages-855098134.jpg"
                    ),
                    description = "Пока тесто стоит в сторонке, на медленном огне потушить в глубокой сковороде очень мелко нарубленную капусту",
                    ingredients = listOf(
                            "Яйцо - 1 ш",
                            "Мука пшеничная - 1,5 стакана"
                    ),
                    time = "20 min"
            )
    )

}