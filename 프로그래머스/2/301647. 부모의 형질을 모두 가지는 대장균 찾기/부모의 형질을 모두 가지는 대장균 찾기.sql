SELECT a.id, a.genotype, b.genotype as parent_genotype
FROM ECOLI_DATA as a left join ECOLI_DATA as b
    ON a.parent_id = b.id
WHERE a.genotype & b.genotype = b.genotype
order by a.id