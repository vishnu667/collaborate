package in.cybergen.collaborate.db

/**
 * Created by vishnu on 13/3/15.
 */

import akka.io.Tcp.Write
import akka.util.ByteString

import scala.concurrent.{ExecutionContext, Future}
import com.github.mauricio.async.db.{RowData, QueryResult}
trait DB {

  implicit def dispatcher: ExecutionContext

  lazy val pool = new Pool().pool
  /**
   * Creates a prepared statement with the given query
   * and passes it to the connection pool with given values.
   */
  def execute(query: String, values: Any*): Future[QueryResult] = {
    if (values.size > 0)
      pool.sendPreparedStatement(query, values)
    else
      pool.sendQuery(query)
  }

  /**
   * Creates a prepared statement with the given query
   * and passes it to the connection pool with given values.
   * @return Seq[RowData] of the query
   */
  def fetch(query: String, values: Any*): Future[Option[Seq[RowData]]] =
    execute(query, values: _*).map(_.rows)

  def printAll() {
    respond("values in db are:")
    for {
      queryResult <- fetch("SELECT * FROM users")
      resultSet <- queryResult
      rowData <- resultSet
      result = getData(rowData)
    } respond(result)
  }
  def respond(response: String) {
    println(response+"\n")
  }
  def getData(rowData: RowData) = {
    rowData("username").asInstanceOf[String]
  }
}
