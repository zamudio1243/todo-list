package com.example.todo_list

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.todo_list.data.models.Item
import com.example.todo_list.ui.components.ListItemView
import com.example.todo_list.ui.theme.TodoListTheme
import com.example.todo_list.ui.theme.getCurrentTheme
import com.example.todo_list.view_models.TodoListViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: TodoListViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            TodoListTheme {
                TodoListScreen(todoListViewModel = viewModel)
            }
        }
    }
}

@Composable
fun TodoListScreen(
    todoListViewModel: TodoListViewModel = viewModel()
) {
    var openDialog by remember {
        mutableStateOf(false)
    }
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = {
                openDialog = true
            }) {
                Icon(Icons.Outlined.Add, contentDescription = "Add item")
            }
        },
        topBar = {
            Text(
                modifier = Modifier.padding(start = 12.dp),
                text = "Todo List",
                style = MaterialTheme.typography.h4
            )
        }
    ) {
        LazyColumn(
            modifier = Modifier.padding(start = 12.dp, end = 12.dp)
        ) {
            item {
                Text(
                    modifier = Modifier
                        .padding(top = 18.dp, bottom = 4.dp),
                    text = "Completed",
                    style = MaterialTheme.typography.subtitle1,
                    color = getCurrentTheme().completed
                )
            }
            items(todoListViewModel.todoList) {
                ListItemView(
                    modifier = Modifier.padding(4.dp),
                    item = it
                )
            }
        }
        if (openDialog) {
            var text by remember {
                mutableStateOf("")
            }
            AlertDialog(
                onDismissRequest = { openDialog = false },
                title = {
                    Text(text = "Add a new item")
                },
                text = {

                    OutlinedTextField(
                        value = text,
                        label = {
                            Text(text = "name")
                        },
                        onValueChange = {
                            text = it
                        }
                    )
                },
                confirmButton = {
                    TextButton(
                        onClick = {
                            openDialog = false
                            todoListViewModel.addItem(
                                Item(name = text)
                            )
                        }
                    ) {
                        Text("Add")
                    }
                },
                dismissButton = {
                    TextButton(
                        onClick = {
                            openDialog = false
                        }
                    ) {
                        Text("Dismiss")
                    }
                }
            )
        }
    }
}