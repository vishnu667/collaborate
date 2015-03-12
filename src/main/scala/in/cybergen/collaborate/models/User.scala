package in.cybergen.collaborate.models

/**
 * Created by vishnu on 11/3/15.
 */
class User(userName:String=null,token:String=null,userID:Long=0) {
  
}

object User {
  def getUser(token:String):
  User ={
    new User(userName = "vishnu",token=token,userID = 1001)
  }  
}