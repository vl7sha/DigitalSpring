SELECT
    (count(index_mass_body)/(
        SELECT max(id) FROM accounts
    )::float * 100)::int AS percent,
    CASE
        WHEN index_mass_body < 18 THEN 'Ниже нормы'
        WHEN index_mass_body >=18 AND index_mass_body <30 THEN 'Норма'
        WHEN index_mass_body >=30 THEN 'Ожирение'
        END AS name
FROM accounts
GROUP BY name
ORDER BY percent DESC