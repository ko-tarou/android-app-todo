package com.websarva.wings.android.todo_app.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType


@Composable
fun TopScreen(){

    var newTodo by remember { mutableStateOf("") }
    var todoList by remember { mutableStateOf(listOf<String>()) }

    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
    ){
        Column (
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.White)
                .padding(100.dp)
        ){
            Text(text = "Todo",
                fontSize = 50.sp
            )

            TextField(
                value = newTodo,
                onValueChange = { newTodo = it },
                placeholder = {Text("入力")},
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Text
                )
            )

            Button(
                onClick = {
                    if (newTodo.isNotBlank()){
                        todoList = todoList + newTodo
                        newTodo = ""
                    }
                }
            ) {
                Text(text = "追加")
            }

            LazyColumn (
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding()
            ){
                items(todoList.size){ index ->

                    Row (
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.LightGray)
                            .padding(8.dp)
                    ){
                        Text(
                            text = todoList[index],
                            fontSize = 20.sp,
                            modifier = Modifier
                                .weight(1f)
                        )
                        IconButton(
                            onClick = {
                                todoList = todoList.toMutableList().apply { removeAt(index) }
                            }
                        ) {
                            Icon(
                                painter = painterResource(id = android.R.drawable.ic_delete),
                                contentDescription = "Delete"
                            )
                        }

                        Button(
                            onClick = {/*todo*/}
                        ) {
                            Text(
                                text = "+"
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
@Preview
fun TopScreenPreview(){
    TopScreen()
}