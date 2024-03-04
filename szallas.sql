--
-- PostgreSQL database dump
--

-- Dumped from database version 12.4 (Ubuntu 12.4-1.pgdg16.04+1)
-- Dumped by pg_dump version 13.0

-- Started on 2020-11-26 14:30:49 CET

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 202 (class 1259 OID 162504)
-- Name: felhasznalo; Type: TABLE; Schema: public; Owner: qwnlwdqpmyxodw
--

CREATE TABLE public.felhasznalo (
    keresztnev character varying(50) NOT NULL,
    vezeteknev character varying(50) NOT NULL,
    felhasznalonev character varying(50) NOT NULL,
    email character varying(50) NOT NULL,
    jelszo character varying(25) NOT NULL,
    telefonszam integer NOT NULL,
    iranyitoszam integer NOT NULL,
    varos character varying(30) NOT NULL,
    utca character varying(50) NOT NULL,
    hazszam character varying(20) NOT NULL
);


ALTER TABLE public.felhasznalo OWNER TO qwnlwdqpmyxodw;

--
-- TOC entry 203 (class 1259 OID 162507)
-- Name: foglalas; Type: TABLE; Schema: public; Owner: qwnlwdqpmyxodw
--

CREATE TABLE public.foglalas (
    azon integer NOT NULL,
    felhasznalonev character varying(40) NOT NULL,
    szobaszam integer NOT NULL,
    erkezes character varying(15) NOT NULL,
    tavozas character varying(15) NOT NULL,
    ertekelt boolean
);


ALTER TABLE public.foglalas OWNER TO qwnlwdqpmyxodw;

--
-- TOC entry 204 (class 1259 OID 162510)
-- Name: foglalas_azon_seq; Type: SEQUENCE; Schema: public; Owner: qwnlwdqpmyxodw
--

CREATE SEQUENCE public.foglalas_azon_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.foglalas_azon_seq OWNER TO qwnlwdqpmyxodw;

--
-- TOC entry 3883 (class 0 OID 0)
-- Dependencies: 204
-- Name: foglalas_azon_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: qwnlwdqpmyxodw
--

ALTER SEQUENCE public.foglalas_azon_seq OWNED BY public.foglalas.azon;


--
-- TOC entry 205 (class 1259 OID 162512)
-- Name: sza_szolg; Type: TABLE; Schema: public; Owner: qwnlwdqpmyxodw
--

CREATE TABLE public.sza_szolg (
    azon integer NOT NULL,
    tipus character varying(20) NOT NULL,
    szallodanev character varying(30) NOT NULL,
    szolg_ar integer NOT NULL
);


ALTER TABLE public.sza_szolg OWNER TO qwnlwdqpmyxodw;

--
-- TOC entry 206 (class 1259 OID 162515)
-- Name: sza_szolg_azon_seq; Type: SEQUENCE; Schema: public; Owner: qwnlwdqpmyxodw
--

CREATE SEQUENCE public.sza_szolg_azon_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.sza_szolg_azon_seq OWNER TO qwnlwdqpmyxodw;

--
-- TOC entry 3884 (class 0 OID 0)
-- Dependencies: 206
-- Name: sza_szolg_azon_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: qwnlwdqpmyxodw
--

ALTER SEQUENCE public.sza_szolg_azon_seq OWNED BY public.sza_szolg.azon;


--
-- TOC entry 207 (class 1259 OID 162517)
-- Name: szalloda; Type: TABLE; Schema: public; Owner: qwnlwdqpmyxodw
--

CREATE TABLE public.szalloda (
    sza_nev character varying(20) NOT NULL,
    iranyitoszam integer NOT NULL,
    varos character varying(20) NOT NULL,
    utca character varying(20) NOT NULL,
    hazszam character varying(20) NOT NULL,
    telefon integer NOT NULL,
    email character varying(50) NOT NULL,
    mobil integer NOT NULL,
    ertekeles real,
    tipus character varying(20) NOT NULL,
    sza_url character varying(255),
    letrehozta character varying(30),
    ert_szam integer
);


ALTER TABLE public.szalloda OWNER TO qwnlwdqpmyxodw;

--
-- TOC entry 208 (class 1259 OID 162520)
-- Name: szobaszamsec; Type: SEQUENCE; Schema: public; Owner: qwnlwdqpmyxodw
--

CREATE SEQUENCE public.szobaszamsec
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.szobaszamsec OWNER TO qwnlwdqpmyxodw;

--
-- TOC entry 209 (class 1259 OID 162522)
-- Name: szoba; Type: TABLE; Schema: public; Owner: qwnlwdqpmyxodw
--

CREATE TABLE public.szoba (
    szobaszam integer DEFAULT nextval('public.szobaszamsec'::regclass) NOT NULL,
    szallodanev character varying(40) NOT NULL,
    kapacitas integer NOT NULL,
    arperfo integer NOT NULL,
    szabad boolean NOT NULL,
    agytipus character varying(15) NOT NULL,
    konyha boolean,
    leiras character varying(255) NOT NULL,
    url character varying(255),
    va_szobaszam integer
);


ALTER TABLE public.szoba OWNER TO qwnlwdqpmyxodw;

--
-- TOC entry 3724 (class 2604 OID 162529)
-- Name: foglalas azon; Type: DEFAULT; Schema: public; Owner: qwnlwdqpmyxodw
--

ALTER TABLE ONLY public.foglalas ALTER COLUMN azon SET DEFAULT nextval('public.foglalas_azon_seq'::regclass);


--
-- TOC entry 3725 (class 2604 OID 162530)
-- Name: sza_szolg azon; Type: DEFAULT; Schema: public; Owner: qwnlwdqpmyxodw
--

ALTER TABLE ONLY public.sza_szolg ALTER COLUMN azon SET DEFAULT nextval('public.sza_szolg_azon_seq'::regclass);


--
-- TOC entry 3868 (class 0 OID 162504)
-- Dependencies: 202
-- Data for Name: felhasznalo; Type: TABLE DATA; Schema: public; Owner: qwnlwdqpmyxodw
--

COPY public.felhasznalo (keresztnev, vezeteknev, felhasznalonev, email, jelszo, telefonszam, iranyitoszam, varos, utca, hazszam) FROM stdin;
Ferenc	Nagy	nagyfera	nagyfera@fre.com	fera	1	2134	Vác	keres	23
Alma	Korte	Ak	ak@gmail.com	ak123	63336666	5600	Békéscsaba	kote	2
Kiss	Ferenc	kicsifera	nincs@nincs.hu	kicsifera	8036637	8000	Siófok	Fő utca	2
Béla	Valak	vala	vala@vala.com	vala	3456765	2321	Baja	bakancs	23
Béla	Herceg	hera	gerttte22	ertffd	456654353	3431	Vác	keres	23
Gyula	Herceg	her	her@her.com	her	4354343	2334	Szeged	bakancs	2
Lajos	Ferenc	kislajoska	nincs@nincs.hu	kislajoska	38382	6361	Szeged	Elso	9
Ferenc	kers	he	he@he.com	hehehe	123544	1234	Dabas	keres	23
Asd1	Asd2	asdasd	asdasd@asdasd.asd	asdasd123	301236547	6720	Szeged	Híd utca	1
Ferenc	Herceg	heri	heri@heri.com	heri	9488537	1345	Baja	bakancs	2
Nagy	Amanda	nagyamanda	nagyamanda@nincs.hu	Amanda	708293922	8700	Nagykanizsa	Fő utca	14
Almácska	Kerszt	Almacska	nincs@nincs.hu	alma	765890	7771	Kistarcsa	Kis utca	11
\.


--
-- TOC entry 3869 (class 0 OID 162507)
-- Dependencies: 203
-- Data for Name: foglalas; Type: TABLE DATA; Schema: public; Owner: qwnlwdqpmyxodw
--

COPY public.foglalas (azon, felhasznalonev, szobaszam, erkezes, tavozas, ertekelt) FROM stdin;
8	Almacska	3	2020-11-20	2020-11-21	f
41	Almacska	14	2020-11-20	2020-11-21	f
2	Almacska	1	2020-11-12	2020-11-13	t
48	heri	16	2020-11-24	2020-11-25	f
\.


--
-- TOC entry 3871 (class 0 OID 162512)
-- Dependencies: 205
-- Data for Name: sza_szolg; Type: TABLE DATA; Schema: public; Owner: qwnlwdqpmyxodw
--

COPY public.sza_szolg (azon, tipus, szallodanev, szolg_ar) FROM stdin;
2	parkolás	Ocean View Hotel	0
4	parkolás	La Belle Hotel	0
5	wifi	La Belle Hotel	0
14	szauna	La Belle Hotel	2000
3	Étterem	Hotel Menő	1500
6	Parkolás	Hotel Kicsifera	0
8	Parkolás	Hotel Presidente	0
9	Wi-Fi	Hotel Presidente	0
10	Medence	Ocean View Hotel	1000
21	parkolás	Balneo Hotel	0
\.


--
-- TOC entry 3873 (class 0 OID 162517)
-- Dependencies: 207
-- Data for Name: szalloda; Type: TABLE DATA; Schema: public; Owner: qwnlwdqpmyxodw
--

COPY public.szalloda (sza_nev, iranyitoszam, varos, utca, hazszam, telefon, email, mobil, ertekeles, tipus, sza_url, letrehozta, ert_szam) FROM stdin;
Ocean View Hotel	33139	Vice City	Ocean Drive	1020	5324006	oceanvievh@oceanhost.com	5324006	0	Hotel	css/image/1013534.JPG	Ak	0
Hotel Menő	1022	Budapest	Fő utca	51	12657733	hotelmeno@hotelmeno.hu	308259728	0	5*	css/image/hotel-aurora.JPG	Ak	0
Hotel elso	8700	Siófok	Fő utca	4	637384	nincs@nincs.hu	3076227	0	3*	https://res.cloudinary.com/hyooouyiy/image/upload/szallas/szallasportal/amor-szalloda.jpeg	kislajoska	0
Balneo Hotel	3400	Mezőkövesd	Fürdő utca	8/a	75432099	balneo@balneo,hu	746728	0	3*	https://res.cloudinary.com/hyooouyiy/image/upload/szallas/szallasportal/hotelkepem.jpg	Almacska	0
asdasdhotel	1111	Budapest	Kálvin tér	3	708529631	info@asdasdhotel.hu	708529631	0	hotel	https://res.cloudinary.com/hyooouyiy/image/upload/szallas/szallasportal/hotel1.jpg	asdasd	0
Hotel Kicsifera	8600	Siófok	Fő utca	2	728282	nincs@nincs.hu	829293	3.8	hotel	https://res.cloudinary.com/hyooouyiy/image/upload/szallas/szallasportal/hotel_2_pic4.jpg	kicsifera	5
Hotel Presidente	3600	Eger	Dobó utca	8	76425987	presidente@presidente.hu	804558080	4	5*	https://res.cloudinary.com/hyooouyiy/image/upload/szallas/szallasportal/hotel-presidente.jpg	Almacska	1
Próba2	1234	Vác	keres	23	12314235	her@her.com	13124341	0	jófélej	https://res.cloudinary.com/hyooouyiy/image/upload/szallas/szallasportal/karosspa_11.jpg	her	0
La Belle Hotel	6725	Szeged	Piroska utca	5/C	70542561	labelle@labelle.hu	706253728	4.15	4*	https://res.cloudinary.com/hyooouyiy/image/upload/szallas/szallasportal/home-hotel.jpg	Almacska	15
Próba1	1234	Vác	keres	23	1234567	heri@heri.com	2345678	5	jóféle	https://res.cloudinary.com/hyooouyiy/image/upload/szallas/szallasportal/3106913.jpg	heri	1
Hotel Amanda	4025	Debrecen	Segner tér	10	42367367	info@hotelamanda.hu	307226161	0	4*	https://res.cloudinary.com/hyooouyiy/image/upload/szallas/szallasportal/amanda.jpg	nagyamanda	0
\.


--
-- TOC entry 3875 (class 0 OID 162522)
-- Dependencies: 209
-- Data for Name: szoba; Type: TABLE DATA; Schema: public; Owner: qwnlwdqpmyxodw
--

COPY public.szoba (szobaszam, szallodanev, kapacitas, arperfo, szabad, agytipus, konyha, leiras, url, va_szobaszam) FROM stdin;
2	La Belle Hotel	1	12000	t	heverő	f	Egyágyas standard szoba	css/image/szoba2.jpg	2
3	La Belle Hotel	4	12000	t	Francia	f	Négyágyas standard szoba	css/image/szoba3.jpg	3
4	Hotel Menő	2	20000	t	Francia	f	Kétágyas standard szoba	css/image/szoba4.jpg	4
5	Hotel Menő	2	20000	t	Francia	f	Kétágyas standard szoba	css/image/szoba5.jpg	5
8	Hotel Presidente	2	22000	t	Francia	t	Kétfős delux szoba	https://res.cloudinary.com/hyooouyiy/image/upload/szallas/szallasportal/unnamed.jpg	1
11	Hotel Presidente	4	30000	t	Francia	t	4 személyes delux szoba	https://res.cloudinary.com/hyooouyiy/image/upload/szallas/szallasportal/nagy.jpg	2
12	Balneo Hotel	2	20000	t	Francia	t	Kétfős delux szoba	https://res.cloudinary.com/hyooouyiy/image/upload/szallas/szallasportal/hoteles.jpg	1
14	Hotel Kicsifera	2	15000	t	Francia	f	Kétfős standard szoba	https://res.cloudinary.com/hyooouyiy/image/upload/szallas/szallasportal/unnamed.jpg	1
1	La Belle Hotel	2	18500	t	Francia	t	Kétágyas standard szoba	css/image/szoba1.jpg	1
16	Próba1	3	1200	t	queen size	t	jó hely	https://res.cloudinary.com/hyooouyiy/image/upload/szallas/szallasportal/648882.jpg	7
18	Próba2	24	1500	t	queen size	t	jü	https://res.cloudinary.com/hyooouyiy/image/upload/szallas/szallasportal/648882.jpg	43
217	Ocean View Hotel	2	5000	t	Francia	f	Mindig kiadó	\N	6
301	Ocean View Hotel	2	7500	t	Francia	f	Luxus kis pénzért	\N	8
\.


--
-- TOC entry 3885 (class 0 OID 0)
-- Dependencies: 204
-- Name: foglalas_azon_seq; Type: SEQUENCE SET; Schema: public; Owner: qwnlwdqpmyxodw
--

SELECT pg_catalog.setval('public.foglalas_azon_seq', 48, true);


--
-- TOC entry 3886 (class 0 OID 0)
-- Dependencies: 206
-- Name: sza_szolg_azon_seq; Type: SEQUENCE SET; Schema: public; Owner: qwnlwdqpmyxodw
--

SELECT pg_catalog.setval('public.sza_szolg_azon_seq', 21, true);


--
-- TOC entry 3887 (class 0 OID 0)
-- Dependencies: 208
-- Name: szobaszamsec; Type: SEQUENCE SET; Schema: public; Owner: qwnlwdqpmyxodw
--

SELECT pg_catalog.setval('public.szobaszamsec', 18, true);


--
-- TOC entry 3728 (class 2606 OID 162532)
-- Name: felhasznalo felhasznalo_pkey; Type: CONSTRAINT; Schema: public; Owner: qwnlwdqpmyxodw
--

ALTER TABLE ONLY public.felhasznalo
    ADD CONSTRAINT felhasznalo_pkey PRIMARY KEY (felhasznalonev);


--
-- TOC entry 3730 (class 2606 OID 162534)
-- Name: foglalas foglalas_pkey; Type: CONSTRAINT; Schema: public; Owner: qwnlwdqpmyxodw
--

ALTER TABLE ONLY public.foglalas
    ADD CONSTRAINT foglalas_pkey PRIMARY KEY (azon);


--
-- TOC entry 3732 (class 2606 OID 162536)
-- Name: sza_szolg sza_szolg_pkey; Type: CONSTRAINT; Schema: public; Owner: qwnlwdqpmyxodw
--

ALTER TABLE ONLY public.sza_szolg
    ADD CONSTRAINT sza_szolg_pkey PRIMARY KEY (azon);


--
-- TOC entry 3734 (class 2606 OID 162538)
-- Name: szalloda szalloda_pkey; Type: CONSTRAINT; Schema: public; Owner: qwnlwdqpmyxodw
--

ALTER TABLE ONLY public.szalloda
    ADD CONSTRAINT szalloda_pkey PRIMARY KEY (sza_nev);


--
-- TOC entry 3736 (class 2606 OID 162540)
-- Name: szoba szoba_pkey; Type: CONSTRAINT; Schema: public; Owner: qwnlwdqpmyxodw
--

ALTER TABLE ONLY public.szoba
    ADD CONSTRAINT szoba_pkey PRIMARY KEY (szobaszam);


--
-- TOC entry 3737 (class 2606 OID 162541)
-- Name: foglalas foglalas_felhasznalonev_fkey; Type: FK CONSTRAINT; Schema: public; Owner: qwnlwdqpmyxodw
--

ALTER TABLE ONLY public.foglalas
    ADD CONSTRAINT foglalas_felhasznalonev_fkey FOREIGN KEY (felhasznalonev) REFERENCES public.felhasznalo(felhasznalonev) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 3738 (class 2606 OID 162546)
-- Name: foglalas foglalas_szobaszam_fkey; Type: FK CONSTRAINT; Schema: public; Owner: qwnlwdqpmyxodw
--

ALTER TABLE ONLY public.foglalas
    ADD CONSTRAINT foglalas_szobaszam_fkey FOREIGN KEY (szobaszam) REFERENCES public.szoba(szobaszam) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 3739 (class 2606 OID 162551)
-- Name: sza_szolg sza_szolg_szallodanev_fkey; Type: FK CONSTRAINT; Schema: public; Owner: qwnlwdqpmyxodw
--

ALTER TABLE ONLY public.sza_szolg
    ADD CONSTRAINT sza_szolg_szallodanev_fkey FOREIGN KEY (szallodanev) REFERENCES public.szalloda(sza_nev) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 3740 (class 2606 OID 162556)
-- Name: szalloda szafel; Type: FK CONSTRAINT; Schema: public; Owner: qwnlwdqpmyxodw
--

ALTER TABLE ONLY public.szalloda
    ADD CONSTRAINT szafel FOREIGN KEY (letrehozta) REFERENCES public.felhasznalo(felhasznalonev) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 3741 (class 2606 OID 162561)
-- Name: szoba szoba_szallodanev_fkey; Type: FK CONSTRAINT; Schema: public; Owner: qwnlwdqpmyxodw
--

ALTER TABLE ONLY public.szoba
    ADD CONSTRAINT szoba_szallodanev_fkey FOREIGN KEY (szallodanev) REFERENCES public.szalloda(sza_nev);


--
-- TOC entry 3881 (class 0 OID 0)
-- Dependencies: 3
-- Name: SCHEMA public; Type: ACL; Schema: -; Owner: qwnlwdqpmyxodw
--

REVOKE ALL ON SCHEMA public FROM postgres;
REVOKE ALL ON SCHEMA public FROM PUBLIC;
GRANT ALL ON SCHEMA public TO qwnlwdqpmyxodw;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- TOC entry 3882 (class 0 OID 0)
-- Dependencies: 647
-- Name: LANGUAGE plpgsql; Type: ACL; Schema: -; Owner: postgres
--

GRANT ALL ON LANGUAGE plpgsql TO qwnlwdqpmyxodw;


-- Completed on 2020-11-26 14:31:54 CET

--
-- PostgreSQL database dump complete
--

