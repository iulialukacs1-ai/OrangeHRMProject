# Bug Report

## BR-001 — Campurile First Name si Last Name accepta caractere speciale

**Data:** 24.05.2026  
**Aplicație:** OrangeHRM Demo  
**URL:** https://opensource-demo.orangehrmlive.com/  
**Raportat de:** Iulia Lukacs

---

**Severitate:** Medium  
**Prioritate:** Medium  
**Status:** Open

---

## Descriere

Campurile First Name si Last Name din pagina Add Employee accepta caractere speciale
(@, #, $, %, ! etc.) fara nicio validare sau mesaj de eroare.

---

## Pasi de reproducere

1. Acceseaza https://opensource-demo.orangehrmlive.com/
2. Login cu username: `Admin` / password: `admin123`
3. Navigheaza la **PIM → Add Employee**
4. Completeaza campul First Name cu `@@@@@@@`
5. Completeaza campul Last Name cu `!!!!!!!`
6. Click **Save**

---

## Rezultat actual

Angajatul este salvat cu succes cu caractere speciale in campurile de nume.

## Rezultat asteptat

Aplicatia afiseaza un mesaj de eroare si nu permite
salvarea unui nume care contine caractere speciale.

---

## Impact

Un angajat poate fi inregistrat in sistem cu un nume invalid,
ceea ce poate cauza probleme in rapoarte si exporturi de date.

---
