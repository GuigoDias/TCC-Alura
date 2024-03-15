package br.com.CleanFinance.Compra;

import br.com.CleanFinance.Cartao.DadosListagemCartoes;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class CompraController {
    @Autowired
    private CompraRepository repository;
    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroCompra dados){
        repository.save(new Compra(dados));
    }

    @GetMapping
    public Page<DadosListagemCompras> listarCartoes(@PageableDefault(sort = {"data"}) Pageable paginacao){
        return repository.findAll(paginacao).map(DadosListagemCompras::new);
    }
}