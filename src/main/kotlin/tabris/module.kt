@file:JsModule("tabris")
package tabris

external val version: String
external val contentView: ContentView

open external class Widget {

  var centerX: Boolean
  var top: dynamic
  var id: String

}

external class TextView : Widget {

  var text: String
  var font: String

}

external class Button : Widget {

  var text: String
  fun onSelect(cb: () -> Unit)

}

external class ContentView : Widget {

  fun append(vararg widgets: Widget): ContentView
  fun <T: Widget>find(selector: JsClass<T>): Array<T> // cheat!

}
