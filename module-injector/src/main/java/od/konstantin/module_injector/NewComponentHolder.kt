package od.konstantin.module_injector

abstract class NewComponentHolder<C : Any, A : BaseApi, D : BaseDependencies> {

    protected var component: C? = null

    abstract fun newComponent(dependencies: D): C

    abstract fun get(): A

    fun init(dependencies: D) {
        if (component == null) {
            synchronized(NewComponentHolder::class.java) {
                if (component == null) {
                    component = newComponent(dependencies)
                }
            }
        }
    }

    fun reset() {
        component = null
    }
}