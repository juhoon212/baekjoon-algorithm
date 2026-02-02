-- 코드를 입력하세요
-- 가장 최근에 들어온 동물은 언제 들어왔나?--

SELECT MAX(AI.DATETIME)
FROM ANIMAL_INS AI;