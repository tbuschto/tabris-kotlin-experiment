import tabris.Button
import tabris.TextView
import tabris.contentView

fun direct() {
  val button = Button();
  button.text = "Show message"
  button.centerX = true
  button.top = 100

  val textView = TextView();
  textView.centerX = true
  textView.top = "prev() 50"
  textView.font = "24px"

  button.onSelect {
    textView.text = "Hello Tabris-Kotlin"
  }

  contentView.append(button, textView)
}