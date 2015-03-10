package in.cybergen.collaborate.api

import spray.routing.HttpService

/**
 * Created by vishnu on 10/3/15.
 */
trait BaseRoutes extends HttpService {
  def baseRoutes = path("ping") { ctx =>
      ctx.complete("pong!")
  } ~
    path("") {
    get {
      complete("home page ")
    }
  }
}
