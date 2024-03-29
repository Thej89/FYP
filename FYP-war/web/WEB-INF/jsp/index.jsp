<%-- 
    Document   : login
    Created on : Nov 30, 2012, 11:14:48 PM
    Author     : Thejanee Walgamage
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <script src="js/jquery-1.8.3.js"></script>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="http://www.modernizr.com/downloads/modernizr-latest.js"></script>
        <script type="text/javascript" src="js/placeholder.js"></script>
        <link rel="stylesheet" type="text/css" href="css/style_login.css" />
        <script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
        <script type="text/javascript" src="js/login.js"></script>
        <title>Login Page</title>
        <style>
            .errorblock {
                color: #ff0000;
                background-color: #ffffff;
                border: 2px solid #ff0000;
                padding: 6px;
                margin-left: -36px;
                font-size: small;
                width: 300px;
            }
        </style>
    </head>
    <body>

        <form name='loginfrm' id="slick-login" method="POST" action="login.htm">
            <div id="errorDiv">
                ${errorMsg}
            </div>
            <label for="username">username</label><input type="text" name='username_login' id="username_login" class="placeholder" placeholder="username">
            <label for="password">password</label><input type="password" name='password_login' id="password_login" class="placeholder" placeholder="password">
            <input type="submit" value="Log In">

        </form>
    </body>
</html>
<!---------------------------------Starting of the new code---------------------------------------------->                
<!--<html>
<head>
  <title>Hello World</title>
  <meta name="viewport" content="initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
  <meta property="og:title" content="Hello world" />
  <meta property="og:type" content="website" />
  <meta property="og:site_name" content="Hello World" />
  <meta property="og:description" content="Hello World!  This is my mobile web sample app." />
  <meta property="og:image" content="http://www.facebookmobileweb.com/hackbook/img/facebook_icon_large.png"/>
</head>
<body>
  <div id="fb-root"></div>
  <script>
    (function() {
      var e = document.createElement('script'); e.async = true;
          e.src = document.location.protocol + '//connect.facebook.net/en_US/all.js';
          document.getElementById('fb-root').appendChild(e);
          }());
  </script>
  
  <script>
    window.fbAsyncInit = function() {
      FB.init({ appId: '167335053423725', 
      status: true, 
      cookie: true,
      xfbml: true,
      oauth: true});
 
      FB.Event.subscribe('auth.statusChange', handleStatusChange);	
    };
  </script>
  
  <script>
   function handleStatusChange(response) {
     document.body.className = response.authResponse ? 'connected' : 'not_connected';
    
     if (response.authResponse) {
       console.log(response);
       updateUserInfo(response);
     }
   }
   </script>
   
   <div id="login">
     <p><button onClick="loginUser();">Login</button></p>
   </div>
   <div id="logout">
     <div id="user-info"></div>
     <p><button  onClick="FB.logout();">Logout</button></p>
   </div>
   
  <script>
    function loginUser() {    
      FB.login(function(response) { }, {scope:'email'});  	
    }
  </script>
  
  <style>
    body.connected #login { display: none; }
    body.connected #logout { display: block; }
    body.not_connected #login { display: block; }
    body.not_connected #logout { display: none; }
  </style>
  
  <div id="user-info"></div>
  <script>
    function updateUserInfo(response) {
      FB.api('/me', function(response) { alert(response.id);  alert(response.name); 
        document.getElementById('user-info').innerHTML = '<img src="https://graph.facebook.com/' + response.id + '/picture">' + response.name;
      });
    }
  </script>

  <a href="#" onclick="getUserFriends();">Get friends</a><br>
  <div id="user-friends"></div>
  <script>
  function getUserFriends() {
    FB.api('/me/friends&fields=name,picture', function(response) {
      console.log('Got friends: ', response);
      
      if (!response.error) {
        var markup = '';
        
        var friends = response.data;
        
        for (var i=0; i < friends.length && i < 25; i++) {
          var friend = friends[i];
          
          markup += '<img src="' + friend.picture + '"> ' + friend.name + '<br>';
        }
        
        document.getElementById('user-friends').innerHTML = markup;
      }
    });
  }
  </script>
 
  <a href="#" onclick="publishStory();">Publish feed story</a><br>
  <script>
  function publishStory() {
    FB.ui({
      method: 'feed',
      name: 'I\'m building a social mobile web app!',
      caption: 'This web app is going to be awesome.',
      description: 'Check out Facebook\'s developer site to start building.',
      link: 'http://www.facebookmobileweb.com/hello',
      picture: 'http://www.facebookmobileweb.com/hackbook/img/facebook_icon_large.png'
    }, 
    function(response) {
      console.log('publishStory response: ', response);
    });
    return false;
  }
  </script>
  
  <a href="#" onclick="sendRequest();">Send request</a><br>
  <script>
  function sendRequest() {
    FB.ui({
      method: 'apprequests',
      message: 'invites you to learn how to make your mobile web app social'
    }, 
    function(response) {
      console.log('sendRequest response: ', response);
    });
  }
  </script>
  
  <fb:like></fb:like>
</body>
</html>-->