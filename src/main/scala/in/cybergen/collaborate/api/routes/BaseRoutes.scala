package in.cybergen.collaborate.api.routes

import in.cybergen.collaborate.models.AuthenticationModel
import spray.http.HttpCookie
import spray.routing.HttpService
import spray.routing.directives.HeaderDirectives

/**
 * Created by vishnu on 10/3/15.
 */
trait BaseRoutes extends HttpService with HeaderDirectives with AuthenticationModel {
  def baseRoutes = path("login" / Segment) { id =>
    get { 
      val user = "sample name"
      val token:String = authenticateUser(user,id)
        setCookie(HttpCookie("auth-token",content = token)) {
          complete(" login as " + user + " for req " + id + " is authenticated " + token)
        }
    }
  } ~
    path("") {
      get {
        complete("home page ")
      }
    }
}
