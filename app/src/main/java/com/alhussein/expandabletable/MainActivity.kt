package com.alhussein.expandabletable

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alhussein.library.model.Group
import com.alhussein.library.model.Item
import com.alhussein.expandabletable.ui.theme.ExpandableTableTheme
import com.alhussein.library.ExpandableTable


class MainActivity : ComponentActivity() {

    val groups = mutableListOf<Group>()

    init {
        val rows = mutableListOf<Item>()
        rows.add(Item(1, "Item 1", description = "description item no 1"))
        rows.add(Item(2, "Item 2", description = "description item no 2"))
        rows.add(Item(3, "Item 3", description = "description item no 3"))
        rows.add(Item(4, "Item 4", description = "description item no 4"))
        rows.add(Item(5, "Item 5", description = "description item no 5"))

        groups.add(Group(title = "Group 1", rows = rows))
        groups.add(Group(title = "Group 2", rows = rows))
        groups.add(Group(title = "Group 3", rows = rows))

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExpandableTableTheme {

                Column {
                    groups.forEach {
                        ExpandableTable(group = it)
                        Spacer(modifier = Modifier.height(8.dp))
                    }
                }

            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ExpandableTableTheme {
        Greeting("Android")
    }
}