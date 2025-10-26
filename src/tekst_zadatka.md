# Laboratorijske vežbe – dvočas br. 9

## Zadatak 1
*(radi laborant u saradnji sa studentima)*

Napraviti javnu klasu **Knjiga** u paketu **zadatak1** koja ima:
1. Privatni atribut **naziv** koji predstavlja naziv knjige.
2. Privatni atribut **godina** koji predstavlja godinu izdanja knjige (ceo broj).
3. Javne **get i set metode** za ove atribute.
4. Redefinisanu javnu metodu **equals** klase Object. Metoda prvo proverava da li je uneti objekat klase **Knjiga**, pa ako nije, vraća FALSE. Metoda vraća TRUE ako su naziv i godina knjige jednaki nazivu i godini unete knjige, a inače vraća FALSE.


Napraviti javnu klasu **ProbaKnjiga** u paketu **zadatak1** u kojoj se kreira jedan objekat klase **Knjiga**. Nakon toga, ispisati dužinu naziva knjige u konzoli.

Proširiti klasu **Knjiga** na sledeći način:
1. Početna vrednost za atribut naziv je prazan String ("").
2. Izmeniti **set metodu za atribut naziv** tako da naziv ne može biti NULL. Ukoliko je prosleđen NULL kao parametar, baciti **neproveravani izuzetak** sa porukom "Naziv ne moze biti NULL".

Izmeniti klasu **ProbaKnjiga** tako da se knjizi kao naziv postavlja NULL. Uhvatiti neproveravani izuzetak koji baca metoda **setNaziv** i ispisati poruku greške u konzoli.

Proširiti klasu **Knjiga** na sledeći način:
1. Izmeniti **set metodu za atribut godina**. Ukoliko prosleđena godina nije u opsegu od 1950 (uključujući ovu godinu) do trenutne godine, baciti **proveravani izuzetak** sa porukom "Godina nije u odgovarajucem opsegu".

Izmeniti klasu **ProbaKnjiga** tako da se u main metodi postavlja kao godina izdanja knjige 2015. Uhvatiti izuzetak koji baca metoda **setGodina** i ispisati poruku greške u konzoli.
<br><br>

Napraviti klasu **Biblioteka** u paketu **zadatak1.biblioteka** koja ima:
1. Privatni atribut **knjige** (tipa List) koji predstavlja listu objekata klase Knjiga. Listu odmah inicijalizovati kao **LinkedList**.
2. Javnu metodu **dodajKnjigu** koja kao parametar dobija instancu klase Knjiga i dodaje je na kraj liste.
3. Javnu metodu **daLiPostoji** koja kao parametar prima objekat klase Knjiga. Metoda vraća TRUE ukoliko u listi postoji knjiga sa istim nazivom i godinom, a u suprotnom metoda vraća FALSE.
4. Javnu metodu **obrisiKnjigu** koja kao parametar prima objekat klase Knjiga i ako postoji u listi, briše je.
5. Javnu metodu **pretraziKnjige** koja kao parametar dobija jedan String. Metoda pronalazi u biblioteci i vraća sve knjige (kao listu) čiji naziv počinje tekstom datim kao parametar. Pri tome, obezbediti da pretraga ne bude osetljiva na velika i mala slova.
6. Javnu metodu **arhivirajKnjige** koja kao parametar dobija godinu (ceo broj). Metoda pronalazi i uklanja ih iz liste knjige koje su izdate date godine i pre nje.

Napraviti klasu **ProbaBiblioteka** u paketu **zadatak1.biblioteka** u kojoj se kreira jedan objekat klase **Biblioteka**. Napraviti dva objekta klase Knjiga sa podacima:
- Naziv: "Znakovi pored puta", godina: 1976
- Naziv: "Mansarda", godina: 1960

Dodati obe knjige u biblioteku. Zatim, arhivirati sve knjige koje su zavedene 2010 godine.

## Zadatak 2
*(studenti rade sami)*

Napraviti klasu **Restoran** u paketu **zadatak2** koja ima:
1. Privatni atribut **naziv**.
2. Privatni atribut **ocena** koja predstavlja ocenu restorana od 1 do 5.
3. Javne **get i set metode** za ove atribute. Atribut naziv ne sme biti NULL, niti prazan String. Atribut ocena mora biti u rasponu od 1 do 5. U slučaju unosa  nedozvoljenih vrednosti, potrebno je izbaciti ***neproveravani*** izuzetak sa porukom "GRESKA".

Napraviti klasu **VodicKrozRestorane** u paketu **zadatak2** koja ima:
1. Privatni atribut **restorani** (tipa List) koji predstavlja listu objekata klase Restoran.
2. Javni **konstruktor** u kojem se lista **restorani** inicijalizuje kao **ArrayList**.
3. Javnu metodu **dodajNaPocetak** koja kao parametar dobija objekat klase **Restoran** i dodaje ga na početak liste.
4. Javnu metodu **ispisiRestoraneSaOcenom** koja kao parametar dobija ocenu i ispisuje nazive svih restorana koji imaju datu ocenu.
5. Javnu metodu **obrisiLoseRestorane** koja iz liste **restorani** uklanja sve restorane sa ocenom 1.

Napraviti klasu **ProbaRestorani** u paketu **zadatak2** gde se kreira jedan objekat klase VodicKrozRestorane i u njega dodaju tri restorana: "Blue Hill" (ocena 4), "Per Se" (ocena 1), "Daniel" (ocena 4). Ispisati sve restorane sa ocenom 4, a zatim obrisati lose restorane iz vodiča.