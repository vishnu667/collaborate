package in.cybergen.collaborate.api.routes

import in.cybergen.collaborate.models.AuthenticationModel
import spray.http.HttpCookie

import spray.routing._
import spray.routing.directives.{SecurityDirectives, CookieDirectives}

/**
 * Created by vishnu on 10/3/15.
 */
trait ApiRoutes extends HttpService with AuthenticationModel with SecurityDirectives {
  def apiRoutes =
      path("user") {
        get { ctx =>
          ctx.complete(" api authenticated user ")
        }
      }
}