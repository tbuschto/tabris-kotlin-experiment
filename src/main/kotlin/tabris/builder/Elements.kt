package tabris.builder

import tabris.TextView
import tabris.Button

fun contentView(content: WidgetTreeBuilder<tabris.Widget>.() -> Unit) {

  tabris.contentView.createTree().content();

}

inline fun WidgetTreeBuilder<tabris.Widget>.textView(
  id : String? = null,
  noinline block : TextViewBuilder.() -> Unit = {}
) : TextViewBuilder = TextViewBuilder(id, block, this)

inline fun WidgetTreeBuilder<tabris.Widget>.button(
  id : String? = null,
  noinline block : ButtonBuilder.() -> Unit = {}
) : ButtonBuilder = ButtonBuilder(id, block, this)

open class TextViewBuilder(
  id: String?,
  block : TextViewBuilder.() -> Unit,
  treeBuilder : WidgetTreeBuilder<*>
) : WidgetBuilder<TextView>(
  id,
  TextView(),
  block.unsafeCast<WidgetBuilder<TextView>.() -> Unit>(),
  treeBuilder
) {

  var font
    set(it) { el.font = it }
    get() = el.font

  var text
    set(it) { el.text = it }
    get() = el.text

  operator fun String.unaryPlus(): Unit {
    text += this
  }

}

open class ButtonBuilder(
  id: String?,
  block : ButtonBuilder.() -> Unit,
  treeBuilder : WidgetTreeBuilder<*>
) : WidgetBuilder<Button>(
  id,
  Button(),
  block.unsafeCast<WidgetBuilder<Button>.() -> Unit>(),
  treeBuilder
) {

  var text
    set(it) { el.text = it }
    get() = el.text

  fun onSelect(cb: () -> Unit) = el.onSelect(cb)

  operator fun String.unaryPlus(): Unit {
    text += this
  }

}

// doing all of this for every property seems redundant, event if code is generated.
// maybe a "properties = {}" syntax, where the type that can be shared with the widget?
// Or merge with widget? (native kotlin only)
// or subclass widget
// all of these seem less-than-ideal for traditional custom components, but functional components should work

