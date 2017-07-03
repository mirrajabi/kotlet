package ir.mirrajabi.kotlet.infrastructure.api.models

/**
 * Simple Delegation example
 * This class overrides id from Identifiable and we are going to use it for PostModel
 */
class IdentifiableImpl(val identifiers : Array<Int>) : Identifiable {
    override fun getIdsString(): String {
        return identifiers.joinToString { i-> i.plusThousandString() }
    }
}

// Its a useless extension but might be helpful for understanding extensions
fun Int.plusThousandString(): String = (this + 10000).toString()