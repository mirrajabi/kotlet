package ir.mirrajabi.kotlet.infrastructure.api.models

/**
 * Simple Delegation example
 * Now this class has a function called getIdsString which its implementation is provided
 * inside IdentifiableImpl class
 */
data class PostModel(val userId : Int,
                     var identifier : Int,
                     val title : String,
                     val body : String) : Identifiable by IdentifiableImpl(arrayOf(userId, identifier))