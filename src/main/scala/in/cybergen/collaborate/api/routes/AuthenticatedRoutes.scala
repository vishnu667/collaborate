package in.cybergen.collaborate.api.routes

import spray.routing.HttpService

/**
 * Created by vishnu on 10/3/15.
 */
trait AuthenticatedRoutes extends HttpService {
  def authenticatedRoutes = pathPrefix("auth") {
    path("login") {
      get {
        complete("login")
      }
    } ~
      path("logout") {
        get {
          complete("logout")
        }
      }
  } ~
    path("") {
      get {
        complete("home page ")
      }
    }
}