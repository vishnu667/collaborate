package in.cybergen.collaborate.api

/**
 * Created by vishnu on 10/3/15.
 */
trait Routes extends BaseRoutes with ApiRoutes{
    def rootRoute = {
      baseRoutes ~
      apiRoutes
    }
}
