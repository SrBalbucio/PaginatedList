package balbucio.paginatedlist;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class PaginatedList<T> {

    private ConcurrentHashMap<Integer, List<T>> paginas = new ConcurrentHashMap<>();
    private List<T> list;
    private int itensPerPage;

    public PaginatedList(List<T> list, int itensPerPage){
        this.list = list;
        this.itensPerPage = itensPerPage;
        split();
    }

    /**
     * Pega os itens de uma página específica
     * @param i Página
     * @return Retorna os itens da página, se não existir retornará uma lista vazia
     */
    public List<T> getPage(int i) {
        return paginas.getOrDefault(i, new ArrayList<>());
    }

    /**
     * Verifica se há uma página após a especificada
     * @param i Página (que acaba se tornando pag + 1)
     * @return Retorna true se existir uma página após a especificada
     */
    public boolean hasNext(int i){
        return paginas.containsKey(i+1);
    }

    /**
     * Verifica se há uma página
     * @param i Página
     * @return Retorna true se existir uma página
     */
    public boolean has(int i){
        return paginas.containsKey(i);
    }

    /**
     * Adiciona novos itens a lista
     * @param newItens Itens a ser adicionados
     */
    public void add(List<T> newItens){
        list.addAll(newItens);
        split();
    }

    /**
     * Retorna a quantidade máximo de páginas
     * @return
     */
    public int getMaxPages(){
        return paginas.size();
    }

    /**
     * Divide a lista em páginas
     */
    private void split(){
        paginas.clear();
        if(list.size() > itensPerPage) {
            int pages = list.size() / itensPerPage;
            int position = 0;
            for(int i = 0; i < pages; i++) {
                ArrayList<T> itens = new ArrayList<>();
                for (T obj : list) {
                    if(position < itensPerPage * i) {
                        itens.add(list.get(position));
                        position++;
                    } else{
                        break;
                    }
                }
                paginas.put(i, itens);
            }
        } else{
            paginas.put(1, list);
        }
    }
}
