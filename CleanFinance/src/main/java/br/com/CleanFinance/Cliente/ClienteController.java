package br.com.CleanFinance.Cliente;

import br.com.CleanFinance.Cliente.ClienteDadosRecords.DadosAtualizacaoCliente;
import br.com.CleanFinance.Cliente.ClienteDadosRecords.DadosCadastroCliente;
import br.com.CleanFinance.Cliente.ClienteDadosRecords.DadosListagemClientes;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteRepository repository;
    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroCliente dados){
        repository.save(new Cliente(dados));
    }

    @GetMapping("/listaClientes")
    public Page<DadosListagemClientes> listarClientes(@PageableDefault(sort = {"nome"}) Pageable paginacao){
        return repository.findAllByAtivoTrue(paginacao).map(DadosListagemClientes::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoCliente dados){
        var cliente = repository.getReferenceById(dados.id());
        cliente.atualizarInformacoes(dados);
    }

    @DeleteMapping("*/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
        var cliente = repository.getReferenceById(id);
        if (cliente.getCartoes() == null){
            cliente.exclusao();
        }
    }

    @GetMapping("/cpf/{cpf}")
    public Cliente pesquisarPorCpf(@RequestBody @Valid String cpf){
        return repository.findByCpf(cpf);
    }
}