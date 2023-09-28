package designPattern.observer.javaobserver

import java.util.*


class OnClickListener() : Observer {


    override fun update(o: Observable?, arg: Any?) {
        if (o is Button) {
            println("Arg from observable : $arg")
        }
    }

}