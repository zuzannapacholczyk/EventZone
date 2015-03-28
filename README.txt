DATABASE - README

1. Instalujesz bazę Oracle 11g express
tutaj: http://www.oracle.com/technetwork/database/database-technologies/express-edition/downloads/index.html

Dane ustawiane podczas instalacji:
Hasło: password
Port for 'Oracle Database Listener': 1521
Port for 'Oracle Services for Microsoft Transaction Server': 2030
Port for 'Oracle HTTP Listener': 8080

2. Uruchamiasz "Get Started" 
	Klikasz Application Express
	Logujesz się jako login: SYSTEM, hasło: password
	Tworzysz użytkownika: loginL eventzone, password: eventzone
	Klikasz: Create workspace

3. Instalujesz SQL Developer
tutaj: http://www.oracle.com/technetwork/developer-tools/sql-developer/downloads/index.html

4. Po uruchomieniu 
	Tworzysz nowe połączenie z danymi: Username: eventzone, password: eventzone, SID: xe, port: 1521
	Klikasz: File -> Open i wybierasz plik .sql, który jest na githubie
	Klikasz zieloną strzałkę i zaznaczasz, że ma ona się wykonać dla utworzonego wcześniej połączenia.
	Klikasz commit (F11) (na tym samym pasku, co zielona strzałka - symbol bazy danych)

Teraz powinieneś przy swoim połączeniu widzieć tabele itd.