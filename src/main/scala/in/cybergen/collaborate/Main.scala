package in.cybergen.collaborate

import akka.actor.{Actor, Props, ActorSystem}
import akka.io.IO
import in.cybergen.collaborate.api.Routes
import spray.can.Http

object Main {
  def main(args: Array[String]): Unit = {
    
    implicit val system = ActorSystem()
    
    val service = system.actorOf(Props[ServerServiceActor], "server-service")
    
    IO(Http) ! Http.Bind(service, interface = "localhost", port = 8001)
    
  }
}

class ServerServiceActor extends Actor with Routes {
  def actorRefFactory = context
  def receive = runRoute(rootRoute)
}
