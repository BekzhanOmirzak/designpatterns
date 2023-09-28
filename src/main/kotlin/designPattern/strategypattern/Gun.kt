package designPattern.strategypattern

class Gun : KillInterface {

    override fun kill() {
        println("I can kill with a gun")
    }

}