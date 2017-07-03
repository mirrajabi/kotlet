package ir.mirrajabi.kotlet.infrastructure.api.models

import ir.mirrajabi.kotlet.infrastructure.extensions.plusThousandString

/**
 * Simple Delegation example
 * This class overrides id from Identifiable and we are going to use it for PostModel
 */
class MultiIdentity(val identifiers : Array<Int>) : Identifiable {
    override fun getIdsString(): String? {
        return identifiers.joinToString { i-> i.plusThousandString() }
    }
}