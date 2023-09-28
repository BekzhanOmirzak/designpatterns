package designPattern.observer

class PhoneDisplay : DisplayElement, Observer {

    var temp: Float = 0.0f
    var humidity: Float = 0.0f
    var pressure: Float = 0.0f

    override fun update(temp: Float, humidity: Float, pressure: Float) {
        this.temp = temp
        this.humidity = humidity
        this.pressure = pressure
        display()
    }

    override fun display() {
        println("Conditions Display on Phone : $temp $humidity $pressure")
    }

}