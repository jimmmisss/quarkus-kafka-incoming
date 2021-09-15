DROP TABLE IF EXISTS public.customer;
CREATE TABLE public.customer
(
    id       bigserial NOT NULL,
    name     varchar(255) NULL,
    lastname varchar(255) NULL,
    document varchar(255) NULL,
    CONSTRAINT customer_pkey PRIMARY KEY (id)
);