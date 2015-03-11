package in.cybergen.collaborate.api.routes

import in.cybergen.collaborate.models.AuthenticationModel
import spray.routing.HttpService
import spray.routing.directives.CookieDirectives

/**
 * Created by vishnu on 10/3/15.
 */
trait ApiRoutes extends HttpService with CookieDirectives with AuthenticationModel{
  
  def apiRoutes = pathPrefix("api"){
    val cookies:String = cookie("auth-token").toString
    if(isAuthenticated(cookies)) {
      path("user") {
        get { ctx =>
          ctx.complete("api authenticated user")
        }
      }
    }else{
      complete("no auth")
    }
  }
}
