import tabris.builder.contentView
import tabris.builder.textView
import tabris.builder.button
import tabris.TextView

fun build() {
  contentView {
    button {
      centerX = true
      top = 100
      + "Show message"
      onSelect {
        find<TextView>("message").text = "Hello Tabris-Kotlin"
      }
    }
    textView("message") {
      centerX = true
      top = "prev() 50"
      font = "24px"
    }
  }
}
