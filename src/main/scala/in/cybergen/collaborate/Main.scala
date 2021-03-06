package in.cybergen.collaborate

import java.util.concurrent.Executors

import akka.actor.{Actor, Props, ActorSystem}
import akka.io.IO
import in.cybergen.collaborate.api.Routes
import spray.can.Http

import scala.concurrent.ExecutionContext


object collaborateActorSystem {
  implicit val system:ActorSystem  = ActorSystem()
  implicit val ec:ExecutionContext = ExecutionContext.fromExecutor(Executors.newFixedThreadPool(1))
}

object Main {

  def main(args: Array[String]): Unit = {

    //Setting up the Akka Actor System
    implicit val system = collaborateActorSystem.system

    //Initiates the ServerServiceActor which handles all the routes
    val service = system.actorOf(Props[ServerServiceActor], "server-service")

    // Load the Interface and the port number from the application.conf

    //default interface is "localhost"
    val interface = system.settings.config.getString("app.interface")

    //default port is 8088
    val port = system.settings.config.getInt("app.port")

    //Binds the Server to the specified interface and port
    IO(Http) ! Http.Bind(service, interface = interface, port = port)

  }

}

// Specifies the routes here which is defined in in.cybergen.collaborate.api
class ServerServiceActor extends Actor with Routes {
  
  //Akka Actor Context is set as the actorRefFactory
  def actorRefFactory = context

  //rootRoute is defined in "in.cybergen.collaborate.api.Routes"
  //def receive = runRoute(rootRoute)
  def receive = runRoute(testRoute)

  implicit def dispatcher: ExecutionContext = collaborateActorSystem.ec
}
