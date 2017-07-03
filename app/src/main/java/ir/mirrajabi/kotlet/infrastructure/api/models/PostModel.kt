package ir.mirrajabi.kotlet.infrastructure.api.models

import ir.mirrajabi.kotlet.infrastructure.extensions.plusThousandString

/**
 * Simple Delegation example
 * Now this class has a function called getIdsString which its implementation is provided
 * inside MultiIdentity class
 */

/* This approach looks better cause it takes the implementation from elsewhere but in this case
 * where the class is modified by retrofit the delegation will not work and throws a runtime
 * exception if we are going to use getIdsString() function :
 * java.lang.NullPointerException: Attempt to invoke virtual method 'java.lang.String
 * ir.mirrajabi.kotlet.infrastructure.api.models.IdentifiableImpl.getIdsString()'
 * on a null object reference
class PostModel(val userId : Int,
                     var id : Int,
                     val title : String,
                     val body : String) : Identifiable by MultiIdentity(arrayOf(userId,id)) {
}
 */
// So I'm going to put the implementation inside the class

class PostModel(val userId : Int,
                var id : Int,
                val title : String,
                val body : String) : Identifiable{
    override fun getIdsString(): String? {
        return arrayOf(id, userId).joinToString { i-> i.plusThousandString() }
    }
}