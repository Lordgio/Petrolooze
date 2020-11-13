package dev.xxxxx.api.impl

import org.junit.Assert

inline fun <reified T : Exception> assertThrows(message: String? = null, runnable: () -> Any?) {
    try {
        runnable.invoke()
    } catch (e: Throwable) {
        if (e is T) {
            message?.let {
                Assert.assertEquals(it, "${e.message}")
            } ?: Assert.assertEquals(T::class, e::class)
            return
        }
        Assert.fail(
            "expected ${T::class.qualifiedName} but caught " +
                    "${e::class.qualifiedName} instead"
        )
    }
    Assert.fail("expected ${T::class.qualifiedName}")
}