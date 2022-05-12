--Single Table
CREATE TABLE IF NOT EXISTS public.payment_t
(
    id integer PRIMARY KEY,
	pmode character varying(20),
    amount double precision,
    cardnumber character varying(20),
	checknumber character varying(20)
);


--Table per concrete class.
CREATE TABLE IF NOT EXISTS public.check_t
(
    id integer PRIMARY KEY,
    amount double precision,
	checknumber character varying(20)
);

CREATE TABLE IF NOT EXISTS public.credit_card_t
(
    id integer PRIMARY KEY,
    amount double precision,
	cardnumber character varying(20)
);

------- JOINED
CREATE TABLE IF NOT EXISTS public.payment_t
(
    id integer PRIMARY KEY,
    amount double precision
);


CREATE TABLE IF NOT EXISTS public.check_t
(
    id integer,
    checknumber character varying(20),
    CONSTRAINT check_t_fk FOREIGN KEY (id)
        REFERENCES public.payment_t (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
));

CREATE TABLE IF NOT EXISTS public.credit_card_t
(
    id integer,
	cardnumber character varying(20),
    CONSTRAINT credit_card_t_fk FOREIGN KEY (id)
        REFERENCES public.payment_t (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);