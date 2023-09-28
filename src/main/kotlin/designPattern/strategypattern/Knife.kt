package designPattern.strategypattern

class Knife : KillInterface {

    override fun kill() {
        println("I killed with knife")
    }

}