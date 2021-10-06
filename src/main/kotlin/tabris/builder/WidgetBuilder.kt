package tabris.builder

import tabris.Widget

abstract class WidgetBuilder<T: Widget>(
  id: String?,
  val el: T,
  block : WidgetBuilder<T>.() -> Unit,
  treeBuilder: WidgetTreeBuilder<*>,
) {

  var centerX
    set(it) { el.centerX = it }
    get() = el.centerX

  var top
    set(it) { el.top = it }
    get() = el.top

  init {
    el.id = id ?: ""
    block()
    treeBuilder.append(el)
  }

}