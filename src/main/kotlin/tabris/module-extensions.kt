package tabris

@JsName("Object")
open external class Object {
}

fun Stack(
  props: StackProperties.() -> Unit = {},
  init: Stack.() -> Unit = {}
): Stack = Stack(asObject<StackProperties>(props)).apply(init)

fun Button(
  props: ButtonProperties.() -> Unit = {},
  init: Button.() -> Unit = {}
): Button = Button(asObject<ButtonProperties>(props)).apply(init)

fun TextView(
  props: TextViewProperties.() -> Unit = {},
  init: TextView.() -> Unit = {}
): TextView = TextView(asObject<TextViewProperties>(props)).apply(init)

fun <T>asObject(init: T.() -> Unit): T {
  return Object().unsafeCast<T>().apply(init);
}
