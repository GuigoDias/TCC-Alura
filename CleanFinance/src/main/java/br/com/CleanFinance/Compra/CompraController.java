package br.com.CleanFinance.Compra;

import br.com.CleanFinance.Compra.CompraDadosRecords.DadosCadastroCompra;
import br.com.CleanFinance.Compra.CompraDadosRecords.DadosListagemCompras;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/compras")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class CompraController {
    @Autowired
    private CompraRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroCompra dados) {
        repository.save(new Compra(dados));
    }

    @GetMapping
    public Page<DadosListagemCompras> listarCartoes(@PageableDefault(sort = {"data"}) Pageable paginacao) {
        return repository.findAll(paginacao).map(DadosListagemCompras::new);
    }

    @GetMapping("/listar")
    public List<ComprasFatura> listarCompras() {
        return repository.COMPRAS();

    }

    @GetMapping("/categoria")
    public List<ReportCategoria> listarCategorias() {
        return repository.CATEGORIAS();

    }

    @GetMapping("/maisrealizadas")
    public List<ComprasMaisRealizadas> ListarComprasRealizadas() {
        return repository.MAISREALIZADAS();
    }
}