package tabris.builder

import tabris.Widget
import tabris.ContentView

class WidgetTreeBuilder<out R : Widget>(val el : ContentView) {

  fun append(child: Widget) = el.append(child)

  // This is all very clumsy, but it's just to proof the concept anyway:
  inline fun <reified T: Widget> find(id: String): T {
    val type = T::class.js;
    val result = el.find(type);
    for (widget in result) {
      if (widget.id == id) {
        return widget;
      }
    }
    throw Error("This isn't the widget you're looking for");
  }

}

fun ContentView.createTree() : WidgetTreeBuilder<Widget> = WidgetTreeBuilder(this)
