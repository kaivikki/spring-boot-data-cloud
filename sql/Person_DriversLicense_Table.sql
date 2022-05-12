CREATE TABLE IF NOT EXISTS public.driving_licence_t
(
   id  BIGSERIAL PRIMARY KEY,
   type character varying (20),
   valid_from date,
   valid_to date
);

CREATE TABLE IF NOT EXISTS public.person_t
(
   id  BIGSERIAL PRIMARY KEY,
   name character varying (20),
   age integer,
   licence_id integer,
	CONSTRAINT person_t_fk FOREIGN KEY (licence_id)
        REFERENCES public.driving_licence_t (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

select aa.id, aa.name, aa.age, aa.licence_id , bb.type , bb.valid_from, bb.valid_to
from person_t aa
join driving_licence_t bb on aa.licence_id = bb.id