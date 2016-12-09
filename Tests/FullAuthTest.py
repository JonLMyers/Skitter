import urllib2
import sys
import time

def reg_user():

    try:
        url = "http://127.0.0.1:8080/registration"

        response = urllib2.urlopen(url)
        cookie = response.headers.get('Set-Cookie')
        cookie = cookie[:-7]
        cookie = cookie[11:]

        tdata = 'screenName=jake&username=jake%40rit.edu&password=password&passwordConfirm=password'
        print "------------------------------------------"

        req = urllib2.Request(url, tdata)
        req.add_header('cookie', cookie)

        print req.get_full_url()
        print req.get_method()
        print req.get_data()
        response = urllib2.urlopen(req)
        print response.getcode()
        return cookie

    except:
        print "Unexpected error:", sys.exc_info()[0]
        print "Register user failed."


def test_isAuth(cookie):

        url = "http://localhost:8080/isAuthenticated?sessionId={0}".format(cookie)

        try:
            response = urllib2.urlopen(url)
            print response.read()
        except:
            print "Unexpected error:", sys.exc_info()[0]
            print "isAuth test failed."

def delete_user():

        url = "http://localhost:8080/delete?username=jake"
        response = urllib2.urlopen(url)
        print response.read()

time.sleep(60)
cookie = reg_user()
print "-----------------------"
print cookie
test_isAuth(cookie)
delete_user()
