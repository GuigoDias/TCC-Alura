

Create View ViewVisualizarCompras AS
Select
       compra.data, compra.estabelecimento, compra.categoria, compra.valor
From cliente
Inner Join cartao ON cliente.id = cartao.cliente_id
Inner Join compra ON cartao.cartao_id = compra.cartao_id;


Create View ViewReportCategoria AS
Select
	cliente.id,cartao.cartao_id,compra.data,compra.categoria,sum(compra.valor) as ValorCategoria

From
	cliente
        Left Join cartao on cliente.id = cartao.cliente_id
	Left Join compra on cartao.cartao_id = compra.cartao_id
Group by
	cliente.id,cartao.cartao_id,compra.data,compra.categoria;


Create View ViewComprasMaisRealizadas AS
SELECT
    cliente.nome AS Cliente,
    Count(compra.id) AS TotalCompras
From cliente
Left Join cartao ON cliente.id = cartao.cliente_id
Left Join compra ON cartao.cartao_id = compra.cartao_id
Group by cliente.id
Order by TotalCompras DESC;


Create View ViewComprasMaiorValor AS
Select
    cliente.nome AS Cliente,
    MAX(compra.valor) AS CompraMaiorValor
From cliente
Left Join cartao ON cliente.id = cartao.cliente_id
Left Join compra ON cartao.cartao_id = compra.cartao_id
Group by cliente.id
Order by CompraMaiorValor DESC;


Create View ViewClientesSemCompras as
Select
	cliente.id,
	cliente.nome as Cliente
 from
	cliente
    Left Join cartao on cliente.id = cartao.cliente_id
    left join compra on compra.cartao_id = cartao.cartao_id
GROUP BY
    cliente.id,
    cliente.nome
HAVING
    SUM(ifnull(compra.valor,0)) = 0;