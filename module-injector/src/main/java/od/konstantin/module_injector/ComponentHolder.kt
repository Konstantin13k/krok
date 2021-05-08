package od.konstantin.module_injector

import kotlin.reflect.KProperty

interface ComponentHolder<C : BaseApi, D : BaseDependencies> {

    fun init(dependencies: D)

    fun get(): C

    fun reset()
}

operator fun <C : BaseApi, D : BaseDependencies> ComponentHolder<C, D>.getValue(
    thisRef: Any?,
    property: KProperty<*>
) = get()