package in.cybergen.collaborate.api.routes


import in.cybergen.collaborate.db.DB
import in.cybergen.collaborate.models.{User, AuthenticationModel}
import spray.routing._

/**
 * Created by vishnu on 10/3/15.
 */
trait ApiRoutes extends HttpService with AuthenticationModel with DB {

  def apiRoutes =
      path("user") {
        get { ctx =>
          val user : User = getUser(ctx.request.cookies.find(_.name == "auth-token").get.content)
//          execute("show tables")
          ctx.complete(" api authenticated user "+user.userName)
        }
      }
}