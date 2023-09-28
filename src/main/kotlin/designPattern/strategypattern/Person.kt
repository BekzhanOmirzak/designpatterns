package designPattern.strategypattern

class Person {

    lateinit var kill: KillInterface

    fun setKillInstrument(killInterface: KillInterface) {
        this.kill = killInterface
    }

    fun damage() {
        kill.kill()
    }

}