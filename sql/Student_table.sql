CREATE TABLE IF NOT EXISTS public.student_t
(
    id BIGSERIAL   PRIMARY KEY,
	fname character varying(20) COLLATE pg_catalog."default",
    lname character varying(20) COLLATE pg_catalog."default",
    score integer
);