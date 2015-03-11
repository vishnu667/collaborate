package in.cybergen.collaborate.api

import in.cybergen.collaborate.api.routes.{AuthenticatedRoutes, ApiRoutes, BaseRoutes}

/**
 * Created by vishnu on 10/3/15.
 */
trait Routes extends BaseRoutes with ApiRoutes with AuthenticatedRoutes{
    def rootRoute = {
      baseRoutes ~ 
        apiRoutes ~ 
        authenticatedRoutes
    }
}
