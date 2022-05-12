CREATE TABLE IF NOT EXISTS public.programmer_t
(
   id BIGSERIAL PRIMARY KEY,
   name character varying (20),
   salary integer
);
CREATE TABLE IF NOT EXISTS public.project_t
(
   id BIGSERIAL PRIMARY KEY,
   name character varying (20)
);
CREATE TABLE IF NOT EXISTS public.programmer_projects_t
(
   programmer_id integer,
   project_id integer,
   CONSTRAINT programmer_t_fk FOREIGN KEY (programmer_id) REFERENCES public.programmer_t (id) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO ACTION,
   CONSTRAINT project_t_fk FOREIGN KEY (project_id) REFERENCES public.project_t (id) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO ACTION
);


SELECT AA.ID, AA.NAME,  AA.SALARY, CC.ID AS PROJECT_ID, CC.NAME AS PROJECT_NAME
FROM PROGRAMMER_T AA
JOIN PROGRAMMER_PROJECTS_T BB on AA.ID = BB.PROGRAMMER_ID
JOIN PROJECT_T CC ON BB.PROJECT_ID = CC.ID