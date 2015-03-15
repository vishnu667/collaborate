package in.cybergen.collaborate.db

/**
 * Created by vishnu on 13/3/15.
 */

import com.github.mauricio.async.db.Configuration
import com.github.mauricio.async.db.mysql.pool.MySQLConnectionFactory
import com.github.mauricio.async.db.pool.ConnectionPool
import com.github.mauricio.async.db.pool.PoolConfiguration
import akka.actor.ActorSystem
import in.cybergen.collaborate.collaborateActorSystem

class Pool() {
  val system:ActorSystem = collaborateActorSystem.system
  /*
  //TODO read configurations from configuration file instead
  db {
    username = "root"
    port = 3306
    password = "root"
    name = "demo"
    pool {
      maxObjects = 10
      maxIdle = 4
      maxQueueSize = 10
    }
  }
  */

  val configuration = new Configuration(username = "root",
    port = 3306,
    password = Some("sam"),// I like Sam Fisher :P
    database = Some("collaborate"))

  val factory = new MySQLConnectionFactory(configuration)
  val pool = new ConnectionPool(factory, new PoolConfiguration(10, 4, 10))
}