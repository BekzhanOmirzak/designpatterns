class DTree {

    val root = Pointer(0)

    fun update(l: Int, r: Int) {

    }




    class Pointer(var at: Int) {
        var freq: Int = 0
        var left: Pointer? = null
        var right: Pointer? = null

        fun init(at: Int) {
            if (left == null) {
                left = Pointer(at * 2 + 1)
                right = Pointer(at * 2 + 2)
            }
        }
    }

}