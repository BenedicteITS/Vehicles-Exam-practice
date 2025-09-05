# Java OOP Exam Practice – File to Database

## About the Project
This project is based on an **old Java exam assignment** that I used for practice in Object-Oriented Programming (OOP).  
The goal of the program is to:
1. **Read data from a file**
2. **Store the data in a database**
3. **Retrieve and display specific data** through a terminal-based interface

It was created purely for learning purposes and to strengthen my skills in Java, file handling, database integration, and console-based interaction.

---
## Task

Det nyopprettede selskapet Scrapyard med filialer i tre norske byer tar imot biler og motorsykler. De 
ønsker å strukturere informasjonen de har om de ulike kjøretøyene. De har laget en fil med 
informasjon (vehicles.txt), og denne informasjonen skal overføres til en database. For en beskrivelse 
av filen, se vedlegg 1. 

**Del 1 - importere data til database:**
Du skal lage et program som leser fra filen vehicles.txt og legger dataene inn i en database. Et forslag 
t
 il databasestruktur finner du i filen scrapyard.sql. Du kan velge å gjøre justeringer i scrapyard.sql, 
men det skal ikke være nødvendig. Det er heller ikke anbefalt å gjøre endringer i databasen da det vil 
stjele tid. Du trenger ikke å kjøre databasescriptet via Java. Det kan du like gjerne kjøre i MySQL 
Workbench, så er databasen din på plass. 
Når du er ferdig med del 1 bør du ha: - - - 
En velfungerende database som har informasjon om skraphandlerstedene (scrapyards) og 
kjøretøy (vehicles). Tabellene i databasen er fylt med data basert på filen vehicles.txt. 
En eller flere klasser som kan kommunisere med databasen. 
En eller flere klasser som kan holde i data fra databasen. Det er forventet at arv benyttes for 
klasser som omfatter ulike typer kjøretøy ettersom de har mange felles egenskaper. Det er 
også forventet at disse klassene blir benyttet i kommunikasjon med databasen. 

**Del 2 – bruke databasen:**
Du skal lage et lite program som tilbyr brukeren en meny med noen menyvalg som omhandler 
skraphandlerstedene og kjøretøyene som nå er plassert i databasen (etter at del 1 er gjennomført). 
Du kan selv velge om du vil ha to main-metoder (en for del 1 og en for del 2), eller om du vil 
kommentere ut koden for del 1 når du utvikler del 2. Eller du kan velge å ha del 1 og del 2 i samme 
program. 
Programmet skal tilby følgende funksjonalitet: - - - - - 
Se informasjon om alle kjøretøy. 
Se informasjon om hvor mye drivstoff som befinner seg i fossilbilene totalt. 
Se informasjon om alle kjøretøy som er kjørbare. 
En valgfri funksjonalitet som du selv velger. Valgt funksjonalitet må medføre kommunikasjon 
med databasen. 
Avslutte programmet. 


##  Purpose
- Practice **Object-Oriented Programming** principles in Java
- Work with **file I/O** to read and parse data
- Learn how to **connect Java to a database** and interact with the database through a Java program
- Build a simple **terminal program** for querying and displaying data

---

##  Status
**Not a production project** – this is a practice exercise based on an old exam task.  
Some parts are implemented, but the project is not fully complete.

---

##  Technologies Used
- **Java** (Object-Oriented Programming)
- **JDBC** (Java Database Connectivity)
- **MySQL** (for database operations)
- **Terminal/Console** for user interaction

---
