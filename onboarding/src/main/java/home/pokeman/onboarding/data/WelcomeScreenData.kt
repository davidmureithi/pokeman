package home.pokeman.onboarding.data

import home.pokeman.onboarding.R

fun welcomeScreenData() = listOf(
        WelcomeScreenInfo(image = R.drawable.ic_cat, title = "Food", description = "Food"),
        WelcomeScreenInfo(image = R.drawable.ic_cat, title = "Food", description = "Food"),
        WelcomeScreenInfo(image = R.drawable.ic_cat, title = "Food", description = "Food"),
        WelcomeScreenInfo(image = R.drawable.ic_cat, title = "Food", description = "Food"),
    )

data class WelcomeScreenInfo(
    val image: Int,
    val title: String = "",
    val description: String = "",
)
