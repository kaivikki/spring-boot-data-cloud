CREATE TABLE IF NOT EXISTS public.customer_t
(
   customer_id BIGSERIAL PRIMARY KEY,
   name character varying (20)
);

CREATE TABLE IF NOT EXISTS public.phone_numbers_t
(
   id BIGSERIAL PRIMARY KEY,
   customer_id integer,
   number character varying (20),
   CONSTRAINT phone_numbers_t_fk FOREIGN KEY (customer_id)
        REFERENCES public.customer_t (customer_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

select cc.customer_id, cc.name, pp.number
from customer_t cc
join phone_numbers_t pp on cc.customer_id = pp.customer_id