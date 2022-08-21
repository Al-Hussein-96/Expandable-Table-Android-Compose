package com.alhussein.library


import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.selection.triStateToggleable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.alhussein.library.model.Group

data class CustomBorder(
    val top: Boolean = false,
    val left: Boolean = false,
    val right: Boolean = false,
    val bottom: Boolean = false
)


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ExpandableTable(group: Group) {
    var expanded by remember {
        mutableStateOf(false)
    }

    val onExpandClicked = {
        expanded = !expanded
    }


    LazyColumn(
        Modifier
            .padding(16.dp)
            .border(width = 1.dp, color = Color.LightGray)
    ) {

        stickyHeader {
            TableRow(
                border = CustomBorder(
                    bottom = true
                ),
                modifier = Modifier.clickable(onClick = onExpandClicked),
                content = {
                    Text(
                        text = group.title,
                        modifier = Modifier
                            .weight(1f)
                            .align(Alignment.CenterVertically),
                        textAlign = TextAlign.Center
                    )
                    IconButton(
                        onClick = onExpandClicked
                    ) {
                        Icon(
                            imageVector = if (expanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                            null
                        )
                    }
                }
            )

        }
        if (expanded)
            items(group.rows) { item ->
                Row {
                    TableCell(
                        text = item.id.toString(),
                        modifier = Modifier.weight(.7f),
                        border = CustomBorder(
                            right = true,
                            bottom = true
                        )
                    )
                    TableCell(
                        text = item.name,
                        modifier = Modifier.weight(.7f),
                        border = CustomBorder(bottom = true)
                    )
                }
            }
    }


}

@Composable
fun LazyItemScope.TableRow(
    content: @Composable RowScope.() -> Unit,
    modifier: Modifier = Modifier,
    border: CustomBorder = CustomBorder()
) {
    val modifier1 = if (border.top) {
        Modifier.drawBehind {
            val strokeWidth = 1 * density
            val y = -strokeWidth / 2

            drawLine(
                Color.LightGray,
                Offset(0f, y),
                Offset(size.width, y),
                strokeWidth
            )
        }
    } else Modifier

    val modifier2 = if (border.bottom) {
        Modifier.drawBehind {
            val strokeWidth = 1 * density
            val y = size.height - strokeWidth / 2

            drawLine(
                Color.LightGray,
                Offset(0f, y),
                Offset(size.width, y),
                strokeWidth
            )
        }
    } else Modifier

    val modifier3 = if (border.right) {
        Modifier.drawBehind {
            val strokeWidth = 1 * density
            val x = size.width - strokeWidth / 2

            drawLine(
                Color.LightGray,
                Offset(x, 0f),
                Offset(x, size.height),
                strokeWidth
            )
        }
    } else Modifier

    val modifier4 = if (border.left) {
        Modifier.drawBehind {
            val strokeWidth = 1 * density
            val x = 0.0f

            drawLine(
                Color.LightGray,
                Offset(x, 0f),
                Offset(x, size.height),
                strokeWidth
            )
        }
    } else Modifier

    Row(
        content = content, modifier = modifier
            .then(modifier1)
            .then(modifier2)
            .then(modifier3)
            .then(modifier4)
    )

}

@Composable
fun LazyItemScope.TableCell(
    text: String,
    modifier: Modifier,
    border: CustomBorder = CustomBorder()
) {
    val modifier1 = if (border.top) {
        Modifier.drawBehind {
            val strokeWidth = 1 * density
            val y = -strokeWidth / 2

            drawLine(
                Color.LightGray,
                Offset(0f, y),
                Offset(size.width, y),
                strokeWidth
            )
        }
    } else Modifier

    val modifier2 = if (border.bottom) {
        Modifier.drawBehind {
            val strokeWidth = 1 * density
            val y = size.height - strokeWidth / 2

            drawLine(
                Color.LightGray,
                Offset(0f, y),
                Offset(size.width, y),
                strokeWidth
            )
        }
    } else Modifier

    val modifier3 = if (border.right) {
        Modifier.drawBehind {
            val strokeWidth = 1 * density
            val x = size.width - strokeWidth / 2

            drawLine(
                Color.LightGray,
                Offset(x, 0f),
                Offset(x, size.height),
                strokeWidth
            )
        }
    } else Modifier

    val modifier4 = if (border.left) {
        Modifier.drawBehind {
            val strokeWidth = 1 * density
            val x = 0.0f

            drawLine(
                Color.LightGray,
                Offset(x, 0f),
                Offset(x, size.height),
                strokeWidth
            )
        }
    } else Modifier


    Text(
        text = text,
        modifier = modifier
            .then(modifier1)
            .then(modifier2)
            .then(modifier3)
            .then(modifier4)
            .padding(8.dp),
        overflow = TextOverflow.Ellipsis,
        maxLines = 1,
        textAlign = TextAlign.Center
    )
}