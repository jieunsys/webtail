# webtail readme

- This is an application that allows you to print a server's logfile from a web browser like tail -f

- jar file can be run like this
nohup java -jar webtail.jar -Dspring.profiles.active=dev -Dlogfile.path=c:/tmp/tmp.log -Dwebsocket.url=ws://localhost:8070/webtail1 -Dwebsocket.handler=/webtail1

- logfile.path = The full pathname of the log file you want to tailing

- websocket.url = ws://server ip or domain + port/webtail1 

- websocket.handler = Enter /webtail1 to associate it with the websocket

