# OrangeHRM Automation Project

Proiect de testare automata dezvoltat ca parte a unui curs de QA Automation.
Acopera testarea UI a aplicației OrangeHRM si testarea API cu ReqRes.

---

## Tehnologii folosite

![Java](https://img.shields.io/badge/Java-11-orange)
![Maven](https://img.shields.io/badge/Maven-4.0.0-blue)
![Selenium](https://img.shields.io/badge/Selenium-4.44.0-green)
![TestNG](https://img.shields.io/badge/TestNG-7.12.0-yellow)
![RestAssured](https://img.shields.io/badge/RestAssured-6.0.0-brightgreen)
![Allure](https://img.shields.io/badge/Allure-2.27.0-purple)

---

## Cum rulezi proiectul

**Prerequisite:** Java 11+, Maven, Google Chrome

1. Cloneaza repository-ul
2. Deschide proiectul in IntelliJ
3. Ruleaza `mvn clean test` din terminal

sau direct din IntelliJ — click dreapta pe `UITests/APITests` → Run

Pentru raport Allure:

`allure serve allure-results`

---

## Ce testeaza proiectul

### UI — OrangeHRM (14 teste)

**Login & Logout**
- Login cu credentiale valide si verificare dashboard
- Login cu credentiale invalide si verificare mesaj de eroare
- Logout si verificare redirectionare

**Angajati**
- Adaugare angajat nou si verificare salvare

**Navigare**
- Verificare navigare pe toate meniurile principale
  (Admin, PIM, Leave, Time, Recruitment, Dashboard, Directory, Buzz)

**Performanta**
- Adaugare KPI nou si verificare salvare

**Admin**
- Reset filtre in pagina de administrare si verificare

### API — ReqRes (8 teste)

- GET users — verificare lista utilizatori
- GET user single — verificare date utilizator specific
- GET user inexistent — verificare raspuns 404
- POST user — creare utilizator nou si verificare date returnate
- DELETE user — stergere utilizator si verificare status code
- Response time — verificare timp de raspuns sub 3 secunde

---

## Structura proiectului

**src/main/java/**
- `pages/` — Page Object Model (BasePage, LoginPage, DashboardPage etc.)
- `utils/` — DriverFactory, ConfigReader, WaitUtils, RetryAnalyzer

**src/test/java/**
- `UITests/` — teste UI organizate pe functionalitati
- `APITests/` — teste API cu RestAssured

**src/test/java/**
- `UIBaseTest/` — BaseTest cu setup si teardown
- `UITests/` — teste UI organizate pe functionalitati
- `APIBaseTest/` — BaseTest pentru API
- `APITests/` — teste API cu RestAssured
- `config/` — configurari teste
- `data/` — date de test
---

## Design Patterns utilizate

- **Page Object Model (POM)** — fiecare pagina are clasa ei separata
- **Page Factory** — initializare elemente cu `@FindBy` in BasePage
- **Base Page** — cod comun mostenit de toate paginile
- **Base Test** — setup si teardown comun pentru toate testele

---

## Note importante

- Testele de Admin si KPI pot pica ocazional din cauza instabilitatii serverului demo OrangeHRM
- La fiecare rulare a testului de Employee se creeaza un angajat nou in sistem
- Serverul demo OrangeHRM este public si poate fi accesat simultan de alti utilizatori
- ReqRes necesita API key pentru planul gratuit — testele acopera endpoint-urile disponibile

---

## Autor

Iulia Lukacs — Curs QA Automation 2026