package in.cybergen.collaborate.api.routes

import in.cybergen.collaborate.models.AuthenticationModel
import spray.http.HttpCookie

import spray.routing._
import spray.routing.directives.{SecurityDirectives, CookieDirectives}

/**
 * Created by vishnu on 10/3/15.
 */
trait ApiRoutes extends HttpService with AuthenticationModel with SecurityDirectives {
  def apiRoutes = pathPrefix("api") {
    var cookieToken = ""

    authorize(check => {
      val cookies: Option[HttpCookie] = check.request.cookies.find(_.name == "auth-token")
      if (cookies.get.content == "CODE_USR1") {
        true
      } else {
        false
      }
    }){
      path("user") {
        get { ctx =>
          ctx.complete(" api authenticated user " + cookieToken)
        }
      }
    }
  }
}