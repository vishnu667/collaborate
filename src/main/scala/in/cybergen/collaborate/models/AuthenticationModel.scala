package in.cybergen.collaborate.models

/**
 * Created by vishnu on 11/3/15.
 */
trait AuthenticationModel {

  def authenticateUser(userName: String, password: String): String = {
    if (password == "usr1") {
      "CODE_USR1"
    } else if (password == "usr2") {
      "CODE_USR2"
    } else {
      null
    }
  }
  
  def isAuthenticated(token:String):Boolean ={
    if(token.eq("CODE_USR1")||token.eq("CODE_USR2")){
      true
    }else {
      false}
  }
}
