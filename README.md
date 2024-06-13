# webtail readme

- This is an application that allows you to print a server's logfile from a web browser like tail -f

- execute run.sh = nohup java -Dspring.profiles.active=dev -Dserver.port=8070 -Dlogfile.path=/logs/was.log -Dwebsocket.url=ws://localhost:8070/webtail1 -Dwebsocket.handler=/webtail1 -Dfile.encoding=UTF-8 -jar webtail-0.0.1-SNAPSHOT.jar > /dev/null 2>&1 &

- -Dserver.port = set server port

- -Dlogfile.path = The full pathname of the log file you want to tailing

- -Dwebsocket.url = ws://${server.ip}:${server.port}/webtail1 

- -Dwebsocket.handler = Enter /webtail1 to associate it with the websocket

- Click the top left toggle button to toggle auto-scroll on/off

- In your browser, go to http://${server.ip}:${server.port}/tail
  because of @GetMapping(path="/tail")


