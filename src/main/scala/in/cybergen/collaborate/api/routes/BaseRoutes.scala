package in.cybergen.collaborate.api.routes

import in.cybergen.collaborate.models.AuthenticationModel
import spray.routing.HttpService
import spray.routing.directives.HeaderDirectives

/**
 * Created by vishnu on 10/3/15.
 */
trait BaseRoutes extends HttpService with HeaderDirectives with AuthenticationModel {
  def baseRoutes = path("") {
      get {
        complete("home page ")
      }
    }
}
