CREATE TABLE IF NOT EXISTS public.patient_t
(
    id integer NOT NULL,
    email character varying(100) NOT NULL,
    name character varying(100),
    CONSTRAINT patient_t_pkey PRIMARY KEY (id, email)
)