package com.example.a30days

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var recipeAdapter: RecipeAdapter
    private lateinit var recipeList: List<Recipt>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val recipeList = listOf(
            Recipt("Day 1", "Broccoli & Tofu Curry", R.drawable.recipe_day1, "creamy curry stew of tofu and broccoli, served with rice. The rich curry sauce and tofu complement each other perfectly, making this a simple and delicious dish suitable for vegetarians."),
            Recipt("Day 2", "Caramelized Shallots", R.drawable.recipe_day2, "Caramelized shallots paired with fresh parsley are simple yet delicious. They are suitable as an appetizer or side dish, and the taste is sweet but not greasy."),
            Recipt("Day 3", "Roasted Carrots with Eggplant", R.drawable.recipe_day3, "Roasted carrots and eggplant with spices make a refreshing vegetarian side dish. The simple cooking method allows the original flavor of the ingredients to be revealed."),
            Recipt("Day 4", "Guacamole Bowl", R.drawable.recipe_day4, "This vibrant, healthy bowl is filled with crispy tortilla chips, fresh guacamole, chili flakes, and baby spinach leaves. It's a great light snack or lunch option, and it's enhanced with just the right amount of dressing."),
            Recipt("Day 5", "Chickpea & Rice BowlA", R.drawable.recipe_day5, "hearty blend of chicken, chickpeas and basmati rice. Served with crispy bread and fresh cilantro, it's a satisfying, refreshing option for lunch or dinner."),
            Recipt("Day 6", "Roasted Cauliflower with Tahini Sauce", R.drawable.recipe_day6, "The whole roasted cauliflower is paired with a rich tahini sauce and sprinkled with pomegranate seeds, presenting a delicate color and flavor. A vegetarian main dish, it is enriched with nuts and spices."),
            Recipt("Day 7", "Baked Sweet PotatoesEasy", R.drawable.recipe_day7, "and healthy baked sweet potato fries seasoned with herbs and salt are crispy on the outside and tender on the inside. A quick and delicious side dish or snack that goes great with any meal."),
            Recipt("Day 8", "Shrimp Penne Pasta", R.drawable.recipe_day8, "This Italian-style pasta dish is topped with shrimp and cherry tomatoes and garnished with basil leaves. Simple yet sophisticated, perfect for dinner, it can be prepared in 15 minutes."),
            Recipt("Day 9", "Chocolate Covered Biscuits", R.drawable.recipe_day9, "These crispy biscuits are coated with chocolate and can be filled with strawberry jam or other flavors. The chocolate shell becomes richer after baking and is a very popular dessert."),
            Recipt("Day 10", "Veggie Protein Bowl", R.drawable.recipe_day10, "This dish includes beans, olives, mushrooms, chicken and rice, served with green sauce and sun-dried tomatoes. It is suitable for diners who like a light and healthy meal."),
            Recipt("Day 11", "Roasted Butternut SquashSimply", R.drawable.recipe_day11, "roasted butternut squash, with herbs and a pinch of salt, is crispy on the outside and tender on the inside, perfect as a side dish to a main course or as a healthy snack."),
            Recipt("Day 12", "Homemade Pickled Tomatoes", R.drawable.recipe_day12, "This homemade pickled tomato is sweet and sour and delicious. It is suitable for salads, sandwiches or as a snack. It retains the freshness and crispness of the tomato."),
            Recipt("Day 13", "Sesame Glazed Salmon SaladSesame", R.drawable.recipe_day13, "glazed salmon is served with fresh vegetable salad, cucumber and orange slices. The refreshing taste blends perfectly with the rich flavor of salmon, making it a healthy dinner choice."),
            Recipt("Day 14", "Shrimp Penne with Cherry Tomatoes Shrimp Penne", R.drawable.recipe_day14, "with Cherry Tomatoes is topped with fresh cherry tomatoes and basil leaves. It has a refreshing and delicious taste and is suitable as a quick and nutritious dinner."),
            Recipt("Day 15", "Grilled Pork Chop with Roasted Potatoes", R.drawable.recipe_day15, "Grilled pork chop with crispy baby potatoes and cherry tomatoes is a classic dinner choice. Rosemary adds a fresh flavor, and the perfectly grilled pork chop pairs well with the simple side dish."),
            Recipt("Day 16", "Mixed Berry Galette", R.drawable.recipe_day16, "This country-style mixed berry galette has a crispy crust and a sweet and sour filling. Served with ice cream or cream, it's the perfect dessert for dessert lovers."),
            Recipt("Day 17", "Lentil Soup with HerbsThis", R.drawable.recipe_day17, "hearty lentil soup sprinkled with fresh herbs and nuts is a hearty vegetarian dish that's healthy, delicious, and perfect for cold weather."),
            Recipt("Day 18", "Baked Vegetable LasagnaThis", R.drawable.recipe_day18, "vegetable lasagna is layered with healthy vegetable fillings and cheese and baked until golden for a hearty main dish perfect for the whole family to share."),
            Recipt("Day 19", "Pistachio Chocolate Chip Cookies", R.drawable.recipe_day19, "Cookies with pistachios and chocolate chips are crispy on the outside and soft on the inside. Every bite is full of the aroma of nuts and chocolate. They are a very popular snack."),
            Recipt("Day 20", "Zucchini Rice Bowl with Soft-Boiled Eggs", R.drawable.recipe_day20, "This rice bowl with soft-boiled eggs and sautéed zucchini, served with fresh cilantro, is a light and healthy lunch option that's rich in protein and vitamins."),
            Recipt("Day 21", "Assorted Pastries", R.drawable.recipe_day21, "These various French pastries, including caramel puff pastry, chocolate croissant and brioche, are crispy on the outside and soft on the inside, sweet but not greasy, and are suitable as a morning or afternoon snack."),
            Recipt("Day 22", "Classic Spaghetti BologneseClassic", R.drawable.recipe_day22, "spaghetti bolognese, with a rich beef tomato sauce and cheese sprinkled on top, is simple yet satisfying and a popular family dinner choice."),
            Recipt("Day 23", "Fruit & Nut Toasts", R.drawable.recipe_day23, "Two slices of toast, topped with banana, hazelnut spread and blackberries, cream cheese, and sprinkled with chopped nuts, is a healthy breakfast or snack choice that is both delicious and nutritious."),
            Recipt("Day 24", "Lemon Roasted Chicken with Vegetables", R.drawable.recipe_day24, "Lemon roasted chicken is served with carrots, onions and pomegranates. After a long period of roasting, the meat is tender and juicy, and the vegetables have also absorbed the rich flavor of the chicken juice. It is very suitable for family gatherings."),
            Recipt("Day 25", "Chickpea & Pistachio Curry", R.drawable.recipe_day25, "Rich yet mild in flavor, this chickpea curry with crispy pistachios and rice is an ideal vegetarian meal that’s nutritious and easy to make."),
            Recipt("Day 26", "Chocolate Glazed Donuts", R.drawable.recipe_day26, "These chocolate-glazed donuts are decorated with dried fruits and sprinkles. They are smooth on the outside and soft on the inside. Every bite is full of chocolate flavor, making them an ideal dessert choice."),
            Recipt("Day 27", "Strawberry Shortcake", R.drawable.recipe_day27, "This strawberry shortcake, with its layers of puff pastry, fresh strawberries and sweet cream, is a classic dessert with a refreshing and non-greasy taste."),
            Recipt("Day 28", "Margherita Pizza", R.drawable.recipe_day28, "The classic Margherita pizza is topped with melted mozzarella cheese, fresh tomatoes and basil leaves. It has a soft texture and rich flavor, making it an authentic Italian-style pizza."),
            Recipt("Day 29", "Mexican Bean Salad", R.drawable.recipe_day29, "Refreshing Mexican bean salad with red onion, cherry tomatoes, cilantro and corn is a light summer salad perfect as a main course or side dish."),
            Recipt("Day 30", "Full Breakfast with Eggs & Pancakes", R.drawable.recipe_day30, "This hearty breakfast includes fried eggs, bacon, pancakes, and an oatmeal fruit bowl. Paired with hot coffee or cocoa, it's the perfect way to start the day."),
        )

        recipeAdapter = RecipeAdapter(recipeList)
        recyclerView.adapter = recipeAdapter

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}