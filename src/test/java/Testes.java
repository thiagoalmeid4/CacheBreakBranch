
import cache.io.Cache;
import org.junit.Test;


/**
 *
 * @author Thiago
 */
public class Testes {
    
    @Test
    public void teste() throws Exception{
        String nome = "thiago";
        Cache cache = new Cache();
        cache.put("nome", nome);
        System.out.println(cache.get("nome"));
    }
    
    //Outro exemplo:
        
        /*Pessoa pessoa = new Pessoa(nome,idade);
          Cache cache = new Cache();
          cache.put("chave" ,pessoa);
          Pessoa novaPessoa = (Pessoa) cache.get("chave");
        */
    
}
