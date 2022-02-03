package com.example.todo_list.ui.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.todo_list.data.models.Tag
import com.example.todo_list.ui.theme.TodoListTheme
import com.example.todo_list.ui.theme.getCurrentTheme


@Composable
fun TagView(
    modifier: Modifier = Modifier,
    typeTag: Tag
){
    val color = when(typeTag){
        Tag.RED -> getCurrentTheme().danger
        Tag.BLUE -> getCurrentTheme().info
        Tag.ORANGE -> getCurrentTheme().warning
        Tag.GREEN -> getCurrentTheme().success
    }
    Card(
        modifier = modifier.size(width = 44.dp, height = 16.dp),
        backgroundColor = color
    ){
        
    }
}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun TagViewPreview(){
    TodoListTheme {
        TagView(typeTag = Tag.BLUE)
    }
}