package io.mmaltsev.vkeducation.presentation.applist

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.mmaltsev.vkeducation.presentation.theme.RuStoreBlue
import io.mmaltsev.vkeducation.presentation.theme.VkEducationTheme

private data class AppItem(
    val name: String,
    val description: String,
    val category: String,
    val iconLabel: String,
    val iconBackground: Color,
    val iconForeground: Color = Color.White,
)

private val sampleApps = listOf(
    AppItem(
        name = "VK",
        description = "Общение, музыка, видео и новости в одном приложении",
        category = "Социальные сети",
        iconLabel = "VK",
        iconBackground = Color(0xFF0077FF),
    ),
    AppItem(
        name = "Telegram",
        description = "Быстрые сообщения, звонки и большие групповые чаты",
        category = "Общение",
        iconLabel = "✈",
        iconBackground = Color(0xFF2AABEE),
    ),
    AppItem(
        name = "Яндекс Go",
        description = "Такси, аренда самокатов и доставка еды",
        category = "Транспорт",
        iconLabel = "Я",
        iconBackground = Color(0xFF222222),
    ),
    AppItem(
        name = "СберБанк Онлайн",
        description = "Переводы, платежи и управление финансами",
        category = "Финансы",
        iconLabel = "S",
        iconBackground = Color(0xFF21A038),
    ),
    AppItem(
        name = "Ozon",
        description = "Миллионы товаров с быстрой доставкой",
        category = "Покупки",
        iconLabel = "oz",
        iconBackground = Color(0xFF005BFF),
    ),
    AppItem(
        name = "Wildberries",
        description = "Одежда, электроника и товары для дома",
        category = "Покупки",
        iconLabel = "WB",
        iconBackground = Color(0xFFCB11AB),
    ),
    AppItem(
        name = "2ГИС",
        description = "Подробные карты, маршруты и организации рядом",
        category = "Карты и навигация",
        iconLabel = "2Г",
        iconBackground = Color(0xFF24A86A),
    ),
    AppItem(
        name = "VK Музыка",
        description = "Музыка, персональные рекомендации и подкасты",
        category = "Музыка и аудио",
        iconLabel = "♫",
        iconBackground = Color(0xFF8B50FF),
    ),
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppListScreen(modifier: Modifier = Modifier) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = Color(0xFFF5F7FB),
        topBar = { AppListToolbar() },
    ) { contentPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(contentPadding),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 18.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            item(key = "list_header") {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 4.dp),
                    verticalAlignment = Alignment.Bottom,
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Column {
                        Text(
                            text = "Популярные приложения",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onBackground,
                        )
                        Spacer(Modifier.height(4.dp))
                        Text(
                            text = "Подборка на каждый день",
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.65f),
                        )
                    }
                    Text(
                        text = "${sampleApps.size}",
                        modifier = Modifier
                            .clip(RoundedCornerShape(12.dp))
                            .background(Color.White)
                            .padding(horizontal = 11.dp, vertical = 6.dp),
                        color = RuStoreBlue,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.SemiBold,
                    )
                }
            }

            items(items = sampleApps, key = { it.name }) { app ->
                AppListItem(app = app)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun AppListToolbar() {
    TopAppBar(
        title = {
            Text(
                text = "Каталог приложений",
                fontWeight = FontWeight.SemiBold,
                color = Color.White,
            )
        },
        navigationIcon = {
            Box(
                modifier = Modifier
                    .padding(start = 12.dp, end = 8.dp)
                    .size(38.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color.White)
                    .semantics { contentDescription = "Иконка RuStore" },
                contentAlignment = Alignment.Center,
            ) {
                Text(
                    text = "R",
                    color = RuStoreBlue,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.ExtraBold,
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = RuStoreBlue,
            titleContentColor = Color.White,
            navigationIconContentColor = Color.White,
        ),
    )
}

@Composable
private fun AppListItem(app: AppItem) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(18.dp),
        color = Color.White,
        border = BorderStroke(1.dp, Color(0xFFE8ECF3)),
        shadowElevation = 1.dp,
    ) {
        Row(
            modifier = Modifier.padding(14.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(14.dp),
        ) {
            Box(
                modifier = Modifier
                    .size(62.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(app.iconBackground)
                    .semantics { contentDescription = "Иконка приложения ${app.name}" },
                contentAlignment = Alignment.Center,
            ) {
                Text(
                    text = app.iconLabel,
                    color = app.iconForeground,
                    fontSize = if (app.iconLabel.length > 2) 17.sp else 21.sp,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                )
            }

            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(5.dp),
            ) {
                Text(
                    text = app.name,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xFF171B24),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
                Text(
                    text = app.description,
                    style = MaterialTheme.typography.bodySmall,
                    color = Color(0xFF667085),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                )
                Surface(
                    shape = RoundedCornerShape(50),
                    color = Color(0xFFF0F4FA),
                ) {
                    Text(
                        text = app.category,
                        modifier = Modifier.padding(horizontal = 9.dp, vertical = 4.dp),
                        fontSize = 11.sp,
                        lineHeight = 14.sp,
                        color = Color(0xFF526078),
                        fontWeight = FontWeight.Medium,
                        maxLines = 1,
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun AppListScreenPreview() {
    VkEducationTheme {
        AppListScreen()
    }
}
