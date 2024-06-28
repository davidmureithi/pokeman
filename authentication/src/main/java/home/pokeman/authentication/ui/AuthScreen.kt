package home.pokeman.authentication.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import home.pokeman.authentication.data.AuthUser
import home.pokeman.authentication.model.AuthViewModel

@Composable
fun AuthScreen(viewModel: AuthViewModel = hiltViewModel()) {
    val userState by viewModel.authState.collectAsState()
    var inputName by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize()) {
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = inputName,
            onValueChange = { inputName = it },
            label = { Text(text = "Name") }
        )
        Spacer(modifier = Modifier.padding(10.dp))
        Button(
            modifier = Modifier.align(Alignment.End),
            onClick = { viewModel.addUser(AuthUser(username = inputName)) }
        ) {
            Text(text = "Add")
        }
        Button(
            modifier = Modifier.align(Alignment.Start),
            onClick = {
                
            }
        ) {
            Text(text = "More")
        }
        Spacer(modifier = Modifier.padding(16.dp))
        when {
            userState.isLoading -> {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.CenterHorizontally))
            }

            !userState.errorMsg.isNullOrEmpty() -> {
                Text(text = userState.errorMsg ?: "Error")
            }

            userState.data.isNullOrEmpty() -> {
                Text(text = "Empty")
            }

            userState.data != null -> {
                LazyColumn {
                    items(userState.data!!) { item ->
                        AuthListItem(
                            username = item.username,
                            userId = item.id.toString(),
                            onUpdateClick = { id, name ->
                                viewModel.updateUser(AuthUser(id.toInt(), name))
                            },
                            onDeleteClick = { id, name ->
                                viewModel.deleteUser(AuthUser(id.toInt(), name))
                            },
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AuthScreenPreview()  {
    val exampleUserList = listOf(
        AuthUser(id = 1, username = "JohnDoe"),
        AuthUser(id = 2, username = "JaneSmith")
    )
    
//    val exampleViewModel = AuthViewModel(MockAuthRepository(exampleUserList))
//
//    AuthScreen(viewModel = exampleViewModel)
}
