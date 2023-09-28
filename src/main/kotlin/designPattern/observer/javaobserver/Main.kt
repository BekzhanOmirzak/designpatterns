package designPattern.observer.javaobserver


fun main() {

    val obj = Button()
    val listeners = OnClickListener()

    obj.addObserver(listeners)

    obj.setViewData("View 2")

    val test = LinearLayout()


}