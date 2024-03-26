package br.com.CleanFinance.Compra;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompraRepository extends JpaRepository<Compra,Long> {


    @Query(value = "Select compra.data as datas, compra.estabelecimento as esta, compra.categoria as categoria, compra.valor as valores From cliente Inner Join cartao ON cliente.id = cartao.cliente_id Inner Join compra ON cartao.cartao_id = compra.cartao_id", nativeQuery = true)
    List<ComprasFatura> COMPRAS();

    @Query(value = "Select cliente.id as ClienteID,cartao.cartao_id as CartaoID,compra.data,compra.categoria as Categoria,sum(compra.valor) as ValorCategoria From cliente Left Join cartao on cliente.id = cartao.cliente_id Left Join compra on cartao.cartao_id = compra.cartao_id Group by cliente.id,cartao.cartao_id,compra.data,compra.categoria",nativeQuery = true)
    List<ReportCategoria> CATEGORIAS();

    @Query(value = "Select  cliente.nome AS ClienteCompras, Count(compra.id) AS TotalCompras From cliente Left Join cartao ON cliente.id = cartao.cliente_id Left Join compra ON cartao.cartao_id = compra.cartao_id Group by cliente.id Order by TotalCompras DESC",nativeQuery = true)
    List<ComprasMaisRealizadas> MAISREALIZADAS();
}

