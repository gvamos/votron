#!/usr/bin/python

import sys,httplib2,urllib2
import json
from urlparse import urlparse


####################################################
#
# Status:  Walk the election
#
####################################################

# Election action panel: http://devops102.wl.cj.com:12345/schulze/elections/elections-page.html
#    (Post new election to run)
#
# Election list (JSON): http://devops102.wl.cj.com:12345/elections
#
# Election selector: http://devops102.wl.cj.com:12345/schulze/election/election.html?name=NaN%20Celebration
#

####################################################
#
# Investigation of
#    http://cjurl.me/vote
#
# Targets:
#
#   Elections: http://devops102.wl.cj.com:12345/schulze/elections/elections.html
#
###################################################

def view(s):
  for key in s.__dict__:
    #print(key)
    print("%s:%s" % (key,s.get(key,"wtf?")))







def fetch(url):
  conn = httplib2.HTTPConnection(url)
  host = urlparse(url)
  print(host)
  print(host.netloc)
  print(host.path)
  conn = httplib2.HTTPConnection(host.netloc)
  resp = conn.request('GET',host.path)
  return resp.getresponse()

HOST="cjurl.me"

#resp1=fetch(HOST)
#tgt2 = resp1.msg.getheader('Location')
#resp2 = fetch(tgt2)
#tgt3 = resp1.msg.getheader('Location')
#resp3 = fetch(tgt3)

#
# Use CJ redirection to find location of voter
#

conn = httplib2.HTTPConnection(HOST)
conn.request('GET','/vote')
resp = conn.getresponse()
forward = resp.msg.getheader('Location')
#
# First bounce
#
parsedresult = urlparse(forward)
host = urlparse(forward).netloc 
conn = httplib2.HTTPConnection(parsedresult.netloc)
conn.request('GET',parsedresult.path)
resp = conn.getresponse()
forward = resp.msg.getheader('Location')
#
# Second bounce
#
parsedresult = urlparse(forward)
host = urlparse(forward).netloc 
conn = httplib2.HTTPConnection(parsedresult.netloc)
conn.request('GET',parsedresult.path)
resp = conn.getresponse()
forward = resp.msg.getheader('Location')


print("voter: %s %s",(str(resp.status),str(resp.reason)))
firstpage = resp.read()
#print(firstpage)
#
# Returns Javascript to load site
#
#<script src="/require-config.js" type="text/javascript"></script>
#<script data-main="/schulze/elections/elections-wiring.js" src="/lib/vendor/require/2.1.6/require.js" type="text/javascript"></script>
#
# Downloads "election wiring" script
#


#
# election list json string
#
HEADERS= {}
SITE='http://devops102.wl.cj.com:12345'
ELECTION_LIST='http://devops102.wl.cj.com:12345/elections'
req = urllib2.Request(SITE+'/elections', None, HEADERS)
electionListJsonString = urllib2.urlopen(req).read()
electionList = json.loads(electionListJsonString)


#
# Intern election list json string
#
nanCelebrationName = urllib.quote('NaN Celebration')

#
# Sample election page fetch:  NaN Celebration
# /schulze/election/election.html?name=NaN%20Celebration
# Sample candidate:
# http://devops102.wl.cj.com:12345/schulze/candidate/candidate.html?election=NaN%20Celebration&candidate=go-carts


        

