package in.cybergen.collaborate.api

import in.cybergen.collaborate.api.routes.{ApiRoutes, BaseRoutes}

/**
 * Created by vishnu on 10/3/15.
 */
trait Routes extends BaseRoutes with ApiRoutes{
    def rootRoute = {
      baseRoutes ~
      apiRoutes
    }
}
