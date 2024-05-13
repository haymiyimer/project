package net.ezra.ui.about

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import net.ezra.R
import net.ezra.navigation.ROUTE_ABOUT
import net.ezra.navigation.ROUTE_ADD_PRODUCT
import net.ezra.navigation.ROUTE_HOME



@Composable
fun AboutScreen(navController: NavHostController) {



        Column(modifier = Modifier.background(Color(0xffefdecd))) {
            LazyColumn {
                item {
                Text(
                text = "About Yamral Fashion Store\n" +
                        "\n" +
                        "Yamral Fashion  is more than just a clothing store; it's a reflection of our passion for style, quality, and individuality. Founded in 2024, we set out with a vision to redefine fashion, offering unique and trendy pieces that empower our customers to express themselves.\n" +
                        "\n" +
                        "Our Story\n" +
                        "\n" +
                        "Yamral's journey began in Nairobi, where we saw a gap in the market for fashion that is both stylish and affordable. Fuelled by a desire to make a difference, we embarked on a mission to curate a collection that celebrates diversity, embraces creativity, and inspires confidence.\n" +
                        "\n" +
                        "Our Values\n" +
                        "\n" +
                        "At Yamral Fashion, our values are at the heart of everything we do. We believe in:\n" +
                        "\n" +
                        "Quality: Every piece is carefully selected for its craftsmanship and durability.\n" +
                        "Style: Our collection is curated to be on-trend, yet timeless, ensuring you look and feel your best.\n" +
                        "Sustainability: We are committed to reducing our environmental impact by sourcing ethically and supporting sustainable practices in the fashion industry.\n" +
                        "Our Mission\n" +
                        "\n" +
                        "Our mission is simple: to provide our customers with an exceptional shopping experience. We strive to offer the latest styles, superior quality, and unparalleled customer service, ensuring that every purchase with us is a positive and memorable one.\n" +
                        "\n" +
                        "Thank you for choosing Yamral Fashion Store. Join us in celebrating fashion, individuality, and style.  "
            )



            FloatingActionButton(
                onClick = {
                    navController.navigate(ROUTE_HOME) {
                        popUpTo(ROUTE_ABOUT) { inclusive = true }
                    }

                }, backgroundColor = Color(0xfF3c341f),
                contentColor = Color.White
            )
            {

                Icon(
                    imageVector = Icons.Filled.Home,
                    contentDescription = null,
                    tint = Color.White
                )

            }
        }

    }
}}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun HomeScreenPreviewLight() {
    AboutScreen(rememberNavController())
}

