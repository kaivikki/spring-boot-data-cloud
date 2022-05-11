CREATE TABLE IF NOT EXISTS public.employee_t
(
   id integer PRIMARY KEY,
   name character varying (20),
   street character varying (100),
   city character varying (100),
   state character varying (100),
   zipcode character varying (100),
   country character varying (100)
);