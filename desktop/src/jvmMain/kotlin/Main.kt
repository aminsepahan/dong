import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import ir.amin.dong.common.App


fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}
