package br.com.alura.project_01.controller.Pecas;

import br.com.alura.project_01.domain.pecas.DadosCadastroPecas;
import br.com.alura.project_01.domain.pecas.Pecas;
import br.com.alura.project_01.domain.pecas.PecasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/pecas")
public class controller {
    @Autowired
    private PecasRepository repository;

    @GetMapping("/cadastro")
    public String carregaPaginaFormulario(Long id , Model model) {
        if(id != null){
            var peca = repository.getReferenceById(id);
        model.addAttribute("peca", peca);}
        return "pecas/cadastro";
    }

    @PostMapping
    @Transactional
    public String cadastraPecas(DadosCadastroPecas dados) {
        var peca = new Pecas(dados);
        repository.save(peca);
        return "redirect:/pecas";
    }

    @PutMapping
    @Transactional
    public String alteraPecas(DadosAlteraPecas dados) {
        var peca = repository.getReferenceById(dados.id());
        peca.atualizaDados(dados);
        return "redirect:/pecas";
    }
    @GetMapping
    public String carregaListaPecas(Model model) {
        model.addAttribute("lista", repository.findAll() );
        return "pecas/listagem";
}
@DeleteMapping
@Transactional
public String removePecas(Long id){
        repository.deleteById(id);
        return "redirect:/pecas";

}
@GetMapping("/login")
public String mostrarPagina(){
        return "login.html";
}
}

