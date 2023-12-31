package com.tweener.czan.android.designsystem.atom.dialog

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.tweener.czan.android.designsystem.atom.text.Text
import com.tweener.czan.android.preview.CzanThemePreview

/**
 * @author Vivien Mahe
 * @since 01/09/2023
 */

@Composable
fun AlertDialog(
    title: String,
    confirmButtonLabel: String,
    onConfirmButtonClicked: () -> Unit,
    onDismiss: () -> Unit,
    modifier: Modifier = Modifier,
    dismissButtonLabel: String? = null,
    icon: ImageVector? = null,
    content: @Composable () -> Unit,
) {
    AlertDialog(
        modifier = modifier,
        icon = { icon?.let { Icon(it, contentDescription = null) } },
        title = { Text(text = title) },
        text = content,
        confirmButton = {
            TextButton(onClick = onConfirmButtonClicked) {
                Text(text = confirmButtonLabel)
            }
        },
        dismissButton = {
            dismissButtonLabel?.let {
                TextButton(onClick = onDismiss) {
                    Text(text = dismissButtonLabel)
                }
            }
        },
        onDismissRequest = onDismiss
    )
}

@PreviewLightDark
@Composable
private fun AlertDialogPreview() {
    CzanThemePreview {
        AlertDialog(
            title = "AlertDialog title",
            confirmButtonLabel = "Confirm",
            dismissButtonLabel = "Cancel",
            onConfirmButtonClicked = {},
            onDismiss = {},
        ) {
            Text(text = "This is a Text component.")
        }
    }
}