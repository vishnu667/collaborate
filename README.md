# collaborate

To Create a platform to help the public in raising problems that can solved by technology and contributors to work on projects that which interests them.

### Thoughts
    Spray.io - for the rest api
    DB- Mysql - use it with no
    EmberJs and Bootstrap for thr UI

### notes

    The application layer and rest layer should not be dependent like a web application
    
### TODO Api Route Structure

Base Routes 
Load Files from files and Serve them using Spray

   /                #todo
   /js              #todo
   /img             #todo
   /css             #todo

Authentication - Routes

    /auth/login     #todo
    /auth/logout    #todo

Authorized Routes
authorization is currently cookie based responds with a 403 forbidden if cookie is not present

    /api/*          #todo
