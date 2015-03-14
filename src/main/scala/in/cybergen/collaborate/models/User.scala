package in.cybergen.collaborate.models

/**
 * Created by vishnu on 11/3/15.
 */
class User(name: String = null, token: String = null, userID: Long = 0) {
  val userName: String = name
  val cookieToken: String = token
  val id: Long = userID
}

object User {
  def getUser(token: String):
  User = {
    new User(name = "vishnu", token = token, userID = 1001)
  }
}