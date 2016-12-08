import urllib2

def reg_user:

    try:
        url = "http://localhost:8080/registration"

        response = urllib2.urlopen(url)
        cookie = response.headers.get('Set-Cookie')

        data = urllib.urlencode({'screenName' : 'jake', 'username' : 'jake@rit.edu', 'password' : 'password', 'passwordConfirm' : 'password'})
        req = urllib2.Request(url, data)
        req.add_header('Cookie', cookie)
        response = urllib2.urlopen(req2)
        print response.getcode()
        return cookie

    except ValueError:
        print "Register user failed."


def test_isAuth(cookie):

        url = "http://localhost:8080/isAuthenticated?sessionId={1}".format(cookie)

        try:
            response = urllib2.urlopen(url)
            print response
        except ValueError
            print "isAuth test failed."

def delete_user:

        url = "http://localhost:8080/delete?username=jake"
        response = urllib2.urlopen(url)
        print response
        return null
