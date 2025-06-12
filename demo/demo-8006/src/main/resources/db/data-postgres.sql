CREATE TABLE public.test_info
(
    id bigint NOT NULL,
    db_name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    create_time timestamp(6) without time zone,
    CONSTRAINT test_info_pkey PRIMARY KEY (id)
)

    TABLESPACE pg_default;

ALTER TABLE public.test_info
    OWNER to postgres;

COMMENT ON TABLE public.test_info
    IS 'データベース情報test';

COMMENT ON COLUMN public.test_info.id
    IS 'ID';

COMMENT ON COLUMN public.test_info.db_name
    IS 'データベース名称';

COMMENT ON COLUMN public.test_info.create_time
    IS '作成時間';
