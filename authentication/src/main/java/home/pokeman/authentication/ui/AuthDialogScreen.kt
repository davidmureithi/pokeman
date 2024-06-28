package home.pokeman.authentication.ui

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun AuthDialogScreen(
    username: String,
    userId: String,
    showDialog: MutableState<Boolean>,
    onUpdateClick: (String, String) -> Unit
) {
    var inputText by remember { mutableStateOf(username) }

    AlertDialog(
        onDismissRequest = { showDialog.value = false },
        text = {
            TextField(value = username, onValueChange = { inputText = it })
        },
        confirmButton = {
            Button(onClick = {
                onUpdateClick(userId, inputText)
                showDialog.value = false
            }) {
                Text(text = "Update")
            }
        },
    )
}

@Preview(showBackground = true)
@Composable
fun AuthDialogScreenPreview() {
    val showDialog = remember { mutableStateOf(true) }
    val exampleUserId = "123"
    val exampleUsername = "David Ndekere"
    
    AuthDialogScreen(
        username = exampleUsername,
        userId = exampleUserId,
        showDialog = showDialog,
        onUpdateClick = { userId, updatedUsername ->
            println("Updating user $userId with new username: $updatedUsername")
        }
    )
}

