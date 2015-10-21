CREATE VIEW PUBLIC.RANKING_GERAL AS SELECT UUID() as ID, V.TIPO_VOTO, AVG(V.NOTA) AS MEDIA,  V.RESTAURANTE_ID FROM VOTO V JOIN RANKING_VOTOS RV ON RV.VOTOS = V.ID JOIN RANKING R ON R.ID = RV.RANKING 
GROUP BY  V.TIPO_VOTO,V.RESTAURANTE_ID;

CREATE VIEW PUBLIC.RANKING_GERAL_CUSTO_BENEFICIO AS SELECT UUID() as ID, AVG(V.NOTA) AS MEDIA,  V.RESTAURANTE_ID FROM VOTO V JOIN RANKING_VOTOS RV ON RV.VOTOS = V.ID JOIN RANKING R ON R.ID = RV.RANKING 
GROUP BY  V.RESTAURANTE_ID;

CREATE VIEW PUBLIC.RANKING_USUARIO_CUSTO_BENEFICIO AS SELECT UUID() as ID, AVG(V.NOTA) AS MEDIA,  V.RESTAURANTE_ID, R.USUARIO_ID FROM VOTO V JOIN RANKING_VOTOS RV ON RV.VOTOS = V.ID JOIN RANKING R ON R.ID = RV.RANKING 
GROUP BY V.RESTAURANTE_ID, R.USUARIO_ID;

CREATE VIEW PUBLIC.RANKING_USUARIO AS SELECT UUID() as ID, V.TIPO_VOTO, AVG(V.NOTA) AS MEDIA,  V.RESTAURANTE_ID, R.USUARIO_ID FROM VOTO V JOIN RANKING_VOTOS RV ON RV.VOTOS = V.ID JOIN RANKING R ON R.ID = RV.RANKING 
GROUP BY  V.TIPO_VOTO,V.RESTAURANTE_ID,R.USUARIO_ID;