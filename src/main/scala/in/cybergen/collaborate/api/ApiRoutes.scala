package in.cybergen.collaborate.api

import spray.routing.HttpService

/**
 * Created by vishnu on 10/3/15.
 */
trait ApiRoutes extends HttpService {
  def apiRoutes = path("pong" / Segment) { data =>
    get {
      complete("ping ! "+data)
    }
  } ~
    path("index.html") {
      get {
        complete("index page ")
      }
    }
}
