package designPattern.observer

class WeatherDataClass : Subject {

    val observerList = mutableListOf<Observer>()

    var temperature: Float = 0.0f
    var humidity: Float = 0.0f
    var pressure: Float = 0.0f

    override fun registerObserver(o: Observer) {
        observerList.add(o)
    }

    override fun removeObserver(o: Observer) {
        observerList.remove(o)
    }

    override fun notifyObservers() {
        observerList.forEach {
            it.update(temperature, humidity, pressure)
        }
    }

    fun setMeasurements(humidity: Float, temp: Float, pressure: Float) {
        this.humidity = humidity
        this.temperature = temp
        this.pressure = pressure
        notifyObservers()
    }

}