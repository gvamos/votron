#!/usr/bin/python

import sys,httplib2,urllib
import json
import urllib.parse


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


#
#
#  http.request automatically follows redirects.  This is not
#  the case with all competing libraries.
#
#
#resp1=fetch(HOST)
#tgt2 = resp1.msg.getheader('Location')
#resp2 = fetch(tgt2)
#tgt3 = resp1.msg.getheader('Location')
#resp3 = fetch(tgt3)

#
# Use CJ redirection to find location of voter
#

#conn = httplib2.HTTPConnection(HOST)
#conn.request('GET','/vote')
#resp = conn.getresponse()
#forward = resp.msg.getheader('Location')

#nanCelebrationName = urllib.parse.quote_plus('NaN Celebration')
#http://devops102.wl.cj.com:12345/schulze/candidate/candidate.html?election=NaN%20Celebration&candidate=go-carts


HOST="cjurl.me"
HEADERS = {'Content-type': 'application/json'}
HTTP = httplib2.Http()
SITE='http://devops102.wl.cj.com:12345'
ELECTION_LIST='http://devops102.wl.cj.com:12345/elections'

url = "http://" + HOST+'/vote'
#resp, content = HTTP.request(url, 'GET', headers=HEADERS)

#def getVote():
#  host = 'cjurl.me'
#  url = "http://" + HOST+'/vote'
#  resp, content = HTTP.request(url, 'GET', headers=HEADERS)
#  return content

###################################################
#
# Utilities
#
###################################################

def fetch(key):
  resp, content = HTTP.request(SITE+'/'+key, 'GET', headers=HEADERS)
  return content.decode('utf-8')

def fetchJson(key): return json.loads(fetch(key))

def fetchNames(key): return [pair.get('name','???') for pair in fetchJson(key)]
  
###################################################
#
# Rest calls
#
###################################################

def getElections(): return fetchNames('elections')

def getVoters(): return fetchNames('voters')

def getCandidates(election):
  url = SITE + '/elections/' + urllib.parse.quote(election) + '/candidates'
  resp, content = HTTP.request(url, 'GET', headers=HEADERS)
  data = json.loads(content.decode('utf-8'))
  return [pair.get('name','???') for pair in data]

elections = getElections()
voters = getVoters()
candidates = getCandidates('NaN Celebration')
  
  


  



