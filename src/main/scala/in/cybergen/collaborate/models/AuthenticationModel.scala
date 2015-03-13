package in.cybergen.collaborate.models

import spray.http.HttpCookie
import spray.routing.RequestContext

/**
 * Created by vishnu on 11/3/15.
 */
trait AuthenticationModel {
  def authenticateUser(userName: String, password: String): String = {
    if (password == "usr1") {
      "CODE_USR1"
    } else if (password == "usr2") {
      "CODE_USR2"
    } else {
      null
    }
  }

  def isAuthenticated(token: String): Boolean = {
    if (token=="CODE_USR1" || token=="CODE_USR2") {
      true
    } else {
      false
    }
  }

  def authorizeUser(check: RequestContext): Boolean = {
    val cookies: Option[HttpCookie] = check.request.cookies.find(_.name == "auth-token")
    if(cookies==None)
      false
    else
      isAuthenticated(cookies.get.content)
  }

  def getUser(token: String): User = User.getUser(token)
}
