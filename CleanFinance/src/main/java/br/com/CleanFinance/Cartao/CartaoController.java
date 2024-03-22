package br.com.CleanFinance.Cartao;

import br.com.CleanFinance.Cartao.CartaoDadosRecords.*;
import br.com.CleanFinance.Compra.CompraRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroCartao dados){
        Cartao cartao = new Cartao(dados);
        var procurandoNumero = pesquisarPorNumero(cartao.getNumero());
        if (procurandoNumero == null) {
            repository.save(cartao);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/listaCartoes")
    public Page<DadosListagemCartoes> listarCartoes(@PageableDefault(sort = {"cliente","numero"}) Pageable paginacao){
        return repository.findAll(paginacao).map(DadosListagemCartoes::new);
    }

    @PutMapping("/ativar/{id}")
    @Transactional
    public void ativar(@PathVariable("id") @Valid Long id){
        var cartao = repository.getReferenceById(id);
        cartao.ativarCartao();
    }

    @PutMapping("/desativar/{id}")
    @Transactional
    public void desativar(@PathVariable("id") @Valid Long id){
        var cartao = repository.getReferenceById(id);
        cartao.desativarCartao();
    }

    @GetMapping("/alterarLimite/{numero}")
    public DadosCartaoAlterarLimite informarLimite(@PathVariable("numero") String numero){
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
    public DadosCartaoPrepararFatura informacoesFatura(@PathVariable("numero") String numero){
        var cartao = pesquisarPorNumero(numero);
        return new DadosCartaoPrepararFatura(cartao);
    }

    @GetMapping("/listarFatura")
    public Page<CartaoListaFatura> listarCompras(@PageableDefault(sort = {"data"}) Pageable paginacao){
        return repositoryCompra.findAll(paginacao).map(CartaoListaFatura::new);
    }

    public Cartao pesquisarPorNumero(String numero){
        return repository.findByNumero(numero);
    }
}