package in.cybergen.collaborate.db

/**
 * Created by vishnu on 13/3/15.
 */
import com.github.mauricio.async.db.Configuration
import com.github.mauricio.async.db.mysql.pool.MySQLConnectionFactory
import com.github.mauricio.async.db.pool.ConnectionPool
import com.github.mauricio.async.db.pool.PoolConfiguration
import akka.actor.ActorSystem

class Pool(system: ActorSystem) {

  val configuration = new Configuration(username = "root",
    port = 1010,
    password = Some(""),
    database = Some(""))

  val factory = new MySQLConnectionFactory(configuration)
  val pool = new ConnectionPool(factory, new PoolConfiguration(conf.dbPoolMaxObjects, conf.dbPoolMaxIdle, conf.dbPoolMaxQueueSize))
}