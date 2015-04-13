package in.cybergen.collaborate.api

import in.cybergen.collaborate.api.routes.{AuthenticatedRoutes, ApiRoutes, BaseRoutes}
import in.cybergen.collaborate.models.AuthenticationModel
import spray.http.HttpCookie
import spray.routing.directives.{HeaderDirectives, SecurityDirectives}

/**
 * Created by vishnu on 10/3/15.
 * Routes Page
 */
trait Routes extends BaseRoutes with SecurityDirectives with AuthenticationModel with ApiRoutes with HeaderDirectives {
  def testRoute = headerValueByName("host") { userId =>
    if (userId == "localhost:8088")
      rootRoute
    else
      site2Route
  }

  def site2Route = path("ping") {
    complete("this is default site try localhost instead")
  }

  def rootRoute = {

    pathPrefix("api") {
      // Authenticated Routes Returns 403 Forbidden if not Authorized
      authorize(check => authorizeUser(check)) {
        apiRoutes
      }
    } ~ pathPrefix("auth") {
      path("login" / Segment) { pass =>
        get {
          val user = "sample name"
          val token: String = authenticateUser(user, pass)
          if (token != None) {
            setCookie(HttpCookie("auth-token", content = token, path = Some("/"))) {
              complete(" login as " + user + " for req  is authenticated " + token)
            }
          } else {
            complete("Auth Failed")
          }
        }
      } ~ path("Tlogin") {
        entity(as[String]) { foo =>
          complete {
            foo
          }
        }
      } ~ baseRoutes

    }
  }
}
