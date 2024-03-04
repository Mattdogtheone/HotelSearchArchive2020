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
	3. lépés: Az `INPUT4` szövegbeviteli mezőbe írjunk be a `JELSZO2` jelszót megerősítésként
    3. lépés: Nyomjuk meg a `REGISZTRACIO` gombot 
    4. lépés: Ellenőrizzük az eredményt. Elvárt eredmény: `OUTPUT` = Sikeres regisztráció

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
	3. lépés: Az `INPUT1` szövegbeviteli mezőbe írjunk be a `NUMBER1` számot, hányan jönnek
    4. lépés: Nyomjuk meg a `FOGLALÁS` gombot 
    5. lépés: Ellenőrizzük az eredményt. Elvárt eredmény: `OUTPUT` = Sikeres foglalás
	
### 1.5. Fizetés funkció tesztelése
- Azonosító: TP-05
- Tesztesetek: TC-01, TC-02
- Leírás: Fizetés funkció tesztelése
    0. lépés: Foglalás után átirányít egy fizetési oldalra, és gépeljük be az adatokat
    1. lépés: Az `INPUT1` szövegbeviteli mezőbe írjunk be a `NEV_BANK` szót
	2. lépés: Az `INPUT2` szövegbeviteli mezőbe írjunk be a `SZAM_BANK` 16 jegyű számot
	3. lépés: Az `INPUT3` szövegbeviteli mezőbe írjunk be a `DAT_BANK` számot (hh/yy formában)
	3. lépés: Az `INPUT4` szövegbeviteli mezőbe írjunk be a `KOD_BANK` háromjegyű számot
    2. lépés: Nyomjuk meg a `FIZETES` gombot 
    3. lépés: Ellenőrizzük az eredményt. Elvárt eredmény: `OUTPUT` = Sikeres fizetés
	
### 1.6. Visszamondás funkció tesztelése
- Azonosító: TP-06
- Tesztesetek: TC-01
- Leírás: Lemondás funkció tesztelése
    0. lépés: Nyissuk meg az oldalt, és keressük a foglalt szállást, amit le akarunk mondani
	1. lépés: Kiválasztjuk a szállást
    2. lépés: Nyomjuk meg a `LEMONDAS` gombot 
    3. lépés: Ellenőrizzük az eredményt. Elvárt eredmény: `OUTPUT` = Sikeres visszamondás

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
- Bemenet: `METTOL` = 2021.07.12. ; `MEDDIG` = 2021.07.15. ; `NUMBER1` = 2
- Művelet: nyomjuk meg a `FOGLALAS` gombot 
- Elvárt kimenet: az eredmény mező tartalma: `OUTPUT` = Sikeres foglalás

### 2.5. Fizetés funkció tesztesetei

#### 2.5.1. TC-01
- TP: TP-05
- Leírás: fizetés funkció tesztelése
- Bemenet: `NEV_BANK` = Van Nevem ; `SZAM_BANK` = 5225 1490 3714 8566 ; `DAT_BANK` = 04/22 ; `KOD_BANK` = 123
- Művelet: nyomjuk meg a `FIZETES` gombot 
- Elvárt kimenet: az eredmény mező tartalma: `OUTPUT` = Sikeres fizetés

#### 2.5.2. TC-02
- TP: TP-05
- Leírás: fizetés funkció tesztelése
- Bemenet: `NEV_BANK` = Van Nevem ; `SZAM_BANK` = 5225 1490 3714 8566 ; `DAT_BANK` = ; `KOD_BANK` = 123
- Művelet: nyomjuk meg a `FIZETES` gombot 
- Elvárt kimenet: az eredmény mező tartalma: `OUTPUT` = HIBA (`DAT_BANK` kitöltendő)

### 2.6. Lemondás funkció tesztesetei

#### 2.6.1. TC-01
- TP: TP-06
- Leírás: lemondás funkció tesztelése
- Bemenet: -
- Művelet: kiválasztjuk a lemondani kívánt szállást, aztán nyomjuk meg a `LEMONDÁS` gombot 
- Elvárt kimenet: az eredmény mező tartalma: Találatok kilistázása , `OUTPUT` = Sikeres lemondás

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
	3. lépés: 2-t beírtam
    4. lépés: a gomb egyszeri megnyomás után inaktív lett
    5. lépés: helyes eredményt kaptam (Sikeres foglalás)
	
### 3.5. Fizetés funkció tesztriportjai

#### 3.5.1. TR-01 (TC-01)
- TP: TP-05
    1. lépés: Van Nevem-t beírtam
	2. lépés: 5225 1490 3714 8566-t beírtam
	3. lépés: 04/22-t beírtam
	4. lépés: 123-t beírtam
    5. lépés: a gomb egyszeri megnyomás után inaktív lett
    6. lépés: helyes eredményt kaptam (Sikeres fizetés)
	
#### 3.5.2. TR-02 (TC-02)
- TP: TP-05
    1. lépés: Van Nevem-t beírtam
	2. lépés: 5225 1490 3714 8566-t beírtam
	3. lépés: 123-t beírtam
    4. lépés: a gomb egyszeri megnyomás után inaktív lett
    5. lépés: helyes eredményt kaptam (HIBA)
	
### 3.6. Lemondás funkció tesztriportjai

#### 3.6.1. TR-01 (TC-01)
- TP: TP-06
    1. lépés: kiválasztottam a lemondani kívánt szállást
    2. lépés: a gomb egyszeri megnyomás után inaktív lett
    3. lépés: helyes eredményt kaptam (Sikeres lemondás)


    