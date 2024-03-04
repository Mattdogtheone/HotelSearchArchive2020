# Tesztjegyzőkönyv

## 1. Teszteljárások (TP)

### 1.1. Regisztráció funkció tesztelése 
- Azonosító: TP-01
- Tesztesetek: TC-01, TC-02, TC-03
- Leírás: Regisztráció funkció tesztelése
    0. lépés: Nyissuk meg az oldalt, és gépeljük be az adatokat
    1. lépés: Az `INPUT1` szövegbeviteli mezőbe írjunk be a `FELHNEV` felhasználónevet
    2. lépés: Az `INPUT2` szövegbeviteli mezőbe írjunk be az `EMAIL` e-mail címet
	3. lépés: Az `INPUT3` szövegbeviteli mezőbe írjunk be a `JELSZO1` jelszót
	4. lépés: Az `INPUT4` szövegbeviteli mezőbe írjunk be a `JELSZO2` jelszót megerősítésként
    5. lépés: Nyomjuk meg a `REGISZTRACIO` gombot 
    6. lépés: Ellenőrizzük az eredményt. Elvárt eredmény: `OUTPUT` = Sikeres regisztráció

### 1.2. Bejelentkezés funkció tesztelése
- Azonosító: TP-02
- Tesztesetek: TC-01
- Leírás: Bejelentkezés funkció tesztelése
    0. lépés: Nyissuk meg az oldalt, és gépeljük be az adatokat
    1. lépés: Az `INPUT1` szövegbeviteli mezőbe írjunk be az `EMAIL` e-mail címet
	2. lépés: Az `INPUT2` szövegbeviteli mezőbe írjunk be a `JELSZO1` jelszót
    3. lépés: Nyomjuk meg a `BEJELENTKEZES` gombot 
    4. lépés: Ellenőrizzük az eredményt. Elvárt eredmény: `OUTPUT` = Sikeres bejelentkezés, áttérés a főoldalra
	
### 1.3. Keresés funkció tesztelése
- Azonosító: TP-03
- Tesztesetek: TC-01
- Leírás: Keresés funkció tesztelése
    0. lépés: Nyissuk meg az oldalt, és gépeljük be az keresett szót
    1. lépés: Az `INPUT1` szövegbeviteli mezőbe írjunk be a `KERESSZO` szót
    2. lépés: Nyomjuk meg a `KERESES` gombot 
    3. lépés: Ellenőrizzük az eredményt. Elvárt eredmény: Kilistázza a dolgokat keresett szóval
	
### 1.4. Foglalás funkció tesztelése
- Azonosító: TP-04
- Tesztesetek: TC-01
- Leírás: Foglalás funkció tesztelése
    0. lépés: Nyissuk meg az oldalt, és gépeljük be az keresett szót
    1. lépés: Az `DATE1` naptárszerű táblázatban megjelöljük a `METTOL` bejelentkezési időpontot
	2. lépés: Az `DATE2` naptárszerű táblázatban megjelöljük a `MEDDIG` kijelentkezési időpontot
    3. lépés: Nyomjuk meg a `FOGLALÁS` gombot 
    4. lépés: Ellenőrizzük az eredményt. Elvárt eredmény: `OUTPUT` = Sikeres foglalás
	
### 1.5. Visszamondás funkció tesztelése
- Azonosító: TP-05
- Tesztesetek: TC-01
- Leírás: Lemondás funkció tesztelése
    0. lépés: Nyissuk meg az oldalt, és keressük a foglalt szállást, amit le akarunk mondani
	1. lépés: Kiválasztjuk a szállást
    2. lépés: Nyomjuk meg a `LEMONDAS` gombot 
    3. lépés: Ellenőrizzük az eredményt. Elvárt eredmény: `OUTPUT` = Sikeres visszamondás
	
### 1.6. Értékelés funkció tesztelése
- Azonosító: TP-06
- Tesztesetek: TC-01
- Leírás: Értékelés funkció tesztelése
    0. lépés: Nyissuk meg az oldalt, és keressük a foglalt szállást, amit értékelni akarunk
	1. lépés: Kiválasztjuk az elégedettségi szintet 5-ös skálán `NUMBER` helyére
    2. lépés: Nyomjuk meg a `ERTEKELES` gombot 
    3. lépés: Ellenőrizzük az eredményt. Elvárt eredmény: `OUTPUT` = Sikeres értékelés
	
### 1.7. Szoba létrehozása funkció tesztelése
- Azonosító: TP-07
- Tesztesetek: TC-01
- Leírás: Szoba létrehozása funkció tesztelése
    0. lépés: Nyissuk meg az oldalt, és nyomjuk meg a szoba létrehozást
	1. lépés: Kitöltjük a szoba adatait (`SZOBASZAM` = szobaszám, `KAPACITAS` = kapacitás, `AR` = ár/fő, `TIPUS` = ágytípus, `VANKONYHA` = vankonyha, `LEIRAS` = leírás, `KEP` = képfeltöltés)
    2. lépés: Nyomjuk meg a `LETREHOZAS` gombot 
    3. lépés: Ellenőrizzük az eredményt. Elvárt eredmény: `OUTPUT` = Sikeres létrehozás
	
### 1.8. Szoba módosítása funkció tesztelése
- Azonosító: TP-08
- Tesztesetek: TC-01
- Leírás: Szoba módosítása funkció tesztelése
    0. lépés: Nyissuk meg az oldalt, és kiválasztjuk azt a szobát, ahol módosítani akarjuk az adatait
	1. lépés: Módosítjuk a szoba adatait
    2. lépés: Nyomjuk meg a `MODOSIT` gombot 
    3. lépés: Ellenőrizzük az eredményt. Elvárt eredmény: `OUTPUT` = Sikeres módosítás
	
### 1.9. Szoba törlése funkció tesztelése
- Azonosító: TP-09
- Tesztesetek: TC-01, TC-02
- Leírás: Szoba törlése funkció tesztelése
    0. lépés: Nyissuk meg az oldalt, és kiválasztjuk azt a szobát, amelyiket törölni akarjuk
    1. lépés: Nyomjuk meg a `TORLES` gombot 
    2. lépés: Ellenőrizzük az eredményt. Elvárt eredmény: `OUTPUT` = Sikeres törlés
	
### 1.10. Szolgáltatások hozzáadása funkció tesztelése
- Azonosító: TP-10
- Tesztesetek: TC-01
- Leírás: Szolgáltatások hozzáadása funkció tesztelése
    0. lépés: Nyissuk meg az oldalt, és kiválasztjuk azt a szobát, amelyikhez akarunk hozzáadni a szolgáltatásait
	1. lépés: Az `INPUT1` szövegbeviteli mezőbe írjunk be a `SZOLGNEV` szolgáltatást
	2. lépés: Az `INPUT2` szövegbeviteli mezőbe írjunk be a `NUMBER` szolgáltatás árát
    3. lépés: Nyomjuk meg a `HOZZAAD` gombot 
    4. lépés: Ellenőrizzük az eredményt. Elvárt eredmény: `OUTPUT` = Sikeres hozzáadás
	
### 1.11. Szolgáltatások törlése funkció tesztelése
- Azonosító: TP-11
- Tesztesetek: TC-01
- Leírás: Szolgáltatások törlése funkció tesztelése
    0. lépés: Nyissuk meg az oldalt, és kiválasztjuk azt a szobát, amelyiknek a szolgáltatását törölni akarjuk
    1. lépés: Nyomjuk meg a `TOROL` gombot 
    2. lépés: Ellenőrizzük az eredményt. Elvárt eredmény: `OUTPUT` = Sikeres törlés	

## 2. Teszesetek (TC)

### 2.1. Regisztáció funkció tesztesetei

#### 2.1.1. TC-01
- TP: TP-01
- Leírás: regisztráció funkció tesztelése 
- Bemenet: `FELHNEV` = Vkineknevevan ; `EMAIL` = nevevan@globail.com;  `JELSZO1` = Vannevem1; `JELSZO2` = Vannevem1;
- Művelet: nyomjuk meg a `REGISZTRACIO` gombot 
- Elvárt kimenet: az eredmény mező tartalma: `OUTPUT` = Sikeres regisztráció

#### 2.1.2. TC-02
- TP: TP-01
- Leírás: regisztráció funkció tesztelése 
- Bemenet: `FELHNEV` = Vkineknevevan ; `EMAIL` = nevevan@globail.com;  `JELSZO1` = Vannevem1; `JELSZO2` = Nevemvan2;
- Művelet: nyomjuk meg a `REGISZTRACIO` gombot 
- Elvárt kimenet: az eredmény mező tartalma: `OUTPUT`= HIBA (`JELSZO1` és `JELSZO2` nem egyeznek meg)

#### 2.1.3. TC-03
- TP: TP-01
- Leírás: regisztráció funkció tesztelése 
- Bemenet: `FELHNEV` = Vkineknevevan ; `EMAIL` = nevevan#globail.com;  `JELSZO1` = Vannevem1; `JELSZO2` = Vannevem1;
- Művelet: nyomjuk meg a `REGISZTRACIO` gombot 
- Elvárt kimenet: az eredmény mező tartalma: `OUTPUT`= HIBA (`EMAIL` nem e-mail cím)

### 2.2. Bejelentkezés funkció tesztesetei

#### 2.2.1. TC-01
- TP: TP-02
- Leírás: bejelentkezés funkció tesztelése
- Bemenet: `EMAIL` = nevevan@globail.com; `JELSZO1` = Vannevem1
- Művelet: nyomjuk meg a `BEJELENTKEZES` gombot 
- Elvárt kimenet: az eredmény mező tartalma: Áttérés a főoldalra , `OUTPUT` = Sikeres bejelentkezés

### 2.3. Keresés funkció tesztesetei

#### 2.3.1. TC-01
- TP: TP-03
- Leírás: keresés funkció tesztelése
- Bemenet: `KERESSZO` = Győr ; 
- Művelet: nyomjuk meg a `KERESES` gombot 
- Elvárt kimenet: az eredmény mező tartalma: Találatok kilistázása , `OUTPUT` = Győr

### 2.4. Foglalás funkció tesztesetei

#### 2.4.1. TC-01
- TP: TP-04
- Leírás: foglalás funkció tesztelése
- Bemenet: `METTOL` = 2021.07.12. ; `MEDDIG` = 2021.07.15.
- Művelet: nyomjuk meg a `FOGLALAS` gombot 
- Elvárt kimenet: az eredmény mező tartalma: `OUTPUT` = Sikeres foglalás

### 2.5. Lemondás funkció tesztesetei

#### 2.5.1. TC-01
- TP: TP-05
- Leírás: lemondás funkció tesztelése
- Bemenet: -
- Művelet: kiválasztjuk a lemondani kívánt szállást, aztán nyomjuk meg a `LEMONDAS` gombot 
- Elvárt kimenet: az eredmény mező tartalma: Találatok kilistázása , `OUTPUT` = Sikeres lemondás

### 2.6. Értékelés funkció tesztesetei

#### 2.6.1. TC-01
- TP: TP-06
- Leírás: értékelés funkció tesztelése
- Bemenet: `NUMBER` = 4
- Művelet: kiválasztjuk az értékelni kívánt szállást, aztán nyomjuk meg a `ERTEKELES` gombot 
- Elvárt kimenet: az eredmény mező tartalma: `OUTPUT` = Sikeres értékelés

### 2.7. Szoba létrehozása funkció tesztesetei

#### 2.7.1. TC-01
- TP: TP-07
- Leírás: szoba létrehozása funkció tesztelése
- Bemenet: `SZOBASZAM` = 1; `KAPACITAS` = 2; `AR` = 10000; `TIPUS` = francia; `VANKONYHA` = igen; `LEIRAS` = ""; `KEP` = képfeltöltés
- Művelet: kiválasztjuk a szállást, amelyiknek hozzá akarjuk adni a szobáját, aztán nyomjuk meg a `LETREHOZ` gombot 
- Elvárt kimenet: az eredmény mező tartalma: `OUTPUT` = Sikeres létrehozás

### 2.8. Szoba módosítása funkció tesztesetei

#### 2.8.1. TC-01
- TP: TP-08
- Leírás: szoba módosítása funkció tesztelése
- Bemenet: `INPUT1` = 2; `INPUT2` = 4; `INPUT3` = 4000; `INPUT4` = koedukált; `INPUT5` = igen; `INPUT6` = ""; `IMPUT7` = képfeltöltés
- Művelet: kiválasztjuk a szállást, amelyiknek a szobáját módosítani akarjuk, aztán nyomjuk meg a `MODOSIT` gombot 
- Elvárt kimenet: az eredmény mező tartalma: `OUTPUT` = Sikeres módosítás

### 2.9. Szoba törlése funkció tesztesetei

#### 2.9.1. TC-01
- TP: TP-09
- Leírás: szoba törlése funkció tesztelése
- Bemenet: -
- Művelet: kiválasztjuk a szállást, amelyiknek a szobáját törölni akarjuk, aztán nyomjuk meg a `TOROL` gombot 
- Elvárt kimenet: az eredmény mező tartalma: `OUTPUT` = Sikeres törlés

#### 2.9.2. TC-02
- TP: TP-09
- Leírás: szoba törlése funkció tesztelése
- Bemenet: -
- Művelet: kiválasztjuk a szállást, amelyiknek a szobáját törölni akarjuk, aztán nyomjuk meg a `TOROL` gombot 
- Elvárt kimenet: az eredmény mező tartalma: `OUTPUT` = HIBA ( Erre a szobára foglaltak! )

### 2.10. Szolgáltatások hozzáadása funkció tesztesetei

#### 2.10.1. TC-01
- TP: TP-10
- Leírás: szolgáltatások hozzáadása funkció tesztelése
- Bemenet: `SZOLGNEV` = fürdőköpeny; `NUMBER` = 800
- Művelet: kiválasztjuk a szállást, amelyiknek a szobájának a szolgáltatását hozzá akarjuk adni, aztán nyomjuk meg a `HOZZAAD` gombot 
- Elvárt kimenet: az eredmény mező tartalma: `OUTPUT` = Sikeres hozzáadás

### 2.11. Szolgáltatások törlése funkció tesztesetei

#### 2.11.1. TC-01
- TP: TP-11
- Leírás: szolgáltatások törlése funkció tesztelése
- Bemenet: `-
- Művelet: kiválasztjuk a szállást, amelyiknek a szobájának a szolgáltatását törölni akarjuk, aztán nyomjuk meg a `TOROL` gombot 
- Elvárt kimenet: az eredmény mező tartalma: `OUTPUT` = Sikeres törlés

## 3. Tesztriportok (TR)

### 3.1. Regisztráció funkció tesztriportjai

#### 3.1.1. TR-01 (TC-01)
- TP: TP-01
    1. lépés: Vkineknevevan-t beírtam
    2. lépés: nevevan@globail.com-t beírtam 
	3. lépés: Vannevem1-t beírtam
	4. lépés: Vannevem1-t beírtam
    3. lépés: a gomb egyszeri megnyomás után inaktív lett
    4. lépés: helyes eredményt kaptam (Sikeres regisztráció)
    

#### 3.1.2. TR-02 (TC-02)
- TP: TP-01
    1. lépés: Vkineknevevan-t beírtam
    2. lépés: nevevan@globail.com-t beírtam 
	3. lépés: Vannevem1-t beírtam
	4. lépés: Nevemvan2-t beírtam
    3. lépés: a gomb egyszeri megnyomás után inaktív lett
    4. lépés: helyes eredményt kaptam (HIBA)
	
	
#### 3.1.3. TR-03 (TC-03)
- TP: TP-01
    1. lépés: Vkineknevevan-t beírtam
    2. lépés: nevevan#globail.com-t beírtam 
	3. lépés: Vannevem1-t beírtam
	4. lépés: Vannevem1-t beírtam
    3. lépés: a gomb egyszeri megnyomás után inaktív lett
    4. lépés: helyes eredményt kaptam (HIBA)

### 3.2. Bejelentkezés funkció tesztriportjai

#### 3.2.1. TR-01 (TC-01)
- TP: TP-02
    1. lépés: nevevan@globail.com-t beírtam
	2. lépés: Vannevem1-t beírtam
    3. lépés: a gomb egyszeri megnyomás után inaktív lett
    4. lépés: helyes eredményt kaptam (Sikeres bejelentkezés)
	
### 3.3. Keresés funkció tesztriportjai

#### 3.3.1. TR-01 (TC-01)
- TP: TP-03
    1. lépés: Győr-t beírtam
    2. lépés: a gomb egyszeri megnyomás után inaktív lett
    3. lépés: helyes eredményt kaptam (találatok kilistázása)
	
### 3.4. Foglalás funkció tesztriportjai

#### 3.4.1. TR-01 (TC-01)
- TP: TP-04
    1. lépés: 2021.07.12.-t kiválasztottam
	2. lépés: 2021.07.15.-t kiválasztottam
    3. lépés: a gomb egyszeri megnyomás után inaktív lett
    4. lépés: helyes eredményt kaptam (Sikeres foglalás)
	
### 3.5. Lemondás funkció tesztriportjai

#### 3.5.1. TR-01 (TC-01)
- TP: TP-05
    1. lépés: kiválasztottam a lemondani kívánt szállást
    2. lépés: a gomb egyszeri megnyomás után inaktív lett
    3. lépés: helyes eredményt kaptam (Sikeres lemondás)
	
### 3.6. Értékelés funkció tesztriportjai

#### 3.6.1. TR-01 (TC-01)
- TP: TP-06
    1. lépés: kiválasztottam az értékelni kívánt szállást
	2. lépés: 4-t kiválasztottam
    3. lépés: a gomb egyszeri megnyomás után inaktív lett
    4. lépés: helyes eredményt kaptam (Sikeres értékelés)
	
### 3.7. Szoba létrehozás funkció tesztriportjai

#### 3.7.1. TR-01 (TC-01)
- TP: TP-07
    1. lépés: kiválasztottam a szállást, aminek a szobáját hozzá akarjuk adni
	2. lépés: 1-t beírtam
	3. lépés: 2-t beírtam
	4. lépés: 10000-t beírtam
	5. lépés: francia-t beírtam
	6. lépés: igen-t kiválasztottam
	7. lépés: semmit nem írtam be
	8. lépés: Képet beszúrtam
    9. lépés: a gomb egyszeri megnyomás után inaktív lett
    10. lépés: helyes eredményt kaptam (Sikeres létrehozás)
	
### 3.8. Szoba módosítás funkció tesztriportjai

#### 3.8.1. TR-01 (TC-01)
- TP: TP-08
    1. lépés: kiválasztottam a szállást, aminek a szobáját módosítani akarjuk
	2. lépés: 2-t beírtam
	3. lépés: 4-t beírtam
	4. lépés: 4000-t beírtam
	5. lépés: koedukált-t beírtam
	6. lépés: igen-t kiválasztottam
	7. lépés: semmit nem írtam be
	8. lépés: Képet beszúrtam
    9. lépés: a gomb egyszeri megnyomás után inaktív lett
    10. lépés: helyes eredményt kaptam (Sikeres módosítás)
	
### 3.9. Szoba létrehozás funkció tesztriportjai

#### 3.9.1. TR-01 (TC-01)
- TP: TP-09
    1. lépés: kiválasztottam a szállást, aminek a szobáját törölni akarjuk
    2. lépés: a gomb egyszeri megnyomás után inaktív lett
    3. lépés: helyes eredményt kaptam (Sikeres törlés)
	
#### 3.9.2. TR-02 (TC-02)
- TP: TP-09
    1. lépés: kiválasztottam a szállást, aminek a szobáját törölni akarjuk
    2. lépés: a gomb egyszeri megnyomás után inaktív lett
    3. lépés: helyes eredményt kaptam (HIBA)
	
### 3.10. Szolgáltatás hozzáadás funkció tesztriportjai

#### 3.10.1. TR-01 (TC-01)
- TP: TP-010
    1. lépés: kiválasztottam a szállásnak a szobáját, aminek a szolgáltatását hozzá akarjuk adni
	2. lépés: fürdőköpeny-t beírtam
	3. lépés: 800-t beírtam
    4. lépés: a gomb egyszeri megnyomás után inaktív lett
    5. lépés: helyes eredményt kaptam (Sikeres hozzáadás)
	
### 3.11. Szolgáltatás törlés funkció tesztriportjai

#### 3.11.1. TR-01 (TC-01)
- TP: TP-11
    1. lépés: kiválasztottam a szállásnak a szobáját, aminek a szolgáltatását törölni akarjuk
    2. lépés: a gomb egyszeri megnyomás után inaktív lett
    3. lépés: helyes eredményt kaptam (Sikeres törlés)


    