# webtail readme

- This is an application that allows you to print a server's logfile from a web browser like tail -f

- execute run.sh = nohup java -jar webtail-0.0.1-SNAPSHOT.jar -Dspring.profiles.active=dev -Dlogfile.path=c:/tmp/tmp.log -Dwebsocket.url=ws://localhost:8070/webtail1 -Dwebsocket.handler=/webtail1 2>&1 &

- -Dlogfile.path = The full pathname of the log file you want to tailing

- -Dwebsocket.url = ws://server ip or domain + port/webtail1 

- -Dwebsocket.handler = Enter /webtail1 to associate it with the websocket

- Click the top left toggle button to toggle auto-scroll on/off

- In your browser, go to http://localhost:8070/tail
  because of @GetMapping(path="/tail")
  