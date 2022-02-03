package com.example.todo_list.ui.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.todo_list.data.models.Item
import com.example.todo_list.data.models.Tag
import com.example.todo_list.ui.theme.TodoListTheme


@Composable
fun ListItemView(
    modifier: Modifier = Modifier,
    item: Item
){
    Card(
        modifier = modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            var isCompleted by remember {
                mutableStateOf(item.isCompleted)
            }
            RadioButton(
                selected = isCompleted,
                onClick = { isCompleted = !isCompleted },
                colors = RadioButtonDefaults.colors(
                    selectedColor = MaterialTheme.colors.primary,
                    unselectedColor = MaterialTheme.colors.secondary
                )
            )
            Spacer(modifier = Modifier.size(8.dp))
            Text(
                modifier = Modifier.weight(1f),
                text = item.name,
                color = MaterialTheme.colors.onSurface
            )
            item.tag?.let {
                TagView(
                    typeTag = it
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun ItemViewPreview(){
    TodoListTheme {
        ListItemView(
            item = Item(
                isCompleted = true,
                name = "Leche",
                tag = Tag.GREEN
            )
        )
    }
}
