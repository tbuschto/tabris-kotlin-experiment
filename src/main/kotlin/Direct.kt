import tabris.widget.Button
import tabris.widget.TextView
import tabris.widget.Stack
import tabris.widget.contentView;

fun direct() {
  contentView.append(
    Stack({spacing = 50}) {
      append(
        Button({
          text = "Show message"
          centerX = true
          top = 100
        }) {
          onSelect {
            contentView.find(TextView::class.js)[0].text = "Hello Tabris-Kotlin foo"
          }
        },
        TextView({
          centerX = true
          font = "24px"
        })
      )
    }
  )
}