# car_renter

## 1. Követelményanalízis
**Egyszerű autók kölcsönzését/bérbeadását kezelő app. Eltárolhatjuk a kölcsönzők adatait, az autók adatait és az ügyintézők adatait is**
### 1.1 Követelmények

#### Funkcionális követelmények
 - Regisztráció
 - Bejelentkezés
 - Autók böngészése
 - Bejelentkezett felhasználóknak   
   - Rendelés létrehozása
   - Autó kiválasztása
   - Időpont foglalás
     - Autók elvitelére
     - Autók visszahozatalára
   - Adatok módosítása
 - Bejelentkezett ügyintézőknek
   - Rendelések jóváhagyása
   - Autók felvétele
   - Autók visszavétele
   - Autók kiadása
   - Autók törlése
#### Nem funkcionális követelmények
  - Felhasználóbarát: Megfelelően elhatárolt funkciók. Világos látható színekkel írt betűk. Ésszerű elrendezés
  - Biztonság: Jelszóval védett funkciók. A jelszavak titkosítottak.
    A különböző űrlapoknál egy hibalistában kijelzi a program a hibákat.
  - Gyors működés: Adatbázisban operáló program, gyors kereséssekkel hamar előállítja a kívánt eredményeket.
  - Autók képpel való megjelenítése: A felhasználók könnyebb döntése érdekében.

### 1.2 Szakterületi fogalomjegyzék

### 1.3 Használatieset-modell
    
#### Szerepek

- Vendég
- Bejelentkezett Felhasználó
- Ügyintéző

#### Modell

#### Folyamatok 
  - Autó/idópont foglalás
  

##### Egy egyszerű foglalás menete

 1. Először bejelentkezünk a szolgáltatásba.
 2. Böngészhetünk az autók között, vagy foglalhatunk időpontot.
 3. Kiválasztunk egy autót.
 4. Megadjuk mikor vesszük fel az autót.

## 3. Implementáció

### 3.1 Adatbázisterv

![Database terv](pictures/database.PNG)

### 3.2 Fejlesztőkörnyezet

Lokális IDE: Visual Studio Code 
 - Github account nem szükséges, de hasznos
 - Hozzunk létre egy munkakönyvtárat
 - node.js-el töltsük le az adonisJS-t
 - adonissJS hozzuk létre a fejlesztő környezetet
 - Ezen a munkaterületen elkezdhetünk kódolni
 - Miután végeztünk a munkával elmenthetjük lokálisan vagy github-ra
 - Githubra először a Visual Studio-n belül a Stage All-al kijelöljük a pusholni kívánt 
 fájlokat majd commit-áljuk őket. Ezután a Push paranccsal föltölthetjük a github accountunkra

## 6. Felhasználói dokumentáció

### 6.1 Ajánlott követelmények 
A program bármilyen operációs rendszeren futtatható. Javascript szükséges a harc típusú küldetésekhez

### 6.2 Telepítés 
#### Telepítés előtt pár szükséges lépés
  - Kegy NodeJS és az npm amit itt lehet letölteni : [www.npmjs.com/get-npm](https://www.npmjs.com/get-npm)
  - Internet elérés

#### Telepítés
1. Látogasson el a 	[github.com/szubi7/car-hire](https://github.com/Telmike91/alkfejlszerver) oldalra
2. Itt kattintson a **"Clone and Download"** gombra, és azon belül kattintson a **"Download as Zip"** gombra.
3. A letöltött állományt csomagoljuk ki
4. **npm i** parancsot adjuk ki parancssorban a kicsomagolt állomány mappájában.
5. **.env.example**-t nevezzük át **.env**-re és állítsuk be tetszés szerint 
6. **npm start**-al elindíthatjuk a programot (Allapesetben localhost:3333-on fut a program)

### 6.3 Használata
1. Böngészőben a keresősávba írjuk be az **.env** fájlban megadott elérést. (Alapeset: localhost:3333)
2. Regisztrálás és bejelentkezés után használhatjuk a programot.
