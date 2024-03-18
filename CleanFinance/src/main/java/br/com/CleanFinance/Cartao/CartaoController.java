package br.com.CleanFinance.Cartao;

import br.com.CleanFinance.Cartao.CartaoDadosRecords.*;
import br.com.CleanFinance.Compra.CompraRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cartoes")
public class CartaoController {
    @Autowired
    private CartaoRepository repository;
    @Autowired
    private CompraRepository repositoryCompra;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroCartao dados){
        repository.save(new Cartao(dados));
    }

    @GetMapping
    public Page<DadosListagemCartoes> listarCartoes(@PageableDefault(sort = {"nome","numero"}) Pageable paginacao){
        return repository.findAll(paginacao).map(DadosListagemCartoes::new);
    }

    @PutMapping("/ativarOuDesativar")
    @Transactional
    public void ativarDesativar(@RequestBody @Valid DadosAtualizacaoCartao dados){
        var cartao = repository.getReferenceById(dados.id());
        cartao.ativarOuDesativar(dados);
    }

    @GetMapping("/alterarLimite/{numero}")
    public DadosCartaoAlterarLimite informarLimite(@RequestBody String numero){
        var cartao = pesquisarPorNumero(numero);
        return new DadosCartaoAlterarLimite(cartao);
    }

    @PutMapping("/alterarLimite")
    @Transactional
    public void alterandoLimite(@RequestBody DadosLimiteCartao dados){
        var cartao = pesquisarPorNumero(dados.numero());
        cartao.alterarLimite(dados.novoLimite());
    }

    @GetMapping("/informarFatura/{numero}")
    public DadosCartaoPrepararFatura informacoesFatura(@RequestBody String numero){
        var cartao = pesquisarPorNumero(numero);
        return new DadosCartaoPrepararFatura(cartao);
    }

    public Page<CartaoListaFatura> listarCompras(@PageableDefault(sort = {"data"}) Pageable paginacao){
        return repositoryCompra.findAll(paginacao).map(CartaoListaFatura::new);
    }

    public Cartao pesquisarPorNumero(@RequestBody @Valid String numero){
        return repository.findByNumero(numero);
    }
}