package designPattern.observer.javaobserver

import java.util.*


class Button : Observable() {

    private var view = "View 1"

    fun setViewData(str: String) {
        view = str
        setChanged()
        notifyObservers(str)
    }

    fun getView(): String {
        return view
    }

}

