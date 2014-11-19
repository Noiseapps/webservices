README
-----------

Projekt z zajęć z webservices.

Każda gałąź będzie odpowiadała jednym zajęciom. (poza master :) - ona jest for fun)

Projekt jest skonfigurowany do pracy z IntelliJ IDEA Ultimate Edition - dla studentów jest dostępna za darmo,
po założeniu konta na https://www.jetbrains.com/student/ z adresem \<index\>@edu.p.lodz.pl

Do działania tego projektu trzeba mieć zainstalowanego i skonfigurowanego Tomcata (testowane na 7)
Projekt testowany pod Ubuntu - na Win pewnie będzie podobnie.

Konfiguracja TC:
-

Run -> Edit configurations... -> Dodajemy nowy Tomcat Server, konfigurujemy ścieżki, artefakt
do zdeployowania i powinno działać.

Potem w przeglądarce wchodzimy na localhost:\<port\>/webapi/myresource i powinno wypisać "Got it"
