create table weather
(
    id           bigserial primary key,
    date         timestamp not null,
    lat          varchar   not null,
    lon          varchar   not null,
    city         varchar   not null,
    state        varchar   not null,
    temperatures jsonb
);