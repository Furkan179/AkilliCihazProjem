PGDMP     4    6                x         	   Kullanici    12.0    12.0                 0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    17441 	   Kullanici    DATABASE     �   CREATE DATABASE "Kullanici" WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Turkish_Turkey.1254' LC_CTYPE = 'Turkish_Turkey.1254';
    DROP DATABASE "Kullanici";
                postgres    false            �            1259    17442    kullanicilar    TABLE     �   CREATE TABLE public.kullanicilar (
    user_name character varying(30) NOT NULL,
    name character varying(25) NOT NULL,
    last_name character varying(25) NOT NULL,
    password character varying(30) NOT NULL
);
     DROP TABLE public.kullanicilar;
       public         heap    postgres    false            �
          0    17442    kullanicilar 
   TABLE DATA           L   COPY public.kullanicilar (user_name, name, last_name, password) FROM stdin;
    public          postgres    false    202          ~
           2606    17446    kullanicilar kullanicilar_pkey 
   CONSTRAINT     c   ALTER TABLE ONLY public.kullanicilar
    ADD CONSTRAINT kullanicilar_pkey PRIMARY KEY (user_name);
 H   ALTER TABLE ONLY public.kullanicilar DROP CONSTRAINT kullanicilar_pkey;
       public            postgres    false    202            �
   S   x��;
�0����~O ��M�b�&E�BO��)�ҢY��5I�a�兄�#-�nw)��b�lN�BAÀ�ώ�*     