@file:JsModule("tabris")
package tabris

external val version: String
external val contentView: ContentView

open external class NativeObject : Object {
}

external interface WidgetProperties {

  var centerX: Boolean
  var top: dynamic
  var id: String

}

open external class Widget : NativeObject {

  var centerX: Boolean
  var top: dynamic
  var id: String

}

external interface CompositeProperties { }

open external class Composite(props: CompositeProperties = definedExternally) : Widget {

  fun append(vararg widgets: Widget): ContentView
  fun <T: Widget>find(selector: JsClass<T>): Array<T> // cheat, should be WidgetCollection

}

external interface StackProperties : CompositeProperties {

  var spacing: Number

}

open external class Stack(props: StackProperties = definedExternally) : Composite  {

  val spacing: Number

}

external interface TextViewProperties : WidgetProperties {

  var text: String
  var font: String

}

external class TextView(props: TextViewProperties = definedExternally) : Widget {

  var text: String
  var font: String

}

external interface ButtonProperties : WidgetProperties {

  var text: String

}

external class Button(props: ButtonProperties = definedExternally) : Widget {

  var text: String
  fun onSelect(cb: () -> Unit)

}

external class ContentView : Composite {

}
